package controllers;

import play.*;
import play.data.validation.Constraints;
import play.mvc.*;

import play.data.*;
import views.html.*;
import models.*;

import java.util.HashMap;
import java.util.HashSet;

import static play.mvc.Results.ok;

public class ProductController {
    public Result getProductList(long productId) {
        Product resProduct = Product.find.byId(productId);
        HashSet<Product> compatibleProducts = Compatibility.getCompatibleProducts(productId);
        Logger.info("Getting details for product {}: \n\tProduct [{}], \n\tCompat [{}]", productId, resProduct, compatibleProducts);
        return ok(product.render(
                resProduct,
                compatibleProducts
        ));
    }

}
