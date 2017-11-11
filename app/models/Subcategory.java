package models;

import play.data.format.*;
import play.data.validation.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Subcategory extends BaseModel {

    private static final long serialVersionUID = 1L;

    @Constraints.Required
    private Subcategory categoryID;

    private String name;

    public Subcategory(Long id, @Constraints.Required Subcategory categoryID, String name) {
        super(id);
        this.categoryID = categoryID;
        this.name = name;
    }

    public Subcategory getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Subcategory categoryID) {
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

        if (getCategoryID() != null ? !getCategoryID().equals(that.getCategoryID()) : that.getCategoryID() != null)
            return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getCategoryID() != null ? getCategoryID().hashCode() : 0);
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
}
