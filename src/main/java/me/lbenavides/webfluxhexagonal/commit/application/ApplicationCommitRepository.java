package me.lbenavides.webfluxhexagonal.commit.application;

import me.lbenavides.webfluxhexagonal.commit.domain.Commit;
import reactor.core.publisher.Flux;

public interface ApplicationCommitRepository {


    Flux<Commit> findByPrId(String prId);

}
