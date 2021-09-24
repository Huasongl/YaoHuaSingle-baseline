package com.yaohua.studies.maththought;

import java.math.BigInteger;

public class lesson1_1 {

    /**
     * @deprecated
     * @param decimalSource 十进制数据源
     * @return 二进制字符
     */
    public static String decimalToBinary(int decimalSource){
        BigInteger bigInteger =new BigInteger(String.valueOf(decimalSource));
        return bigInteger.toString(2);
    }
}
