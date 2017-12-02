package controllers;

import models.Category;
import models.Product;
import play.Logger;
import play.mvc.Result;
import views.html.productList;


import java.util.HashMap;
import java.util.List;

import static play.mvc.Results.ok;

public class ProductListController {

    public Result getProductList(String categoryName, int page) {
        HashMap<String, List<String>> filterMap = new HashMap<>();
        Category cat = Category.findByName(categoryName);
        filterMap.put("Subcategories", cat.getSubcategoriesNames());
        filterMap.put("Color", cat.getColorList());
        filterMap.put("Manufacturer", cat.getManufacturerList());
        filterMap.put("Material", cat.getMaterialList());
        filterMap.put("Price", cat.getPriceList());
        Logger.info("filterMap {}", filterMap);
        return ok(
                productList.render(
                        filterMap,
                        Product.find.all().subList(page, page+16),
                        categoryName
                )
        );
    }
    
}
