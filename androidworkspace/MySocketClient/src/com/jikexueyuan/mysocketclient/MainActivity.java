package com.jikexueyuan.mysocketclient;

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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText ip;
	EditText editText;
	TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ip = (EditText) findViewById(R.id.edittext1);
		editText = (EditText) findViewById(R.id.edittext2);
		text = (TextView) findViewById(R.id.textView);

		findViewById(R.id.button1).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						connect();

					}
				});
		findViewById(R.id.button2).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						send();

					}

				});

	}

	// .................................................................

	Socket socket = null;
	BufferedWriter writer = null;
	BufferedReader reader = null;

	public void connect() {

		AsyncTask<Void, String, Void> read = new AsyncTask<Void, String, Void>() {

			@Override
			protected Void doInBackground(Void... params) {
				try {
//					socket = new Socket(ip.getText().toString(), 12345);
					socket = new Socket(ip.getText().toString(), 12345);
					writer = new BufferedWriter(new OutputStreamWriter(
							socket.getOutputStream()));
					reader = new BufferedReader(new InputStreamReader(
							socket.getInputStream()));
					publishProgress("@success");
				} catch (UnknownHostException e1) {
					Toast.makeText(MainActivity.this, "无法建立连接",
							Toast.LENGTH_SHORT).show();

				} catch (IOException e1) {
					Toast.makeText(MainActivity.this, "无法建立连接",
							Toast.LENGTH_SHORT).show();

				}

				try {
					String line;
					while ((line = reader.readLine()) != null) {
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

					Toast.makeText(MainActivity.this, "连接成功",
							Toast.LENGTH_SHORT).show();
				}
				
				text.append("别人说：" + values[0] + "\n");
				super.onProgressUpdate(values);
			}

		};

		read.execute();

	}

	public void send() {
		try {
			text.append("我说：" + editText.getText().toString() + "\n");
			writer.write(editText.getText().toString() + "\n");
			writer.flush();
			editText.setText("");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

}
