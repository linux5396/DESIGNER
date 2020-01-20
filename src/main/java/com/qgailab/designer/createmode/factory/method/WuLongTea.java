package com.qgailab.designer.createmode.factory.method;

/**
 * @author linxu
 * @date 2020/1/20
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class WuLongTea extends Tea {
    public WuLongTea(String type) {
        this.teaType=type;
    }

    @Override
    public String showType() {
        return this.teaType;
    }
}
