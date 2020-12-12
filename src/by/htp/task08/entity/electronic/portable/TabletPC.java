package by.htp.task08.entity.electronic.portable;

import by.htp.task08.entity.electronic.PortableElectronic;

import java.util.Objects;

public class TabletPC extends PortableElectronic {

    private int flashMemoryCapacity;
    private String colour;

    public TabletPC(String brand, int price, int batteryCapacity, double displayInches, int memoryRam, int flashMemoryCapacity, String colour) {
        super(brand, price, displayInches, batteryCapacity, memoryRam);
        this.flashMemoryCapacity = flashMemoryCapacity;
        this.colour = colour;
    }

    public int getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(int flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
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
        TabletPC tabletPC = (TabletPC) o;
        return flashMemoryCapacity == tabletPC.flashMemoryCapacity
                && Objects.equals(colour, tabletPC.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), flashMemoryCapacity, colour);
    }

    @Override
    public String toString() {
        return "BRAND=" + getBrand() + ", PRICE=" + getPrice() + ", BATTERY_CAPACITY=" + getBatteryCapacity()
                + ", DISPLAY_INCHES=" + getDisplayInches() + ", MEMORY_RAM=" + getMemoryRam()
                + ", FLASH_MEMORY_CAPACITY=" + getFlashMemoryCapacity() + ", COLOR=" + getColour();
    }
}
