package ac.za.cput.adp3.xyzcongolmerate.repository.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserRole;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.UserRoleRepository;

import java.util.HashSet;
import java.util.Set;

public class UserRoleRepositoryImpl implements UserRoleRepository {

    private Set<UserRole> userRoleDB;
    private static UserRoleRepository userRoleRepository = null;

    private UserRoleRepositoryImpl() {
        this.userRoleDB = new HashSet<>();
    }

    public static UserRoleRepository getUserRoleRepository() {
        if (userRoleRepository == null) userRoleRepository = new UserRoleRepositoryImpl();
        return userRoleRepository;
    }

    @Override
    public UserRole create(UserRole userRole) {
        this.userRoleDB.add(userRole);
        return userRole;
    }

    @Override
    public UserRole read(UserRole userRole) {
        return  userRoleDB.stream()
                .filter(usrRole -> usrRole.equals(usrRole.getUserEmail()))
                .findAny()
                .orElse(null);
    }

    @Override
    public UserRole update(UserRole userRole) {
        if(read(userRole) != null){
            delete(userRole);
            create(userRole);
        }
        return userRole;
    }

    @Override
    public void delete(UserRole userRole) {
        UserRole userRole1 = read(userRole);
        this.userRoleDB.remove(userRole);    }

    @Override
    public Set<UserRole> getAll() {
        return userRoleDB;
    }
}
