package com.sample.helloworld;

import org.springframework.stereotype.Component;

@Component
public class SampleService {

    public int calculateAddition(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }
}
