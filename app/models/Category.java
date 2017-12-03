package models;

import io.ebean.Finder;
import play.Logger;
import play.data.format.*;
import play.data.validation.*;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "categories")
public class Category extends BaseModel {

    private static final long serialVersionUID = 1L;
    public static final Finder<Long, Category> find = new Finder<>(Category.class);

    @Constraints.Required
    private String name;

    public static Category findByName(String name) {
        return find.query()
                .where()
                .eq("name", name)
                .findUnique();
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subcategory> getSubcategories() {
        List<Subcategory> subcategoryList = Subcategory.find.query().where().eq("categoryID", this.id).findList();
        Logger.info("Getting subcategories for '{}': '{}'", this.name, subcategoryList);
        return subcategoryList;
    }

    public List<String> getSubcategoriesNames() {
        return Subcategory.find.query().where().eq("categoryID", this.id).findList()
                .stream()
                .map(Subcategory::getName)
                .collect(Collectors.toList());
    }

    public List<String> getMaterialList(){
        return this.getSubcategories()
                .stream()
                .map(sb -> Product.find.query().where().eq("subcategoryID", sb.id).findList())
                .flatMap(List::stream)
                .map(Product::getMaterial)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> getManufacturerList(){
        return this.getSubcategories()
                .stream()
                .map(sb -> Product.find.query().where().eq("subcategoryID", sb.id).findList())
                .flatMap(List::stream)
                .map(Product::getManufacturer)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> getPriceList(){
        return this.getSubcategories()
                .stream()
                .map(sb -> Product.find.query().where().eq("subcategoryID", sb.id).findList())
                .flatMap(List::stream)
                .map(prod -> prod.getPrice().toString())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> getColorList(){
        return this.getSubcategories()
                .stream()
                .map(sb -> Product.find.query().where().eq("subcategoryID", sb.id).findList())
                .flatMap(List::stream)
                .map(Product::getColor)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Product> getProductList(){
        return this.getSubcategories()
                .stream()
                .map(sb -> Product.find.query().where().eq("subcategoryID", sb.id).findList())
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        if (!super.equals(o)) return false;

        Category category = (Category) o;

        return getName() != null ? getName().equals(category.getName()) : category.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
