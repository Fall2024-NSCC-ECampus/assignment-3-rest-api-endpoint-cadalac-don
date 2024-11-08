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

public class Store {
    @Column
    int shippingHubRates;
    @Column
    int creditCardNumber;
    @Column
    String creditCardName;
    @Column
    String companyID;
    @Column
    String itemPhones;
    @Column
    int quantities;

    @Id
    @GeneratedValue
    private Long id;

    public Store(int shippingHubRates, int creditCardNumber, String creditCardName,
                 String companyID, String itemPhones, int quantities) {
        this.shippingHubRates = shippingHubRates;
        this.creditCardNumber = creditCardNumber;
        this.creditCardName = creditCardName;
        this.companyID = companyID;
        this.itemPhones = itemPhones;
        this.quantities = quantities;
    }
}
