package ac.za.cput.adp3.xyzcongolmerate.factory.misc;

import ac.za.cput.adp3.xyzcongolmerate.domain.misc.Role;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoleFactoryTest {

    @Test
    public void buildRole() {
        Role role = RoleFactory.buildRole("root");
        Assert.assertNotNull(role.getRoleId());
        Assert.assertEquals("root", role.getRoleName());
        System.out.println("Role ID:\t"+ role.getRoleId() +"\nRole name:\t"+ role.getRoleName());
    }
}