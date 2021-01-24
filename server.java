import java.io.DataInputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Server_prog extends Thread {

	Socket s1;

	JTextArea textArea;
	int myid;
	public Server_prog(Socket S, JTextArea t,int id){
		s1=S;
		textArea = t;
		myid=id;
	}

	public void run(){
		try{
			DataInputStream din=new DataInputStream(s1.getInputStream());
			while(true){
				String p=	din.readUTF();
				String q=  textArea.getText();

				JFrame frame = new JFrame();
			    String code = JOptionPane.showInputDialog(
			        frame,
			        "Whats your name?(label)",
			        "Client name (title)",
			        JOptionPane.WARNING_MESSAGE
			    );

				textArea.setText(q+"\n"+myid+"-"+code+"\n"+p+"----"+scc);

			}
		}catch(Exception e){
		}

	}
}
