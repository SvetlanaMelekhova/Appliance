package by.htp.task08.entity.technic;

import by.htp.task08.entity.Appliance;

import java.util.Objects;

public abstract class Technic extends Appliance {

    private int powerConsumption;

    public Technic(String brand, int price, int powerConsumption) {
        super(brand, price);
        this.powerConsumption = powerConsumption;
    }

    public int getPowerConsumption() {

        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {

        this.powerConsumption = powerConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Technic that = (Technic) o;
        return powerConsumption == that.powerConsumption;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), powerConsumption);
    }

    @Override
    public String toString() {
        return "Technic " + "Power Consumption: " + powerConsumption;
    }
}
