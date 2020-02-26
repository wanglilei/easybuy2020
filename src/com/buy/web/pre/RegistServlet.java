package com.buy.web.pre;

import com.buy.web.pre.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistServlet")
public class RegistServlet extends AbstractServlet {

    @Override
    public Class getServletClass() {
        return RegistServlet.class;
    }
}
