package com.qgailab.designer.action.modemethod;

/**
 * @author linxu
 * @date 2020/2/29
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class MergeSort extends SortAlgorithm {
    @Override
    public void sort(int[] arr) {
        //this is mode
        super.sort(arr);
        //my self impl
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            mergeSort(arr, left, mid - 1);
            mergeSort(arr, mid, right);
            //merge sort
        }
    }

    private void merge(int[] arr, int left, int right) {
        int[] temp = new int[right - left + 1];
        int p1 = left;
        int p2 = (right + left) >> 1;
        //some do.
    }


}
