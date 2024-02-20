package com.lemon.auth.shared.search;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.Produces;

@ApplicationScoped
public class CriteriaSearchProducer {

    @Produces
    @Dependent
    public <T> CriteriaSearch<T> produceCriteriaSearch() {
        return new CriteriaSearch<>();
    }
}