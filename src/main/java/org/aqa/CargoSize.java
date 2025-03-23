package org.aqa;

public class CargoSize {

    public enum SizeOfDelivery{
        SMALL, LARGE
    }

    private SizeOfDelivery size;

    public CargoSize(SizeOfDelivery size){
        this.size = size;
    }

    public SizeOfDelivery getSize() {
        return size;
    }
}
