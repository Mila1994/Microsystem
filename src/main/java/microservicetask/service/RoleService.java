package microservicetask.service;


import microservicetask.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAllRoles();
    Role findRoleByName(String roleName);
}
