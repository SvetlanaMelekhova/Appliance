package by.htp.task08.entity.technic.kitchen;

import java.util.Objects;

public class Oven extends Kitchen {

    private int capacity;
    private int depth;

    public Oven(String brand, int price, int powerConsumption, int weight, int capacity, int depth, double height, double width) {
        super(brand, price, powerConsumption, weight, height, width);
        this.capacity = capacity;
        this.depth = depth;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDepth() {
        return depth;
    }

    @Override
    public void switchOn() {

    }

    @Override
    public void switchOff() {

    }

    //someMethods

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
        Oven oven = (Oven) o;
        return capacity == oven.capacity
                && depth == oven.depth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity, depth);
    }

    @Override
    public String toString() {
        return "BRAND=" + getBrand() + ", PRICE=" + getPrice() + ", POWER_CONSUMPTION=" + getPowerConsumption()
                + ", WEIGHT=" + getWeight() + ", CAPACITY=" + getCapacity() + ", DEPTH=" + getDepth()
                + ", HEIGHT=" + getHeight() + ", WIDTH=" + getWidth();
    }
}
