package ac.za.cput.adp3.xyzcongolmerate.repository.demography.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Gender;
import ac.za.cput.adp3.xyzcongolmerate.repository.demography.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {

    private static GenderRepository genderRepository = null;
    private Set<Gender> genderDB;

    private GenderRepositoryImpl() {
        this.genderDB = new HashSet<>();
    }

    public static GenderRepository genderRepository() {
        if (genderRepository == null) genderRepository = new GenderRepositoryImpl();
        return genderRepository;
    }

    @Override
    public Gender create(Gender gender) {
        this.genderDB.add(gender);
        return gender;
    }

    @Override
    public Gender read(final String genderId) {
        return  genderDB.stream()
                .filter(gender -> genderId.equalsIgnoreCase(gender.getGenderId()))
                .findAny()
                .orElse(null);
    }

    @Override
    public Gender update(Gender gender) {
        if(read(gender.getGenderId()) != null){
            delete(gender.getGenderId());
            create(gender);
        }
        return gender;
    }

    @Override
    public void delete(String genderId) {
        Gender gender = read(genderId);
        this.genderDB.remove(gender);
    }

    @Override
    public Set<Gender> getAll() {
        return genderDB;
    }
}
