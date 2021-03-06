package models;

import io.ebean.Finder;
import org.mindrot.jbcrypt.BCrypt;
import play.Logger;
import play.data.format.*;
import play.data.validation.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table (name="users")
public class User extends BaseModel {

    public static final Finder<Long, User> find = new Finder<>(User.class);

    private static final long serialVersionUID = 1L;

    @Constraints.Required
    @Formats.NonEmpty
    @Column(unique = true)
    private String email;

    @Constraints.Required
    @Formats.NonEmpty
    @Column (name="passwordhash")
    private String passwordHash;

    // Shipping info
    @Column (name="firstname")
    private String firstName;
    @Column (name="lastname")
    private String lastName;
    private String address;
    private String apartment;
    private String city;
    @Column (name="postcode")
    private String postCode;
    private String country;

    public User() {
        super();
    }

    public User(String email, String passwordHash, String firstName, String lastName, String address, String apartment, String city, String postCode, String country) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.apartment = apartment;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static User authenticate(String email, String password) {
        Optional<User> user = Optional.ofNullable(User.findByEmail(email));
        Logger.info("isPresent {}", user.isPresent());
        if (user.isPresent()) {
            Logger.info("Retrieved the user nullable {}", user.get());
            if (true) {
                Logger.info("User successfully validated {}", user.get());
                return user.get();
            }
        }
        Logger.info("Couldn't validate the user");
        return null;
    }

    public static User findByEmail(String email) {
        return find.query()
                .where()
                .eq("email", email)
                .findUnique();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        if (getEmail() != null ? !getEmail().equals(user.getEmail()) : user.getEmail() != null) return false;
        if (getPasswordHash() != null ? !getPasswordHash().equals(user.getPasswordHash()) : user.getPasswordHash() != null)
            return false;
        if (getFirstName() != null ? !getFirstName().equals(user.getFirstName()) : user.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(user.getLastName()) : user.getLastName() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(user.getAddress()) : user.getAddress() != null) return false;
        if (getApartment() != null ? !getApartment().equals(user.getApartment()) : user.getApartment() != null)
            return false;
        if (getCity() != null ? !getCity().equals(user.getCity()) : user.getCity() != null) return false;
        if (getPostCode() != null ? !getPostCode().equals(user.getPostCode()) : user.getPostCode() != null)
            return false;
        return getCountry() != null ? getCountry().equals(user.getCountry()) : user.getCountry() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPasswordHash() != null ? getPasswordHash().hashCode() : 0);
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getApartment() != null ? getApartment().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getPostCode() != null ? getPostCode().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", apartment='" + apartment + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
