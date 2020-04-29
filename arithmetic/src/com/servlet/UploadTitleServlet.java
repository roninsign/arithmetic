package com.servlet;

import com.dao.UserScoreDao;
import com.dao.impl.UserScoreDaoImpl;
import com.entity.UserScore;
import com.util.WebContents;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@WebServlet(name = "UploadTitleServlet",urlPatterns = "/upTitle",asyncSupported = true)
public class UploadTitleServlet extends HttpServlet {

    public UploadTitleServlet(){
        super();
    }
    public void destroy(){
        super.destroy();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码

        response.setContentType("text/html; charset = utf-8");//使客户端浏览器，区分不同种类的数据，并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据。
        request.setCharacterEncoding("utf-8");//设置对客户端请求进行重新编码的编码为utf-8
        response.setCharacterEncoding("utf-8"); //指定对服务器响应进行重新编码的编码为utf-8
//        PrintWriter out = response.getWriter();   //服务器向客户端反馈的时候需要用流向客户端输出数据
        String state = request.getParameter("state");  //获取jsp页面发生的事件
        if (state.equals("up")) {
            /*上传文件*/
            upLoadFile(request,response);
        }else if (state.equals("calculate")) {
            try {
                /*一次性显示所有文件的判断*/
                calculate(request,response);
            } catch (ScriptException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else if (state.equals("begin")) {
            /*一次显示一道题目的开始运算*/
            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowDate = df.format(day);
            HttpSession session=request.getSession();
            session.setAttribute("nowDate",nowDate);
            begin(request,response);
        }else if (state.equals("begin3")) {
            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowDate = df.format(day);
            HttpSession session=request.getSession();
            session.setAttribute("nowDate1",nowDate);
            /* 开始运算，一次显示所有题目*/
            try {
                downloadFile2(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (state.equals("begin4")) {
            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowDate = df.format(day);
            HttpSession session=request.getSession();
            session.setAttribute("nowDate1",nowDate);
            /* 开始运算，分页显示题目*/
            try {
                downloadFile3(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (state.equals("begin2")){
            /* 一次显示一道题目，第一道往后的运算*/
            try {
                begin2(request,response);
            } catch (ScriptException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

    private void downloadFile3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher(WebContents.DOALGOBYPAGE);
        request.setAttribute("list",session.getAttribute("list"));
        request.setAttribute("count",session.getAttribute("count"));
        rd.forward(request, response);
    }


    /**
     * 上传文件
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void  upLoadFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
//        String filename3= request.getParameter("file2");
//        if (filename3==null){
//            RequestDispatcher rd = null;
//            request.setAttribute("msg1","未上传文件，请重新上传");
//            request.setAttribute("msg2","Unuploaded file, please upload again.");
//            rd = request.getRequestDispatcher(WebContents.WELCOME);
//            rd.forward(request, response);
//        }
//        System.out.print(filename3);
        try {
            //设置系统环境
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //文件存储的路径
            String storePath = getServletContext().getRealPath("/WEB-INF/files");
            //判断传输方式  form  enctype=multipart/form-data
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            String storeFile = "";
            if(!isMultipart)
            {
                pw.write("传输方式有错误！");
                return;
            }
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(4*1024*1024);//设置单个文件大小不能超过4M
            upload.setSizeMax(4*1024*1024);//设置总文件上传大小不能超过6M
            //监听上传进度
            upload.setProgressListener(new ProgressListener() {
                //pBytesRead：当前以读取到的字节数
                //pContentLength：文件的长度
                //pItems:第几项
                public void update(long pBytesRead, long pContentLength,
                                   int pItems) {
                    System.out.println("已读去文件字节 :"+pBytesRead+" 文件总长度："+pContentLength+"   第"+pItems+"项");


                }
            });
            //解析
            List<FileItem> items = upload.parseRequest(request);
            for(FileItem item: items)
            {
                if(item.isFormField())//普通字段，表单提交过来的
                {
                    String name = item.getFieldName();
                    String value = item.getString("UTF-8");
                    System.out.println(name+"=="+value);
                }else
                {
//                  String mimeType = item.getContentType(); 获取上传文件类型
//                  if(mimeType.startsWith("image")){
                    InputStream in =item.getInputStream();
                    String fileName = item.getName();
                    if(fileName==null || "".equals(fileName.trim()))
                    {
                        continue;
                    }
                    fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
                    fileName = UUID.randomUUID()+"_"+fileName;

                    //按日期来建文件夹
                    String newStorePath = makeStorePath(storePath);
                    storeFile = newStorePath+"\\"+fileName;
                    OutputStream out = new FileOutputStream(storeFile);
                    byte[] b = new byte[1024];
                    int len = -1;
                    while((len = in.read(b))!=-1)
                    {
                        out.write(b,0,len);
                    }
                    in.close();
                    out.close();
                    item.delete();//删除临时文件
                }
            }
            downloadFile(request,response,storeFile);
        }catch(org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException e){
            //单个文件超出异常
            pw.write("单个文件不能超过4M");
        }catch(org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException e){
            //总文件超出异常
            pw.write("总文件不能超过6M");

        }catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *解读上传文件的内容
     * @param request
     * @param response
     * @param filename
     * @throws Exception
     */
    private void  downloadFile(HttpServletRequest request, HttpServletResponse response,String filename) throws Exception{
        response.setContentType("html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String realPath = filename;
        File file = new File(realPath);
        List<String> list = new ArrayList<>();
        int count =0;
        if(file.exists()){
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            if((line = bufferedReader.readLine())==null){
                out.print("The file is not exits!");
                System.out.println(line);
            }else{
                while((line = bufferedReader.readLine())!=null){
                    list.add(line);
                    count++;
                    System.out.println(line);
                }
            }
        }
        RequestDispatcher rd = null;
        if (count<1){
            request.setAttribute("msg1","文件内容为空，请重新上传！！！");
            request.setAttribute("msg2","The contents of the file are empty. Please upload again.！！！");
            rd = request.getRequestDispatcher(WebContents.WELCOME);
        }else{
            HttpSession session=request.getSession();
            session.setAttribute("list",list);
            session.setAttribute("count",count);
            rd = request.getRequestDispatcher(WebContents.SSUCCESSUPLOAD);
        }
        rd.forward(request, response);
    }

    /**
     * 一次显示全部题目
     * @param request
     * @param response
     * @throws Exception
     */
    private void  downloadFile2(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session=request.getSession();
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher(WebContents.DOALGO);
        request.setAttribute("list",session.getAttribute("list"));
        request.setAttribute("count",session.getAttribute("count"));
        rd.forward(request, response);
    }

    /**
     * 开始计算，第一道题目
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void  begin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int i=1;
        int right = 0;
        int titleResult[] = {0};
        int rightNum[] = {0};
        request.setAttribute("i",i); //题目的数量
        HttpSession session=request.getSession();
        request.setAttribute("list",session.getAttribute("list")); //提交的全部内容
        request.setAttribute("right",right);//对的数量
        request.setAttribute("titleResult",titleResult);//回答的结果
        request.setAttribute("rightNum",rightNum);//正确的题号
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher(WebContents.DOALGO2);
        rd.forward(request, response);
    }

    /**
     * 一次显示一道题目 ，除第一次运算
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws ScriptException
     * @throws ParseException
     */
    private void  begin2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ScriptException, ParseException {
        UserScoreDao userScoreDao = new UserScoreDaoImpl();
        UserScore userScore =new UserScore();
        int i= Integer.parseInt(request.getParameter("i"));
        int right =  Integer.parseInt(request.getParameter("right"));
        double w =i+0.5;
        double v =i+0.6;
        HttpSession session=request.getSession();
        int count = (int) session.getAttribute("count");
        int titleResult[] = new int [count];
        for(int a=0;a<i;a++){
            w =a+0.5;
            int d = Integer.parseInt(request.getParameter(String.valueOf(w)));
            System.out.print(d);
            titleResult[a]=d;
        }
        double w1 =i+0.2;
        int d1 = Integer.parseInt(request.getParameter(String.valueOf(w1)));
        titleResult[i-1]=d1;
        int rightNum[] = new int [count];
        for(int a=0;a<i-1;a++){
            v=a+0.6;
            rightNum[a]= Integer.parseInt(request.getParameter(String.valueOf(v)));
        }
        double j = i+0.1;
        double r = i+0.2;
        String s = request.getParameter(String.valueOf(j));
        int s1 = Integer.parseInt(request.getParameter(String.valueOf(r)));
        System.out.print(s1);
        int result = doCalculate(s);
        if (result==s1) {
            right++;
            rightNum[i-1] = 0;
        }else {
            rightNum[i-1] = i;
        }
        RequestDispatcher rd = null;
        i++;
        if (i<=count){
            request.setAttribute("count",count); //题目的数量
            request.setAttribute("rightNum",rightNum);//对的题号。对的结果为1，错的为0
            request.setAttribute("right",right);//做对的数量
            request.setAttribute("titleResult", titleResult);//存放做题者提交的答案
            request.setAttribute("i",i); //题目的数量
            rd = request.getRequestDispatcher(WebContents.DOALGO2);
        }else{


            //计算做题的用时
            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strTime = df.format(day);
            String  nowDate = (String) request.getSession().getAttribute("nowDate");
            long time = (df.parse(strTime).getTime()-df.parse(nowDate).getTime() )/1000;
            long seconds = (time%3600)%60;
            long min = (time%3600)/60;
            long hour = time/3600;
            request.setAttribute("allTime1",hour+"时 "+min+"分 "+seconds+" 秒" );
            request.setAttribute("allTime2",hour+"h "+min+"min "+seconds+" s" );
            request.setAttribute("count",count); //题目的数量
            request.setAttribute("rightNum",rightNum);//对的题号。对的结果为1，错的为0
            request.setAttribute("right",right);//做对的数量
            request.setAttribute("titleResult", titleResult);//存放做题者提交的答案
            request.setAttribute("list",session.getAttribute("list")); //题目的数量



            userScore.setUsername((String) session.getAttribute("username"));
            userScore.setStudentNumber( (String) session.getAttribute("studentNumber"));
            userScore.setScore(right+"/"+count);
            double right1 =right+0.00;
            double count1 = count+0.00;

            userScore.setAccuracy(right1/count1*100);
            userScore.setAllTime(hour+": "+min+":"+seconds );
            Date date = new Date();
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            userScore.setCurrentDate(df1.format(date));

            System.out.println(userScore);
            userScoreDao.addUserScore(userScore);

            rd = request.getRequestDispatcher(WebContents.RESULT);
        }

        rd.forward(request, response);

    }

    /**
     * 一次显示全部题目的验证
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws ScriptException
     */
    private void  calculate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ScriptException, ParseException {
        int count = Integer.parseInt(request.getParameter("count"));
        UserScoreDao userScoreDao = new UserScoreDaoImpl();
        UserScore userScore =new UserScore();
        int right = 0 ;
        double j = 0;
        double q = 0;
        int rightNum[] = new int[count];// 对的题号。对的结果为1，错的为0
        int titleResult[] = new int [count];//存放做题者提交的答案
        String allTime  = request.getParameter("allTime");
        for (int i = 1;i<=count;i++){
            j=i+0.1;
            q=i+0.2;
            String s = request.getParameter(String.valueOf(j));//获取题的字符串
            System.out.print(s);
            int s1 = Integer.parseInt(request.getParameter(String.valueOf(q)));//获取对应题目的答案
            System.out.print(s1);
            int result = doCalculate(s);
            System.out.print(result);
            request.getParameter("list");
            titleResult[i-1]=s1;
            if (result==s1){
                right++;
                rightNum[i-1]=0; //做对的为0
            }else {
                rightNum[i-1]=i;//做错的为i
            }
        }



        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strTime = df.format(day);
        String  nowDate = (String) request.getSession().getAttribute("nowDate1");
        long time = (df.parse(strTime).getTime()-df.parse(nowDate).getTime() )/1000;
        long seconds = (time%3600)%60;
        long min = (time%3600)/60;
        long hour = time/3600;

        HttpSession session=request.getSession();
        userScore.setUsername((String) session.getAttribute("username"));
        userScore.setStudentNumber( (String) session.getAttribute("studentNumber"));
        userScore.setScore(right+"/"+count);
        double right1 =right+0.00;
        double count1 = count+0.00;
        userScore.setAccuracy(right1/count1*100);
        userScore.setAllTime(hour+": "+min+":"+seconds);
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        userScore.setCurrentDate(df1.format(date));
        System.out.println(userScore);
        userScoreDao.addUserScore(userScore);

        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher(WebContents.RESULT);
        request.setAttribute("count",count); //题目的数量
        request.setAttribute("rightNum",rightNum);//对的题号。对的结果为1，错的为0
        request.setAttribute("right",right);//做对的数量
        request.setAttribute("titleResult", titleResult);//存放做题者提交的答案
        request.setAttribute("list",request.getParameter("list"));//存放timu
        request.setAttribute("allTime2",hour+"h "+min+"min "+seconds+" s");//存放时间英文
        request.setAttribute("allTime1",hour+"时 "+min+"分 "+seconds+" 秒" );//存放时间中文
        rd.forward(request, response);
    }


    /**
     * 输进一个字符串，计算结果
     * @param str
     * @return
     * @throws ScriptException
     */
    private int doCalculate(String str) throws ScriptException {
        String s= str.replace('÷','/');//将除号转化为程序可识别的除号
        ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
        String hush = String.valueOf(jse.eval(s));
        double temp = Double.parseDouble(hush);
        int result = (int)temp;
        return result;
    }

    private static final long serialVersionUID = 1L;
    private String makeStorePath(String storePath) {
        Date date = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String s = df.format(date);
        String path = storePath+"\\"+s;
        File file = new File(path);
        if(!file.exists())
        {
            file.mkdirs();//创建多级目录，mkdir只创建一级目录
        }
        return path;
    }

}
