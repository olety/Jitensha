package models;

import io.ebean.Finder;
import play.Logger;
import play.data.format.*;
import play.data.validation.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "subcategories")
public class Subcategory extends BaseModel {

    private static final long serialVersionUID = 1L;
    public static final Finder<Long, Subcategory> find = new Finder<>(Subcategory.class);

    @Constraints.Required
    @Column(name = "CategoryId")
    private long categoryID;

    @Constraints.Required
    private String name;

    public HashSet<String> getColorSet() {
        HashSet<String> colorSet = new HashSet<>();
        for (Product product : Product.find.query().where().eq("subcategoryID", this.id).findList()) {
            colorSet.add(product.getColor());
        }
        return colorSet;
    }

    public HashSet<String> getMaterialSet() {
        HashSet<String> returnSet = new HashSet<>();
        for (Product product : Product.find.query().where().eq("subcategoryID", this.id).findList()) {
            returnSet.add(product.getMaterial());
        }
        return returnSet;
    }

    public HashSet<String> getManufacturerSet() {
        HashSet<String> returnSet = new HashSet<>();
        for (Product product : Product.find.query().where().eq("subcategoryID", this.id).findList()) {
            returnSet.add(product.getManufacturer());
        }
        return returnSet;
    }

    public HashSet<BigDecimal> getPriceSet() {
        HashSet<BigDecimal> returnSet = new HashSet<>();
        for (Product product : Product.find.query().where().eq("subcategoryID", this.id).findList()) {
            returnSet.add(product.getPrice());
        }
        return returnSet;
    }

    public List<Product> getProducts() {
        List<Product> productList = Product.find.query().where().eq("subcategoryID", this.id).findList();
        Logger.info("Getting products for '{}': '{}'", this.name, productList);
        return productList;
    }

    public Subcategory(@Constraints.Required long categoryID, String name) {
        this.categoryID = categoryID;
        this.name = name;
    }

    public Category getCategory() {
        return Category.find.query().where().eq("id", this.categoryID).findUnique();
    }

    public long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subcategory)) return false;
        if (!super.equals(o)) return false;

        Subcategory that = (Subcategory) o;

        if (getCategoryID() != that.getCategoryID()) return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getCategoryID() ^ (getCategoryID() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Subcategory{" +
                "id=" + id +
                ", categoryID=" + categoryID +
                ", name='" + name + '\'' +
                '}';
    }

    public static Subcategory findById(long id) {
        return find.query()
                .where()
                .eq("id", id)
                .findUnique();
    }

}
