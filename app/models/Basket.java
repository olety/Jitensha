package models;

import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Constraint;

@Entity
@Table(name="baskets")
public class Basket {

    private static final long serialVersionUID = 1L;

    @Constraints.Required
    @Column(name="UserID")
    private long userID;

    @Constraints.Required
    @Column(name="ProductID")
    private long productID;

    private int quantity;

}
