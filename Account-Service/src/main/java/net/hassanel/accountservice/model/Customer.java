package net.hassanel.accountservice.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Customer {
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
}
