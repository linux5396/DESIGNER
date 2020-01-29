package com.qgailab.designer.struct.adapter.obj;

import com.qgailab.designer.struct.adapter.clazz.Monitor;

/**
 * @author linxu
 * @date 2020/1/29
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class MultiAdapter extends Laptop {
    private Monitor monitor;
    private Printer printer;

    public MultiAdapter(Monitor monitor) {
        this.monitor = monitor;
    }

    public MultiAdapter(Printer printer) {
        this.printer = printer;
    }

    public MultiAdapter(Monitor monitor, Printer printer) {
        this.monitor = monitor;
        this.printer = printer;
    }

    @Override
    public void printAnyWay(String msg) {
        printer.print(msg);
    }
}
