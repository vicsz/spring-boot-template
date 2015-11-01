package com.sample.springboot;

import org.springframework.stereotype.Component;

@Component
public class SampleService {

    public int calculateAddition(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }
}
