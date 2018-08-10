package com.example.intelligent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DengLu extends Activity{
private Button BtnDeng;
private EditText EtName;
private EditText EtPwd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		findView();//得到浏览器中的监控对象
		setListener();//设置对象的监听器

	}
	private void setListener() {
		// TODO 自动生成的方法存根
		BtnDeng.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				String name =EtName.getText().toString();//得到用户输入的用户名
				String pwd  =EtPwd.getText().toString();
				
				if(isUSer(name,pwd)){
					Intent i = new Intent(DengLu.this,ThirdRoom.class);//合法跳转
					startActivity(i);
					
				}
				else{
			Toast.makeText(DengLu.this, "用户名密码错误", Toast.LENGTH_SHORT).show();
				}
				}
		});
						}
	protected boolean isUSer(String name, String pwd) {
		// TODO 自动生成的方法存根
		if("admin".equals(name)&&"123".equals(pwd)){
			return true;
		}else{
		return false;
		}
	}
	private void findView() {
		// TODO 自动生成的方法存根
		BtnDeng=(Button)findViewById(R.id.BtnDeng);
		EtName=(EditText)findViewById(R.id.EtName);
		EtPwd=(EditText)findViewById(R.id.EtPwd);
	}

			
		
	}


