package me.lbenavides.webfluxhexagonal.pullrequest.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public record PullRequest(String id, String title, String description, LocalDateTime creationDate, Duration codingTime) {

    public PullRequest(String id, String title, String description, LocalDateTime creationDate ) {
        this(id, title, description, creationDate, Duration.ofSeconds(0,0));
    }

    public PullRequest withCodingTime(Duration codingTime) {
        return new PullRequest(id, title, description, creationDate, codingTime);
    }

}
