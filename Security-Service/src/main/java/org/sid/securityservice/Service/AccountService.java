package org.sid.securityservice.Service;

import org.sid.securityservice.Entities.AppRole;
import org.sid.securityservice.Entities.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username,String roleName);
    AppUser loadUserByUserName(String username);
    List<AppUser>listUsers();
    List<AppRole>listRole();
}
