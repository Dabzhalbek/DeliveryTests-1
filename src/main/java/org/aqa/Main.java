package org.aqa;

public class Main {
    public static void main(String[] args) {
        DeliveryCalculate calc = new DeliveryCalculate();
        CargoSize cargoSize = new CargoSize(CargoSize.SizeOfDelivery.LARGE);
        DeliveryWorkload deliveryWorkload = new DeliveryWorkload(DeliveryWorkload.WorkloadRate.VERY_HIGH_WORKLOAD);
        int cost = calc.DeliveryCost(cargoSize,deliveryWorkload,30,true);
        System.out.println(cost);
    }

    //(200+)*1.6
}
