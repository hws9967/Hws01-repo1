package com.test.www.service;

import java.util.List;

import com.test.www.dao.UserDao;
import com.test.www.po.User;

/**
 * 
    * @ClassName: Service
    * @Description: 中间层，目前没有实际的作用，知识负责交接传递
    * @author 395621926
    * @date 2020年1月22日
    *
 */
public class ServiceUser {
	
	UserDao userDao = new UserDao();
	/**
	 * 
	    * @Title: LoginUser
	    * @Description:登陆功能的实现
	    * @param @param user
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public boolean LoginUser(User user) {
		
		return  userDao.loginUser(user);
	}
	
	/**
	 * 
	    * @Title: InsertUser
	    * @Description: 注册用户数据
	    * @param @param user
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public boolean InsertUser(User user) {
		
		return  userDao.InsertUser(user);
	}
	
	/**
	 * 
	    * @Title: userList
	    * @Description: 用户一览表的获取
	    * @param @return    参数
	    * @return List<User>    返回类型
	    * @throws
	 */
	public List<User> userList(){
	
		return userDao.userList();
	}
	/**
	 * 
	    * @Title: updateUser
	    * @Description: 更新用户信息
	    * @param @param user
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	public boolean deleteUser(int name) {
		return userDao.deleteUser(name);
	}
	
	public User selectUser(int name) {
		return userDao.selectUser(name);
	}
	
	public List<User> select(String sql) {
		return userDao.select(sql);
	}
}
