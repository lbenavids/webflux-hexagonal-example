package me.lbenavides.webfluxhexagonal.pullrequest.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public interface CommitDurationService {

    Duration calculateCodingTime(String prId, LocalDateTime creationDate);

}
