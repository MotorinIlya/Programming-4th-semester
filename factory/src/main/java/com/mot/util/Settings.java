package com.mot.util;

public class Settings {
    private int bodySupplyTime;
    private int motorSupplyTime;
    private int accessorySupplyTime;
    private int dealerSaleTime;

    public Settings(int accessorySupplyTime, int bodySupplyTime, int motorsSupplyTime, int dealerPeriod) {
        this.accessorySupplyTime = accessorySupplyTime;
        this.bodySupplyTime = bodySupplyTime;
        this.dealerSaleTime = dealerPeriod;
        this.motorSupplyTime = motorsSupplyTime;
    }

    public int getBodySupplyTime() {
        return bodySupplyTime;
    }

    public int getMotorSupplyTime() {
        return motorSupplyTime;
    }

    public int getAccessorySupplyTime() {
        return accessorySupplyTime;
    }

    public int getDealerSaleTime() {
        return dealerSaleTime;
    }

    public void setAccessorySupplyTime(int accessorySupplyTime) {
        this.accessorySupplyTime = accessorySupplyTime;
    }

    public void setBodySupplyTime(int bodySupplyTime) {
        this.bodySupplyTime = bodySupplyTime;
    }

    public void setMotorSupplyTime(int motorSupplyTime) {
        this.motorSupplyTime = motorSupplyTime;
    }

    public void setDealerSaleTime(int dealerSaleTime) {
        this.dealerSaleTime = dealerSaleTime;
    }
}
