package ac.za.cput.adp3.xyzcongolmerate.repository.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserDemography;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.UserDemographyRepository;

import java.util.HashSet;
import java.util.Set;

public class UserDemographyRepositoryImpl implements UserDemographyRepository {

    private Set<UserDemography> userDemographyDB;
    private static UserDemographyRepository userDemographyRepository = null;

    private UserDemographyRepositoryImpl() {
        this.userDemographyDB = new HashSet<>();
    }

    public static UserDemographyRepository getUserDemographyRepository() {
        if (userDemographyRepository == null) userDemographyRepository = new UserDemographyRepositoryImpl();
        return userDemographyRepository;
    }

    @Override
    public UserDemography create(UserDemography userDemography) {
        this.userDemographyDB.add(userDemography);
        return userDemography;    }

    @Override
    public UserDemography read(String userEmail) {
        return  userDemographyDB.stream()
                .filter(userDemography -> userEmail.equalsIgnoreCase(userDemography.getUserEmail()))
                .findAny()
                .orElse(null);
    }

    @Override
    public UserDemography update(UserDemography userDemography) {
        if(read(userDemography.getUserEmail()) != null){
            delete(userDemography.getUserEmail());
            create(userDemography);
        }
        return userDemography;
    }

    @Override
    public void delete(String userEmail) {
        UserDemography userDemography = read(userEmail);
        this.userDemographyDB.remove(userEmail);    }

    //TODO: Implement body
    @Override
    public Set<UserDemography> getAll() {
        return userDemographyDB;
    }
}
