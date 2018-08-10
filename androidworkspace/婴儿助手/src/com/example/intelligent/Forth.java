package com.example.intelligent;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;



public class Forth extends Activity{
	private Button mButton01;
	
	
	
	private SoundPool sp;//声明一个SoundPool  
	private int music;//定义一个整型用load（）；来设置suondID  
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.yinyue);
		
		mButton01= (Button)findViewById(R.id.play_music);
		
		
		 sp= new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);//第一个参数为同时播放数据流的最大个数，第二数据流类型，第三为声音质量   
	        music = sp.load(this, R.raw.letme, 1); //把你的声音素材放到res/raw里，第2个参数即为资源文件，第3个为音乐的优先级   
		 
	        
	        MediaPlayer mp;
	        mp = MediaPlayer.create(this, R.raw.letme);
	        mp.start();
	        
	        
	        //mButton01.setOnClickListener(new View.OnClickListener() {
	         //   @Override
	          //  public void onClick(View v) {
	           
	           // 	sp.play(music, 1, 1, 0, 0, 1);


	         //   }
	     //  });
		
		
	
	}
	
	
	
}

