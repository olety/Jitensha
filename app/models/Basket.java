package models;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Constraint;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="baskets")
public class Basket extends Model {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    protected long id;

    private static final long serialVersionUID = 1L;

    public static final Finder<Long, Basket> find = new Finder<>(Basket.class);

    public static List<Product> getUserProductList(User user) {
        return find.query().where().eq("userID", user.id).findList()
                .stream().map(Basket::getProductID)
                .map(Product::findProductById)
                .collect(Collectors.toList());
    }


    public static void deleteUserProductList(User user) {
        find.query().where().eq("userID", user.id).delete();
    }

    public static void deleteUserProduct(User user, long productID) {
        find.query().where().eq("userID", user.id).and().eq("productID", productID).findList().get(0).delete();
    }


    @Constraints.Required
    @Column(name="UserID")
    private long userID;

    @Constraints.Required
    @Column(name="ProductID")
    private long productID;


    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }
}
