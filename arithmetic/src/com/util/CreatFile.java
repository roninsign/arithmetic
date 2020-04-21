package com.util;

import com.dao.Algorithm;
import com.dao.impl.AlgorithmImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreatFile {
    public boolean creatFile(int n,int m1,int m2,int o,int c,int b1 ) throws Exception {
        boolean flag=false;
        MyExpection myExpection = new MyExpection();
        try {
            File file = new File("../result.txt");//相对路径
            if (file.exists()) {
                file.delete();
            }
            if (file.createNewFile()) {

                Algorithm algorithm = new AlgorithmImpl();
                FileOutputStream fileout = new FileOutputStream(file);
                //生成相应数量的题目，并写入
                for (int i = n; i > 0; i--) {
                    String str = null;
                    if (b1==1){//是否有括号，b=1,you;b=2，不包含。
                        //如果包含乘除，c=1;如果不包含 c=2；
                        if (o==1){ //一位运算符，没有括号
                            str= algorithm.algorithm(m1, m2, o, c);
                        }else {
                            str= algorithm.BracketsAlgo(m1, m2, o, c);
                        }
//                        System.out.println(str);
                    }else {
                        str= algorithm.algorithm(m1, m2, o, c);
//                        System.out.println(str);
                    }
                    byte[] b = str.getBytes();
                    fileout.write(b);
                    fileout.write("\r\n".getBytes());
                }
                fileout.close();
            }
            System.out.println("result.text文件创建成功！");
            flag = true;
        } catch (FileNotFoundException e) {
            throw new Exception(myExpection.MyExpection2());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }
}

