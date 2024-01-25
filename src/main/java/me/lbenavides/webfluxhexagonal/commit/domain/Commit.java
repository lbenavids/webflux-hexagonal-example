package me.lbenavides.webfluxhexagonal.commit.domain;

import java.time.LocalDateTime;

public record Commit(String id, String message, String author, LocalDateTime creation, String prId) {
}
