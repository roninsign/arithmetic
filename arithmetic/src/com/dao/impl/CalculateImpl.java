package com.dao.impl;

import com.dao.Calculate;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author huangjuncheng
 * @version 1.0
 * @classname CalculateImpl
 * @description TODO
 * @date 2020/4/28 0028 18:09
 **/
public class CalculateImpl implements Calculate {
    /*
     * @author huangjuncheng
     * @description //TODO 判断表达式str是否在m1-m2之间
     * @date 18:14 2020/4/28 0028
     * @param [str, m1, m2]
     * @return int
     **/
    @Override
    public int calculate(String str, int m1, int m2) throws ScriptException {
        String s= str.replace('÷','/');//将除号转化为程序可识别的除号
        ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
        String hush = String.valueOf(jse.eval(s));
        double temp = Double.parseDouble(hush);
        int result = (int)temp;
        return (temp!=result||result>m2||result<m1)?0:1;
    }
    /*
     * @author huangjuncheng
     * @description //TODO 返回表达式str的计算结果
     * @date 18:18 2020/4/28 0028
     * @param [str]
     * @return int
     **/
    @Override
    public int calculate(String str) throws ScriptException {
        String s= str.replace('÷','/');
        ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
        String hush = String.valueOf(jse.eval(s));
        double temp = Double.parseDouble(hush);
        int result = (int)temp;
        return result;
    }
}
