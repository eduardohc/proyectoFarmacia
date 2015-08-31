package Farm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Button;
import java.awt.Font;
import java.awt.List;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Notificaciones extends JFrame {

	private JPanel contentPane;
	private List list;
	private List list1;
	
	public static int entrar = 0;
	private Button button_1;
	
	public static String nombre_boton = "Fecha Agendada";
	private List list2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notificaciones frame = new Notificaciones();
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
	public Notificaciones() {
		setTitle("Proximas Citas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 160, 724, 390);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 255));
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button button = new Button("Nombre");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(54, 49, 344, 22);
		contentPane.add(button);
		
		button_1 = new Button(nombre_boton);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_1.setBounds(398, 49, 134, 22);
		contentPane.add(button_1);
		
		list = new List();
		list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x = 0;
				
	               
				x = list.getSelectedIndex();
                
				
				list1.select(x);
				list2.select(x);
				
			}
		});
		list.setBounds(54, 71, 344, 172);
		contentPane.add(list);
		
		list1 = new List();
		list1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 0;
				
	               
				x = list1.getSelectedIndex();
                
				
				list.select(x);
				list2.select(x);
				
			}
		});
		list1.setBounds(398, 71, 134, 172);
		contentPane.add(list1);
		
		JButton btnVerFechas = new JButton("Ver Citas");
		btnVerFechas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				list.removeAll();
				list1.removeAll();
				list2.removeAll();
				
				try{
					
				    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			        Connection con=DriverManager.getConnection("jdbc:odbc:Farmacia");
			     
			        Statement stmt=con.createStatement();
			        ResultSet rs = stmt.executeQuery("Select * from Notificaciones");
			        
			    
			        
			        int i=0;
			        while(rs.next())
			        {
			        	
			        	list.add(rs.getString(2));
						list1.add(rs.getString(3));
						list2.add(rs.getString(4));
						
						
			        	i++;
			        }

			        stmt.close();
					con.close();

                }
			       
			        catch(Exception ep)
			        {
			           JOptionPane.showMessageDialog(null, "Error: Connection "+ep.getMessage());
			        }		
				
				
			}
		});
		
		list2 = new List();
		list2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x = 0;
				
	               
				x = list2.getSelectedIndex();
                
				
				list.select(x);
				list1.select(x);
			}
		});
		list2.setBounds(532, 71, 82, 172);
		contentPane.add(list2);
		
		Button button_2 = new Button("Hora");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_2.setBounds(532, 49, 82, 22);
		contentPane.add(button_2);
		btnVerFechas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVerFechas.setBounds(54, 249, 99, 23);
		contentPane.add(btnVerFechas);
		
		JButton btnIngresarUnaFecha = new JButton("Agregar Cita");
		btnIngresarUnaFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Fecha fecha =new Fecha();
				fecha.setVisible(true);
				
				
			}
		});
		btnIngresarUnaFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnIngresarUnaFecha.setBounds(163, 249, 145, 23);
		contentPane.add(btnIngresarUnaFecha);
		
		JButton btnEliminarFecha = new JButton("Borrar Cita");
		btnEliminarFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 0;
				
	               
				x = list1.getSelectedIndex();
               
                String Nombre;
                
				
				
				Nombre = list.getSelectedItem();
				
				
				
				int op = JOptionPane.showConfirmDialog(null, "Seguro que desea Eliminar a " + Nombre);
				if(op == JOptionPane.YES_OPTION)
				{
	    		try
				{
					
	    			x = list1.getSelectedIndex();
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			        Connection con=DriverManager.getConnection("jdbc:odbc:Farmacia");
			        Statement stmt=con.createStatement();
			        String sql="DELETE FROM Notificaciones where Nombre ='"+Nombre+"'";
					stmt.executeUpdate(sql);
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Eliminado");
					stmt.close();
					con.close();
				}
				catch(Exception ep)
				{
					JOptionPane.showMessageDialog(null, "Error: Connection "+ep.getMessage());
				}
				}
			}
		});
		btnEliminarFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminarFecha.setBounds(325, 299, 108, 23);
		contentPane.add(btnEliminarFecha);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			
	
			
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		
		});
		btnAtrs.setBounds(443, 300, 89, 23);
		contentPane.add(btnAtrs);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Notificaciones.class.getResource("/Farm/Image/Fondoo.png")));
		lblNewLabel.setBounds(0, 0, 708, 351);
		contentPane.add(lblNewLabel);
	}
}
