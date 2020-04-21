package com.dao.impl;

import com.dao.Algorithm;

public class AlgorithmImpl implements Algorithm {


    /**
     * 不包含括号的四则运算，参数为四则运算的范围m1,m2
     * 运算符的数量o，默认为1
     * 是否包含乘除法 c=2，不包含。c=1，包含
     * @param m3
     * @param m2
     * @param o
     * @param c
     * @return
     */
    @Override
    public String algorithm(int m3, int m2, int o, int c) {

        String S="";
        //不包含乘除
        if (c==2){       //一位运算符
            if (o==1){
                int num1 = (int) (Math.random()*(m2-m3)+m3);
                int num2 = (int)  (Math.random()*(m2-m3)+m3);
                int symbol = (int)(Math.random()*2);
                if(symbol==0){ //加法
                    while((num1+num2)>m2){
                        num1 = (int) (Math.random()*(m2-m3)+m3);
                        num2 = (int)  (Math.random()*(m2-m3)+m3);
                    }
                    S=num1+"+"+num2; //没写result结果
                }else{
                    while((num1-num2)<m3){
                        num1 =(int) (Math.random()*(m2-m3)+m3);
                        num2 = (int) (Math.random()*(m2-m3)+m3);
                    }
                    S=num1+"-"+num2;//没写result结果
                }
            }else{  //不包含乘除，运算符大于一
                int symbol [] = new int[o];
                int num[]=new int[o+1];
                int a=0;
                int b=1;
                int result =0;
                while(a==0){
                    for (int i=0;i<o;i++){
                        symbol[i]= (int) (Math.random()*2);
                    }
                    for (int i=0;i<o-1;i++){
                        if (symbol[i]==symbol[i+1]){
                            a=a;
                        }else {
                            a++;
                        }
                    }
                }
                for (int i=0;i<num.length;i++){
                    num[i]= (int) (Math.random()*(m2-m3)+m3);
                }
                if(symbol[0]==0){ //加法
                    while((num[0]+num[1])>m2){
                        num[0] = (int) (Math.random()*(m2-m3)+m3);
                        num[1]= (int) (Math.random()*(m2-m3)+m3);
                    }
                    S= num[0]+"+"+num[1];
                    result =num[0]+num[1];
                }else{
                    while((num[0]-num[1])<m3){
                        num[0] = (int) (Math.random()*(m2-m3)+m3);
                        num[1] = (int) (Math.random()*(m2-m3)+m3);
                    }
                    S=num[0]+"-"+num[1];
                    result=num[0]-num[1];
                }
                while (b<o){//记录运算符数量
                    for (int i=1;i<o;i++){
                        if (symbol[i]==0){//加法
                            while((result+num[i+1])>m2){
                                num[i+1] = (int) (Math.random()*(m2-m3)+m3);
                            }
                            S=S+"+"+num[i+1];
                            result=result+num[i+1];
                            b++;
                        }else {//减法
                            while((result-num[i+1])<m3){
                                num[i+1] = (int) (Math.random()*(m2-m3)+m3);
                            }
                            S=S+"-"+num[i+1];
                            result=result-num[i+1];
                            b++;
                        }
                    }
                }
            }
        }else { //包含乘除
            if (o==1){ //运算符为一
                int l=0;
                while(l==0){
                    int num1 = (int) (Math.random()*(m2-m3)+m3);//Math.random()产生0-1之间的随机数，左闭右开
                    int num2 = (int) (Math.random()*(m2-m3)+m3);
                    int symbol = (int)(Math.random()*4);
                    if (symbol==0){//加法
                        while((num1+num2)>m2){
                            num1 = (int) (Math.random()*(m2-m3)+m3);
                            num2 = (int) (Math.random()*(m2-m3)+m3);
                        }
                        S=num1+"+"+num2;
                        l++;
                    }else if (symbol==1){//减法
                        while((num1-num2)<m3){
                            num1 = (int) (Math.random()*(m2-m3)+m3);
                            num2 = (int) (Math.random()*(m2-m3)+m3);
                        }
                        S=num1+"-"+num2;
                        l++;
                    }else if(symbol==2){//乘法
                        while((num1*num2)>m2){
                            num1 =(int) (Math.random()*(m2-m3)+m3);
                            num2 = (int) (Math.random()*(m2-m3)+m3);
                        }
                        S=num1+"*"+num2;
                        l++;
                    }else {//除法
                        while ((num1%num2)!=0||(num1/num2)<m3){//余数不为零且不小于最小值
                            num1 =(int) (Math.random()*(m2-m3)+m3);
                            num2 =(int) (Math.random()*(m2-m3)+m3);
                        }
                        S=num1+"÷"+num2;
                    }
                }

            }else {  //运算符数量大于一
                int m[]=new int[o];//存放运算符的数组
                int n = o + 1;
                int[] num = new int[n];                  //存放产生随机数字的数组，数组长度比运算符数量多一
                int[] algo = new int[n+o];       //存放产生四则运算的数组，数组长度为运算符数量和数字数量之和
                int number = 0;
                while (number < m.length) {//如果运算次数小于运算符个数，继续运算
                    int d=0;
                    while(d==0){
                        for (int i=0;i<o;i++){//随机产生运算符
                            m[i]= (int) (Math.random()*4);
                        }
                        for (int i=0;i<o-1;i++){
                            if (m[i]==m[i+1]){
                                d=d;
                            }else {
                                d++;
                            }
                        }
                    }


                    for (int i = 0; i < n; i++) {                //随机产生n个数字，存放在num数组中
                        num[i] = (int) (Math.random()*(m2-m3)+m3);
                    }

                    /*产生的符合规定的运算符存到m1数组中，m1数组长度比字符数量多一，方便后面运算*/
                    int m1[] = new int[m.length + 1];
                    for (int i = 0; i < m.length; i++) {
                        m1[i] = m[i];
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
                    for (int i = 0; i < m.length; i++) {
                        if ((m1[i] < m1[i + 1]) && (m1[i + 1] == 2)) {//下一个运算符为乘法
                            /* 包含情况为 0<2;1<2 计算优先级高的（乘法） 区域运算，并将结果放到 存放数字的数组中，运算过的运算符也被取代*/

                            if (num[i + 1] * num[i + 2]>m2){
                                number = 0;
                                for (int k = 0; k < m.length; k++) {
                                    m[k] = 0;
                                }
                                break;
                            }
                            num[i + 2] = num[i + 1] * num[i + 2];
                            num[i + 1] = num[i];
                            m1[i + 1] = m1[i];
                            number++;
                        } else if ((m1[i] < m1[i + 1]) && m1[i + 1] == 3 && m1[i] != 2) {
                            /* 包含情况为 0<3;1<3计算优先级高的（除法） 区域运算，并将结果放到 存放数字的数组中，运算过的运算符也被取代*/
                            if (num[i + 2] != 0) {              //首先除数不能为0
                                int a = num[i + 1] % num[i + 2];  //是否整除
                                if (a == 0) {
                                    //如果整除，进行除法运算
                                    if (num[i + 1] / num[i + 2]<m3){
                                        number = 0;
                                        for (int k = 0; k < m.length; k++) {
                                            m[k] = 0;
                                        }
                                        break;
                                    }
                                    num[i + 2] = num[i + 1] / num[i + 2];
                                    num[i + 1] = num[i];
                                    m1[i + 1] = m1[i];
                                    number++;
                                } else {                     //如果不能整除，重新进行四则运算的产生
                                    number = 0;
                                    for (int k = 0; k < m.length; k++) {
                                        m[k] = 0;
                                    }
                                    break;
                                }
                            } else {                       //除数为0，重新进行四则运算的产生
                                number = 0;
                                for (int k = 0; k < m.length; k++) {
                                    m[k] = 0;
                                }
                                break;
                            }
                        } else if (m1[i] == 2 && m1[i + 1] == 3) {
                            /* 包含情况为 2<3计算从左向右进行，并将结果放到 存放数字的数组中*/
                            if (m[i] * m[i + 1]>m2){
                                number = 0;
                                for (int k = 0; k < m.length; k++) {
                                    m[k] = 0;
                                }
                                break;
                            }
                            m[i + 1] = m[i] * m[i + 1];
                            number++;
                        } else if ((m1[i] < m1[i + 1]) && (m1[i + 1] == 1)) {
                            /* 包含情况为 0<1  计算从左向右进行，并将结果放到 存放数字的数组中*/
                            if (m[i] + m[i + 1]>m2){
                                number = 0;
                                for (int k = 0; k < m.length; k++) {
                                    m[k] = 0;
                                }
                                break;
                            }
                            m[i + 1] = m[i] + m[i + 1];
                            number++;
                        } else if ((m1[i] > m1[i + 1]) && m1[i] == 3) {
                            /* 包含情况为 3>2;3>1;3>0  计算从左向右进行，并将结果放到 存放数字的数组中*/
                            if (num[i + 1] != 0) {              //被除数不能为0
                                int a = num[i] % num[i + 1];
                                if (a == 0) {                 //能够整除
                                    if (num[i] / num[i + 1]<m3){
                                        number = 0;
                                        for (int k = 0; k < m.length; k++) {
                                            m[k] = 0;
                                        }
                                        break;
                                    }
                                    num[i + 1] = num[i] / num[i + 1];
                                    number++;
                                } else {
                                    number = 0;
                                    for (int k = 0; k < m.length; k++) {
                                        m[k] = 0;
                                    }
                                    break;
                                }
                            } else {                      //被除数为0
                                number = 0;
                                for (int k = 0; k < m.length; k++) {
                                    m[k] = 0;
                                }
                                break;
                            }
                        } else if ((m1[i] > m1[i + 1]) && m1[i] == 2) {
                            /* 包含情况为 2>1;1>0  计算从左向右进行，并将结果放到 存放数字的数组中*/
                            if ( num[i] * num[i + 1]>m2){
                                number = 0;
                                for (int k = 0; k < m.length; k++) {
                                    m[k] = 0;
                                }
                                break;
                            }
                            num[i + 1] = num[i] * num[i + 1];
                            number++;
                        } else if ((m1[i] > m1[i + 1]) && m1[i] == 1) {
                            /* 包含情况为 1>0  计算从左向右进行，并将结果放到 存放数字的数组中*/
                            if (num[i] > num[i + 1]) {     //是否产生负数
                                if ( num[i] - num[i + 1]<m3){
                                    number = 0;
                                    for (int k = 0; k < m.length; k++) {
                                        m[k] = 0;
                                    }
                                    break;
                                }
                                num[i + 1] = num[i] - num[i + 1];
                                number++;
                            } else {
                                number = 0;
                                for (int k = 0; k < m.length; k++) {
                                    m[k] = 0;
                                }
                                break;
                            }
                        } else {
                            /* 包括情况为0==0；1==1；2==2  3==3*/
                            if (m1[i] == m1[i + 1]) {
                                if (m1[i] == 0) {       //加法
                                    if ( num[i] + num[i + 1]>m2){
                                        number = 0;
                                        for (int k = 0; k < m.length; k++) {
                                            m[k] = 0;
                                        }
                                        break;
                                    }
                                    num[i + 1] = num[i] + num[i + 1];
                                    number++;
                                } else if (m1[i] == 1) {  //减法，判断是否产生负数
                                    if (num[i] > num[i + 1]) {
                                        if ( num[i] - num[i + 1]<m3){
                                            number = 0;
                                            for (int k = 0; k < m.length; k++) {
                                                m[k] = 0;
                                            }
                                            break;
                                        }
                                        num[i + 1] = num[i] - num[i + 1];
                                    } else {
                                        number = 0;
                                        for (int k = 0; k < m.length; k++) {
                                            m[k] = 0;
                                        }
                                        break;
                                    }
                                } else if (m1[i] == 2) {    //乘法
                                    if (num[i] * num[i + 1]>m2){
                                        number = 0;
                                        for (int k = 0; k < m.length; k++) {
                                            m[k] = 0;
                                        }
                                        break;
                                    }
                                    num[i + 1] = num[i] * num[i + 1];
                                    number++;
                                } else {                //除法运算，判断除数不能为0，不能产生小数
                                    if (num[i + 1] != 0) {
                                        int a = num[i] % num[i + 1];
                                        if (a == 0) {
                                            if (num[i] / num[i + 1]<m3){
                                                number = 0;
                                                for (int k = 0; k < m.length; k++) {
                                                    m[k] = 0;
                                                }
                                                break;
                                            }
                                            num[i + 1] = num[i] / num[i + 1];
                                            number++;

                                        } else {
                                            for (int k = 0; k < m.length; k++) {
                                                m[k] = 0;
                                            }
                                            number = 0;
                                            break;
                                        }
                                    } else {
                                        for (int k = 0; k < m.length; k++) {
                                            m[k] = 0;
                                        }
                                        number = 0;
                                        break;
                                    }


                                }
                            }

                        }
                    }

                }  //包含乘除，运算符大于

                S = String.valueOf(algo[0]) + symbol(algo[1]);
                symbol(algo[1]);
                for (int j = 2; j < algo.length; j++) {
                    if (j % 2 == 0)
                        S = S + String.valueOf(algo[j]);
                    else {
                        S = S + symbol(algo[j]);

                    }
                }
//                     S = S + "=" + num[num.length - 1];//输出运算结果
//                     S = S;
            }


        }

        return  S;
    }

    /**
     * 包含括号的四则运算，参数为四则运算的范围m3,m2
     * * 运算符的数量o，默认为1
     * 是否包含乘除法 c=2，不包含。c=1，包含
     * @param m3
     * @param m2
     * @param o
     * @param c
     * @return
     */
    @Override
    public String BracketsAlgo(int m3, int m2, int o, int c) {
        String S="";
        //不包含乘除
        if (c==2){
            //一个运算符+多个运算符
            int symbol [] = new int[o];
            int a=0;
            int result =0;
            if (o==1){//一个运算符
                symbol[0]=(int) (Math.random()*2);
                a++;
            }

            while(a==0){//多个运算符
                for (int i=0;i<o;i++){
                    symbol[i]= (int) (Math.random()*2);
                }
                for (int i=0;i<o-1;i++){//如果所有的运算符一样，则重新分配
                    if (symbol[i]==symbol[i+1]){
                        a=a;
                    }else {
                        a++;
                    }
                }
            }

            int num1= (int) (Math.random() * (m2 - m3) + m3);
            int num2= (int) (Math.random() * (m2 - m3) + m3);
            if (symbol[0]==0){
                while (num1+num2>=m2){
                    num1= (int) (Math.random() * (m2 - m3) + m3);
                    num2= (int) (Math.random() * (m2 - m3) + m3);
                }
                result=num1+num2;
                S=num1+"+"+num2;
            }else {
                while (num1-num2<m3){
                    num1= (int) (Math.random() * (m2 - m3) + m3);
                    num2= (int) (Math.random() * (m2 - m3) + m3);
                }
                result=num1-num2;
                S=num1+"-"+num2;
            }


            for (int i=1;i<o;i++){
                num1 = (int) (Math.random() * (m2 - m3) + m3);
                if (symbol[i]==0){
                    while (result + num1 > m2){
                        num1= (int) (Math.random() * ((m2 - m3)/4)+ m3);
                    }
                    result=result+num1;
                    S=S+"+"+num1;

                }else {
                    //减法
                    if (result-num1>=m3){
                        result = result-num1;
                        S=S+"-"+num1;
                    }else if(num1-result>=m3){
                        result=num1-result;
                        S=num1+"-"+"("+S+")";
                    }else {
                        while (num1-result<m3){
                            num1 = (int) (Math.random() * (m2 - m3) + m3);
                        }
                        result=num1-result;
                        S=num1+"-"+"("+S+")";
                    }

                }
            }
//            S = S;
        }else {
            //包含乘除，多个运算
            int m[] = new int[o];
            int f = 0;
            int x = 1;
            while (x < o) {
                while (f == 0) {
                    m[0]=(int) (Math.random() * 2);
                    for (int i = 0; i < o; i++) {
                        m[i] = (int) (Math.random() * 4);
                    }
                    for (int i = 0; i < o - 1; i++) {
                        if (m[i] == m[i + 1]) {
                            f = f;
                        } else {
                            f++;
                        }

                    }

                }

                /*首先进行第一个运算符的运算*/
                String s = "";
                int result = 0;
                int num1 = (int) (Math.random() * (m2 - m3) + m3);
                int num2 = (int) (Math.random() * (m2 - m3) + m3);
                if (m[0] == 0) {
                    while( num1 + num2>m2){
                        num1 = (int) (Math.random() * ((m2 - m3)/4) + m3);
                        num2 = (int) (Math.random() * ((m2 - m3)/4) + m3);
                    }
                    result = num1 + num2;
                    s = num1 + "+" + num2;
                    x++;
                } else {
                    while( num1- num2<m3){
                        num1 = (int) (Math.random() * (m2 - m3) + m3);
                        num2 = (int) (Math.random() * ((m2 - m3)/4) + m3);
                    }
                    result = num1 - num2;
                    s = num1 + "-" + num2;
                    x++;

                }


                for (int i = 1; i < m.length; i++) {

                    num1 = (int) (Math.random() * (m2 - m3) + m3);
                    if ((priority(m[i - 1]) < priority(m[i]))) {//判断优先级，加、减法优先级低于乘除法
                        if (m[i] == 3) {    //除法运算
                            while (result % num1 != 0 || (result / num1<m3)  ) {
                                num1 = (int) (Math.random() * ((m2 - m3)/4) + m3);
                            }
                            result = result / num1;
                            x++;
                            s = "(" + s + ")" + "÷" + num1;
                        } else {          //乘法运算
                            while ( result * num1>m2){
                                num1 = (int) (Math.random() * ((m2 - m3)/4) + m3);
                            }
                            result = result * num1;
                            x++;
                            s = "(" + s + ")" + "*" + num1;

                        }
                    } else {
                        if (m[i] == 0) {     //加法
                            while (result + num1>m2){
                                num1 = (int) (Math.random() * ((m2 - m3)/4) + m3);
                            }
                            result = result + num1;
                            s = s + "+" + num1;
                            x++;

                        } else if (m[i] == 1) {  //减法

                            if (result - num1 > 0) {  //确保不产生负数
                                while (result-num1<m3){
                                    num1 = (int) (Math.random() * ((m2 - m3)/4) + m3);
                                }
                                result = result - num1;
                                s = s + "-" + num1;
                                x++;
                            } else {

                                while (num1-result<m3){
                                    num1 = (int) (Math.random() * (m2 - m3+1) + m3);
                                }
                                result = num1 - result;
                                s = num1 + "-" + "(" + s + ")";
                                x++;
                            }
                        } else if (m[i] == 2) {  //乘法
                            while (result * num1>m2){
                                num1 = (int) (Math.random() * ((m2 - m3)/4 )+ m3);
                            }
                            result = result * num1;
                            s = s + "*" + num1;
                            x++;
                        } else {             //除法
                            while (result % num1 != 0 || (result / num1<m3) ) {
                                num1 = (int) (Math.random() *((m2 - m3)/4) + m3);
                            }
                            result = result / num1;
                            s = s + "÷" + num1;
                            x++;
                        }
                    }
                }
//                    s = s + "=" + result;
//                s = s + "=";
                S=s;
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
