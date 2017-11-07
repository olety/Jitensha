package models;

import lombok.Data;
import play.data.format.*;
import play.data.validation.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
public class Compatibility extends BaseModel {

    private static final long serialVersionUID = 1L;
    
    @Constraints.Required
    public long bikeProductID;

    @Constraints.Required
    public long componentProductID;

}
