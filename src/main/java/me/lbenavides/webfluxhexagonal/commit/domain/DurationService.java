package me.lbenavides.webfluxhexagonal.commit.domain;

import me.lbenavides.webfluxhexagonal.pullrequest.domain.CommitDurationService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public class DurationService implements CommitDurationService {

    private final CommitRepository commitRepository;

    public DurationService(CommitRepository commitRepository) {
        this.commitRepository = commitRepository;
    }

    @Override
    public Duration calculateCodingTime(String prId, LocalDateTime creationDate) {

        List<Commit> byPrId = commitRepository.findByPrId(prId);
        LocalDateTime minDate = filterStream(creationDate, byPrId).min(LocalDateTime::compareTo)
                .orElseThrow();

             LocalDateTime maxDate = filterStream(creationDate, byPrId).max(LocalDateTime::compareTo)
                .orElseThrow();


        return Duration.between(minDate, maxDate);
    }

    private static Stream<LocalDateTime> filterStream(LocalDateTime creationDate, List<Commit> byPrId) {
        return byPrId.stream()
                .filter(commit -> commit.creation()
                        .isBefore(creationDate))
                .map(Commit::creation);
    }
}
