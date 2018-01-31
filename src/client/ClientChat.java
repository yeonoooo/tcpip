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
			start();//���������� �׽�Ʈ �Ұ��� >> ���� TRY-CATCH ������ ���� Ȯ�� �� �ٽ� �ֱ�
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
		//output stream �ѹ� ����� ���� ��� ���
		
		Receiver receiver = new Receiver();
		receiver.start();//�ڵ����� run()�� �����

		while (true) {
			Sender sender = new Sender();//runnable interface
			Thread t = new Thread(sender);
			System.out.println("Input Client Message...");
			String msg = scanner.nextLine();
			if(msg.equals("q")) {
				scanner.close();//���α׷��� ����Ǵ� ���ÿ� ��ĳ�� ����.
				sender.close();//���α׷� ����� Stream ����.
				break;
				}
			sender.setSendMsg(msg);
			t.start();//run(); �ڵ� ����
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
			if (dout != null) dout.close();
			if (out != null) out.close();
		}

		@Override
		public void run() {
			try {
				if (dout != null) dout.writeUTF(msg);
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
			if (din != null) din.close();//���⼭ ���� �߻� �� in.close ���� X
			if (in != null) in.close();
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
