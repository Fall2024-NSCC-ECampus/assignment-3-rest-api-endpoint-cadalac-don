package org.example.assignment3.controller;
import org.springframework.web.bind.annotation.RestController;
import org.example.assignment3.model.Shipment;
import org.example.assignment3.repository.ShipmentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
public class StoreController {
    private final ShipmentRepository shipmentRepository;

    public StoreController(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @PostMapping(value = "/shipment/new")
    public ResponseEntity<Shipment> createPurchase(@RequestBody Shipment shipment) {
        shipmentRepository.save(shipment);
        return new ResponseEntity<>(shipment, HttpStatus.CREATED);
    }

    @GetMapping(value = "/shipment/list")
    public ResponseEntity<List<Shipment>> listPurchase() {
        List<Shipment> shipment = shipmentRepository.findAll();
        return new ResponseEntity<>(shipment, HttpStatus.OK);
    }
}