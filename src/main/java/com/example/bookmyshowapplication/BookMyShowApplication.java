package com.example.bookmyshowapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// enables spring to automatically populate certain fields in our entities (like createdDate, lastModifiedDate, createdBy, and lastModifiedBy) based on the lifecycle events of the entity.
// This is particularly useful for tracking when an entity was created or updated and by whom.
@EnableJpaAuditing
public class BookMyShowApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

}

