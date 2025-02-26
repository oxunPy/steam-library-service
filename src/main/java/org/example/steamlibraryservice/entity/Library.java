package org.example.steamlibraryservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "libraries")
public class Library {
    @Id
    private String id;

    private Long userId;

    private List<String> gameIds;         // List of owned game IDs

    private LocalDateTime lastUpdated;

    public void addGame(String gameId) {
        this.gameIds.add(gameId);
    }

    public void removeGame(String gameId) {
        this.gameIds.remove(gameId);
    }

    public Library(String id, Long userId, List<String> gameIds, LocalDateTime lastUpdated) {
        this.id = id;
        this.userId = userId;
        this.gameIds = gameIds;
        this.lastUpdated = lastUpdated;
    }

    public Library() {}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getGameIds() {
        return gameIds;
    }

    public void setGameIds(List<String> gameIds) {
        this.gameIds = gameIds;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
