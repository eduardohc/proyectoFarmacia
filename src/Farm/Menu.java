package Farm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/Farm/Image/Home.png")));
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(340, 130, 892, 487);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setForeground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistrar = new JButton("Nuevo Producto");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registro reg = new Registro();
				reg.setVisible(true);
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegistrar.setBounds(129, 360, 152, 29);
		contentPane.add(btnRegistrar);
		
		JButton btnBuscar = new JButton("Ver Productos");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Busqueda bus = new Busqueda();
				bus.setVisible(true);
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.setBounds(346, 360, 152, 29);
		contentPane.add(btnBuscar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSalir.setBounds(767, 402, 99, 24);
		contentPane.add(btnSalir);
		
		
		
		JButton btnProximasFechas = new JButton("Proximas Citas");
		btnProximasFechas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Notificaciones not = new Notificaciones();
				not.setVisible(true);
			
			}
			
		});
		btnProximasFechas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnProximasFechas.setBounds(571, 360, 145, 28);
		contentPane.add(btnProximasFechas);
		
		JButton btnVenta = new JButton("Compra");
		btnVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Ventas ventas = new Ventas();
				ventas.setVisible(true);
				
			}
		});
		btnVenta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVenta.setBounds(692, 154, 152, 29);
		contentPane.add(btnVenta);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Menu.class.getResource("/Farm/Image/Compra.png")));
		label_1.setBounds(692, 11, 153, 144);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Menu.class.getResource("/Farm/Image/Busca.png")));
		label_2.setBounds(367, 215, 119, 144);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Menu.class.getResource("/Farm/Image/Citas.png")));
		label_3.setBounds(590, 215, 109, 137);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Menu.class.getResource("/Farm/Image/Medicamento.png")));
		label_4.setBounds(75, 237, 206, 122);
		contentPane.add(label_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/Farm/Image/Bienvenido.png")));
		lblNewLabel_1.setBounds(260, 0, 344, 183);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Men\u00FA Principal");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setBounds(309, 166, 224, 34);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Menu.class.getResource("/Farm/Image/Fondoo.png")));
		label.setBounds(0, 0, 876, 448);
		contentPane.add(label);
		
	}
}
