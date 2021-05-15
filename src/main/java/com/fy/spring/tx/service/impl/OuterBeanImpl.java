package com.fy.spring.tx.service.impl;

import com.fy.spring.tx.service.OuterBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fy.spring.tx.dao.TestDAO;
import com.fy.spring.tx.model.User;
import com.fy.spring.tx.service.InnerBean;

/**
 * 使用事务时，需要注意类内调用不生效的问题，
 * spring的tx是通过切面控制的，本类调用无法捕捉切面，从而事务行为无效
 */
@Service
public class OuterBeanImpl implements OuterBean {
	private static final Log log = LogFactory.getLog(OuterBeanImpl.class);

	@Autowired
	private TestDAO testDAO;
	
	@Autowired
	private InnerBean innerBean;

	/** 调用方法可以是事务方法也可以是非事务方法 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void testRequired(User outer, User inner) {
		testDAO.insertUser(outer);
		try{
			innerBean.testRequired(inner);
		} catch(RuntimeException e){
          log.error("内层方法出现异常回滚",e);
		}
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void testRequiresNew(User outer, User inner) {
		testDAO.insertUser(outer);
		try{
			innerBean.testRequiresNew(inner);
		} catch(RuntimeException e){
			log.error("内层方法出现异常回滚",e);
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void testNested(User outer, User inner) {
		testDAO.insertUser(outer);
		try{
			innerBean.testNested(inner);
		} catch(RuntimeException e){
			log.error("内层方法出现异常回滚",e);
		}
	}

}
