package com.rabitabank.task.demo.controller;

import com.rabitabank.task.demo.model.*;
import com.rabitabank.task.demo.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/calc")
@RequiredArgsConstructor
public class MainController {

    private final MainService service;

    @PostMapping("/add")
    public ResponseEntity<ResultModel> add(@RequestBody RequestModel request) {
        return service.add(request);
    }

    @PostMapping("/subtract")
    public ResponseEntity<ResultModel> subtract(@RequestBody RequestModel request) {
        return service.subtract(request);
    }

    @PostMapping("/multiply")
    public ResponseEntity<ResultModel> multiply(@RequestBody RequestModel request) {
        return service.multiply(request);
    }

    @PostMapping("/divide")
    public ResponseEntity<ResultModel> divide(@RequestBody RequestModel request) {
        return service.divide(request);
    }
}
