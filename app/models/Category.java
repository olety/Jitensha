package models;

import io.ebean.Finder;
import play.Logger;
import play.data.format.*;
import play.data.validation.*;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

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

    public HashSet<String> getMaterialSet(){
        HashSet<String> returnSet = new HashSet<>();
        for (Subcategory sb: this.getSubcategories()) {
            for (Product product : Product.find.query().where().eq("subcategoryID", sb.id).findList()) {
                returnSet.add(product.getMaterial());
            }
        }
        return returnSet;
    }

    public HashSet<String> getManufacturerSet(){
        HashSet<String> returnSet = new HashSet<>();
        for (Subcategory sb: this.getSubcategories()) {
            for (Product product : Product.find.query().where().eq("subcategoryID", sb.id).findList()) {
                returnSet.add(product.getManufacturer());
            }
        }
        return returnSet;
    }

    public HashSet<BigDecimal> getPriceSet(){
        HashSet<BigDecimal> returnSet = new HashSet<>();
        for (Subcategory sb: this.getSubcategories()) {
            for (Product product : Product.find.query().where().eq("subcategoryID", sb.id).findList()) {
                returnSet.add(product.getPrice());
            }
        }
        return returnSet;
    }

    public HashSet<String> getColorSet(){
        HashSet<String> returnSet = new HashSet<>();
        for (Subcategory sb: this.getSubcategories()) {
            for (Product product : Product.find.query().where().eq("subcategoryID", sb.id).findList()) {
                returnSet.add(product.getColor());
            }
        }
        return returnSet;
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
