package com.qgailab.designer.createmode.factory.abstracts;

import com.qgailab.designer.createmode.factory.method.Tea;
import com.qgailab.designer.createmode.factory.method.WuLongTea;

/**
 * @author linxu
 * @date 2020/1/20
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class ShenZhenFactory implements AbstractFactory {
    @Override
    public Tea createTea() {
        return new WuLongTea("wulong");
    }

    @Override
    public Beard createBeard() {
        return new Hanbeger("汉堡");
    }

    /**
     * 将工厂模式与单例模式配合使用
     */
    public static ShenZhenFactory getInstance() {
        return LazyHolder.INST;
    }

    public static final class LazyHolder {
        public static final ShenZhenFactory INST = new ShenZhenFactory();
    }
}
