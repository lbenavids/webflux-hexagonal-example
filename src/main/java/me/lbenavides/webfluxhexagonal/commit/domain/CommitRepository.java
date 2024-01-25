package me.lbenavides.webfluxhexagonal.commit.domain;

import java.util.List;

@FunctionalInterface
public interface CommitRepository {

    List<Commit> findByPrId(String prId);

}
