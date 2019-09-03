package ac.za.cput.adp3.xyzcongolmerate.factory.user;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserFactoryTest {

    @Test
    public void buildUser() {
        User userTest = UserFactory.buildUser("test@test.com","Banele","Mlamleli");
        System.out.println(userTest);
        Assert.assertNotNull(userTest.toString());
        assertEquals("test@test.com", userTest.toString());
    }
}