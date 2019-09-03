package ac.za.cput.adp3.xyzcongolmerate.factory.org;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.OrganisationUser;
import ac.za.cput.adp3.xyzcongolmerate.domain.user.User;
import ac.za.cput.adp3.xyzcongolmerate.factory.user.UserFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

import static ac.za.cput.adp3.xyzcongolmerate.util.Helper.getSuffixFromClassName;
import static org.junit.Assert.*;

public class OrganisationUserFactoryTest {

    private static final String SUFFIX = getSuffixFromClassName(OrganisationUserFactory.class);

    @Test
    public void buildOrganisationUser() {
        User user = UserFactory.buildUser("test@test.com", "Banele", "Mlamleli");
        OrganisationUser orgUser = new OrganisationUser(SUFFIX + UUID.randomUUID().toString(), user.getUserEmail());
        Assert.assertNotNull(orgUser);
        Assert.assertNotNull(orgUser.getOrgCode());
        System.out.println(orgUser.toString());
    }
}