package ac.za.cput.adp3.xyzcongolmerate.factory.user;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserRole;
import ac.za.cput.adp3.xyzcongolmerate.factory.org.OrganisationUserFactory;
import org.junit.Test;

import java.util.UUID;

import static ac.za.cput.adp3.xyzcongolmerate.util.Helper.getSuffixFromClassName;
import static org.junit.Assert.*;

public class UserRoleFactoryTest {

    private static final String SUFFIX = getSuffixFromClassName(OrganisationUserFactory.class);

    @Test
    public void buildUserRole() {
        UserRole ur = UserRoleFactory.buildUserRole(SUFFIX + UUID.randomUUID().toString(), "test@test.com", "1");
        assertNotNull(ur);
        assertEquals("test@test.com", ur.getUserEmail());
        System.out.println(ur.toString());
    }
}