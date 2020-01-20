package com.qgailab.designer.createmode.factory.abstracts;

import com.qgailab.designer.createmode.factory.method.Tea;

/**
 * @author linxu
 * @date 2020/1/20
 * <tip>take care of yourself.everything is no in vain.</tip>
 * 抽象工工的核心思想在于工厂是抽象的，能够生产各式各样的产品
 */
public interface AbstractFactory {
    Tea createTea();

    Beard createBeard();
}
