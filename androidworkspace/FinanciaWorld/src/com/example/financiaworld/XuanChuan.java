package com.example.financiaworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class XuanChuan extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.xuanchuan);
		
		
		
		Thread timer = new Thread(){
		public void run(){
			try{
				sleep(3000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}finally{
			Intent openMainActivity = new Intent("com.example.financiaworld.DENGLU");
			startActivity(openMainActivity);
			}
		}
		};timer.start();
	}

	@Override
	protected void onPause() {
		// TODO �Զ����ɵķ������
		super.onPause();
		finish();
	}
	

}
