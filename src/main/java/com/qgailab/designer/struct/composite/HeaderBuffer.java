package com.qgailab.designer.struct.composite;

/**
 * @author linxu
 * @date 2020/2/29
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class HeaderBuffer implements Buffer {
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
}
