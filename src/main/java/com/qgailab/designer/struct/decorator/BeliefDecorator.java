package com.qgailab.designer.struct.decorator;

/**
 * @author linxu
 * @date 2020/1/30
 * <tip>take care of yourself.everything is no in vain.</tip>
 * 抽象信仰装饰器
 */
public class BeliefDecorator implements Belief {
    private Belief belief;

    public BeliefDecorator(Belief belief) {
        this.belief = belief;
    }

    @Override
    public void mambaSpirit() {
        this.belief.mambaSpirit();
    }
}
