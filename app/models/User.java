package models;

import play.data.format.*;
import play.data.validation.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class User extends BaseModel {

    private static final long serialVersionUID = 1L;

    @Constraints.Required
    public String email;

    @Constraints.Required
    public String passwordHash;

    // Shipping info
    public String firstName;
    public String lastName;
    public String address;
    public String apartment;
    public String city;
    public String postCode;
    public String country;

}
