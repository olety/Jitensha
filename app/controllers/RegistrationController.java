package controllers;

import models.User;
import org.mindrot.jbcrypt.BCrypt;
import play.api.i18n.Lang;
import play.api.libs.Crypto$;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.Messages;
import play.i18n.MessagesApi;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.registration;

import javax.inject.Inject;
import java.util.Optional;


/**
 * Created by yusch on 07.11.2017.
 */
public class RegistrationController extends Controller {

    public static class RegistrationForm {
        public String firstName = "";
        public String lastName = "";
        public String email = "";
        public String address = "";
        public String apartment = "";
        public String city = "";
        public String postCode = "";
        public String country = "";
        public String password = "";
    }

    private final FormFactory formFactory;
    private final MessagesApi messagesApi;
    // Injecting formFactory
    @Inject
    public RegistrationController(final FormFactory formFactory, final MessagesApi messagesApi) {
        this.formFactory = formFactory;
        this.messagesApi = messagesApi;
    }

    public Result getRegistrationForm() {
        return ok(
                registration.render(formFactory.form(RegistrationForm.class))
        );
    }

    public Result register() {

        Form<RegistrationForm> registerForm = formFactory.form(RegistrationForm.class).bindFromRequest();

        RegistrationForm registrationControll = registerForm.get();

        Result resultError = checkBeforeSave(registerForm, registrationControll.email);

        if (resultError != null) {
            return resultError;
        }

        try {
            User newUser = new User();
            newUser.setEmail(registrationControll.email);
            newUser.setFirstName(registrationControll.firstName);
            newUser.setLastName(registrationControll.lastName);
            newUser.setAddress(registrationControll.address);
            newUser.setCity(registrationControll.city);
            newUser.setApartment(registrationControll.apartment);
            newUser.setCountry(registrationControll.country);
            newUser.setPostCode(registrationControll.postCode);
            newUser.setPasswordHash(BCrypt.hashpw(registrationControll.password, BCrypt.gensalt()));
            newUser.save();
            return ok();
        } catch (Throwable e) {
            return ok();
        }
    }

    private Result checkBeforeSave(Form<RegistrationForm> registerForm, String email) {
        // Check unique email
        Optional<User> user = Optional.ofNullable(User.findByEmail(email));
        if (user.isPresent()) {
            flash("error", messagesApi.get(Lang.defaultLang(), "error.email.already.exist"));
            return badRequest(registration.render(registerForm));
        }
        return null;
    }
}
