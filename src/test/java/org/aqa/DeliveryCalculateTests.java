package org.aqa;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DeliveryCalculateTests {
    private DeliveryCalculate deliveryCalculate;
    private CargoSize cargoSizeLarge;
    private CargoSize cargoSizeSmall;
    private DeliveryWorkload deliveryWorkloadVeryHigh;
    private DeliveryWorkload deliveryWorkloadIncrease;
    private DeliveryWorkload deliveryWorkloadHigh;
    private DeliveryWorkload deliveryWorkloadNo;

    @BeforeAll
    public void setUp() {
        deliveryCalculate = new DeliveryCalculate();
        cargoSizeLarge = new CargoSize(CargoSize.SizeOfDelivery.LARGE);
        cargoSizeSmall = new CargoSize(CargoSize.SizeOfDelivery.SMALL);
        deliveryWorkloadVeryHigh = new DeliveryWorkload(DeliveryWorkload.WorkloadRate.VERY_HIGH_WORKLOAD);
        deliveryWorkloadHigh = new DeliveryWorkload(DeliveryWorkload.WorkloadRate.HIGH_WORKLOAD);
        deliveryWorkloadIncrease = new DeliveryWorkload(DeliveryWorkload.WorkloadRate.INCREASED_WORKLOAD);
        deliveryWorkloadNo = new DeliveryWorkload(DeliveryWorkload.WorkloadRate.NO_WORKLOAD);
    }

    @Test
    @Tag("negative")
    @DisplayName("Distance:35,Size:Large,Load:Increase,Fragile:true")
    public void costOf35kmWithHighWorkloadFragile() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->
        {deliveryCalculate.DeliveryCost(cargoSizeLarge, deliveryWorkloadIncrease, 35, true);});
        assertEquals("Fragile cargo cannot be sent over a distance of more than 30 km.", illegalArgumentException.getMessage());
    }

    @Test
    @Tag("positive")
    @DisplayName("Distance:35,Size:Small,Load:No,Fragile:false")
    public void costOf30kmWithNoWorkload() {
        int expectedCost = ((300 + 100) * 1);
        int actualCost = deliveryCalculate.DeliveryCost(cargoSizeSmall, deliveryWorkloadNo, 35, false);
        assertEquals(expectedCost, actualCost);
    }
}
