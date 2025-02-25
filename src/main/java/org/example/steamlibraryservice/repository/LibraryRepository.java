package org.example.steamlibraryservice.repository;


import org.example.steamlibraryservice.entity.Library;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface LibraryRepository extends ReactiveMongoRepository<Library, String> {
    Mono<Library> findByUserId(Long userId);
}
