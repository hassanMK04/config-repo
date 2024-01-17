package org.sid.securityservice.Web;

import lombok.Data;
import org.sid.securityservice.Entities.AppRole;
import org.sid.securityservice.Entities.AppUser;
import org.sid.securityservice.Service.AccountService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
public class AccountRestController {
    private AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping(path = "/users")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public AppUser addNewUser(@RequestBody AppUser appUser) {
        return accountService.addNewUser(appUser);
    }
    @PostMapping(path = "/Role")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public AppRole addNewRole(AppRole appRole) {
        return accountService.addNewRole(appRole);
    }
    @PostMapping(path = "/addRoleToUser")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public void addRoleToUser(String username, String roleName) {
        accountService.addRoleToUser(username, roleName);
    }
    @GetMapping(path = "/user/{username}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public AppUser loadUserByUserName(@PathVariable String username) {
        return accountService.loadUserByUserName(username);
    }
    @GetMapping(path = "/users")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public List<AppUser> listUsers() {
        return accountService.listUsers();
    }

    @GetMapping(path = "/roles")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public List<AppRole> listRoles() {
        return accountService.listRole();
    }

    @PostMapping(path = "/addRoleToUsers")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public void addRoleToUser(@RequestBody RoleUserForme roleUserForme) {
        accountService.addRoleToUser(roleUserForme.getUserName(), roleUserForme.getRoleName());
    }

    @GetMapping(path = "/dataTest")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public Map<String,Object> dataTest(Authentication authentication){
        return Map.of("username",authentication.getName(),
                "authorities",authentication.getAuthorities()
        );
    }
    @PostMapping(path = "/savedData")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Map<String,String>SavedData(String data){
        return Map.of("savedData",data

        );
    }
}
@Data
class RoleUserForme{
    private String userName;
    private String RoleName;
}