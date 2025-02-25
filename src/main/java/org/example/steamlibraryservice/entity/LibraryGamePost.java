package org.example.steamlibraryservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "lib_game_posts")
public class LibraryGamePost {
    @Id
    private String id;

    private String gameId;

    private String title;

    private String content;

    private LocalDateTime postedAt;
}
