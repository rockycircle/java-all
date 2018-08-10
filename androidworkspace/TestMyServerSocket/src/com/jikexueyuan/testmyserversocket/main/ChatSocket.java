package com.jikexueyuan.testmyserversocket.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatSocket extends Thread {
	 
	     Socket socket;
             public ChatSocket(Socket s){
            	 
            	 this.socket=s;
        
             }
             public void out(String out){
            	 try {
					socket.getOutputStream().write(out.getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
             }
             
            @Override
             public void run() {

            	try {
					BufferedReader br = new BufferedReader(
							new InputStreamReader(
									socket.getInputStream(),"UTF-8"));
				
            	    String line = null;
					while((line = br.readLine())!=null){
  	               ChatManager.getChatManager().publish(this, line);
                 System.out.println("msg:" + line);
            	
            	}
					br.close();
            	 } catch (UnsupportedEncodingException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
            }

}
