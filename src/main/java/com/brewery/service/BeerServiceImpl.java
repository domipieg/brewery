package com.brewery.service;

import com.brewery.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDto getBeerById(UUID id) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .name("Leżajsk")
                .style("Lager")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        // todo impl
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.info("Deleting a beer: {}", beerId);
    }
}
