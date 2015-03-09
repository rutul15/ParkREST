package com.davidoladeji.exchange.repository;

import com.davidoladeji.exchange.model.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "exchange", path = "/")
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    Exchange findBySymbOneAndSymbTwo(@Param("symbone") String symbone, @Param("symbtwo")String symbtwo);
}

