package uz.iftixortalim.crmspring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class Token {

    @GetMapping("/get-server-token")
    public ResponseEntity<String> token(){
        return ResponseEntity.ok("public_FW25bs89f41BybJjVaF3PmWbCUEM");
    }
}
