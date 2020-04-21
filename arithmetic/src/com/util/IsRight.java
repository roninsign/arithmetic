package com.util;

public class IsRight {


    /**
     * 如果包含乘除，c=1;如果不包含 c=2；
     *
     * @param a
     * @return
     */
    public static int cTest(String[] a)  {
        int o = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals("-c") ) {
                o = 1;
            }
        }

        if (o ==0) {
            o = 2;
        }

        return o;
    }


    /**
     * 题目数值的范围
     * @param a
     * @return
     */
    public int[] mTest(String[] a) throws Exception {
        MyExpection myExpection = new MyExpection();
        int m1[] = new int[2];
        int n1 = 0;
        int n2 = 0;
        try{
            for (int i = 0; i < a.length - 2; i++) {
                if (a[i].equals("-m") ) {
                    String s1 = a[i + 1];
                    String s2 = a[i + 2];
                    n1 = Integer.parseInt(s1);
                    n2 = Integer.parseInt(s2);
                    if (!((s1 != null && s1.matches("^[0.0-9.0]+$")) ||(s2 != null && s2.matches("^[0.0-9.0]+$")))){
                        System.out.print("请输入题目数值范围的正确格式，类型为整数 (下限1-100；上限：50-1000)：");
                    }else if (n1 < 1 || n1 > 100 || n2 < 50 || n2 > 1000 || n1 > n2){
                        System.out.print("请输入正确的题目数值范围，类型为整数 (下限1-100；上限：50-1000)：");
                    }else {
                        m1[0] = n1;
                        m1[1] = n2;
                    }
                }
            }
            return m1;
        }catch (Exception e){
            throw new Exception(myExpection.MyExpection4());
        }
    }

    /**
     * 判断 输入你要打印的题目数量的个数是否为整数
     * @return
     */
    public int numberTest(String[] a) throws Exception {
        MyExpection myExpection = new MyExpection();
        try {
            int n1 = 0;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].equals("-n") ) {
                    String s = a[i + 1];
                    n1 = Integer.parseInt(s);
                    if (!(s != null && s.matches("^[0.0-9.0]+$"))){
                        System.out.print("打印的题目数量不符合要求，请重新输入 (1-10000)：");
                    }else if (n1==0){
                        System.out.print("打印的题目数量不能为0，请重新输入 (1-10000)：");
                        n1=0;
                    }else{
                        n1=n1;
                    }
                }

            }
            return n1;
        }catch (Exception e){
            throw  new Exception(myExpection.MyExpectio5());
        }

    }

    /**
     * 输入你要打印的符号的个数是否为整数
     *
     * @return
     */
    public int symbolTest(String[] a)  throws Exception{
        MyExpection myExpection = new MyExpection();
        try{
            int n1 = 0;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] .equals( "-o")) {
                    String s = a[i + 1];
                    n1 = Integer.parseInt((s));
                    if (!(s != null && s.matches("^[0.0-9.0]+$"))) {// [0-9]没办法识别小数，[0.0-9.0]可以识别小数和整数
                        System.out.print("请重新输入你要打印的题目所带符号正确的数量 (1-10)：");
                    }
                }

            }

            if (n1 < 1) {
                n1 = 1;
            }
            return n1;
        }catch (Exception e){
            throw  new Exception(myExpection.MyExpectio6());
        }
    }



    /***
     * 是否有括号，b=1,you;b=2，不包含。
     * @return
     */
    public int isBracket(String[] a) {
        int b = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals( "-b")) {
                b = 1;
            }
        }
        if (b < 1) {
            b = 2;
        }
        return b;
    }
}