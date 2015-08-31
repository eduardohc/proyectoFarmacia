package Farm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Button;
import java.awt.List;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Ventas extends JFrame {

	private JPanel contentPane;
	private List list;
	private JTextField txt;
	private List list1;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JComboBox cb1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas frame = new Ventas();
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
	public Ventas() {
		setTitle("Venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(340, 50, 900, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArticulo = new JLabel("Articulo: ");
		lblArticulo.setForeground(Color.PINK);
		lblArticulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblArticulo.setBounds(300, 83, 73, 20);
		contentPane.add(lblArticulo);
		
		cb1 = new JComboBox();
		cb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String [] articulo = new String [99];
				String [] precio = new String [99];
				String [] tipo = new String [99];
				String [] dosis = new String [99];

				try{
					
					    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				        Connection con=DriverManager.getConnection("jdbc:odbc:Farmacia");
				     
				        java.sql.Statement stmt = con.createStatement();
				        
				        ResultSet rs = stmt.executeQuery("Select * from Consulta_Costo");
				        
				    int i=0;
				        while(rs.next())
				        {
				        	
				           articulo[i] = rs.getString(1); 
				           precio[i] = rs.getString(2);
				           tipo[i] = rs.getString(3);
					       dosis[i] = rs.getString(4); 
				           i++;
				        }
				       
				        
				        int aux = cb1.getSelectedIndex();
				        
				        list.add("" + articulo[(aux - 1)] + "                     " + tipo[(aux - 1)] + "                      " + dosis[(aux - 1)]);
				        list1.add(precio[aux - 1]);
				        
				        stmt.close();
						con.close();
						
						
				}
				
		        catch(Exception ep)
		        {
		           JOptionPane.showMessageDialog(null, "Error: Connection "+ep.getMessage());
		        }
				
				
				String[] A = new String [100];
				float [] B = new float [100];
				float Total = 0;
				int Total_Articulos = 0;
				
				A = list1.getItems();
				
				for(int i=0; i<A.length; i++)
				{
					B[i] = Float.parseFloat(A[i]);
					Total = Total + B[i];
					
				}
				
				Total_Articulos = list1.getItemCount();
				txt.setText("" + Total_Articulos);
				txt1.setText("" + Total);
				
				
			}
		});
		cb1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb1.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar un Articulo"}));
		cb1.setBounds(376, 82, 325, 23);
		contentPane.add(cb1);
		
		Button button = new Button("Articulos                 Tipo                     Dosis");
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(41, 140, 365, 23);
		contentPane.add(button);
		
		list = new List();
		list.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x;
				
				x = list.getSelectedIndex();
				
				list1.select(x);
			}
		});
		list.setBounds(41, 163, 365, 288);
		contentPane.add(list);
		
		list1 = new List();
		list1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				int x;
				
				x = list1.getSelectedIndex();
				
				list.select(x);
			}
		});
		list1.setBounds(406, 162, 110, 289);
		contentPane.add(list1);
		
		Button button_1 = new Button("Precio");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_1.setBounds(406, 141, 110, 22);
		contentPane.add(button_1);
		
		JLabel lblTotalDeArticulos = new JLabel("Total de Articulos: ");
		lblTotalDeArticulos.setForeground(Color.PINK);
		lblTotalDeArticulos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalDeArticulos.setBounds(577, 214, 133, 20);
		contentPane.add(lblTotalDeArticulos);
		
		txt = new JTextField();
		txt.setEditable(false);
		txt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt.setBounds(720, 214, 40, 20);
		contentPane.add(txt);
		txt.setColumns(10);
		
		JLabel lblTotalAPagar = new JLabel("Total a Pagar:");
		lblTotalAPagar.setForeground(Color.PINK);
		lblTotalAPagar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalAPagar.setBounds(577, 245, 120, 20);
		contentPane.add(lblTotalAPagar);
		
		txt1 = new JTextField();
		txt1.setEditable(false);
		txt1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt1.setBounds(720, 245, 133, 20);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JLabel lblEfectivo = new JLabel("Efectivo:");
		lblEfectivo.setForeground(Color.PINK);
		lblEfectivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEfectivo.setBounds(577, 276, 110, 20);
		contentPane.add(lblEfectivo);
		
		txt2 = new JTextField();
		txt2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt2.setBounds(720, 276, 133, 20);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		JLabel lblDevolver = new JLabel("Devolver:");
		lblDevolver.setForeground(Color.PINK);
		lblDevolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDevolver.setBounds(577, 377, 97, 20);
		contentPane.add(lblDevolver);
		
		txt3 = new JTextField();
		txt3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt3.setBounds(720, 377, 133, 20);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				float Total = 0, Efectivo = 0, Devolver = 0;
				
				Total = Float.parseFloat(txt1.getText());
				Efectivo = Float.parseFloat(txt2.getText());
				
				Devolver = Efectivo - Total;
				
				txt3.setText("" + Devolver);
				
			}
		});
		btnPagar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPagar.setBounds(734, 327, 89, 23);
		contentPane.add(btnPagar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try{
					
				    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			        Connection con=DriverManager.getConnection("jdbc:odbc:Farmacia");
			     
			        java.sql.Statement stmt = con.createStatement();
			        
			        ResultSet rs =   stmt.executeQuery("Select * from Consulta_Costo");
			        
			    
			        while(rs.next())
			        {
			            
				        cb1.addItem(rs.getString(1));
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
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(706, 82, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnEliminarDeLa = new JButton("Eliminar de la Lista");
		btnEliminarDeLa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminarDeLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x;
				
				x = list.getSelectedIndex();
				
				list.remove(x);
				list1.remove(x);
				
				String[] A = new String [100];
				int [] B = new int [100];
				int Total = 0, Total_Articulos = 0;
				
				A = list1.getItems();
				
				for(int i=0; i<A.length; i++)
				{
					B[i] = Integer.parseInt(A[i]);
					Total = Total + B[i];
					
				}
				
				Total_Articulos = list1.getItemCount();
				txt.setText("" + Total_Articulos);
				txt1.setText("" + Total);
			}
		});
		btnEliminarDeLa.setBounds(41, 472, 153, 23);
		contentPane.add(btnEliminarDeLa);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(734, 472, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnNuevaCompra = new JButton("Nueva Compra");
		btnNuevaCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x = 1;
				
				cb1.setSelectedIndex(x);
				
				list.removeAll();
				list1.removeAll();
				
				txt.setText("");
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				
			}
		});
		btnNuevaCompra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNuevaCompra.setBounds(376, 472, 140, 23);
		contentPane.add(btnNuevaCompra);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Ventas.class.getResource("/Farm/Image/Dinero.png")));
		label_5.setBounds(706, 109, 140, 104);
		contentPane.add(label_5);
		
		JLabel lblRealizarUnaCompra = new JLabel("Tip: Realizar Una Compra Virtual Ayuda A Saber Cuanto Es Lo Que Posiblemente Puedas Gastar");
		lblRealizarUnaCompra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRealizarUnaCompra.setForeground(Color.PINK);
		lblRealizarUnaCompra.setBounds(150, 0, 824, 35);
		contentPane.add(lblRealizarUnaCompra);
		
		JLabel label = new JLabel("$");
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(710, 248, 10, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("$");
		label_1.setForeground(Color.YELLOW);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(710, 279, 10, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("$");
		label_2.setForeground(Color.YELLOW);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(710, 380, 10, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Ventas.class.getResource("/Farm/Image/Fondoo.png")));
		label_3.setBounds(0, 0, 884, 561);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Ventas.class.getResource("/Farm/Image/Fondooo.png")));
		label_4.setBounds(0, 0, 884, 35);
		contentPane.add(label_4);
	}
}
