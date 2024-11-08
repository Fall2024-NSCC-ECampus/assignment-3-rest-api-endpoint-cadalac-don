package org.example.assignment3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    @Column
    String firstName;
    @Column
    String lastName;
    @Column
    String phoneNumber;
    @Column
    String shippingAddress;
    @Column
    String email;

    @Id
    @GeneratedValue
    private Long id;

    public Customer(String firstName, String lastName, String phoneNumber, String shippingAddress, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.shippingAddress = shippingAddress;
        this.email = email;
    }
}
