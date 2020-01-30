package com.qgailab.designer.struct.decorator.logsample;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author linxu
 * @date 2020/1/30
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class SampleTest {
    static {
        initLogRecord();
    }

    private static void initLogRecord() {
        Properties props = null;
        FileInputStream fis = null;
        try {
            props = new Properties();
            fis = new FileInputStream("./log4j.properties");
            props.load(fis);
            PropertyConfigurator.configure(props);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            fis = null;
        }
    }

    public static void main(String[] args) {
        Logger logger = JsonLoggerFactory.getLogger(SampleTest.class);
        logger.info("test message");
        logger.error("occurred error",new NullPointerException("null p."));
        logger.debug("123");

    }
}
