package com.qgailab.designer.struct.flyweight;

/**
 * @author linxu
 * @date 2020/2/5
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class ConcreteFlyWeightString extends FlyWeightString {
    public ConcreteFlyWeightString(String string) {
        super(string);
    }

    @Override
    protected String printLastModifiedTime(String time) {
        System.out.println("time is:" + time);
        return time;
    }
}
