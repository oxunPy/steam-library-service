package org.example.steamlibraryservice.repository;

import org.example.steamlibraryservice.entity.LibraryGamePost;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface LibraryGamePostRepository extends ReactiveMongoRepository<LibraryGamePost, String> {
    Flux<LibraryGamePost> findByGameIdOrderByPostedAtDesc(String gameId);
}
