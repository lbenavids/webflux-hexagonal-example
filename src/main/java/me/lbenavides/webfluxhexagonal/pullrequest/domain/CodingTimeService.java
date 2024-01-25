package me.lbenavides.webfluxhexagonal.pullrequest.domain;

import java.time.Duration;

public class CodingTimeService {
    private final CommitDurationService commitDurationService;

    public CodingTimeService(CommitDurationService commitDurationService) {
        this.commitDurationService = commitDurationService;
    }

    public PullRequest calculateCodingTime(PullRequest pullRequest) {
        Duration duration = this.commitDurationService.calculateCodingTime(pullRequest.id(),
                                                                           pullRequest.creationDate());
        return pullRequest.withCodingTime(duration);
    }



}
