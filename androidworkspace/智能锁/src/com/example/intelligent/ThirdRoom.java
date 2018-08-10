package com.example.intelligent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;





import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdRoom extends Activity{
private Button astartConnect;
private Button abtnAuto;
private Button abtnonoff;
private Button abtnWenSend;
private Button cold;
private Button warm;
private Button nowet;
private Button gao;
private Button zhong;
private Button di;
private Button fanadd;
private Button fansub;
private EditText editText2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.thother);
			
		astartConnect = (Button)findViewById(R.id.StartConnect);
		abtnAuto = (Button)findViewById(R.id.auto);
		abtnonoff = (Button)findViewById(R.id.fan_on_off);
		//abtnWenSend = (Button)findViewById(R.id.button2);	
		//editText2= (EditText)findViewById(R.id.edittext2);
		cold = (Button)findViewById(R.id.cold);
		//warm = (Button)findViewById(R.id.warm);
		//nowet = (Button)findViewById(R.id.nowet);
		//gao = (Button)findViewById(R.id.gao);
		//zhong = (Button)findViewById(R.id.zhong);
		//di = (Button)findViewById(R.id.di);
		fanadd = (Button)findViewById(R.id.fanadd);
		fansub = (Button)findViewById(R.id.fansub);
		
		
		
		astartConnect.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						connect();
						
					}
				});
		fanadd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendadd();
				
			}
		});
		fansub.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendsub();
				
			}
		});		
		
				abtnAuto.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						aautobtn();
						
					}
				});
				
				abtnonoff.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						aonoffbtn();
						
					}
				});
				abtnWenSend.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						sendbtn();
						
					}
				});
				cold.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						sendcold();
						
					}
				});
				warm.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						sendwarm();
						
					}
				});
				nowet.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						sendnowet();
						
					}
				});
                gao.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						sendgao();
						
					}
				  });
               zhong.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		sendzhong();
		
	}
});
di.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		senddi();
		
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
	//			socket = new Socket("10.0.2.2", 12345);
				socket = new Socket("192.168.0.26", 12345);
	//			socket = new Socket("10.70.10.191", 12345);		
//				socket = new Socket("10.0.2.2", 12345); 
				
				writer = new BufferedWriter(
						new OutputStreamWriter(
								socket.getOutputStream()));
				reader = new BufferedReader(
						new InputStreamReader(
								socket.getInputStream()));
				publishProgress("@success");
				
			} catch (UnknownHostException e) {
			Toast.makeText(ThirdRoom.this, "无法连接", Toast.LENGTH_SHORT).show();	
		
			
			} catch (IOException e) {
			Toast.makeText(ThirdRoom.this, "无法连接", Toast.LENGTH_SHORT).show();
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
              
				Toast.makeText(ThirdRoom.this, "连接成功",
						Toast.LENGTH_SHORT).show();
			}
	     
			super.onProgressUpdate(values);
		}
		
		
		
		
		
	};
	read.execute();
}

public void aautobtn(){
	try {
		writer.write("auto"+"\n");
		writer.flush();
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
	
}
public void aonoffbtn(){
	try {
		writer.write("off"+"\n");
		writer.flush();
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
	
}
public void sendbtn(){
	try {
		writer.write(editText2.getText().toString() +"high,refrigeration"+ "\n");
		writer.flush();
		editText2.setText("");
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
	
}

public void sendcold(){
	try {
		writer.write("refrigeration"+"\n");
		writer.flush();
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
	
}
public void sendwarm(){
	try {
		writer.write("heating"+"\n");
		writer.flush();
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
	
}
public void sendnowet(){
	try {
		writer.write("arefation"+"\n");
		writer.flush();
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
	
}
public void sendgao(){
	try {
		writer.write("high"+"\n");
		writer.flush();
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
	
}
public void sendzhong(){
	try {
		writer.write("medium"+"\n");
		writer.flush();
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
	
}
public void senddi(){
	try {
		writer.write("low"+"\n");
		writer.flush();
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
	
}
public void sendadd(){
	try {
		writer.write(editText2.getText().toString() +"\n");
		writer.flush();
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
	
}
public void sendsub(){
	try {
		writer.write(editText2.getText().toString() +"\n");
		writer.flush();
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
	
}

}


