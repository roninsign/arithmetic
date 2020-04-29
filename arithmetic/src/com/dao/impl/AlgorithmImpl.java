package com.dao.impl;

import com.dao.Algorithm;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class AlgorithmImpl implements Algorithm {


    /**
     * 不包含括号的四则运算，参数为四则运算的范围m1,m2
     * 运算符的数量o，默认为1
     * 是否包含乘除法 c=1，不包含。c=2，包含
     * @param m1
     * @param m2
     * @param o
     * @param c
     * @return
     */
    @Override
    public String algorithm(int m1, int m2, int o, int c) throws ScriptException {

        String S="";




        int m[]=new int[o];//存放运算符的数组
        int n = o + 1;
        int[] num = new int[n];                  //存放产生随机数字的数组，数组长度比运算符数量多一
        int[] algo = new int[n+o];       //存放产生四则运算的数组，数组长度为运算符数量和数字数量之和
        int number = 0;
        CalculateImpl cal = new CalculateImpl();
        while (number < m.length) {//如果运算次数小于运算符个数，继续运算
            int d=0;

            for (int i=0;i<o;i++){//随机产生运算符
                m[i]= (int) (Math.random()*2*c);
            }




            for (int i = 0; i < n; i++) {                //随机产生n个数字，存放在num数组中
                num[i] = (int) (Math.random()*(m2-m1)+m1);
            }

            /*产生的符合规定的运算符存到m3数组中，m3数组长度比字符数量多一，方便后面运算*/
            int m3[] = new int[m.length + 1];
            for (int i = 0; i < m.length; i++) {
                m3[i] = m[i];
            }

            /*将运算符跟数字交错存到数组中，输出为一个四则运算 */
            algo[0] = num[0];
            algo[1] = m[0];
            for (int i = 2; i < n + m.length; i++) {
                if (i % 2 == 0) {
                    algo[i] = num[i / 2];
                } else {
                    algo[i] = m[i / 2];
                }
            }


        /* 将运算符从前到后两两比较，先计算优先级高的运算符，先乘除后加减，同级运算符从左向右依次计算
          在计算过程中判断是否产生负数、是否产生小数，是否除数为0等，如果产生不满足要求的运算式，
          则舍去，如果符合要求，则打印出来。
         */


            S = String.valueOf(algo[0]) + symbol(algo[1]);
            for (int j = 2; j < algo.length; j++) {
                if (j % 2 == 0)
                    S = S + String.valueOf(algo[j]);
                else {
                    S = S + symbol(algo[j]);

                }
            }

            if(cal.calculate(S,m1,m2)==0) {
                number = 0;
            }
            else{
                number = o;
            }
        }
        return S;
    }


    /**
     * 包含括号的四则运算，参数为四则运算的范围m3,m2
     * * 运算符的数量o，默认为1
     * 是否包含乘除法 c=1，不包含。c=2，包含
     * @param m1
     * @param m2
     * @param o
     * @param c
     * @return
     */
    @Override
    public String BracketsAlgo(int m1, int m2, int o, int c) throws ScriptException {
        String S="";
        CalculateImpl cal = new CalculateImpl();
        while(true) {
            int m[] = new int[o];

            for (int i = 0; i < o; i++) {
                m[i] = (int) (Math.random() * (2*c));
            }

            /*首先进行第一个运算符的运算*/
            String s = "";
            int result = 0;
            int num1 = (int) (Math.random() * (m2 - m1)/4 + m1);
            int num2 = (int) (Math.random() * (m2 - m1)/4 + m1);

            if (m[0] == 0) {
                while( num1 + num2>m2&&num1!=m1){
                    num1 = (int) (Math.random() * ((m2 - m1)/4) + m1);
                    num2 = (int) (Math.random() * ((m2 - m1)/4) + m1);
                }
                result = num1 + num2;
                s = num1 + "+" + num2;
            } else if(m[0]==1){
                while( num1- num2<m1&&(num1!=m2&&num2!=m1)){
                    num1 = (int) (Math.random() * (m2 - m1)/4 + m1);
                    num2 = (int) (Math.random() * ((m2 - m1)/4) + m1);
                }
                result = num1 - num2;
                s = num1 + "-" + num2;

            }else if(m[0]==2){
                while( num1* num2>m2&&num1!=m1){
                    num1 = (int) (Math.random() * (m2 - m1)/4 + m1);
                    num2 = (int) (Math.random() * ((m2 - m1)/4) + m1);
                }
                result = num1 * num2;
                s = num1 + "*" + num2;

            }
            else {


                while (num2==0||num1 % num2 != 0 || (num1/num2 <m1&&(num1!=m2&&num2!=m1))  ) {

                    num2= (int) (Math.random() * ((m2 - m1)/4) + m1);
                    num1 = (int) (Math.random() * ((m2 - m1)/4) + m1);
                }

                result = num1 / num2;
                s = num1 + "÷" + num2;

            }



            for (int i = 1; i < m.length; i++) {

                num1 = (int) (Math.random() * (m2 - m1)/4 + m1);
                if ((priority(m[i - 1]) < priority(m[i]))) {//判断优先级，加、减法优先级低于乘除法
                    if (m[i] == 3) {    //除法运算
                        //排除除数为0的异常
                        while (num1==0||result % num1 != 0 || (result/num1<m1&&(num1!=m2&&num2!=m1))  ) {
                            num1 = (int) (Math.random() * ((m2 - m1)/4)/4 + m1);

                        }

                        result = result / num1;
                        s = "(" + s + ")" + "÷" + num1;
                    } else {          //乘法运算
                        while ( result * num1>m2&&num1!=m1){
                            num1 = (int) (Math.random() * ((m2 - m1)/4)/4 + m1);
                        }
                        result = result * num1;
                        s = "(" + s + ")" + "*" + num1;

                    }
                } else {
                    if (m[i] == 0) {     //加法
                        while (result + num1>2*m2&&num1!=m1){
                            num1 = (int) (Math.random() * ((m2 - m1)/4) + m1);
                        }
                        result = result + num1;
                        s = s + "+" + num1;

                    } else if (m[i] == 1) {  //减法

                        if (result - num1 >0) {  //确保不产生负数
                            while (result-num1<m1&&(num1!=m2)){
                                num1 = (int) (Math.random() * ((m2 - m1)/4) + m1);
                            }
                            result = result - num1;
                            s = s + "-" + num1;
                        } else {

                            while (num1-result<m1&&(num1!=m2&&num2!=m1)){
                                num1 = (int) (Math.random() * (m2 - m1+1)/4 + m1);
                            }
                            result = num1 - result;
                            s = num1 + "-" + "(" + s + ")";
                        }
                    } else if (m[i] == 2) {  //乘法
                        while (result * num1>m2&&num1!=m1){
                            num1 = (int) (Math.random() * ((m2 - m1)/4 )/4+ m1);
                        }
                        result = result * num1;
                        s = s + "*" + num1;
                    } else {             //除法

                        while (num1==0||result % num1 != 0 || (result/num1<m1&&(num1!=m2))  ) {
                            num1 = (int) (Math.random() * ((m2 - m1)/4)/4 + m1);

                        }
                        result = result / num1;
                        s = s + "÷" + num1;

                    }

                }
            }
            S=s;
            if(cal.calculate(S,m1,m2)==0) {
                continue;
            }
            else{
                break;

            }
        }
        return S;
    }




    @Override
    public int getNum(int x, int y) {
        while (true) {
            if (x%y ==0)
                return y;
            int z = y;
            y = x % y;
            x = z;
        }
    }

    /**
     * 判断优先级，加减优先级低于乘除
     * 如果是加减法，返回0
     * 如果是乘除法，返回1
     * @param n
     * @return
     */
    @Override
    public int priority(int n) {
        if (n==0||n==1){
            return 0;
        }else if (n==3||n==2){
            return 1;
        }else {
            return -1;
        }
    }

    @Override
    public String symbol(int n) {

        String s="";
        switch (n){
            case 0:
                s= "+";
                break;
            case 1:
                s= "-";
                break;
            case 2:
                s= "*";
                break;
            case 3:
                s= "÷";
                break;
        }
        return s;

    }
}
