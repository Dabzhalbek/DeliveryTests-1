package org.aqa;

public class DeliveryWorkload {

    public enum WorkloadRate {
        VERY_HIGH_WORKLOAD,
        HIGH_WORKLOAD,
        INCREASED_WORKLOAD,
        NO_WORKLOAD
    }

    private WorkloadRate workloadRate;

    public DeliveryWorkload(WorkloadRate workloadRate) {
        this.workloadRate = workloadRate;
    }

    public WorkloadRate getWorkloadRate() {
        return workloadRate;
    }
}
