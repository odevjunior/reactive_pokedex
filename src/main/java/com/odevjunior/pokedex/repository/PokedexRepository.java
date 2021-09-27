package com.odevjunior.pokedex.repository;

import com.odevjunior.pokedex.model.Pokemon;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokedexRepository extends ReactiveMongoRepository<Pokemon, String> {
}
