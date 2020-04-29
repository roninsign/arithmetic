package com.dao;


import javax.script.ScriptException;

public interface Algorithm {



    /**
     * 不包含括号的四则运算，参数为四则运算的范围m1,m2
     * 运算符的数量o、
     * 是否包含乘除法
     * @param m1
     * @param m2
     * @param o
     * @param c
     * @return
     */
    public  String algorithm(int m1, int m2, int o, int c) throws ScriptException;


    /**
     *包含括号的四则运算，参数为四则运算的范围m1,m2
     * 运算符的数量o
     * 是否包含乘除法
     * @param m1
     * @param m2
     * @param o
     * @param c
     * @return
     */
    public  String BracketsAlgo(int m1, int m2, int o, int c) throws ScriptException;


    /**
     * 求最大公因数
     * @param x
     * @param y
     * @return
     */
    public int getNum(int x, int y);

    /**
     * 判断优先级
     * @param n
     * @return
     */
    public  int priority(int n);

    /**
     * 判断符号
     * @param n
     * @return
     */
    public  String symbol(int n);
}
