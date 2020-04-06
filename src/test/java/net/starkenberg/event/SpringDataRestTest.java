package net.starkenberg.event;

import net.starkenberg.event.model.Child;
import net.starkenberg.event.model.Event;
import net.starkenberg.event.model.Guardian;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@DirtiesContext
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class SpringDataRestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testEvent() {
        ResponseEntity<Event> entity = restTemplate.getForEntity(
                "http://localhost:" + this.port + "/events/1", Event.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(LocalDate.of(2018, 4, 11), entity.getBody().getEventDate());
        assertEquals(true, entity.getBody().isActive());
        assertEquals(true, entity.getBody().isRegistrationOpen());
        assertNotNull(entity.getBody().getCreateDate());
        assertNotNull(entity.getBody().getLastModifiedDate());
    }

    @Test
    public void testGuardian() {
        ResponseEntity<Guardian> entity = restTemplate.getForEntity(
                "http://localhost:" + this.port + "/guardians/1", Guardian.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals("fred", entity.getBody().getFirstName());
        assertEquals("flintstone", entity.getBody().getLastName());
        assertEquals("fred@flintstone.net", entity.getBody().getEmail());
        assertEquals(new Integer(12345), entity.getBody().getZipCode());
        assertNotNull(entity.getBody().getCreateDate());
        assertNotNull(entity.getBody().getLastModifiedDate());
    }

    @Test
    public void testChild() {
        ResponseEntity<Child> entity = restTemplate.getForEntity(
                "http://localhost:" + this.port + "/children/1", Child.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals("pebbles", entity.getBody().getName());
        assertEquals(false, entity.getBody().getSpecialNeeds());
        assertEquals(LocalDate.of(2015, 1, 1), entity.getBody().getBirthDate());
        assertNotNull(entity.getBody().getCreateDate());
        assertNotNull(entity.getBody().getLastModifiedDate());
    }

    @Test
    public void testChild2() {
        ResponseEntity<Child> entity = restTemplate.getForEntity(
                "http://localhost:" + this.port + "/children/2", Child.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals("bam", entity.getBody().getName());
        assertEquals(true, entity.getBody().getSpecialNeeds());
        assertEquals(LocalDate.of(2015, 11, 11), entity.getBody().getBirthDate());
        assertNotNull(entity.getBody().getCreateDate());
        assertNotNull(entity.getBody().getLastModifiedDate());
    }
}
