package com.coderhouse.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para Time API")
public class TimeApiDTO {

    @Schema(description = "Año", example = "2025", requiredMode = Schema.RequiredMode.REQUIRED)
    private int year;

    @Schema(description = "Mes", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private int month;

    @Schema(description = "Día", example = "24", requiredMode = Schema.RequiredMode.REQUIRED)
    private int day;

    @Schema(description = "Hora", example = "14", requiredMode = Schema.RequiredMode.REQUIRED)
    private int hour;

    @Schema(description = "Minuto", example = "30", requiredMode = Schema.RequiredMode.REQUIRED)
    private int minute;

    @Schema(description = "Fecha y hora como cadena de texto", example = "2025-01-24T14:30:00", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String dateTime;

    // Constructores
    public TimeApiDTO() {
        super();
    }

    public TimeApiDTO(int year, int month, int day, int hour, int minute, String dateTime) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.dateTime = dateTime;
    }

    // Getters y Setters
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
