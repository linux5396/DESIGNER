package com.qgailab.designer.action.modemethod;

/**
 * @author linxu
 * @date 2020/2/29
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public abstract class SortAlgorithm implements Algorithm {
    @Override
    public void sort(int[] arr) {
        //verify
        if (arr == null || arr.length < 2) {
            return;
        }
        //extern
    }
}
