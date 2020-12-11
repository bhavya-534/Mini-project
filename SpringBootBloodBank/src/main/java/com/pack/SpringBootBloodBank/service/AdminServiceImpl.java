package com.pack.SpringBootBloodBank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.SpringBootBloodBank.dao.AdminRepository;
import com.pack.SpringBootBloodBank.model.Admin;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminRepository adminRepository;

	@Override
	public Admin adminAuthentication(Admin admin) {
		// TODO Auto-generated method stub
		Optional<Admin> optional= adminRepository.findById(admin.getUserName());
		Admin databaseAdmin= null;
		if(optional.isPresent()) {
			databaseAdmin = optional.get();
			if(databaseAdmin.getPassword().equals(admin.getPassword())) {
				return admin;
			}
		}
		return null;
	} 

	

}

