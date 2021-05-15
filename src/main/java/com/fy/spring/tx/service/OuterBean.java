package com.fy.spring.tx.service;

import com.fy.spring.tx.model.User;

/**
 * 嵌套事务测试-外层调用方法提供类
 */
public interface OuterBean {

	void testRequired(User outer, User inner);

	void testRequiresNew(User outer, User inner);

	void testNested(User outer, User inner);
}
