package com.qgailab.designer.struct.flyweight;

/**
 * @author linxu
 * @date 2020/2/6
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class TestFlyWeight {
    public static void main(String[] args) {
        String[] arg = {"myStringConstance"};
        FlyWeightString flyWeightString = FlyWeightFactory.getFlyWeight("concretestring", ConcreteFlyWeightString.class, arg);
        FlyWeightString flyWeightString1 = FlyWeightFactory.getFlyWeight("concretestring", ConcreteFlyWeightString.class, arg);
        flyWeightString.printLastModifiedTime(System.currentTimeMillis() + "");
        System.out.println(flyWeightString.getString());
        flyWeightString1.printLastModifiedTime(System.currentTimeMillis() + "---");
        System.out.println(flyWeightString1.getString());
    }
}
