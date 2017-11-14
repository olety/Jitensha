package controllers;

import play.*;
import play.data.validation.Constraints;
import play.mvc.*;

import play.data.*;
import views.html.*;
import models.*;

import javax.inject.Inject;
import play.data.validation.Constraints.Validatable;
import play.data.validation.ValidationError;

public class AuthController extends Controller {

    @Constraints.Validate
    public static class LoginForm implements Validatable<ValidationError> {
        @Constraints.Required
        private String email;

        @Constraints.Required
        private String password;

        @Override
        public ValidationError validate() {
            Logger.info("VALIDATING");
            Logger.info("email {} password {}", getEmail(), getPassword());
            if (User.authenticate(getEmail(), getPassword()) == null) {
                // Error will be displayed for the email field:
                Logger.info("Can't authenticate the user.");
                return new ValidationError("email", "Invalid credentials");
            }
            return null;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    private final FormFactory formFactory;

    // Injecting formFactory
    @Inject
    public AuthController(final FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result login() {
        return ok(
            login.render(formFactory.form(LoginForm.class))
        );
    }

    public Result authenticate() {
        Logger.info("AuthController.authenticate");
        Form<LoginForm> loginForm = formFactory.form(LoginForm.class).bindFromRequest();
        Logger.info("Got the loginForm: {}", loginForm.toString());
        if (loginForm.hasErrors() ){
            Logger.info("loginForm had errors {}", loginForm.allErrors());
            return badRequest(login.render(loginForm));
        } else {
            Logger.info("loginForm passed the check: {}", loginForm.toString());
            Logger.info("Inside values: {}",loginForm.get());
            session().clear();
            session("email", loginForm.get().getEmail());
            return redirect(routes.HomeController.index());
        }

    }

    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
                routes.HomeController.index()
        );
    }
}
