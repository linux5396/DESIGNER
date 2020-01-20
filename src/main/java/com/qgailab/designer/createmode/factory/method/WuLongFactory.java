package com.qgailab.designer.createmode.factory.method;

/**
 * @author linxu
 * @date 2020/1/20
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class WuLongFactory implements TeaFactory {
    @Override
    public Tea createTea() {
        return new WuLongTea("wulong");
    }
}
