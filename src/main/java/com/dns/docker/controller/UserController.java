package com.dns.docker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dns.docker.dao.IUserDAO;
import com.dns.docker.entity.User;

/**
 * @author dinusha
 *
 */
@RestController
public class UserController {

	@Autowired
	IUserDAO userRepo;
	
	/*@Autowired
	IDocDAO docRepo;
	
	@Autowired
	IPatientDAO patientRepo;
	
	@Autowired
	IAdminDAO adminRepo;
*/
	@RequestMapping("/users")
	public Iterable<User> users() {
		Iterable<User> userList = userRepo.findAll();
		
		for (User user : userList) {
			System.out.println("userId:"+user.getUid()+" email:"+user.getEmail());
		}
		return userList;

	}
/*	
	@RequestMapping("/doctors")
	public Iterable<Doctor> doctors() {
		Iterable<Doctor> docList = docRepo.findAll();
		
		for (User user : docList) {
			System.out.println("userId:"+user.getUid()+" email:"+user.getEmail());
		}
		return docList;

	}
	
	@RequestMapping("/patients")
	public Iterable<Patient> patients() {
		Iterable<Patient> patientList = patientRepo.findAll();
		
		for (User user : patientList) {
			System.out.println("userId:"+user.getUid()+" email:"+user.getEmail());
		}
		return patientList;

	}
	
	@RequestMapping("/admins")
	public Iterable<Admin> admins() {
		Iterable<Admin> patientList = adminRepo.findAll();
		
		for (User user : patientList) {
			System.out.println("userId:"+user.getUid()+" email:"+user.getEmail());
		}
		return patientList;

	}
*/
}
