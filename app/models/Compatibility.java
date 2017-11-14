package models;

import play.data.format.*;
import play.data.validation.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Compatibility extends BaseModel {

    private static final long serialVersionUID = 1L;
    
    @Constraints.Required
    private long bikeProductID;

    @Constraints.Required
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
                "id=" + id +
                ", bikeProductID=" + bikeProductID +
                ", componentProductID=" + componentProductID +
                '}';
    }
}
