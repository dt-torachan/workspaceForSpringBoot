package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class UserDAO {
	
	@Transactional
	public Model searchById(@RequestParam("id") String id,@RequestParam("password") String password,Model model) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://ec2-3-222-30-53.compute-1.amazonaws.com:5432/d3ebsimt1afacu","ricbhkslwxzrqj","5cda005554442a939f9c68973f02ec0bc748280e632c11f0fdbaccfd8fcb9b9a");
			PreparedStatement pstmt = conn.prepareStatement("select * from users where id = ?");
			pstmt.setString(1, id);
						ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				model.addAttribute("id", rs.getString("id"));
				model.addAttribute("password", rs.getString("password"));
				model.addAttribute("username", rs.getString("username"));
				model.addAttribute("phone", rs.getString("phone"));
				model.addAttribute("mail", rs.getString("mail"));
				model.addAttribute("privilege", rs.getInt("privilege"));
				
				if(!model.getAttribute("id").equals(id) || !model.getAttribute("password").equals(password)){
					model.addAttribute("errormessage", "IDまたはパスワードが正しくありません");
				}
			}else{
				model.addAttribute("errormessage", "登録されていないIDです");
			}
		}catch(SQLException e) {
			model.addAttribute("errormessage", e);
		}
			return model;
	}

}
