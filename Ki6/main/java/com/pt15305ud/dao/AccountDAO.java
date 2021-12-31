package com.pt15305ud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pt15305ud.entity.Account;

public interface AccountDAO extends JpaRepository<Account, String> {

}
