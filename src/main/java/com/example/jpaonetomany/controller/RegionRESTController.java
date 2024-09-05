package com.example.jpaonetomany.controller;

import com.example.jpaonetomany.model.Kommune;
import com.example.jpaonetomany.model.Region;
import com.example.jpaonetomany.repository.RegionRepository;
import com.example.jpaonetomany.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RegionRESTController {

    @Autowired
    ApiServiceGetRegioner apiServiceGetRegioner;

    @Autowired
    RegionRepository regionRepository;

    @GetMapping("/getregioner")
    public List<Region> getRegioner(){
       List<Region> lstRegioner = apiServiceGetRegioner.getRegioner();
       return lstRegioner;
    }

    @PostMapping("/regioner")
    @ResponseStatus(HttpStatus.CREATED)
    public Region postRegion(@RequestBody Region region) {
        System.out.println(region);
        return regionRepository.save(region);
    }

    @PutMapping("/regioner/{kode}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Region> putRegion(@PathVariable String kode, @RequestBody Region region) {
        Optional<Region> orgRegion = regionRepository.findById(kode);
        if (orgRegion.isPresent()) {
            regionRepository.save(region);
            return ResponseEntity.ok(region);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/regioner/{kode}")
    public ResponseEntity<String> deleteRegion(@PathVariable String kode) {
        Optional<Region> orgRegion = regionRepository.findById(kode);
        if (orgRegion.isPresent()) {
            regionRepository.deleteById(kode);
            return ResponseEntity.ok("Region deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Region not found");
        }
    }

}
