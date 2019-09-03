package ac.za.cput.adp3.xyzcongolmerate.repository.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.User;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.UserRepository;

import java.util.HashSet;
import java.util.Set;

public class UserRepositoryImpl implements UserRepository {

    private Set<User> userDB;
    private static UserRepository userRepository = null;

    private UserRepositoryImpl() {
        this.userDB = new HashSet<>();
    }

    public static UserRepository getUserRepository() {
        if (userRepository == null) userRepository = new UserRepositoryImpl();
        return userRepository;
    }

    @Override
    public User create(User user) {
        this.userDB.add(user);
        return user;
    }

    @Override
    public User read(String email) {
        return  userDB.stream()
                .filter(user -> email.equalsIgnoreCase(user.getUserEmail()))
                .findAny()
                .orElse(null);
    }

    @Override
    public User update(User user) {
        if(read(user.getUserEmail()) != null){
            delete(user.getUserEmail());
            create(user);
        }
        return user;
    }

    @Override
    public void delete(String email) {
        User user = read(email);
        this.userDB.remove(user);    }

    @Override
    public Set<User> getAll() {
        return userDB;
    }
}
