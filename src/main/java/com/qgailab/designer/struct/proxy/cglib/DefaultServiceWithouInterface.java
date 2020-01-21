package com.qgailab.designer.struct.proxy.cglib;

/**
 * @author linxu
 * @date 2020/1/21
 * <tip>take care of yourself.everything is no in vain.</tip>
 * 一个不实现接口的类的代理
 */
public class DefaultServiceWithouInterface {
    /*
     * final method cannot enhance
     */
    public /*final */void doAction() {
        System.out.println("i am without impl any interface.");
    }
}
