package com.example.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
 
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
 
 
public class MainActivity extends Activity {
 
    EditText show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (EditText)findViewById(R.id.show);
        new Thread()
        {
            @Override
            public void run()
            {
                try {
                    //�������ӵ�Զ�̷�������Socket
                    Socket socket = new Socket("192.168.1.110",9527);
                    //��Socket��Ӧ����������װ��BufferedReader
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    //������ͨ��I/O����
                    String line = br.readLine();
                    show.setText("���Է����������ݣ�"+line);
                    br.close();
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
 
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}