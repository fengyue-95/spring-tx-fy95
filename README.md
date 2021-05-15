# spring-tx-fy95
spring-tx事务传播行为学习

一、事务传播常见问题？？？

1.没有使用代理类，从而直接使用本类中的方法。
2.当两个方法共用一个事务时，内层方法抛出异常，被事务拦截器拦截，并标记回滚，外层方法调用内层方法时try，catch住了内层方法，此时外层方法正常提交时，共用的事务已经被标记回滚，会抛出
  "Transaction rolled back because it has been marked as rollback-only"异常。
