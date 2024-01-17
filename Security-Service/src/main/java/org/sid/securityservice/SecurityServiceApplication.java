package org.sid.securityservice;

import org.sid.securityservice.Config.RsakeysConfig;
import org.sid.securityservice.Entities.AppRole;
import org.sid.securityservice.Entities.AppUser;
import org.sid.securityservice.Service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
@EnableConfigurationProperties(RsakeysConfig.class)

public class SecurityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityServiceApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner start(AccountService accountService){
        return args ->{
            accountService.addNewUser(new AppUser(null,"user1","12345",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"admin","12345",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user2","12345",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user3","12345",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user4","12345",new ArrayList<>()));

            accountService.addNewRole(new AppRole(null,"USER"));
            accountService.addNewRole(new AppRole(null,"ADMIN"));
            accountService.addNewRole(new AppRole(null,"PRODUCT-MANAGER"));
            accountService.addNewRole(new AppRole(null,"CUSTOMER-MANAGER"));
            accountService.addNewRole(new AppRole(null,"BILLS-MANAGER"));

            accountService.addRoleToUser("user1","USER");
            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("admin","USER");
            accountService.addRoleToUser("user2","PRODUCT-MANAGER");
            accountService.addRoleToUser("user2","USER");
            accountService.addRoleToUser("user3","CUSTOMER-MANAGER");
            accountService.addRoleToUser("user3","USER");
            accountService.addRoleToUser("user4","BILLS-MANAGER");
            accountService.addRoleToUser("user4","USER");


        };
    }

}
