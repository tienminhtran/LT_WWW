package vn.edu.iuh.fit.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.entities.Role;
import vn.edu.iuh.fit.repositories.RoleRepository;

public class RoleServices {

    private RoleRepository roleRepository;

    public RoleServices() {
        this.roleRepository = new RoleRepository();
    }
    public Role getRoleByIdAccount(String account_id) {
        return roleRepository.getRoleByIdAccount(account_id);
    }
}
