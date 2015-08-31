package Farm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Fecha extends JFrame {

	private JPanel contentPane;
	private JComboBox cb1;
	private JComboBox cb2;
	private JComboBox cb3;
	private JTextField txt1;
	private JLabel lbl1;
	private JLabel lblNombreDelPaciente;
	private JTextField txt;
	private JLabel lbl2;
	private JTextField txt2;
	private JButton btnGuardar;
	private JLabel lbl3;
	private JButton btnSalir;
	private JTextField txt3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fecha frame = new Fecha();
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
	public Fecha() {
		setTitle("Agendar una Fecha");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 60, 560, 470);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDia = new JLabel("Dia:");
		lblDia.setForeground(Color.PINK);
		lblDia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDia.setBounds(62, 148, 37, 24);
		contentPane.add(lblDia);
		
		cb1 = new JComboBox();
		cb1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cb1.setBounds(101, 150, 46, 20);
		contentPane.add(cb1);
		
		JLabel lblMes = new JLabel("Mes:");
		lblMes.setForeground(Color.PINK);
		lblMes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMes.setBounds(170, 148, 46, 24);
		contentPane.add(lblMes);
		
		cb2 = new JComboBox();
		cb2.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		cb2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb2.setBounds(211, 150, 116, 20);
		contentPane.add(cb2);
		
		JLabel lblAo = new JLabel("A\u00F1o:");
		lblAo.setForeground(Color.PINK);
		lblAo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAo.setBounds(349, 148, 46, 24);
		contentPane.add(lblAo);
		
		cb3 = new JComboBox();
		cb3.setModel(new DefaultComboBoxModel(new String[] {"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"}));
		cb3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb3.setBounds(390, 150, 66, 20);
		contentPane.add(cb3);
		
		JButton btnAgendarFecha = new JButton("Agendar Fecha");
		btnAgendarFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String nombre = "", dia ="", año = "";
				int MES;
				
				nombre = txt.getText();
				
				dia = (String) cb1.getSelectedItem();
				MES = 1 + cb2.getSelectedIndex();
				año = (String) cb3.getSelectedItem();
				
				lbl1.setVisible(true);
				lbl2.setVisible(true);
				lbl3.setVisible(true);
				txt1.setVisible(true);
				txt2.setVisible(true);
				btnGuardar.setVisible(true);
				
				
				txt1.setText(dia + "/" + MES + "/" + año);
				txt2.setText(nombre);
				
				
			}
		});
		btnAgendarFecha.setBounds(211, 187, 127, 23);
		contentPane.add(btnAgendarFecha);
		
		lbl3 = new JLabel("Fecha Agendada:");
		lbl3.setForeground(Color.PINK);
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl3.setBounds(101, 311, 136, 24);
		contentPane.add(lbl3);
		lbl3.setVisible(false);
		
		txt1 = new JTextField();
		txt1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt1.setBounds(240, 311, 127, 24);
		contentPane.add(txt1);
		txt1.setColumns(10);
		txt1.setVisible(false);
		
		lbl1 = new JLabel("Confirmaci\u00F3n de Datos");
		lbl1.setForeground(new Color(255, 255, 153));
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl1.setBounds(170, 241, 274, 24);
		contentPane.add(lbl1);
		lbl1.setVisible(false);
		
		lblNombreDelPaciente = new JLabel("Nombre de la Persona o Evento");
		lblNombreDelPaciente.setForeground(Color.PINK);
		lblNombreDelPaciente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreDelPaciente.setBounds(50, 113, 227, 24);
		contentPane.add(lblNombreDelPaciente);
		
		txt = new JTextField();
		txt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt.setBounds(287, 113, 227, 24);
		contentPane.add(txt);
		txt.setColumns(10);
		
		lbl2 = new JLabel("Nombre: ");
		lbl2.setForeground(Color.PINK);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl2.setBounds(163, 276, 74, 24);
		contentPane.add(lbl2);
		lbl2.setVisible(false);
		
		txt2 = new JTextField();
		txt2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt2.setBounds(240, 276, 216, 24);
		contentPane.add(txt2);
		txt2.setColumns(10);
		txt2.setVisible(false);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String [] A = new String [4];
					
					A[0] = txt2.getText();
					A[1] = txt1.getText();
					A[2] = txt3.getText();
					
					
					
					try
					{
				
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				        Connection con=DriverManager.getConnection("jdbc:odbc:Farmacia");
						 Statement stmt=con.createStatement();
						String sql="INSERT INTO Notificaciones (Nombre, Fecha, Hora) values ('" + (A[0]) + "','" + (A[1]) + "','" + (A[2]) + "');"; 
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
		btnGuardar.setBounds(224, 385, 116, 35);
		contentPane.add(btnGuardar);
		
		btnSalir = new JButton("Atr\u00E1s");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnSalir.setBounds(365, 385, 107, 35);
		contentPane.add(btnSalir);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setForeground(Color.PINK);
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHora.setBounds(182, 350, 46, 14);
		contentPane.add(lblHora);
		
		txt3 = new JTextField();
		txt3.setBounds(240, 345, 86, 23);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		JLabel lblNuevaCita = new JLabel("NUEVA CITA");
		lblNuevaCita.setForeground(Color.PINK);
		lblNuevaCita.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNuevaCita.setBounds(190, 34, 177, 42);
		contentPane.add(lblNuevaCita);
		btnGuardar.setVisible(false);
	}
}
