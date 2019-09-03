package ac.za.cput.adp3.xyzcongolmerate.factory.demography;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Gender;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GenderFactoryTest {

    @Test
    public void buildGender() {
        Gender gender = GenderFactory.buildGender("Female");
        Assert.assertNotNull(gender.getGenderId());
        Assert.assertEquals("Female", gender.getGenderDescription());
        System.out.println(gender.toString());
    }
}