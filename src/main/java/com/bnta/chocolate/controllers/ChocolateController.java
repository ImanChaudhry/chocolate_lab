package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("chocolate") // localhost:8080/chocolate
public class ChocolateController {

    @Autowired
    ChocolateRepository chocolateRepository;


// SHOW
    @GetMapping
    public ResponseEntity<Chocolate> getAllChocolatesAndFilters(
            @RequestParam(required = false, name = "type") String type
    ){
        if (type != null){
            return new ResponseEntity(chocolateRepository.findAll(), HttpStatus.OK);
        }
        return new ResponseEntity(chocolateRepository.findChocolateByType(type), HttpStatus.OK);
    }

// POST

    @PostMapping // localhost:8080/pets/
    public ResponseEntity<Chocolate> createChocolate(@RequestBody Chocolate newChocolate){
        chocolateRepository.save(newChocolate);
        return new ResponseEntity<>(newChocolate, HttpStatus.CREATED);
    }

}
