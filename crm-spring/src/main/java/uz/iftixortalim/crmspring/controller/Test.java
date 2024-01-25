package uz.iftixortalim.crmspring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class Test {

    @GetMapping("/checkJwt")
    public ResponseEntity<Boolean> checkJwt(){
        return ResponseEntity.ok(true);
    }
}
