package controller;
import com.google.gson.Gson;
import dao.ContactsDao;
import model.Contact;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ������������� on 24.02.2016.
 */
public class MainServlet extends HttpServlet{
    private static Statement stmt;
    private static ResultSet rs;
    private  Connection con;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String expression = request.getParameter("expression");
        PrintWriter out = response.getWriter();

        ContactsDao dao = new ContactsDao();
        List<Contact> list = dao.getContacts(expression);

        Gson gson = new Gson();
        String json = gson.toJson(list);
        out.println(json);

        out.close();
    }
}
