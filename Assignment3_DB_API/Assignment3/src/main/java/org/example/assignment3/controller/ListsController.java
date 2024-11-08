package org.example.assignment3.controller;
import org.example.assignment3.model.Store;
import org.springframework.web.bind.annotation.RestController;
import org.example.assignment3.repository.StoreRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
public class ListsController {
    private final StoreRepository storeRepository;

    public ListsController(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @PostMapping(value = "/store/new")
    public ResponseEntity<Store> createList(@RequestBody Store store) {
        storeRepository.save(store);
        return new ResponseEntity<>(store, HttpStatus.CREATED);
    }

    @GetMapping(value = "/store/list")
    public ResponseEntity<List<Store>> listLists() {
        List<Store> store = storeRepository.findAll();
        return new ResponseEntity<>(store, HttpStatus.OK);
    }
}