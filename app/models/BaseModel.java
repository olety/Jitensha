package models;

import io.ebean.Model;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class BaseModel extends Model {

   @Id
   public Long id;

}
