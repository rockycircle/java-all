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
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forclient);
		
		final EditText editText = (EditText)findViewById(R.id.editText01);
		
		Button connectBtn =(Button)findViewById(R.id.connectBtn);
		Button subitBtn =(Button)findViewById(R.id.submitBtn);
	
	//���ӷ�����
		connectBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v)
			{
				try{
					//���ӷ�����
					_socket = new Socket(SERVERIP, SERVERPORT);
					
					//ȡ������/�����
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
	
//������Ϣ��������
	public void sendMessage(String message)
	{
		try
		{
			System.out.println(message);
			
			//������Ϣ��������
			_printWriter.print(message);
			_printWriter.flush();
		}
		catch (Exception e){}
	}
	
	//������������������Ϣ
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
					//������Ϣ
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
			
			//ˢ����Ϣ
			try
			{
				//������յ�������
				System.out.println(_message);
			}
			catch (Exception e)
			{
			}
		}
	};
	
	
}
