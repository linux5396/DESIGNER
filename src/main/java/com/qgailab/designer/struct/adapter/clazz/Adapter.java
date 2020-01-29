package com.qgailab.designer.struct.adapter.clazz;

/**
 * @author linxu
 * @date 2020/1/29
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class Adapter extends Monitor implements Computer {

    @Override
    public String print(String msg) {
        System.out.println(msg);
        super.show();
        return msg;
    }

    @Override
    public String print() {
        super.show();
        return null;
    }
}
