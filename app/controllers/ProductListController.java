package controllers;

import io.ebeaninternal.server.lib.util.Str;
import models.Category;
import models.Product;
import play.Logger;
import play.mvc.Result;
import views.html.productList;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static play.mvc.Controller.request;
import static play.mvc.Results.ok;

public class ProductListController {

    public Result getProductList(String categoryName) {
        Logger.info("Getting a product list for the category [{}]", categoryName);
        HashMap<String, List<String>> filterMap = new HashMap<>();
        Category cat = Category.findByName(categoryName);
        filterMap.put("Subcategories", cat.getSubcategoriesNames());
        filterMap.put("Color", cat.getColorList());
        filterMap.put("Manufacturer", cat.getManufacturerList());
        filterMap.put("Material", cat.getMaterialList());
        //filterMap.put("Price", cat.getPriceList());
        Logger.info("filterMap {}", filterMap);

        List<Product> plist= cat.getProductList();
        Logger.info("plist {}", plist);

        return ok(
                productList.render(
                        filterMap,
                        plist,
                        categoryName
                )
        );
    }

    public Result getProductsListBySearch() {
        Map<String, String[]> m = request().body().asFormUrlEncoded();
        Logger.info("m {}", m);
        String search = m.get("search")[0];
        List<Product> plist= Product.findByPartName(search);
        Logger.info("plist {}", plist);

        return ok(
                productList.render(
                        null,
                        plist,
                        "NONE"
                )
        );
    }


}
