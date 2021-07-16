package org.nachc.examples.websecurity.servlet;

import java.io.IOException;

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
		log.info("Doing log off for user:");
		Subject subject = SecurityUtils.getSubject();
		if(subject != null && subject.isAuthenticated()) {
			subject.logout();
		}
		log.info("User has been log offed");
	}

	
	
}
