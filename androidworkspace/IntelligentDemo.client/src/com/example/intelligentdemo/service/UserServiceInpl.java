package com.example.intelligentdemo.service;

import com.example.intelligentdemo.client.LoginActivity;

import android.util.Log;

public class UserServiceInpl implements UserService{

	 private static final String TAG = "UserServiceImpl";
	@Override
	public void userLogin(String loginName, String loginPassword)
			throws Exception {
		// TODO 自动生成的方法存根
		Log.d(TAG, loginName);
		Log.d(TAG, loginPassword);
		
		Thread.sleep(3000);
		
		if(loginName.equals("tom") && loginPassword.equals("123")){
			
		}else{
			throw new ServiceRulesException(LoginActivity.MSG_LOGIN_FAILED);
		}
	}

}
