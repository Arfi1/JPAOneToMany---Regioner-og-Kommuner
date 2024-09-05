package com.example.jpaonetomany.controller;

import com.example.jpaonetomany.model.Kommune;
import com.example.jpaonetomany.model.Region;
import com.example.jpaonetomany.repository.KommuneRepository;
import com.example.jpaonetomany.service.ApiServiceGetKommuner;
import com.example.jpaonetomany.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class KommuneRESTController {

    @Autowired
    ApiServiceGetKommuner apiServiceGetKommuner;
    @Autowired
    KommuneRepository kommuneRepository;

    @GetMapping("/getkommuner")
    public List<Kommune> getKommuner(){
        List<Kommune> lstKommuner = apiServiceGetKommuner.getKommuner();
        return lstKommuner;
    }

    @PostMapping("/kommuner")
    @ResponseStatus(HttpStatus.CREATED)
    public Kommune postKommune(@RequestBody Kommune kommune) {
        System.out.println(kommune);
        return kommuneRepository.save(kommune);
    }

    @PutMapping("/kommuner/{kode}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Kommune> putKommune(@PathVariable String kode, @RequestBody Kommune kommune) {
        Optional<Kommune> orgKommune = kommuneRepository.findById(kode);
        if (orgKommune.isPresent()) {
            kommuneRepository.save(kommune);
            return ResponseEntity.ok(kommune);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/kommuner/{kode}")
    public ResponseEntity<String> deleteKommune(@PathVariable String kode) {
        Optional<Kommune> orgKommune = kommuneRepository.findById(kode);
        if (orgKommune.isPresent()) {
            kommuneRepository.deleteById(kode);
            return ResponseEntity.ok("Kommune deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kommune not found");
        }
    }

}
