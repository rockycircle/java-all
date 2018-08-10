package com.example.tongxin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Client extends Activity{
	//socket = new Socket("10.0.2.2", 12345);
	private static final String SERVERIP  = "10.0.2.2";
	private static final int SERVERPORT  = 12345;
	private static Thread  _thread    =   null;
	private Socket   _socket   =  null;
	private BufferedReader  _bufferedReader  =  null;
	private static PrintWriter  _printWriter  =  null;
	private String   _message     = "";
	
   	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forclient);
		
		final EditText editText = (EditText)findViewById(R.id.editText01);
		
		Button connectBtn =(Button)findViewById(R.id.connectBtn);
		Button subitBtn =(Button)findViewById(R.id.submitBtn);
	
	//连接服务器
		connectBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v)
			{
				try{
					//连接服务器
					_socket = new Socket(SERVERIP, SERVERPORT);
					
					//取得输入/输出流
					_bufferedReader = new BufferedReader(new InputStreamReader
							(_socket.getInputStream(),"GB2312"));
					
					_printWriter = new PrintWriter(_socket.getOutputStream(),true);
					
					
				}
				catch (Exception e){
					System.out.println("Connect is failed!");
				}
			}});
		subitBtn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				String msg = editText.getText().toString();
				
				sendMessage(msg);
			}});
	
		_thread = new Thread(_runnable);
		_thread.start();
	}
	
//发送信息到服务器
	public void sendMessage(String message)
	{
		try
		{
			System.out.println(message);
			
			//发送信息给服务器
			_printWriter.print(message);
			_printWriter.flush();
		}
		catch (Exception e){}
	}
	
	//监听服务器发来的消息
	private Runnable _runnable = new Runnable()
	{
		public void run()
		{
			while(true)
			{
				try
				{
				if((_message = _bufferedReader.readLine()) !=null)
				{
					//发送信息
					_handler.sendMessage(_handler.obtainMessage());
				}
				}
				catch (Exception e)
				{					
				}
			}
		}
	};
	Handler  _handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			super.handleMessage(msg);
			
			//刷新信息
			try
			{
				//输出接收到的数据
				System.out.println(_message);
			}
			catch (Exception e)
			{
			}
		}
	};
	
	
}
