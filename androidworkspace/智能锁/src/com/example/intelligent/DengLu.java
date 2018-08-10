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
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		findView();//�õ�������еļ�ض���
		setListener();//���ö���ļ�����

	}
	private void setListener() {
		// TODO �Զ����ɵķ������
		BtnDeng.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				String name =EtName.getText().toString();//�õ��û�������û���
				String pwd  =EtPwd.getText().toString();
				
				if(isUSer(name,pwd)){
					Intent i = new Intent(DengLu.this,ThirdRoom.class);//�Ϸ���ת
					startActivity(i);
					
				}
				else{
			Toast.makeText(DengLu.this, "�û����������", Toast.LENGTH_SHORT).show();
				}
				}
		});
						}
	protected boolean isUSer(String name, String pwd) {
		// TODO �Զ����ɵķ������
		if("admin".equals(name)&&"123".equals(pwd)){
			return true;
		}else{
		return false;
		}
	}
	private void findView() {
		// TODO �Զ����ɵķ������
		BtnDeng=(Button)findViewById(R.id.BtnDeng);
		EtName=(EditText)findViewById(R.id.EtName);
		EtPwd=(EditText)findViewById(R.id.EtPwd);
	}

			
		
	}


