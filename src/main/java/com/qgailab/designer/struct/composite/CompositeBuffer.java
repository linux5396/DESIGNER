package com.qgailab.designer.struct.composite;

import java.util.Arrays;

/**
 * @author linxu
 * @date 2020/2/29
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class CompositeBuffer implements Buffer {
    //存储引用
    private Buffer[] buffers = new Buffer[2];

    public void compositeBuffer(Buffer bf1, Buffer bf2) {
        //copy ref
        buffers[0] = bf1;
        buffers[1] = bf2;
    }

    @Override
    public void put(byte[] bytes) {

    }

    @Override
    public byte get(int index) {
        return 0;
    }

    @Override
    public byte[] read(int start, int length) {
        return new byte[0];
    }

    private int computeBufIndex(int start, int length) {
        return -1;
    }
}
