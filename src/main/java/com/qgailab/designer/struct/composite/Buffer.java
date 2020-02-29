package com.qgailab.designer.struct.composite;

/**
 * @author linxu
 * @date 2020/2/29
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public interface Buffer {
    void put(byte[] bytes);

    byte get(int index);

    byte[] read(int start, int length);
}
