package com.sample.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Autowired
    private SampleService calculationService;

    @RequestMapping("/greeting")
    public ResponseEntity<String> greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new ResponseEntity<String>("Hello " + name, HttpStatus.OK);
    }

    @RequestMapping("/calculation")
    public ResponseEntity<Integer> calculation(@RequestParam(value="firstNumber") int firstNumber, @RequestParam(value="secondNumber") int secondNumber) {
        return new ResponseEntity<Integer>(calculationService.calculateAddition(firstNumber, secondNumber), HttpStatus.OK);
    }
}
