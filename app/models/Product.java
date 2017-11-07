package models;

import play.data.format.*;
import play.data.validation.*;

import javax.persistence.*;
import java.util.*;
import java.math.BigDecimal;

@Entity
public class Product extends BaseModel {

    private static final long serialVersionUID = 1L;

    @Constraints.Required
    public long subcategoryID;

    @Constraints.Required
    public String name;

    public BigDecimal size;
    public String sizeUnit;
    public BigDecimal weight;
    public BigDecimal cost;
    public BigDecimal price;
    public int stock;
    public String color;
    public String material;
    public String manufacturer;

}
