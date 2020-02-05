package com.qgailab.designer.struct.flyweight;

/**
 * @author linxu
 * @date 2020/2/5
 * <tip>take care of yourself.everything is no in vain.</tip>
 * 抽象享元
 */
public abstract class FlyWeightString {
    private String string;
    private int length;


    public FlyWeightString(String string) {
        this.string = string;
        this.length = string.length();
    }

    /**
     *
     * @param time 外部状态
     * @return
     */
    protected abstract String printLastModifiedTime(String time);

    public String getString() {
        return string;
    }


    public int getLength() {
        return length;
    }
}
