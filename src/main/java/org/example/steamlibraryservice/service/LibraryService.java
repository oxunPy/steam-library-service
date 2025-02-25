package org.example.steamlibraryservice.service;

import org.example.steamlibraryservice.entity.Library;
import org.example.steamlibraryservice.entity.LibraryGamePost;
import org.example.steamlibraryservice.repository.LibraryGamePostRepository;
import org.example.steamlibraryservice.repository.LibraryRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Collections;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final LibraryGamePostRepository libraryGamePostRepository;

    public LibraryService(LibraryRepository libraryRepository, LibraryGamePostRepository libraryGamePostRepository) {
        this.libraryRepository = libraryRepository;
        this.libraryGamePostRepository = libraryGamePostRepository;
    }

    // Get Library by User ID
    public Mono<Library> getLibraryByUserId(Long userId) {
        return libraryRepository.findByUserId(userId);
    }

    // Add a game to the user's library
    public Mono<Library> addGameToLibrary(Long userId, String gameId) {
        return libraryRepository.findByUserId(userId)
                .defaultIfEmpty(new Library(null, userId, Collections.emptyList(), LocalDateTime.now()))
                .flatMap(library -> {
                    if (!library.getGameIds().contains(gameId)) {
                        library.getGameIds().add(gameId);
                        library.setLastUpdated(LocalDateTime.now());
                    }
                    return libraryRepository.save(library);
                });
    }

    public Flux<LibraryGamePost> getNewGamePosts(String gameId) {
        return libraryGamePostRepository.findByGameIdOrderByPostedAtDesc(gameId);
    }
}
