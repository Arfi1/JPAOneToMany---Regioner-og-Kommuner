package com.example.jpaonetomany.controller;

import com.example.jpaonetomany.model.Kommune;
import com.example.jpaonetomany.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class KommunePageController {

    @Autowired
    private KommuneRepository kommuneRepository;

    @GetMapping("kommunepage")
    public ResponseEntity<List<Kommune>> getPageOfKommuner() {
        int page = 4;
        int size = 5;
        Pageable kommunePage = PageRequest.of(page, size);
        Page<Kommune> pageKommune = kommuneRepository.findAll(kommunePage);
        List<Kommune> lstKommuner = pageKommune.getContent();
        return new ResponseEntity<>(lstKommuner, HttpStatus.OK);
    }

    @GetMapping("kommunepageparm")
    public ResponseEntity<Map<String, Object>> getPageOfKommuner(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable kommunePage = PageRequest.of(page, size);
        Page<Kommune> pageKommune = kommuneRepository.findAll(kommunePage);
        List<Kommune> lstKommuner = pageKommune.getContent();

        if (lstKommuner.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("kommuner", lstKommuner);
        map.put("currentPage", pageKommune.getNumber());
        map.put("totalItems", pageKommune.getTotalElements());

        return new ResponseEntity<>(map, HttpStatus.OK);
    }



 /*   {
        int page = 4;
        int size = 5;
        Pageable kommunePage = PageRequest.of(page, size);
        Page<Kommune> pageKommune = kommuneRepository.findAll(kommunePage);
        List<Kommune> lstKommuner = pageKommune.getContent();
        return new ResponseEntity<>(lstKommuner, HttpStatus.OK);
    }*/


}
