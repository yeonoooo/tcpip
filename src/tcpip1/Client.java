package tcpip1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String args[]) {
		System.out.println("Jeongmin modified this project.");
		String ip = "70.12.111.130";
		int port = 7777;
		Socket socket = null;
		OutputStream outs = null;
		OutputStreamWriter outw = null;

		try {
			System.out.println("Start Client");
			socket = new Socket(ip, port);
			System.out.println("Connected OK");

			// Send Data
			outs = socket.getOutputStream();
			outw = new OutputStreamWriter(outs);
			outw.write("JeongminPark");
			// outw.write("ChahyeonLee");
			// outw.write("KyeonghoKim");
			System.out.println("Send Completed");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (outw != null)
					outw.close();
				if (outs != null)
					outs.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
