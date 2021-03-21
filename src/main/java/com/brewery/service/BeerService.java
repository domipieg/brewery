package com.brewery.service;

import com.brewery.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID id);
    BeerDto saveNewBeer(BeerDto beerDto);
    void updateBeer(UUID beerId, BeerDto beerDto);
    void deleteBeer(UUID beerId);
}
