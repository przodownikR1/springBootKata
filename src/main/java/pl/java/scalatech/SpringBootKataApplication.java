package pl.java.scalatech;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pl.java.scalatech.compoment.StartupComponent;
import pl.java.scalatech.domain.Journal;
import pl.java.scalatech.repository.JournalRepository;

@SpringBootApplication
public class SpringBootKataApplication {

    @Autowired
    private StartupComponent startup;
    
    @Bean
    InitializingBean saveData(JournalRepository repo) {
        return () -> {
            repo.save(new Journal("Get to know Spring Boot", "Today I will learn Spring Boot","01/01/2016"));
                    repo.save(new Journal("Simple Spring Boot Project", "I will do my first Spring Boot Project","01/02/2016"));
                            repo.save(new Journal("Spring Boot Reading", "Read more about Spring Boot","02/01/2016"));
                                    repo.save(new Journal("Spring Boot in the Cloud", "Spring Boot using Cloud Foundry","03/01/2016"));
        };
    }

    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootKataApplication.class, args);
    }
}
