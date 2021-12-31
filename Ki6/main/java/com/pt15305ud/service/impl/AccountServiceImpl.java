package com.pt15305ud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pt15305ud.dao.AccountDAO;
import com.pt15305ud.entity.Account;
import com.pt15305ud.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDAO _accDAO;

	@Override
	public Account findById(String username) {
	return _accDAO.findById(username).get();
	}

}
