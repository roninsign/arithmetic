package com.servlet;

import com.dao.UserDao;
import com.dao.UserScoreDao;
import com.dao.impl.UserDaoImpl;
import com.dao.impl.UserScoreDaoImpl;
import com.entity.User;
import com.entity.UserScore;
import com.util.WebContents;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = "/user",asyncSupported = true)
public class UserServlet extends HttpServlet {

    public UserServlet(){
        super();
    }
    public void destroy(){
        super.destroy();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = utf-8");//使客户端浏览器，区分不同种类的数据，并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据。
        request.setCharacterEncoding("utf-8");//设置对客户端请求进行重新编码的编码为utf-8
        response.setCharacterEncoding("utf-8"); //指定对服务器响应进行重新编码的编码为utf-8
//        PrintWriter out = response.getWriter();   //服务器向客户端反馈的时候需要用流向客户端输出数据
        String state = request.getParameter("state");  //获取jsp页面发生的事件
        if (state.equals("login")){
            /* 跳转到生成题目页面*/
            LoginCheck(request,response);
        }else if (state.equals("register")){
            RequestDispatcher rd =request.getRequestDispatcher(WebContents.REGISTER);
            rd.forward(request,response);
        }else if (state.equals("doRegister")){
            Register(request,response);
        }else if (state.equals("all")){
            ListUserScore(request,response);
        }else if (state.equals("allUser")){
            ListAllUser(request,response);

        }else if (state.equals("logout")){
            logout(request,response);
        }
    }

    /**
     * 退出登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void logout(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher(WebContents.LOGIN);
        rd.forward(request,response);

    }

    /**
     * 查看全部用户成绩
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void ListAllUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<UserScore> list = new ArrayList<UserScore>();
        RequestDispatcher rd = null;
        UserScoreDao userScoreDao = new UserScoreDaoImpl();
        list = userScoreDao.ListAll();
        request.setAttribute("list",list);
        System.out.println(list);
        rd = request.getRequestDispatcher(WebContents.ALL);
        rd.forward(request,response);

    }


    /**
     * 登录用户的历史成绩
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void ListUserScore(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<UserScore> list = new ArrayList<UserScore>();
        RequestDispatcher rd = null;
        HttpSession session=request.getSession();
        UserScoreDao userScoreDao =new UserScoreDaoImpl();
        String sNo = (String) session.getAttribute("studentNumber");
        list = userScoreDao.InquiryBystudentNumber(sNo);
        request.setAttribute("list",list);
        rd = request.getRequestDispatcher(WebContents.SNO);
        rd.forward(request,response);
    }

    /**
     * 登录检查是否正确
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void LoginCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentNumber = request.getParameter("studentNumber");
        String password = request.getParameter("password");
        UserDao userdao = new UserDaoImpl();
        User user1= userdao.SelectUserBystudentName(studentNumber);
        HttpSession session=request.getSession();
        RequestDispatcher rd = null;
        if (user1!= null) {
            String username = user1.getUsername();
            session.setAttribute("username",username);
            session.setAttribute("studentNumber",studentNumber);
            if (user1.getPassword().equals(password)) {
                rd = request.getRequestDispatcher(WebContents.WELCOME);
                rd.forward(request, response);
            } else {
                rd = request.getRequestDispatcher(WebContents.LOGIN);
                request.setAttribute("msg1", "密码错误,请重新输入！");
                request.setAttribute("msg2", "The password is wrong. Please retype it！");
                rd.forward(request, response);
            }
        } else {
            rd = request.getRequestDispatcher(WebContents.LOGIN);
            request.setAttribute("msg1", "该用户不存在，请重新输入用户信息！");
            request.setAttribute("msg2", "The user does not exist, please reenter the information！");
            rd.forward(request, response);
        }
    }


    /**
     * 注册用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void  Register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = null;
        UserDao userdao = new UserDaoImpl();
        if (userdao.SelectUserBystudentName(request.getParameter("studentNumber")) != null) {
            request.setAttribute("msg1", "用户名已经存在，请重新注册！！！");
            request.setAttribute("msg2", "The user name already exists, please reregister.！！！");
            rd = request.getRequestDispatcher(WebContents.REGISTER);
            rd.forward(request, response);
        } else {
            User user = new User();
            user.setUsername(request.getParameter("username"));
            user.setStudentNumber(request.getParameter("studentNumber"));
            user.setPassword(request.getParameter("password"));
            System.out.println(user);
            if (user != null)
                if (!user.getPassword().equals("")) {
                    userdao = new UserDaoImpl();
                    userdao.AddUser(user);
                    request.setAttribute("msg1", "注册成功，请登录！！！");
                    request.setAttribute("msg2", "Registration is successful, please login.！！！");
                    rd = request.getRequestDispatcher(WebContents.LOGIN);
                    rd.forward(request, response);
                } else {
                    rd = request.getRequestDispatcher(WebContents.REGISTER);
                    request.setAttribute("msg1", "输入信息不完全，请重新输入！！！");
                    request.setAttribute("msg2", "The input information is incomplete，please reenter the information.！！！");
                    rd.forward(request, response);
                }
            else {
                rd = request.getRequestDispatcher(WebContents.REGISTER);
                request.setAttribute("msg1", "输入信息不完全，请重新输入！！！");
                request.setAttribute("msg2", "The input information is incomplete，please reenter the information.！！！");
                rd.forward(request, response);
            }
        }
    }

}
