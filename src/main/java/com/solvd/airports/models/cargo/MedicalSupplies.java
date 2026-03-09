
//* NOT IN USE, WIP

package com.solvd.airports.models.cargo;

import java.time.LocalDate;

public class MedicalSupplies {

    private String name;
    private LocalDate expirationDate;
    private Double requiredTemperature; // °C

    public MedicalSupplies() {}

    public MedicalSupplies (String name,
                           LocalDate expirationDate,
                           Double requiredTemperature) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.requiredTemperature = requiredTemperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getRequiredTemperature() {
        return requiredTemperature;
    }

    public void setRequiredTemperature(double requiredTemperature) {
        this.requiredTemperature = requiredTemperature;
    }


    @Override
    public String toString() {
        return "MedicalSupplies{" +
                "name='" + name + '\'' +
                ", expirationDate=" + expirationDate +
                ", requiredTemperature=" + requiredTemperature;
    }
}



