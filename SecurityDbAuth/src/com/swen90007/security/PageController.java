package com.swen90007.security;

import java.security.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @Autowired
    private DataSource dataSource;

    private List<UserRoleDTO> loadUsersAndRoles() {
	String sql = "SELECT USERS.USER_ID, USERNAME, PASSWORD, ENABLED, USER_ROLE_ID, ROLE FROM USERS JOIN ROLES ON ROLES.USER_ID=USERS.USER_ID";
	Connection conn = null;

	try {
	    conn = dataSource.getConnection();
	    PreparedStatement ps = conn.prepareStatement(sql);

	    List<UserRoleDTO> dtos = new ArrayList<UserRoleDTO>();
	    UserRoleDTO dto = null;
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		dto = new UserRoleDTO();
		dto.setUserId(rs.getInt("USER_ID"));
		dto.setUsername(rs.getString("USERNAME"));
		dto.setPassword(rs.getString("PASSWORD"));
		dto.setEnabled(rs.getInt("ENABLED"));
		dto.setRoleId(rs.getInt("USER_ROLE_ID"));
		dto.setRole(rs.getString("ROLE"));
		dtos.add(dto);
	    }
	    rs.close();
	    ps.close();
	    return dtos;
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	} finally {
	    if (conn != null) {
		try {
		    conn.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	    }
	}
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(ModelMap model, Principal principal) {
	model.addAttribute("message", "Welcome " + principal.getName());
	model.addAttribute("dtos", loadUsersAndRoles());
	return "admin";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(ModelMap model, Principal principal) {
	model.addAttribute("message", "Welcome " + principal.getName());
	model.addAttribute("principal", principal);
	return "welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
	return "login";
    }
}