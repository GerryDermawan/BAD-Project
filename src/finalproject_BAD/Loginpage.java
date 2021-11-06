package finalproject_BAD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Loginpage extends JFrame implements ActionListener{

	JPanel loginlp, emaillp, passwordlp, emailtp, passwordtp, loginbp, signupbp, panelform, panelbutton;
	JLabel loginl, emaill, passwordl;
	JPasswordField passwordt;
	JTextField emailt;
	JButton loginb, signupb;
	
	
	public Loginpage() {
		Font fonta = new Font("sansserif", Font.BOLD, 30);
		Font fontb = new Font("sansserif", Font.BOLD, 15);
		
		loginl = new JLabel();
		loginlp = new JPanel();
		loginlp.setBorder(new EmptyBorder(90,10,30,10));
//		loginlp.setBackground(Color.green);
		loginl.setFont(fonta);
		loginl.setText("LOGIN");
		loginlp.add(loginl);
		
		panelform = new JPanel();
		panelform.setLayout(new GridLayout(2,2));
		
		emaill = new JLabel();
		emaill.setFont(fontb);
		emaill.setText("Email :");
		emaillp = new JPanel();
		emaillp.setLayout(new FlowLayout(FlowLayout.LEFT));
		emaillp.setBorder(new EmptyBorder(30,30,0,0));
		emaillp.add(emaill);
		
		passwordl = new JLabel();
		passwordl.setFont(fontb);
		passwordl.setText("Password :");
		passwordlp = new JPanel();
		passwordlp.setLayout(new FlowLayout(FlowLayout.LEFT));
		passwordlp.setBorder(new EmptyBorder(0,30,30,0));
		passwordlp.add(passwordl);
		
		emailt = new JTextField();
		emailt.setPreferredSize(new Dimension(150,30));
		emailtp = new JPanel();
		emailtp.setPreferredSize(new Dimension(150,30));
		emailtp.setBorder(new EmptyBorder(30,0,0,0));
		emailtp.add(emailt);
		
		passwordt = new JPasswordField();
		passwordt.setEchoChar('*');
		passwordt.setPreferredSize(new Dimension(150,30));
		passwordtp = new JPanel();
		passwordtp.setPreferredSize(new Dimension(150,30));
		passwordtp.setBorder(new EmptyBorder(0,0,30,0));
		passwordtp.add(passwordt);
		
		panelform.add(emaillp);
		panelform.add(emailtp);
		panelform.add(passwordlp);
		panelform.add(passwordtp);
		
		loginb = new JButton();
//		loginb.setFont(fonta);
		loginb.setText("Login");
		loginb.setPreferredSize(new Dimension(150,40));
		loginb.addActionListener(this);
		loginbp = new JPanel();
		loginbp.setPreferredSize(new Dimension(150,40));
//		loginb.setBorder(new EmptyBorder(0,10,0,10));
		loginbp.add(loginb);
		JPanel bungkuslogin = new JPanel();
		bungkuslogin.add(loginbp);
		
		signupb = new JButton();
//		signupb.setFont(fonta);
		signupb.setText("Sign up");
		signupb.setPreferredSize(new Dimension(150,40));
		signupb.addActionListener(this);
		signupbp = new JPanel();
		signupbp.setPreferredSize(new Dimension(150,40));
//		signupbp.setBorder(new EmptyBorder(0,10,0,10));
		signupbp.add(signupb);
		JPanel bungkussignup = new JPanel();
		bungkussignup.add(signupbp);
		
		panelbutton = new JPanel(new GridLayout(1,2));
		panelbutton.setBorder(new EmptyBorder(20,0,20,0));
		panelbutton.add(bungkuslogin);
		panelbutton.add(bungkussignup);
		
		JPanel bungkusb = new JPanel();
		bungkusb.add(panelbutton);
		
		
		
		
		add(loginlp, BorderLayout.NORTH);
		add(panelform, BorderLayout.CENTER);
		add(bungkusb, BorderLayout.SOUTH);
		
		setTitle("Stophee");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(400,500);
//		setLayout(new GridLayout(3,1));
		setResizable(false);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == loginb) {
			if (notnullvalidate()) {
				System.out.println("Validasi email dan password");
				if (emailt.getText().equals("b")) {
					boolean a;
					if (String.valueOf(passwordt.getPassword()).equals("a")) {
						System.out.println(passwordt.getPassword());
						new Mainmenu();
						this.dispose();
					} else {
						JOptionPane.showMessageDialog(this, "You inputted the wrong password", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(this, "Your Email hasn't been registered", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}			
		}
		
	}
	
	private boolean notnullvalidate() {
		// TODO Auto-generated method stub
		boolean val = true;
		if (!emailt.getText().isEmpty()) {
			System.out.println("Ini password " + String.valueOf(passwordt.getPassword()));
			if (!(passwordt.getPassword().length == 0)){
				val = true;
				return val;
			} else {
				System.out.println("Masuk");
				JOptionPane.showMessageDialog(this, "Please input your Password", "Error", JOptionPane.ERROR_MESSAGE);
				val = false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Please input your email", "Error", JOptionPane.ERROR_MESSAGE);
			val = false;
		}
		
		return val;
		
	}

}
