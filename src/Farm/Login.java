package Farm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.ImageIcon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JPasswordField txt2;
	private JButton btnEntrar;
	private JButton btnSalir;
	private JLabel text2;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel lblIniciarSesion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 140, 571, 351);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("Usuario:");
		lblid.setForeground(Color.PINK);
		lblid.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblid.setBounds(76, 98, 86, 22);
		contentPane.add(lblid);
		
		text2 = new JLabel("Contrase\u00F1a: ");
		text2.setForeground(Color.PINK);
		text2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		text2.setBounds(73, 142, 120, 22);
		contentPane.add(text2);
		
		txt1 = new JTextField();
		txt1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt1.setBounds(172, 99, 207, 22);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JPasswordField();
		txt2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt2.setBounds(172, 143, 207, 22);
		contentPane.add(txt2);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String Contraseña_id = "Farmacia";
				
				String Contraseña = "medicina";
				
				String contra_id = "";
				String contra = "";
				
				
				contra_id = txt1.getText();
				contra = txt2.getText();
				
				
				if(Contraseña_id.equals(contra_id))
				{
					if(Contraseña.equals(contra))
					{
						Menu menu = new Menu();
						menu.setVisible(true);
						dispose();
						
				    }
					else
					{
						label_1.setVisible(true);
						JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
						
					
					}
				}
				else
				{
					label.setVisible(true);
					label_1.setVisible(true);
					JOptionPane.showMessageDialog(null, "Error de Usuario o Contraseña. \nPor favor intentelo nuevamente");
					
					
				}
				
			
				
			}
		});
		btnEntrar.setBounds(425, 223, 89, 31);
		contentPane.add(btnEntrar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		btnSalir.setBounds(425, 257, 89, 31);
		contentPane.add(btnSalir);
		
		lblIniciarSesion = new JLabel("INICIAR SESION");
		lblIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblIniciarSesion.setForeground(Color.PINK);
		lblIniciarSesion.setBounds(160, 32, 240, 31);
		contentPane.add(lblIniciarSesion);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Login.class.getResource("/Farm/Image/Contrase\u00F1a.png")));
		label_4.setBounds(278, 188, 126, 119);
		contentPane.add(label_4);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Login.class.getResource("/Farm/Image/Usuario.png")));
		label_3.setBounds(403, 0, 89, 105);
		contentPane.add(label_3);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/Farm/Image/eliminar-eliminar-la-salida-icono-9161-16.png")));
		label.setBounds(383, 104, 21, 16);
		contentPane.add(label);
		label.setVisible(false);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Login.class.getResource("/Farm/Image/eliminar-eliminar-la-salida-icono-9161-16.png")));
		label_1.setBounds(383, 148, 21, 16);
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Login.class.getResource("/Farm/Image/Fondoo.png")));
		label_2.setBounds(0, 0, 555, 312);
		contentPane.add(label_2);
		label_1.setVisible(false);
	}
}
