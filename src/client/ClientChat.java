package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {

	String ip;
	int port;
	Socket socket;
	Scanner scanner;

	public ClientChat() {
	}

	public ClientChat(String ip, int port) {
		this.ip = ip;
		this.port = port;
		try {
			socket = new Socket(ip, port);
			System.out.println("Connect to the Server... Success!");
			start();//여기있으면 테스트 불가능 >> 따라서 TRY-CATCH 밖으로 빼서 확인 후 다시 넣기
		} catch (IOException e) {
			System.out.println("Connect to the Server... Fail T.T");
			e.printStackTrace();
		} finally {
			try {
				if(socket!=null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void start() throws IOException {
		scanner = new Scanner(System.in);
		//output stream 한번 만들어 놓고 계속 사용
		
		Receiver receiver = new Receiver();
		receiver.start();//자동으로 run()이 실행됨
		
		Sender sender = new Sender();//runnable interface 구현 방법
		Thread t = new Thread(sender);
		System.out.println("별명을 입력하세요.");
		String nickname = scanner.nextLine();
		
		while (true) {
			
			System.out.println("Input Client Message...");
			String msg = scanner.nextLine();
			if(msg.equals("q")) {
				scanner.close();//프로그램이 종료되는 동시에 스캐너 닫음.
				sender.close();//프로그램 종료시 Stream 닫음.
				break;
				}
			sender.setSendMsg(msg);
			t.start();//run(); 자동 실행
		}
		System.out.println("Exit Chatting...");
	}
	
	class Sender implements Runnable {
		OutputStream out;
		DataOutputStream dout;
		String msg;

		public Sender() throws IOException {
			out = socket.getOutputStream();
			dout = new DataOutputStream(out);
		}

		public void setSendMsg(String msg) {
			this.msg = msg;
		}

		public void close() throws IOException {
			if (dout != null)
				dout.close();
			if (out != null)
				out.close();
		}

		@Override
		public void run() {
			try {
				if (dout != null)
					dout.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class Receiver extends Thread {
		InputStream in;
		DataInputStream din;
		String msg;

		public Receiver() throws IOException {
			in = socket.getInputStream();
			din = new DataInputStream(in);
		}

		public void close() throws IOException {
			if (din != null)
				din.close();//여기서 예외 발생 시 in.close 실행 X
			if (in != null)
				in.close();
		}

		@Override
		public void run() {
			while (true) {
				try {
					msg = din.readUTF();
					System.out.println("Server: " +msg);
					if (msg.equals("end")) {
						break;
					}
				} catch (IOException e) {
					System.out.println("Exit Client User");
					break;
				}
			}
		}
	}

}
