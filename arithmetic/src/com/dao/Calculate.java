package com.dao;

import javax.script.ScriptException;

public interface Calculate {
    /**
     * @author huangjuncheng
     * @description //TODO 判断表达式str是否在m1-m2之间
     * @date 18:08 2020/4/28 0028
     * @param [str, m1, m2]
     * @return int
     **/
    public int calculate(String str,int m1,int m2) throws ScriptException;
    /**
     * @author huangjuncheng
     * @description //TODO 返回表达式str的值
     * @date 18:08 2020/4/28 0028
     * @param [str]
     * @return int
     **/
    public int calculate(String str) throws ScriptException;

}
