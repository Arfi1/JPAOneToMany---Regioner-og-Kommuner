package com.example.jpaonetomany.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
public class ExceptionController {

    @GetMapping("/file/{filename}")
    public String file(@PathVariable String filename) {
        String content = "";
        try {
            FileInputStream fs = new FileInputStream("c:/AFILE/" + filename);
            try {
                byte[] bytes = fs.readAllBytes();
                content = new String(bytes);
            } catch (Exception e) {
                return e.getMessage();
            }
        } catch (FileNotFoundException e){
            String s = e.getMessage();
            s = s + " file: " + filename + " not found";
            return s;
        }
        return content;
    }

    @GetMapping("div/{divnum}")
    public String div(@PathVariable int divnum) {
        int i1 = 100 / divnum;
        return "" + i1;
    }


    @GetMapping("loop/{loopnum}")
    public String loop(@PathVariable String loopnum) {
        int x = 0;
        // vi har tilføjet y så x ikke bliver størrer;
        int y = 0;
        try {
            x = Integer.parseInt(loopnum);
            for (int i = 0; i < x; i++) {
                y++;
            }
        }catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return e.getClass().getName() + " : " + e.getMessage();
        }
        return "" + x;
    }
}
