package employee.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login  extends JFrame implements ActionListener{
	JTextField tfusername,tfpassword;
	
		Login(){
			 getContentPane().setBackground(Color.WHITE);
			 setLayout(null);
			
			JLabel lbusername = new JLabel("USER NAME");
			lbusername.setBounds(40, 20, 100, 30);
			add(lbusername);
			
			tfusername = new JTextField();
			tfusername.setBounds(150,20,100,30);
			add(tfusername);
			
			JLabel lbpassword = new JLabel("PASSWORD");
			lbpassword.setBounds(40, 70, 100, 30);
			add(lbpassword);
			
			tfpassword = new JTextField();
			tfpassword.setBounds(150,70,100,30);
			add(tfpassword);
			
			JButton Login = new JButton("LOG IN");
			Login.setBounds(150,140, 100, 30);
			Login.setBackground(Color.BLACK);
			Login.setForeground(Color.WHITE);
			Login.addActionListener(this);
			add(Login);
			
			ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
			Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
			ImageIcon i3 = new ImageIcon(i2);
			JLabel image = new JLabel(i3);
			image.setBounds(350, 0, 200, 200);
			add(image);
			
			setSize(600, 300);
			setLocation(450, 200);
			setVisible(true);
			
		}
		
	
		public void actionPerformed(ActionEvent ae) {
			
			try {
				
				String username = tfusername.getText();
				String password = tfpassword.getText();
				Conn c= new Conn();
				String query= "select * from login where username ='"+username+"'and password ='"+password+"'";
				String s2="Insert into login values ('aman','456123')";
				c.s.executeUpdate(s2);
				ResultSet rs= c.s.executeQuery(query);
				System.out.println(rs);
				
				
				
				if(rs.next()) {
					
					setVisible(false);
					new Home();
				}else {
					JOptionPane.showMessageDialog(null,"Invalid username or password");
					setVisible(false);
				}
				
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			
		}
		
	public static void main(String[] args) {
		new Login();
	}
}
