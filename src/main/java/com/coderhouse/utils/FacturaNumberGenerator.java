package com.coderhouse.utils;

import org.springframework.stereotype.Component;
import com.coderhouse.repositories.FacturaRepository;
import java.time.LocalDate;

@Component
public class FacturaNumberGenerator {
    private final FacturaRepository facturaRepository;

    public FacturaNumberGenerator(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public String generateNextNumber() {
        String year = String.valueOf(LocalDate.now().getYear());
        Long lastNumber = facturaRepository.findLastNumberForYear(year);
        return String.format("%s-%08d", year, (lastNumber != null ? lastNumber + 1 : 1));
    }
}