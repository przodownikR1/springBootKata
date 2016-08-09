package pl.java.scalatech.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class InternetHealth implements HealthIndicator {
    @Override
    public Health health() {
        try {
            RestTemplate rest = new RestTemplate();
            rest.getForObject("http://onet.pl", String.class);
            return Health.up().build();
        } catch (Exception e) {
            return Health.down().withDetail("reason", e.getMessage()).build();

        }
    }
}