package com.example.intelligentdemo.client;

import java.lang.ref.WeakReference;

import com.example.intelligentdemo.service.ServiceRulesException;
import com.example.intelligentdemo.service.UserService;
import com.example.intelligentdemo.service.UserServiceInpl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity {
private EditText txtLoginName;
private EditText txtLoginPassword;
private Button btnLogin;
private Button btnReset;

private UserService userService = new UserServiceInpl();

private static final int FLAG_LOGIN_SUCCESS = 1;

private static final String MSG_LOGIN_ERROR = "登陆出错。";
private static final String MSG_LOGIN_SUCCESS = "登陆成功。";
public static final String MSG_LOGIN_FAILED = "登陆名|登录密码出错。";

private static ProgressDialog dialog;

private void init(){
    this.txtLoginName = (EditText) this.findViewById(R.id.txt_login_name);
    this.txtLoginPassword=(EditText)this.findViewById(R.id.txt_login_password);
    this.btnLogin =(Button) this.findViewById(R.id.btn_login);
    this.btnReset =(Button) this.findViewById(R.id.btn_reset);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        this.init();

        this.btnLogin.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO 自动生成的方法存根
			final	String loginName = txtLoginName.getText().toString();
			final	String loginPassword = txtLoginPassword.getText().toString();
				
				//Toast.makeText(view.getContext(),"登录名" +loginName,Toast.LENGTH_SHORT ).show();
				//Toast.makeText(view.getContext(),"登录密码" +loginPassword,Toast.LENGTH_SHORT ).show();
				
				
				/*
				 * 输入值的验证
				 * */
			/*
			 * loading...
			 * */
			
			if(dialog == null){
				dialog = new ProgressDialog(LoginActivity.this);
			}
			dialog.setTitle("请等待");
			dialog.setMessage("登陆中。。。");
			dialog.setCancelable(false);
			dialog.show();
			
				/*
				 * 副线程
				 * */
				Thread thread = new Thread(new Runnable(){

					@Override
					public void run() {
						// TODO 自动生成的方法存根
						try{
							userService.userLogin(loginName, loginPassword);							
		                    handler.sendEmptyMessage(FLAG_LOGIN_SUCCESS );
						}catch(ServiceRulesException e){
							e.printStackTrace();
							Message msg = new Message();
							Bundle data = new Bundle();
							data.putSerializable("ErrorMsg", e.getMessage());
							handler.sendMessage(msg);}
						catch(Exception e){
							e.printStackTrace();
							Message msg = new Message();
							Bundle data = new Bundle();
							data.putSerializable("ErrorMsg", MSG_LOGIN_ERROR);
							handler.sendMessage(msg);
							
						}
					}
					
					
				});
				thread.start();
			}
        	
        	
        });
        this.btnReset.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO 自动生成的方法存根
				txtLoginName.setText("");
				txtLoginPassword.setText("");
			}
        	
        });
        
    }
    private void showTip(String str){
    	Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    	
    }
    private static class IHandler extends Handler{
     
    	private final WeakReference<Activity> mActivity;
    	 
    	public IHandler(LoginActivity activity){
    		mActivity = new WeakReference<Activity>(activity);
     
    		
    	}
     
    	
		@Override
		public void handleMessage(Message msg) {
			int flag = msg.what;
			switch(flag){
			case 0:
				String errorMsg = (String) msg.getData().getSerializable("ErrorMsg");
			((LoginActivity)mActivity.get()).showTip(errorMsg);
				break;
			case FLAG_LOGIN_SUCCESS:
				((LoginActivity)mActivity.get()).showTip(MSG_LOGIN_SUCCESS);
				break;
				default:
					break;  
			}
		}
    	
    }
  private IHandler handler = new IHandler(this);
    
}
