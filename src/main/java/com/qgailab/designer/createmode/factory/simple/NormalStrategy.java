package com.qgailab.designer.createmode.factory.simple;

/**
 * @author linxu
 * @date 2020/1/20
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class NormalStrategy implements Strategy{
    private double discount;

    public NormalStrategy(double discount) {
        this.discount = discount;
    }

    @Override
    public double discount() {
        return discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
