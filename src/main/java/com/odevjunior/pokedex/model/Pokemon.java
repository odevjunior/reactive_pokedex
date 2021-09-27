package com.odevjunior.pokedex.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class Pokemon {
    @Id
    private String id;

    private String name;
    private String category;
    private String ability;
    private Double strength;
}
