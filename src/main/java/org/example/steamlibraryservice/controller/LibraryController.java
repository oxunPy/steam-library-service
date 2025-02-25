package org.example.steamlibraryservice.controller;

import org.example.steamlibraryservice.entity.Library;
import org.example.steamlibraryservice.service.LibraryService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    // ✅ Get Library by User ID
    @GetMapping("/{userId}")
    public Mono<Library> getLibrary(@PathVariable Long userId) {
        return libraryService.getLibraryByUserId(userId);
    }

    // ✅ Add Game to User's Library
    @PostMapping("/add")
    public Mono<Library> addGameToLibrary(@RequestParam Long userId, @RequestParam String gameId) {
        return libraryService.addGameToLibrary(userId, gameId);
    }
}
