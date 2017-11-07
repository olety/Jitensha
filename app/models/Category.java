package models;

import lombok.Data;
import play.data.format.*;
import play.data.validation.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
public class Category extends BaseModel {

    private static final long serialVersionUID = 1L;

    public String name;

}
