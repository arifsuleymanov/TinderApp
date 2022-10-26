package com.tinder;

import com.entity.CurrentUser;
import com.entity.User;
import com.entity.impl.LikedProfilesImpl;
import com.entity.impl.UserImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.lang.System.out;

@WebServlet(name = "IndexController", urlPatterns = {"/index"})
public class IndexController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    //adding new commentsgit
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            UserImpl userImpl = new UserImpl();
            LikedProfilesImpl likePageController = new LikedProfilesImpl();
            String email = request.getParameter("inputEmail");
            String password = request.getParameter("inputPassword");
            if (email != null && password != null) {
//                if (email.equals("admin@gmail.com") && password.equals("12345")) {
//                    response.sendRedirect("like-page.jsp");
//                } else {
//                    out.println("entered username or password is wrong");
//                }
                if (userImpl.getPasswordByEmail(email).equals(password)) {
                    likePageController.setCurrentUser(new User(userImpl.getIDByEmail(email), email, userImpl.getPasswordByEmail(email)));
                    CurrentUser.setId(userImpl.getIDByEmail(email));
                    response.sendRedirect("like-page.jsp");
                } else {
                    out.println("entered username or password is wrong");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        out.println("in do post");
        try {
            String email = request.getParameter("inputEmail");
            String password = request.getParameter("inputPassword");
            if (email.equals("admin@gmail.com") && password.equals("12345")) {
                response.sendRedirect("like-page.jsp");
            } else {
                out.println("entered username or password is wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}