package org.nachc.examples.websecurity.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogOutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Subject subject = SecurityUtils.getSubject();
		log.info("Doing log off for user: ");
		if(subject != null && subject.isAuthenticated()) {
			subject.logout();
			SecurityUtils.getSecurityManager().logout(subject);
			log.info("Subject has been logged off");
			RequestDispatcher disp = req.getRequestDispatcher("/app/logOn.jsp");
			disp.forward(req, resp);
		} else {
			log.info("USER NOT FOUND, NOT LOGGED OFF");
		}
		log.info("User has been loged off");
	}

}
