package controllers;

import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;
import controllers.routes;
import models.Basket;
import models.Category;
import models.Product;
import models.User;
import play.Logger;
import play.core.routing.Route;
import play.mvc.Result;
import router.Routes;
import views.html.cart;
import views.html.login;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static play.mvc.Controller.request;
import static play.mvc.Controller.session;
import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;
import static play.mvc.Results.redirect;

public class ShopController {

    public Result addToCart(long itemId) {
        Logger.info("Trying to add {} to cart", itemId);
        Logger.info("Session {}", session());
        Optional<String> email = Optional.ofNullable(session().get("email"));
        if (email.isPresent()) {
            Optional<User> user = Optional.ofNullable(User.findByEmail(email.get()));
            if (user.isPresent()){
                Basket bought = new Basket();
                bought.setUserID(user.get().getId());
                bought.setProductID(itemId);
                Logger.info("Saving a new purchase: {}", bought);
                bought.save();
            }
            return ok();
        } else {
            return redirect(controllers.routes.AuthController.login());
        }
    }

    public Result removeFromCart(long itemId) {
        Logger.info("Trying to remove {} from cart", itemId);
        Logger.info("Session {}", session());
        Optional<String> email = Optional.ofNullable(session().get("email"));
        if (email.isPresent()) {
            Optional<User> user = Optional.ofNullable(User.findByEmail(email.get()));
            if (user.isPresent()){
                Logger.info("Deleting a product from a cart - user {} itemId {}", user.get(), itemId);
                Basket.deleteUserProduct(user.get(), itemId);
            }
            return ok();
        } else {
            return redirect(controllers.routes.AuthController.login());
        }
    }

    public Result displayCart() {
        String email = session().get("email");
        Optional<User> user = Optional.ofNullable(User.findByEmail(email));

        if (user.isPresent()) {
            List<Product> products = Basket.getUserProductList(user.get());
            Logger.info("Displaying cart to user {}, \nproductList = {}", user.get(), products);
            return ok(cart.render(products, null));
        }

        return badRequest(cart.render(null, null));
    }


    //
    public Result buyItems(String stripeToken, double amount) {
        Optional<User> user = Optional.ofNullable(User.findByEmail(session().get("email")));

        if (!user.isPresent()) {
            return badRequest(cart.render(null, null));
        }

        Stripe.apiKey = "sk_test_wnR8ArdUozEFO5pw2gjFcguv";

        // Token is created using Checkout or Elements!
        // Get the payment token ID submitted by the form:
        String token = stripeToken;

        // Charge the user's card:
        Map<String, Object> params = new HashMap<>();
        params.put("amount", amount);
        params.put("currency", "usd");
        params.put("description", "Example charge");
        params.put("source", token);

        Charge charge = null;

        try {
            charge = Charge.create(params);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (CardException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }

        Logger.info("Charging the stripe.io : {}", charge);
        Logger.info("Deleting user products...");

        Basket.deleteUserProductList(user.get());
        
        return ok(cart.render(Basket.getUserProductList(user.get()), charge));
    }

}
