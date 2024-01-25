package me.lbenavides.webfluxhexagonal.pullrequest.application;

import me.lbenavides.webfluxhexagonal.pullrequest.domain.PullRequest;
import reactor.core.publisher.Flux;

public interface PrRepository {

    Flux<PullRequest> findAll();

}
