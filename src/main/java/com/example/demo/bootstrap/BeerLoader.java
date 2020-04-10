package com.example.demo.bootstrap;

import com.example.demo.domain.Beer;
import com.example.demo.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class BeerLoader implements CommandLineRunner {
    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadBeerObjects();
    }
    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Mango Boho")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .upc(337010000001L)
                    .price(new BigDecimal("12.23"))
                    .minOnHand(12)
                    .build()
            );
            beerRepository.save(Beer.builder()
                    .beerName("Bira")
                    .beerStyle("LPA")
                    .quantityToBrew(205)
                    .upc(337010000002L)
                    .price(new BigDecimal("12.235"))
                    .minOnHand(14)
                    .build()
            );
        }

        System.out.println("Loaded Beers.." + beerRepository.count());
    }
}
