package ac.za.cput.adp3.xyzcongolmerate.factory.demography;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Race;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceFactoryTest {

    @Test
    public void buildRace() {
        Race race = RaceFactory.buildRace("Black-man");
        Assert.assertNotNull(race.getRaceId());
        Assert.assertEquals("Black-man", race.getRaceDescription());
        System.out.println("Race ID:\t"+ race.getRaceId() +"\nRace desc.:\t"+ race.getRaceDescription());
    }
}