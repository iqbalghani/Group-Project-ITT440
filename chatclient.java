import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class chatclient {

	private JFrame frmClient;
private static Socket cs;
private final static JTextArea ta2 = new JTextArea();
private static JTextField tf2;
private static String date;
final static String INET_ADDR = "192.168.56.104";
final static int PORT = 8888;
private JButton bt6;
private JButton bt8;
private JButton bt5;
private JButton bt7;
private JTextArea txtrWelcomeToClient;
	/**
	 * Launch the application.
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chatclient window = new chatclient();
					window.frmClient.setVisible(true);
					window.frmClient.setSize(430,600);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		cs= new Socket("192.168.56.103",12000);
InetAddress address = InetAddress.getByName(INET_ADDR);

        // Create a buffer of bytes, which will be used to store
        // the incoming bytes containing the information from the server.
        // Since the message is small here, 256 bytes should be enough.
        byte[] buf = new byte[256];

        // Create a new Multicast socket (that will allow other sockets/programs
        // to join it as well.
        try (MulticastSocket clientSocket = new MulticastSocket(PORT)){
            //Joint the Multicast group.
            clientSocket.joinGroup(address);

            while (true) {

                // Receive the information and print it.
                DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
                clientSocket.receive(msgPacket);

                String msg = new String(buf, 0, buf.length);
       		String hbd = ta2.getText();

       		ta2.setText(msg+"\n"+ hbd);

            }

        }catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		}
	/**
	 * Create the application.
	 */
	public chatclient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClient = new JFrame();
		frmClient.getContentPane().setBackground(new Color(0, 128, 128));
		frmClient.setTitle("Client");
		frmClient.getContentPane().setLayout(null);
		ta2.setBackground(new Color(255, 255, 255));
		ta2.setBounds(10, 44, 564, 179);
		frmClient.getContentPane().add(ta2);

		tf2 = new JTextField();
		tf2.setBackground(new Color(255, 255, 255));
		tf2.setBounds(10, 299, 346, 151);
		frmClient.getContentPane().add(tf2);
		tf2.setColumns(10);

		JButton b2 = new JButton("Send");
		b2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		b2.setBackground(new Color(255, 255, 0));
		b2.addActionListener(new ActionListener() {
				catch(Exception e1)
				{
				System.out.println(e1.getMessage());
			}
			}
		});
		b2.setBounds(377, 391, 173, 59);
		frmClient.getContentPane().add(b2);

		bt6 = new JButton("Thanks");
		bt6.setBackground(SystemColor.textHighlightText);
		bt6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf2.setText("Thanks");

			}
		});
		bt6.setBounds(377, 299, 89, 33);
		frmClient.getContentPane().add(bt6);

		bt8 = new JButton("Welcome");
		bt8.setBackground(SystemColor.textHighlightText);
		bt8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf2.setText("Welcome");
			}
		});
		bt8.setBounds(377, 343, 89, 37);
		frmClient.getContentPane().add(bt8);

		bt5 = new JButton("Ok");
		bt5.setBackground(SystemColor.textHighlightText);
		bt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf2.setText("Ok");

			}
		});
		bt5.setBounds(476, 343, 74, 37);
		frmClient.getContentPane().add(bt5);

		bt7 = new JButton("Bye");
		bt7.setBackground(SystemColor.textHighlightText);
		bt7.setForeground(new Color(0, 0, 0));
		bt7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf2.setText("Bye");
			}
		});
		bt7.setBounds(476, 299, 74, 33);
		frmClient.getContentPane().add(bt7);

		txtrWelcomeToClient = new JTextArea();
		txtrWelcomeToClient.setText("Welcome to Client");
		txtrWelcomeToClient.setBounds(136, 11, 161, 22);
		frmClient.getContentPane().add(txtrWelcomeToClient);
	}
}
