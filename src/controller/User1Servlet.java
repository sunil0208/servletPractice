package controller;

import model.Users;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by sunil on 5/25/16.
 */
@WebServlet(name = "User1Servlet")
public class User1Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String password;
        String username;

        username = request.getParameter("userName");
        System.out.println("check "+username);
        password = request.getParameter("password");

        Users users = new Users();
        users.setUserName(username);
        users.setPassword(password);

        UserService userService = new UserService();
        //check for login
        if((userService.searchUserId(users))){
            System.out.println("forward to next page after login");
            RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp");
            rd.forward(request,response);
        }//end of if
        else{
            try {
                //to insert the users for register

                 userService.insertUser(users);

                out.print("users successfully registered");
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                rd.include(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }




    }
}
