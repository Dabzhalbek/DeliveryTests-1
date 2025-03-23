package org.aqa;

public class DeliveryCalculate {

    public int DeliveryCost(CargoSize size, DeliveryWorkload deliveryWorkload, int distance, boolean fragileCargo) {
        int cost = 0;

        if (distance > 30) {
            cost += 300;
        } else if (distance > 10) {
            cost += 200;
        } else if (distance > 2) {
            cost += 100;
        } else {
            cost += 50;
        }

        if (size.getSize() == CargoSize.SizeOfDelivery.SMALL) {
            cost += 100;
        } else if (size.getSize() == CargoSize.SizeOfDelivery.LARGE) {
            cost += 200;
        }

        if (fragileCargo) {
            if (distance > 30) {
                throw new IllegalArgumentException("Fragile cargo cannot be sent over a distance of more than 30 km.");
            }
            cost += 300;
        }

        double workloadMultiplier = 1;
        switch (deliveryWorkload.getWorkloadRate()) {
            case VERY_HIGH_WORKLOAD:
                workloadMultiplier = 1.6;
                break;
            case HIGH_WORKLOAD:
                workloadMultiplier = 1.4;
                break;
            case INCREASED_WORKLOAD:
                workloadMultiplier = 1.2;
                break;
            default:
                workloadMultiplier = 1;
        }
        cost *= workloadMultiplier;

        if (cost < 400) {
            cost = 400;
        }

        return cost;
    }
}
