package com.istars;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
/*
    香农信息熵：H(x) = -sum(pi*log(pi))
    计算一个字符串序列（包含‘A’，‘B’，‘C’，‘D’四种字符，问确定这个字符所需的信息量。
    输入：content=“AABB”
    输出：1.0
 */

public class InforGain {

    public static void main(String[] args) {
        String str="AABBCC";
        //将字符串转换为字符数组
        char[] arrStr=str.toCharArray();
        Map<Character,Double> counts=new HashMap<Character, Double>();
        for(char c:arrStr) {
            //遍历字符数组，第一次遍历得到时将其数量为1.0，再次遍历时数量自增
            Double count=counts.get(c);
            if(count==null) {
                counts.put(c, 1.0);
            }else {
                counts.put(c, count+1.0);
            }
        }

        int arrLength = arrStr.length;
        Double result = 0.0;
        //遍历Map求求信息熵
        for(Map.Entry<Character, Double> entry:counts.entrySet()) {
            Double p = entry.getValue()/arrLength;
            result += p*(Math.log(p) / Math.log(2));
        }
        result = -result;
        //结果保留两位小数
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(result));
    }
}
