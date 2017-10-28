package controllers;

import play.*;
import play.mvc.*;

import play.data.*;
import views.html.*;
import models.*;
import javax.inject.Inject;

public class AuthController extends Controller {

    public static class LoginForm {

        public String email;
        public String password;

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
        return ok();
    }

}
