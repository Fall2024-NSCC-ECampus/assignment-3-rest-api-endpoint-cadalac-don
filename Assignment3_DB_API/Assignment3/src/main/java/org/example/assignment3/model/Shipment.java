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

public class Shipment {
    @Column
    String firstName;
    @Column
    String lastName;
    @Column
    int trackingNumber;
    @Column
    String StoreInfo;
    @Column
    int returnTrackingNumber;

    @Id
    @GeneratedValue
    private Long id;

    public Shipment(String firstName, String lastName, int trackingNumber, String storeInfo, int returnTrackingNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.trackingNumber = trackingNumber;
        this.StoreInfo = storeInfo;
        this.returnTrackingNumber = returnTrackingNumber;
    }
}