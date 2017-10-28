package controllers;

import play.mvc.*;

import views.html.*;


public class LoginController extends Controller {

    
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

}
