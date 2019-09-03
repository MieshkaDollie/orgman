package ac.za.cput.adp3.xyzcongolmerate.repository.demography.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Race;
import ac.za.cput.adp3.xyzcongolmerate.repository.demography.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpl implements RaceRepository {

    private Set<Race> raceDB;
    private static RaceRepository raceRepository = null;

    private RaceRepositoryImpl() {
        this.raceDB = new HashSet<>();
    }

    public static RaceRepository getRaceRepository() {
        if (raceRepository == null) raceRepository = new RaceRepositoryImpl();
        return raceRepository;
    }

    @Override
    public Race create(Race race) {
        this.raceDB.add(race);
        return race;
    }

    @Override
    public Race read(String raceId) {
        return  raceDB.stream()
                .filter(gender -> raceId.equalsIgnoreCase(raceId))
                .findAny()
                .orElse(null);
    }

    @Override
    public Race update(Race race) {
        if(read(race.getRaceId()) != null){
            delete(race.getRaceId());
            create(race);
        }
        return race;
    }

    @Override
    public void delete(String raceId) {
        Race race = read(raceId);
        this.raceDB.remove(race);
    }

    @Override
    public Set<Race> getAll() {
        return raceDB;
    }
}
