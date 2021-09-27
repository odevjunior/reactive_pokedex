package com.odevjunior.pokedex;

import com.odevjunior.pokedex.model.Pokemon;
import com.odevjunior.pokedex.repository.PokedexRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.util.BsonUtils;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class PokedexApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokedexApplication.class, args);
	}
	@Bean
	CommandLineRunner init (ReactiveMongoOperations operations, PokedexRepository repository) {
		return args -> {
			Flux<Pokemon> pokedexFlux = Flux.just(
					new Pokemon(null, "Blastoise", "Water", "Hydropump", 60.9),
					new Pokemon(null, "Wartoitle", "Water", "Hydropump", 6.9),
					new Pokemon(null, "Squirtle", "Water", "Hydropump", 2.9)
			).flatMap(repository::save);

			pokedexFlux
					.thenMany(repository.findAll())
					.subscribe(System.out::println);
		};
	}
}
