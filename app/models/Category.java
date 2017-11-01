package models;

import play.data.format.*;
import play.data.validation.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Category extends BaseModel {

    private static final long serialVersionUID = 1L;

    @Constraints.Required
    public long categoryID;
	
	public String name;

}
