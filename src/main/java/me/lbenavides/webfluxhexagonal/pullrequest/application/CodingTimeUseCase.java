package me.lbenavides.webfluxhexagonal.pullrequest.application;

import me.lbenavides.webfluxhexagonal.commit.application.ApplicationCommitRepository;
import me.lbenavides.webfluxhexagonal.commit.domain.DurationService;
import me.lbenavides.webfluxhexagonal.pullrequest.domain.CodingTimeService;
import me.lbenavides.webfluxhexagonal.pullrequest.domain.PullRequest;
import reactor.core.publisher.Flux;

public class CodingTimeUseCase {

    private final PrRepository prRepository;
    private final ApplicationCommitRepository commitRepository;

    public CodingTimeUseCase(PrRepository prRepository, ApplicationCommitRepository commitRepository) {
        this.prRepository = prRepository;
        this.commitRepository = commitRepository;
    }


    public Flux<PullRequest> calculateForAll(){
        
   return      prRepository.findAll()
                .flatMap(pr -> commitRepository.findByPrId(pr.id()).collectList()
                        .map(list-> new CodingTimeService(new DurationService(prId -> list)))
                        .map(codingTimeService -> codingTimeService.calculateCodingTime(pr)));
    }

}
