package models;

import io.ebean.Model;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModel extends Model {

   @Id
   protected Long id;

   public BaseModel(Long id) {
      this.id = id;
   }

   public Long getId() {
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

      return getId() != null ? getId().equals(baseModel.getId()) : baseModel.getId() == null;
   }

   @Override
   public int hashCode() {
      return getId() != null ? getId().hashCode() : 0;
   }

   @Override
   public String toString() {
      return "BaseModel{" +
              "id=" + id +
              '}';
   }
}
