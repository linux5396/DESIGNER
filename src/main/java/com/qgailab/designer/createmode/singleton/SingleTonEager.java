package com.qgailab.designer.createmode.singleton;

/**
 * @author linxu
 * @date 2020/1/19
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class SingleTonEager {
    private static SingleTonEager inst;

    private SingleTonEager() {
    }

    static {
        inst = new SingleTonEager();
    }

}
