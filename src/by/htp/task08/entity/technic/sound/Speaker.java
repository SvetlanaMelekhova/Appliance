package by.htp.task08.entity.technic.sound;

import by.htp.task08.entity.technic.Technic;

import java.util.Objects;

public class Speaker extends Technic {

    private int numberOfSpeakers;
    private Range frequencyRange;
    private int cordLength;


    public Speaker(String brand, int price, int powerConsumption, int numberOfSpeakers, Range frequencyRange, int cordLength) {
        super(brand, price, powerConsumption);
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRange = frequencyRange;
        this.cordLength = cordLength;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public Range getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(Range frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public int getCordLength() {
        return cordLength;
    }

    public void setCordLength(int cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public void switchOn() { }

    @Override
    public void switchOff() { }

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
        Speaker speaker = (Speaker) o;
        return numberOfSpeakers == speaker.numberOfSpeakers
                && cordLength == speaker.cordLength
                && Objects.equals(frequencyRange, speaker.frequencyRange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfSpeakers, frequencyRange, cordLength);
    }

    @Override
    public String toString() {
        return "BRAND=" + getBrand() + ", PRICE=" + getPrice() + ", POWER_CONSUMPTION=" + getPowerConsumption()
                + ", NUMBER_OF_SPEAKERS=" + getNumberOfSpeakers() + ", FREQUENCY_RANGE=" + getFrequencyRange()
                + ", CORD_LENGTH=" + getCordLength();
    }
}
