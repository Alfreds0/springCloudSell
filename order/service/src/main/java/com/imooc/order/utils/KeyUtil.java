package com.imooc.order.utils;

import java.util.Random;

public class KeyUtil {
    /**
     * 生成唯一主键+随机数
     * 格式：时间加随机数
     * @return
     */
    public synchronized static String getUniqueKey() {
        Random random=new Random();
        Integer number= random.nextInt(900000)+100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
