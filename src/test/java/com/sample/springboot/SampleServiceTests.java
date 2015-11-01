package com.sample.springboot;

import com.sample.springboot.SampleService;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class SampleServiceTests {

    @Test
    public void testAddition(){
        SampleService sampleService = new SampleService();

        assertTrue(sampleService.calculateAddition(10,20) == 30);
    }

}
