package models;

import play.data.format.*;
import play.data.validation.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Subcategory extends BaseModel {

    private static final long serialVersionUID = 1L;

    @Constraints.Required
    public Subcategory categoryID;

    public String name;

}
