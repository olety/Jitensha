package controllers;

import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.registration;

import javax.inject.Inject;

/**
 * Created by yusch on 07.11.2017.
 */
public class RegistrationController extends Controller {

    public static class RegistrationForm {
        public String firstName;
        public String lastName;
        public String address;
        public String apartment;
        public String city;
        public String postCode;
        public String country;
    }

    private final FormFactory formFactory;
    // Injecting formFactory
    @Inject
    public RegistrationController(final FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result getRegistrationForm() {
        return ok(
                registration.render(formFactory.form(RegistrationForm.class))
        );
    }

    public Result register() {
        return ok();
    }
}
