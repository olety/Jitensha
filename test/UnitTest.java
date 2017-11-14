import models.*;
import org.junit.*;
import static org.junit.Assert.*;

import play.Application;
import play.db.Database;
import play.db.Databases;
import play.db.evolutions.Evolutions;
import play.test.Helpers;

public class UnitTest {
    private static Database database;
    private static Application app;

    @Test
    public void createAndRetrieveUser() {
        new User(1L, "bob@gmail.com", "secret", "" , "" ,"", "" ,"", "","").save();
        User bob = User.find.query().where().eq("email", "bob@gmail.com").findUnique();
        assertNotNull(bob);
        assertEquals("bob@gmail.com", bob.getEmail());
    }
//
//    @Test
//    public void tryAuthenticateUser() {
//        new User(1L, "bob@gmail.com", "secret", "" , "" ,"", "" ,"", "","").save();
//
//        assertNotNull(User.authenticate("bob@gmail.com", "secret"));
//        assertNull(User.authenticate("bob@gmail.com", "badpassword"));
//        assertNull(User.authenticate("tom@gmail.com", "secret"));
//    }

}
