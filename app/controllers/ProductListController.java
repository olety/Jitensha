package controllers;

import io.ebean.Expression;
import models.Category;
import models.Product;
import models.Subcategory;
import play.Logger;
import play.mvc.Result;
import views.html.productList;


import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static play.mvc.Results.ok;

public class ProductListController {

    public Result getProductList(String categoryName) {
        HashMap<String, List<String>> filterMap = new HashMap<>();
        Category cat = Category.findByName(categoryName);
        filterMap.put("Subcategories", cat.getSubcategoriesNames());
        filterMap.put("Color", cat.getColorSet());
        filterMap.put("Manufacturer", cat.getManufacturerSet());
        filterMap.put("Material", cat.getMaterialSet());
        filterMap.put("Price", cat.getPriceSet());
        Logger.info("filterMap {}", filterMap);
        return ok(
                productList.render(
                        filterMap,
                        Product.find.all(),
                        categoryName
                )
        );
    }
    
}
