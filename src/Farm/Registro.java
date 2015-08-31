package Farm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.TextArea;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt7;
	private TextArea txt8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setTitle("Registro de Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(340, 130, 740, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosDeMedicamento = new JLabel("Nuevo Producto");
		lblDatosDeMedicamento.setForeground(new Color(0, 102, 153));
		lblDatosDeMedicamento.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDatosDeMedicamento.setBounds(255, 51, 220, 33);
		contentPane.add(lblDatosDeMedicamento);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setForeground(Color.PINK);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(84, 111, 98, 22);
		contentPane.add(lblNombre);
		
		txt1 = new JTextField();
		txt1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt1.setBounds(172, 111, 191, 22);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JLabel lblSucursal = new JLabel("Sucursal:");
		lblSucursal.setForeground(Color.PINK);
		lblSucursal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSucursal.setBounds(84, 148, 98, 22);
		contentPane.add(lblSucursal);
		
		txt2 = new JTextField();
		txt2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt2.setBounds(172, 148, 191, 22);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		JLabel lblContenido = new JLabel("Concentrado:");
		lblContenido.setForeground(Color.PINK);
		lblContenido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContenido.setBounds(76, 187, 113, 22);
		contentPane.add(lblContenido);
		
		txt3 = new JTextField();
		txt3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt3.setBounds(172, 187, 191, 22);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		JLabel lblViaDeAdministracion = new JLabel("V\u00EDa de Administracion:");
		lblViaDeAdministracion.setForeground(Color.PINK);
		lblViaDeAdministracion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblViaDeAdministracion.setBounds(373, 108, 161, 22);
		contentPane.add(lblViaDeAdministracion);
		
		txt4 = new JTextField();
		txt4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt4.setBounds(544, 108, 124, 22);
		contentPane.add(txt4);
		txt4.setColumns(10);
		
		JLabel lblTipo = new JLabel("Forma:");
		lblTipo.setForeground(Color.PINK);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipo.setBounds(91, 224, 69, 22);
		contentPane.add(lblTipo);
		
		txt5 = new JTextField();
		txt5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt5.setBounds(172, 224, 191, 22);
		contentPane.add(txt5);
		txt5.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Contenido:");
		lblCantidad.setForeground(Color.PINK);
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCantidad.setBounds(84, 261, 98, 22);
		contentPane.add(lblCantidad);
		
		txt6 = new JTextField();
		txt6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt6.setBounds(172, 261, 191, 22);
		contentPane.add(txt6);
		txt6.setColumns(10);
		
		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setForeground(Color.PINK);
		lblCosto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCosto.setBounds(182, 297, 69, 20);
		contentPane.add(lblCosto);
		
		txt7 = new JTextField();
		txt7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt7.setBounds(265, 296, 98, 22);
		contentPane.add(txt7);
		txt7.setColumns(10);
		
		JLabel label = new JLabel("$");
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(255, 296, 9, 22);
		contentPane.add(label);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                String [] A = new String [15];
				
				A[0] = txt1.getText();
				A[1] = txt2.getText();
				A[2] = txt3.getText();
				A[3] = txt4.getText();
				A[4] = txt5.getText();
				A[5] = txt6.getText();
				A[6] = txt7.getText();
				A[7] = txt8.getText();
				
				
				try
				{
			
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			        Connection con=DriverManager.getConnection("jdbc:odbc:Farmacia");
					 Statement stmt=con.createStatement();
					String sql="INSERT INTO Producto (Nombre_Comercial, Sucursal, Contenido, Via_Administracion, Tipo, Cantidad, Costo, Descripcion) values ('" +(A[0]) + "','" + (A[1]) + "','" + (A[2]) + "','"+(A[3]) + "','" + (A[4]) + "','" + (A[5]) + "','" + (A[6]) + "','" + (A[7]) + "');"; 
					stmt.executeUpdate(sql);
					stmt.close();
					con.close();
					
					JOptionPane.showMessageDialog(null, "Guardado con Exito");
					 
				}
				catch(Exception ep)
				{
					JOptionPane.showMessageDialog(null, "Error: Connection "+ep.getMessage());
					
				}
				
				dispose();
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGuardar.setBounds(583, 355, 113, 33);
		contentPane.add(btnGuardar);
		
		JButton Salir = new JButton("Atr\u00E1s");
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
			
		});
		Salir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Salir.setBounds(460, 355, 105, 33);
		contentPane.add(Salir);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(Color.PINK);
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescripcion.setBounds(484, 166, 98, 22);
		contentPane.add(lblDescripcion);
		
		txt8 = new TextArea();
		txt8.setBounds(378, 194, 303, 89);
		contentPane.add(txt8);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Registro.class.getResource("/Farm/Image/Fondooo.png")));
		label_1.setBounds(0, 0, 724, 411);
		contentPane.add(label_1);
	}
}
