package models;

import io.ebean.Finder;
import io.ebean.Model;
import play.Logger;
import play.data.format.*;
import play.data.validation.*;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.*;

@Entity
@Table(name = "compatibility")
public class Compatibility extends Model {

    private static final long serialVersionUID = 1L;
    public static final Finder<Long, Compatibility> find = new Finder<>(Compatibility.class);

    public static HashSet<Product> getCompatibleProducts(long prodID) {
        HashSet<Product> compset = new HashSet<Product>();
        Logger.info("Getting products compatible with {}", prodID);
        List<Compatibility> compatibilityList = find.query().where().or()
                .eq("bikeProductID", prodID)
                .eq("componentProductID", prodID)
                .findList();
        Logger.info("Compatibility list: {}", compatibilityList);
        for (Compatibility comp : compatibilityList) {

            if (comp.bikeProductID == prodID) {
                compset.add(Product.find.byId(comp.componentProductID));
            } else {
                compset.add(Product.find.byId(comp.bikeProductID));
            }
        }
        return compset;
    }

    @Constraints.Required
    @Column(name = "BikeProductId")
    private long bikeProductID;

    @Constraints.Required
    @Column(name = "ComponentProductId")
    private long componentProductID;

    public Compatibility(long bikeProductID, long componentProductID) {
        this.bikeProductID = bikeProductID;
        this.componentProductID = componentProductID;
    }

    public long getBikeProductID() {
        return bikeProductID;
    }

    public void setBikeProductID(long bikeProductID) {
        this.bikeProductID = bikeProductID;
    }

    public long getComponentProductID() {
        return componentProductID;
    }

    public void setComponentProductID(long componentProductID) {
        this.componentProductID = componentProductID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compatibility)) return false;
        if (!super.equals(o)) return false;

        Compatibility that = (Compatibility) o;

        if (getBikeProductID() != that.getBikeProductID()) return false;
        return getComponentProductID() == that.getComponentProductID();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (getBikeProductID() ^ (getBikeProductID() >>> 32));
        result = 31 * result + (int) (getComponentProductID() ^ (getComponentProductID() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Compatibility{" +
                "bikeProductID=" + bikeProductID +
                ", componentProductID=" + componentProductID +
                '}';
    }
}
