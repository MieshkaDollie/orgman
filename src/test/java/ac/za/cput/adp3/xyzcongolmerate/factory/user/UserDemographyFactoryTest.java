package ac.za.cput.adp3.xyzcongolmerate.factory.user;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Gender;
import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Race;
import ac.za.cput.adp3.xyzcongolmerate.domain.user.User;
import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserDemography;
import ac.za.cput.adp3.xyzcongolmerate.factory.demography.GenderFactory;
import ac.za.cput.adp3.xyzcongolmerate.factory.demography.RaceFactory;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.*;

public class UserDemographyFactoryTest {

    @Test
    public void buildUserDemography() {
        User user = UserFactory.buildUser("md123@gmail.com","Mieshka","Dollie");
        Race race = RaceFactory.buildRace("Coloured");
        Gender gender = GenderFactory.buildGender("Female");
        Date date = new Date();
        UserDemography userDemography = UserDemographyFactory.buildUserDemography(user.getUserEmail(),"Tile",gender.getGenderId(),race.getRaceId(),date);
        assertNotNull(userDemography);
        assertNotNull(userDemography.getUserEmail());
        System.out.println(userDemography.toString());
    }
}