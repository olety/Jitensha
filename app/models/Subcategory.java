package models;

import io.ebean.Finder;
import play.data.format.*;
import play.data.validation.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Subcategory extends BaseModel {

    private static final long serialVersionUID = 1L;
    public static final Finder<Long, Subcategory> find = new Finder<>(Subcategory.class);

    @Constraints.Required
    private long categoryID;

    @Constraints.Required
    private String name;

    public Subcategory(@Constraints.Required long categoryID, String name) {
        this.categoryID = categoryID;
        this.name = name;
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
    public static Subcategory findById(long id) {
        return find.query()
                .where()
                .eq("id", id)
                .findUnique();
    }

}
