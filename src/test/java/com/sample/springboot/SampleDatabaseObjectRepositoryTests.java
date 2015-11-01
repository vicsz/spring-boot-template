package com.sample.springboot;

import com.sample.springboot.Application;
import com.sample.springboot.SampleDatabaseObject;
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

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
@DirtiesContext
public class SampleDatabaseObjectRepositoryTests {

    @Value("${local.server.port}")
    private int port = 0;

    @Test
    public void testPostAndGet() throws Exception {

        SampleDatabaseObject sampleObject = new SampleDatabaseObject();
        sampleObject.setSalutation("Hi");
        sampleObject.setPerson("JohnSmith");

        ResponseEntity<SampleDatabaseObject> postResponseEntity =
                new TestRestTemplate().postForEntity("http://localhost:" + this.port + "/sampleDatabaseObjects", sampleObject, SampleDatabaseObject.class);

        assertTrue(postResponseEntity.getStatusCode() == HttpStatus.CREATED);

        ResponseEntity<SampleDatabaseObject> getResponseEntity =
                new TestRestTemplate().getForEntity(postResponseEntity.getHeaders().getLocation().toString(), SampleDatabaseObject.class);

        assertTrue(getResponseEntity.getStatusCode() == HttpStatus.OK);

        assertTrue(getResponseEntity.getBody().getSalutation().equals("Hi"));
        assertTrue(getResponseEntity.getBody().getPerson().equals("JohnSmith"));
    }

    @Test
    public void testFailureOnDuplicateEntryOnUniqueColumn() throws Exception {

        SampleDatabaseObject sampleObject = new SampleDatabaseObject();
        sampleObject.setSalutation("Hi");
        sampleObject.setPerson("JohnSmith");

        ResponseEntity<SampleDatabaseObject> postResponseEntity =
                new TestRestTemplate().postForEntity("http://localhost:" + this.port + "/sampleDatabaseObjects", sampleObject, SampleDatabaseObject.class);

        assertTrue(postResponseEntity.getStatusCode() == HttpStatus.CREATED);

        ResponseEntity<SampleDatabaseObject> postResponseEntity2 =
                new TestRestTemplate().postForEntity("http://localhost:" + this.port + "/sampleDatabaseObjects", sampleObject, SampleDatabaseObject.class);

        assertTrue(postResponseEntity2.getStatusCode() == HttpStatus.CONFLICT);

    }

}
