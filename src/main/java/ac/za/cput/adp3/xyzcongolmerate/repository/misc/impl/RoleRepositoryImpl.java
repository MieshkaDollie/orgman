package ac.za.cput.adp3.xyzcongolmerate.repository.misc.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.misc.Role;
import ac.za.cput.adp3.xyzcongolmerate.repository.misc.RoleRepository;

import java.util.HashSet;
import java.util.Set;

public class RoleRepositoryImpl implements RoleRepository {

    private Set<Role> roleDB;
    private static RoleRepository roleRepository = null;

    private RoleRepositoryImpl() {
        this.roleDB = new HashSet<>();
    }

    public static RoleRepository getRoleRepository() {
        if (roleRepository == null) roleRepository = new RoleRepositoryImpl();
        return roleRepository;
    }

    @Override
    public Role create(Role role) {
        this.roleDB.add(role);
        return role;
    }

    @Override
    public Role read(String roleId) {
        return  roleDB.stream()
                .filter(role -> roleId.equalsIgnoreCase(role.getRoleId()))
                .findAny()
                .orElse(null);
    }

    @Override
    public Role update(Role role) {
        if(read(role.getRoleId()) != null){
            delete(role.getRoleId());
            create(role);
        }
        return role;
    }

    @Override
    public void delete(String roleId) {
        Role role = read(roleId);
        this.roleDB.remove(role);
    }

    @Override
    public Set<Role> getAll() {
        return roleDB;
    }
}
