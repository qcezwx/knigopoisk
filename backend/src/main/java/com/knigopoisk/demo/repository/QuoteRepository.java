package com.knigopoisk.demo.repository;

import com.knigopoisk.demo.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {
}
