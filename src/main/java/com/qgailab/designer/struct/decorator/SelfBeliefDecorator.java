package com.qgailab.designer.struct.decorator;

/**
 * @author linxu
 * @date 2020/1/30
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class SelfBeliefDecorator extends BeliefDecorator {
    public SelfBeliefDecorator(Belief belief) {
        super(belief);
    }

    @Override
    public void mambaSpirit() {
        //my declare
        System.out.println("I think so the mamba spirit,i decorate it with my additional thoughts.");
        super.mambaSpirit();
        System.out.println("never stop!never give up!do you self.");
    }

    public static void main(String[] args) {
        Belief belief=new KobeBelief();
        BeliefDecorator decorator=new SelfBeliefDecorator(belief);
        decorator.mambaSpirit();
    }
}
