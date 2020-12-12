package by.htp.task08.entity.electronic.portable;

import by.htp.task08.entity.electronic.PortableElectronic;

import java.util.Objects;

public class Laptop extends PortableElectronic {

    private String os;
    private int memorySystem;
    private double cpu;

    public Laptop(String brand, int price, int batteryCapacity, String os, int memoryRam, int memorySystem, double cpu, double displayInches) {
        super(brand, price, displayInches, batteryCapacity, memoryRam);
        this.os = os;
        this.memorySystem = memorySystem;
        this.cpu = cpu;
    }


    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getMemorySystem() {
        return memorySystem;
    }

    public void setMemorySystem(int memorySystem) {
        this.memorySystem = memorySystem;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
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
        Laptop laptop = (Laptop) o;
        return memorySystem == laptop.memorySystem
                && Double.compare(laptop.cpu, cpu) == 0
                && Objects.equals(os, laptop.os);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), os, memorySystem, cpu);
    }

    @Override
    public String toString() {
        return "BRAND=" + getBrand() + ", PRICE=" + getPrice() + ", BATTERY_CAPACITY=" + getBatteryCapacity()
                + ", OS=" + getOs() + ", MEMORY_RAM=" + getMemoryRam() + ", SYSTEM_MEMORY=" + getMemorySystem()
                + ", CPU=" + getCpu() + ", DISPLAY_INCHES=" + getDisplayInches();
    }
}
