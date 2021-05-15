package com.fy.spring.tx.service.impl;

import com.fy.spring.tx.dao.TestDAO;
import com.fy.spring.tx.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fy.spring.tx.service.InnerBean;

@Service
public class InnerBeanImpl implements InnerBean {

	@Autowired
	private TestDAO testDAO;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void testRequired(User inner) {
		testDAO.insertUser(inner);
		//throw new RuntimeException("Rollback this transaction!");
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void testRequiresNew(User inner) {
		testDAO.insertUser(inner);
		//throw new RuntimeException("Rollback this transaction!");
	}

	@Override
	@Transactional(propagation=Propagation.NESTED)
	public void testNested(User inner) {
		testDAO.insertUser(inner);
		//throw new RuntimeException("Rollback this transaction!");
	}

}
