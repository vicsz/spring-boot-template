package com.sample.springboot;

import com.sample.springboot.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
@DirtiesContext
public class SampleControllerTests {

    @Value("${local.server.port}")
    private int port = 0;

    @Test
    public void testGreeting() throws Exception {
        ResponseEntity<String> entity = new TestRestTemplate().getForEntity("http://localhost:" + this.port + "/greeting?name=test", String.class);

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertTrue(entity.getBody().equals("Hello test"));
    }

    @Test
    public void testCalculation() throws Exception {
        ResponseEntity<Integer> entity = new TestRestTemplate().getForEntity("http://localhost:" + this.port + "/calculation?firstNumber=1&secondNumber=2", Integer.class);

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertTrue(entity.getBody().equals(3));
    }
}
