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
    private long subcategoryID;

    @Constraints.Required
    private String name;

    private BigDecimal size;
    private String sizeUnit;
    private BigDecimal weight;
    private BigDecimal cost;
    private BigDecimal price;
    private int stock;
    private String color;
    private String material;
    private String manufacturer;

    public Product(long subcategoryID, String name, BigDecimal size, String sizeUnit,
                   BigDecimal weight, BigDecimal cost, BigDecimal price, int stock, String color, String material, String manufacturer) {
        this.subcategoryID = subcategoryID;
        this.name = name;
        this.size = size;
        this.sizeUnit = sizeUnit;
        this.weight = weight;
        this.cost = cost;
        this.price = price;
        this.stock = stock;
        this.color = color;
        this.material = material;
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        if (!super.equals(o)) return false;

        Product product = (Product) o;

        if (subcategoryID != product.subcategoryID) return false;
        if (stock != product.stock) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (size != null ? !size.equals(product.size) : product.size != null) return false;
        if (sizeUnit != null ? !sizeUnit.equals(product.sizeUnit) : product.sizeUnit != null) return false;
        if (weight != null ? !weight.equals(product.weight) : product.weight != null) return false;
        if (cost != null ? !cost.equals(product.cost) : product.cost != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (color != null ? !color.equals(product.color) : product.color != null) return false;
        if (material != null ? !material.equals(product.material) : product.material != null) return false;
        return manufacturer != null ? manufacturer.equals(product.manufacturer) : product.manufacturer == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (subcategoryID ^ (subcategoryID >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (sizeUnit != null ? sizeUnit.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + stock;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        return result;
    }

    public long getSubcategoryID() {
        return subcategoryID;
    }

    public void setSubcategoryID(long subcategoryID) {
        this.subcategoryID = subcategoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public String getSizeUnit() {
        return sizeUnit;
    }

    public void setSizeUnit(String sizeUnit) {
        this.sizeUnit = sizeUnit;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", subcategoryID=" + subcategoryID +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", sizeUnit='" + sizeUnit + '\'' +
                ", weight=" + weight +
                ", cost=" + cost +
                ", price=" + price +
                ", stock=" + stock +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
