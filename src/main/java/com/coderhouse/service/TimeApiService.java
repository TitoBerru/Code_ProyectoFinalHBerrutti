package com.coderhouse.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coderhouse.dtos.TimeApiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

@Service
public class TimeApiService {

    @Autowired
    private RestTemplate restTemplate;

  
    private final String API_URL = "https://timeapi.io/api/Time/current/zone?timeZone=America/Argentina/Buenos_Aires";

    public LocalDateTime getCurrentTime() {
    	try {
    		TimeApiDTO response = restTemplate.getForObject(API_URL, TimeApiDTO.class);
            return LocalDateTime.parse(response.getDateTime());
        } catch (DateTimeParseException e) {
            // Manejo de excepciones cuando el formato de la fecha no es válido
            System.err.println("Error parsing date: " + e.getMessage());
            return LocalDateTime.now();
        } catch (Exception e) {
            // Manejo de otras excepciones
            System.err.println("Error fetching time: " + e.getMessage());
            return LocalDateTime.now();
        }
    }
}
