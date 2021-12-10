package kr.co.hyewon.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import kr.co.hyewon.beans.UserBean;
import kr.co.hyewon.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Resource(name = "loginUserBean")
	@Lazy
	private UserBean loginUserBean;

	public boolean checkUserIdExist(String user_id) {

		String user_name = userDao.checkUserIdExist(user_id);

		if(user_name == null) {
			return true;
		} else {
			return false;
		}
	}

	public void addUserInfo(UserBean joinUserBean) {
		userDao.addUserInfo(joinUserBean);
	}

	public void getLoginUserInfo(UserBean temploginUserBean) {

		UserBean temploginUserBean2 = userDao.getLoginUserInfo(temploginUserBean);

		if(temploginUserBean2 != null) {  //로그인 성공 시
			loginUserBean.setUser_idx(temploginUserBean2.getUser_idx());
			loginUserBean.setUser_idx(temploginUserBean2.getUser_idx());
			loginUserBean.setUserLogin(true); // 로으인 되있는 것
		}
	}
}
