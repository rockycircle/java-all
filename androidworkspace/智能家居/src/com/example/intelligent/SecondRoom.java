package com.example.intelligent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;




import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class SecondRoom extends Activity{
private Button startConnect;
private Button btnAuto;
private Button btnonoff;
private Button btnWenAdd;
private Button btnWenSub;
private Button btnMoCod;
private Button btnMoWam;
private Button btnMoWet;
private Button btnShYao;
private Button btnXiaYao;
private Button btnFengSu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.other);
			
		startConnect = (Button)findViewById(R.id.StartConnect);
		btnAuto = (Button)findViewById(R.id.auto);
		btnonoff = (Button)findViewById(R.id.fan_on_off);
		btnWenAdd = (Button)findViewById(R.id.fanadd);		
		
		        startConnect.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						connect();
						
					}
				});
				
				btnAuto.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						autobtn();
						
					}
				});
				btnonoff.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						onoffbtn();
						
					}
				});
				btnWenAdd.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Intent k = new Intent(SecondRoom.this,ThirdRoom.class);//合法跳转
						startActivity(k);
						
					}
				});
	
	

}
//.................................................................
Socket socket = null;
BufferedWriter writer= null;
BufferedReader reader= null;

public void connect(){
	AsyncTask<Void,String,Void> read = new AsyncTask<Void,String,Void>(){

		@Override
		protected Void doInBackground(Void... params) {
		
			try {
//				socket = new Socket("10.0.2.2", 12345);
//				socket = new Socket("192.168.1.107", 12345);
				
				socket = new Socket("10.0.2.2", 12345); 
				
			//	socket = new Socket("10.70.10.190", 12345);
				writer = new BufferedWriter(
						new OutputStreamWriter(
								socket.getOutputStream()));
				reader = new BufferedReader(
						new InputStreamReader(
								socket.getInputStream()));
				publishProgress("@success");
				
			} catch (UnknownHostException e) {
			Toast.makeText(SecondRoom.this, "无法连接", Toast.LENGTH_SHORT).show();	
		
			
			} catch (IOException e) {
			Toast.makeText(SecondRoom.this, "无法连接", Toast.LENGTH_SHORT).show();
			}
			
			
			try {
				String line;
				while((line=reader.readLine())!=null){
					publishProgress(line);
					
				}
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			return null;
		}

		@Override
		protected void onProgressUpdate(String... values) {
			if (values[0].equals("@success")) {

				Toast.makeText(SecondRoom.this, "连接成功",
						Toast.LENGTH_SHORT).show();
			}
	
			super.onProgressUpdate(values);
		}
		
		
		
		
		
	};
	read.execute();
}

public void autobtn(){
	try {
		writer.write("auto"+"\n");
		writer.flush();
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
	
}
public void onoffbtn(){
	try {
		writer.write("onoff"+"\n");
		writer.flush();
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
	
}



}


