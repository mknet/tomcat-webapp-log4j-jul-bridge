package net.marcelkoch.java;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;


public class HelloServlet implements Servlet {

    private static final Logger LOG4j = LogManager.getLogger(HelloServlet.class);

    private static final java.util.logging.Logger JUL = java.util.logging.Logger.getLogger(HelloServlet.class.getName());

    @Override
    public void init(ServletConfig servletConfig) {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        LOG4j.info("log4j message");

        JUL.info("JUL message");

        servletResponse.getWriter().println("Hello");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
