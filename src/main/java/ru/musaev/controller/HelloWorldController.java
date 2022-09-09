package ru.musaev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@GetMapping
    public ResponseEntity<String> sendHello() {
        return ResponseEntity.ok("Hello world");
    }

}
