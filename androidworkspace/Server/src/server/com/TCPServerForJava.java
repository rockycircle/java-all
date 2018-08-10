package server.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServerForJava {

	private static final int SERVERPORT = 12345;
	private static List<Socket>_clientList = new ArrayList<Socket>();
	private static ExecutorService _executorService;
	private static ServerSocket  _serverSocket;
	
	//开启服务器
	public static void main(String[] args)
	{
		try
		{
			//设置服务器端口
			_serverSocket = new ServerSocket(SERVERPORT);
			
			//创建一个线程池
			_executorService = Executors.newCachedThreadPool();
			System.out.println("等待Android客户端程序的连接...");
			//用来临时保存客户端的Socket对象
			Socket client = null;
			
			while(true)
			{
           //接收客户连接并添加到list中
				client = _serverSocket.accept();
				_clientList.add(client);
				
				//开启一个客户端线程
				_executorService.execute(new ThreadServer(client));
			}
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	//每个客户端单独开启一个线程
	static class ThreadServer implements Runnable
	{
		private Socket                _socket;
		private BufferedReader        _bufferedReader;
		private PrintWriter           _printWriter;
		private   String                  _message;
		
		public ThreadServer(Socket socket)  throws IOException
		{
			this._socket   =  socket;
			_bufferedReader = new BufferedReader (new InputStreamReader
					(socket.getInputStream()));
	    //输出连接信息
			_message = "connect with"+this._socket.getInetAddress()+"port"
	    + this._socket.getPort();
			
			sendMessage(_message);
		}
		public void run()
		{
			try
			{
				while((_message = _bufferedReader.readLine())!= null)
				{
					if(_message.trim().equals("exit"))
					{
						//当一个客户端退出时
						_clientList.remove(_socket);
						_bufferedReader.close();
						_printWriter.close();
						_message = "connect with"+ this._socket.getInetAddress()
								+"port"+this._socket.getPort();
						_socket.close();
						sendMessage(_message);
						
						break;
					}
					else
					{
						_message = _socket.getInetAddress() +":"+_message;
						sendMessage(_message);
						
					}	
				}
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		private void sendMessage(String message) throws IOException
		{
			System.out.println(message);
			for (Socket client : _clientList)
			{
				_printWriter = new PrintWriter(client.getOutputStream(), true);
				_printWriter.println(_message);
			}
		}
	
	}
}




















