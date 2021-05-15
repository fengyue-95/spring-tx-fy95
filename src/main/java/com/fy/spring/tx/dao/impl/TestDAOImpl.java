package com.fy.spring.tx.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fy.spring.tx.dao.TestDAO;
import com.fy.spring.tx.model.User;

@Service
public class TestDAOImpl implements TestDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insertUser(User user) {
		
		sessionFactory.getCurrentSession().save(user);
		// sessionFactory.openSession() ��ʹ����ʧЧ
	   // ���� getCurrentSession ��㷽������û������........MMP
	}

}
