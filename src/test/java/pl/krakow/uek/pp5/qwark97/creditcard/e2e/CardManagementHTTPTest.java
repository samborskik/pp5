package pl.krakow.uek.pp5.qwark97.creditcard.e2e;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import pl.krakow.uek.pp5.qwark97.creditcard.model.CreditCardDetailsDto;

import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class CardManagementHTTPTest {
    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    int port;

    @Test
    public void itAllowAccessCardList() {
        ResponseEntity re = restTemplate.getForEntity(getUrl("/api/fake-cards"), CreditCardDetailsDto[].class);
        assertThat(re.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(new Object[]{}).hasSize(2);
//        assertThat(Instant.now()).isAfterOrEqualTo(Instant.now().minus(Duration.ofDays(1)));
    }

    private String getUrl(String uri) {
        return String.format("http://localhost:%s/%s", port, uri);
    }

}
