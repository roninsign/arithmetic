package com.servlet;

import com.dao.Algorithm;
import com.dao.impl.AlgorithmImpl;
import com.util.MyExpection;
import com.util.WebContents;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@WebServlet(name = "AlgorithmServlet",urlPatterns = "/Algo",asyncSupported = true)
public class AlgorithmServlet extends HttpServlet {
    public AlgorithmServlet(){
        super();
    }
    public void destroy(){
        super.destroy();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html; charset = utf-8");//使客户端浏览器，区分不同种类的数据，并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据。
        request.setCharacterEncoding("utf-8");//设置对客户端请求进行重新编码的编码为utf-8
        response.setCharacterEncoding("utf-8"); //指定对服务器响应进行重新编码的编码为utf-8
//        PrintWriter out = response.getWriter();   //服务器向客户端反馈的时候需要用流向客户端输出数据
        String state = request.getParameter("state");  //获取jsp页面发生的事件
        if (state.equals("Algo1")){
            /* 跳转到生成题目页面*/
            RequestDispatcher rd =request.getRequestDispatcher(WebContents.Algorithm);
            rd.forward(request,response);
        }else if (state.equals("downFile")){
            /*  下载文件*/
            try {
                downloadFile(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (state.equals("langu")){
            /*langu 选择语言，根据语言的不同，选择不同的显示内容*/
            String language = request.getParameter("language");
            HttpSession session=request.getSession();
            session.setAttribute("language",language);
            RequestDispatcher rd = null;
//           rd = request.getRequestDispatcher(WebContents.WELCOME);


            rd = request.getRequestDispatcher(WebContents.LOGIN);
            rd.forward(request, response);
        }else if (state.equals("return")){
            /* 返回欢迎页面 */
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher(WebContents.WELCOME);
            rd.forward(request, response);
        }else if(state.equals("startDo")){
            //开始做题
            request.getRequestDispatcher(WebContents.STARTDO).forward(request,response);
        }
        else {
            try {

                Map<String, String[]> condition = request.getParameterMap();
                request.getSession().setAttribute("condition",condition);
                /*题目生成*/
                algoTest(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 根据从前台获得的参数，来生成相应的符合要求的四则运算
     * @param request
     * @param response
     * @throws Exception
     */
    private void  algoTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html");//使客户端浏览器，区分不同种类的数据，并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据。
        request.setCharacterEncoding("utf-8");//设置对客户端请求进行重新编码的编码为utf-8
        response.setCharacterEncoding("utf-8"); //指定对服务器响应进行重新编码的编码为utf-8
        RequestDispatcher rd = null;

        try {
            String s1 = request.getParameter("n");
            String s2 = request.getParameter("m1");
            String s3 = request.getParameter("m2");
            if (!((s1.matches("^[0.0-9.0]+$"))||(s2.matches("^[0.0-9.0]+$"))||( s3.matches("^[0.0-9.0]+$")))) {
                rd = request.getRequestDispatcher(WebContents.Algorithm);
                request.setAttribute("msg", "输入参数必须为符合要求的正整数,请重新输入！！！");
                request.setAttribute("msg1", "Input parameters must be positive integers that meet the requirements. Please retype.！！！");
                rd.forward(request, response);
            }
            int n= Integer.parseInt(s1);
            int m1= Integer.parseInt(s2);
            int m2= Integer.parseInt(s3);
            int o = Integer.parseInt(request.getParameter("o"));
            int c = Integer.parseInt(request.getParameter("c"));
            int b1 = Integer.parseInt(request.getParameter("b"));
            if (n<1|| m1<0 || m2 <50||n>10000||m1>100||m2<50||o<1||o>10||m1>m2) {
                rd = request.getRequestDispatcher(WebContents.Algorithm);
                request.setAttribute("msg", "输入参数错误,请重新输入！！！");
                request.setAttribute("msg1", "Input parameter error, please re-enter.！！！");
                rd.forward(request, response);
            }

            Algorithm algorithm = new AlgorithmImpl();
            String path = request.getContextPath();
            String ctxPath = request.getSession().getServletContext().getRealPath("/");
            String fileName =   UUID.randomUUID() + "result.txt";
            FileWriter fileWriter = new FileWriter(ctxPath+fileName,true);
            PrintWriter out = response.getWriter();
            List<String> list = new ArrayList<>();
            int count=0;
            for (int i = n; i > 0; i--) {
                String str = null;
                if (b1==1){//是否有括号，b=1,you;b=2，不包含。
                    //如果包含乘除，c=1;如果不包含 c=2；
                    if (o==1){ //一位运算符，没有括号
                        str= algorithm.algorithm(m1, m2, o, c);
                        list.add(str);
                        count++;
                    }else {
                        str= algorithm.BracketsAlgo(m1, m2, o, c);
                        list.add(str);
                        count++;
                    }
                }else {
                    str= algorithm.algorithm(m1, m2, o, c);
                    list.add(str);
                    count++;
                }
                fileWriter.write("\r\n"+str);
            }

            HttpSession session=request.getSession();
            String language= (String) session.getAttribute("language");
            System.out.println(fileName);
            rd = request.getRequestDispatcher(WebContents.Algorithm);
            request.getSession().setAttribute("list",list);
            request.getSession().setAttribute("count",count);
            request.setAttribute("msg", "文件创建成功，下载请点击！！！");
            request.setAttribute("msg1", "File creation success, download please click.！！！");
            request.setAttribute("filename",fileName);
            request.setAttribute("language",language);
            rd.forward(request, response);
            System.out.println(fileName);
            fileWriter.flush();
            out.flush();
            out.close();
        }catch (Exception e) {
            MyExpection myExpection = new MyExpection();
            throw new Exception(myExpection.MyExpection3());
        }
    }

    /**
     * 下载生成的文件
     * @param request
     * @param response
     * @throws Exception
     */
    private void  downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setContentType("text/html; charset = utf-8");
        //得到get方式提交的那个filename
        String fileName = request.getParameter("filename");
        System.out.println(fileName);
        //表明是要下载文件
        response.setHeader("Content-Disposition", "attachment; filename="+fileName);
        //得到服务器里文件的真实地址
        String path = this.getServletContext().getRealPath(fileName);
        System.out.println(path);
        //一个二进制输入流
        FileInputStream fis = new FileInputStream(new File(path));
        byte[] b = new byte[1024];
        int length;
        OutputStream out = response.getOutputStream();
        while((length = fis.read(b)) > 0) {
            out.write(b, 0, length);//写出
        }
        out.flush();
        out.close();
        fis.close();
    }
}
