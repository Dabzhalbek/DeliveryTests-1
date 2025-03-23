package org.aqa;

public class Size {

    public enum SizeOfDelivery{
        SMALL, LARGE
    }

    private SizeOfDelivery size;

    public Size (SizeOfDelivery size){
        this.size = size;
    }
}
