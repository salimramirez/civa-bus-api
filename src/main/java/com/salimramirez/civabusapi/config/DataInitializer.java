package com.salimramirez.civabusapi.config;

import com.salimramirez.civabusapi.entity.Bus;
import com.salimramirez.civabusapi.entity.BusBrand;
import com.salimramirez.civabusapi.repository.BusBrandRepository;
import com.salimramirez.civabusapi.repository.BusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {

    private final BusBrandRepository busBrandRepository;
    private final BusRepository busRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(DataInitializer.class);

    public DataInitializer(
            BusBrandRepository busBrandRepository,
            BusRepository busRepository
    ) {
        this.busBrandRepository = busBrandRepository;
        this.busRepository = busRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void seedDatabase() {
        if (busBrandRepository.count() == 0) {
            BusBrand volvo = new BusBrand(null, "Volvo");
            BusBrand scania = new BusBrand(null, "Scania");
            BusBrand mercedes = new BusBrand(null, "Mercedes-Benz");
            BusBrand fiat = new BusBrand(null, "Fiat");
            BusBrand marcoPolo = new BusBrand(null, "Marco Polo");
            busBrandRepository.saveAll(List.of(volvo, scania, mercedes, fiat, marcoPolo));
            LOGGER.info("Database seeded with default bus brands.");
            if (busRepository.count() == 0) {
                Bus bus1 = new Bus();
                bus1.setBusNumber("1001");
                bus1.setPlate("ABC-123");
                bus1.setCharacteristics("Cama, WiFi, Aire Acondicionado");
                bus1.setActive(true);
                bus1.setBrand(volvo);
                Bus bus2 = new Bus();
                bus2.setBusNumber("2002");
                bus2.setPlate("XYZ-789");
                bus2.setCharacteristics("Semicama, USB");
                bus2.setActive(true);
                bus2.setBrand(scania);
                Bus bus3 = new Bus();
                bus3.setBusNumber("3003");
                bus3.setPlate("LMN-456");
                bus3.setCharacteristics("Cama, WiFi, TV");
                bus3.setActive(false);
                bus3.setBrand(mercedes);
                Bus bus4 = new Bus();
                bus4.setBusNumber("4004");
                bus4.setPlate("DEF-234");
                bus4.setCharacteristics("Semicama, WiFi, USB");
                bus4.setActive(true);
                bus4.setBrand(fiat);
                Bus bus5 = new Bus();
                bus5.setBusNumber("5005");
                bus5.setPlate("GHI-567");
                bus5.setCharacteristics("Cama Suite, WiFi, TV");
                bus5.setActive(true);
                bus5.setBrand(marcoPolo);
                Bus bus6 = new Bus();
                bus6.setBusNumber("6006");
                bus6.setPlate("JKL-890");
                bus6.setCharacteristics("Semicama, Aire Acondicionado");
                bus6.setActive(false);
                bus6.setBrand(volvo);
                Bus bus7 = new Bus();
                bus7.setBusNumber("7007");
                bus7.setPlate("MNO-321");
                bus7.setCharacteristics("Cama, WiFi, Reclinables");
                bus7.setActive(true);
                bus7.setBrand(mercedes);
                busRepository.saveAll(List.of(bus1, bus2, bus3, bus4, bus5, bus6, bus7));
                LOGGER.info("Database seeded with default buses.");
            }
        }
    }
}
