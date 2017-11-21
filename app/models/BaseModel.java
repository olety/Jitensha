package models;

import io.ebean.Model;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModel extends Model {

   @Id
   protected long id;

   public BaseModel() { }

   public long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof BaseModel)) return false;

      BaseModel baseModel = (BaseModel) o;

      return getId() == baseModel.getId();
   }

   @Override
   public String toString() {
      return "BaseModel{" +
              "id=" + id +
              '}';
   }
}
