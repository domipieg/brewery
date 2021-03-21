package com.brewery.model;

import lombok.*;

import java.util.UUID;

@Data
@Builder
public class BeerDto {
    private UUID id;
    private String name;
    private BeerStyle style;
    private Long upc;
}
