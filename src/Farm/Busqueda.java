package Farm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.List;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Busqueda extends JFrame {

	private JPanel contentPane;
	private List list;
	private List list1;
	private Button button_2;
	private List list2;
	private Button button_3;
	private List list3;
	private Button button_4;
	private List list4;
	private Button button_5;
	private List list5;
	private Button button_6;
	private List list6;
	private Button button_7;
	private List list7;
	private JButton btnSalir;
	private JButton btnLimpiarTexto;
	private JButton btnEliminar;
	private JLabel label_1;
	private JLabel lblAlmacnDeProductos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
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
	public Busqueda() {
		setTitle("Busqueda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 130, 950, 400);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 255));
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				list.removeAll();
				list1.removeAll();
				list2.removeAll();
				list3.removeAll();
				list4.removeAll();
				list5.removeAll();
				list6.removeAll();
				list7.removeAll();
				
				
				
				try{
					
				    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			        Connection con=DriverManager.getConnection("jdbc:odbc:Farmacia");
			     
			        Statement stmt=con.createStatement();
			        ResultSet rs = stmt.executeQuery("Select * from Producto");
			        
			    
			        
			        int i=0;
			        while(rs.next())
			        {
			        	
			        	list.add(rs.getString(2));
						list1.add(rs.getString(3));
						list2.add(rs.getString(4));
						list3.add(rs.getString(5));
						list4.add(rs.getString(6));
						list5.add(rs.getString(7));
						list6.add("$" + rs.getString(8));
						list7.add(rs.getString(9));
						
						
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
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.setBounds(28, 300, 99, 23);
		contentPane.add(btnBuscar);
		
		list = new List();
		list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 0;
				
	               
				x = list.getSelectedIndex();
                
				
				list1.select(x);
				list2.select(x);
				list3.select(x);
				list4.select(x);
				list5.select(x);
				list6.select(x);
				list7.select(x);
				
			}
		});
		list.setBounds(28, 62, 110, 211);
		contentPane.add(list);
		
		Button button = new Button("Producto");
		button.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		button.setBounds(28, 40, 110, 22);
		contentPane.add(button);
		
		Button button_1 = new Button("Sucursal");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_1.setBounds(138, 40, 87, 22);
		contentPane.add(button_1);
		
		list1 = new List();
		list1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x = 0;
				
	               
				x = list1.getSelectedIndex();
                
				
				list.select(x);
				list2.select(x);
				list3.select(x);
				list4.select(x);
				list5.select(x);
				list6.select(x);
				list7.select(x);
			}
		});
		list1.setBounds(138, 62, 87, 211);
		contentPane.add(list1);
		
		button_2 = new Button("Concentrado");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_2.setBounds(224, 40, 99, 22);
		contentPane.add(button_2);
		
		list2 = new List();
		list2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x = 0;
				
	               
				x = list2.getSelectedIndex();
                
				
				list1.select(x);
				list.select(x);
				list3.select(x);
				list4.select(x);
				list5.select(x);
				list6.select(x);
				list7.select(x);
			}
		});
		list2.setBounds(224, 62, 99, 211);
		contentPane.add(list2);
		
		button_3 = new Button("Via de Administracion");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_3.setBounds(323, 40, 159, 22);
		contentPane.add(button_3);
		
		list3 = new List();
		list3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x = 0;
				
	               
				x = list3.getSelectedIndex();
                
				
				list1.select(x);
				list2.select(x);
				list.select(x);
				list4.select(x);
				list5.select(x);
				list6.select(x);
				list7.select(x);
			}
		});
		list3.setBounds(323, 62, 159, 211);
		contentPane.add(list3);
		
		button_4 = new Button("Forma");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_4.setBounds(482, 40, 70, 22);
		contentPane.add(button_4);
		
		list4 = new List();
		list4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x = 0;
				
	               
				x = list4.getSelectedIndex();
                
				
				list1.select(x);
				list2.select(x);
				list3.select(x);
				list.select(x);
				list5.select(x);
				list6.select(x);
				list7.select(x);
			}
		});
		list4.setBounds(482, 62, 70, 211);
		contentPane.add(list4);
		
		button_5 = new Button("Contenido");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_5.setBounds(552, 40, 87, 22);
		contentPane.add(button_5);
		
		list5 = new List();
		list5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x = 0;
				
	               
				x = list5.getSelectedIndex();
                
				
				list1.select(x);
				list2.select(x);
				list3.select(x);
				list4.select(x);
				list.select(x);
				list6.select(x);
				list7.select(x);
			}
		});
		list5.setBounds(552, 62, 87, 211);
		contentPane.add(list5);
		
		button_6 = new Button("Costo");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_6.setBounds(639, 40, 70, 22);
		contentPane.add(button_6);
		
		list6 = new List();
		list6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x = 0;
				
	               
				x = list6.getSelectedIndex();
                
				
				list1.select(x);
				list2.select(x);
				list3.select(x);
				list4.select(x);
				list5.select(x);
				list.select(x);
				list7.select(x);
			}
		});
		list6.setBounds(639, 62, 70, 211);
		contentPane.add(list6);
		
		button_7 = new Button("Descripcion");
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_7.setBounds(710, 40, 197, 22);
		contentPane.add(button_7);
		
		list7 = new List();
		list7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x = 0;
				
	               
				x = list7.getSelectedIndex();
                
				
				list1.select(x);
				list2.select(x);
				list3.select(x);
				list4.select(x);
				list5.select(x);
				list6.select(x);
				list.select(x);
			}
		});
		list7.setBounds(710, 62, 197, 211);
		contentPane.add(list7);
		
		btnSalir = new JButton("Atr\u00E1s");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalir.setBounds(808, 309, 99, 23);
		contentPane.add(btnSalir);
		
		btnLimpiarTexto = new JButton("Limpiar Todo");
		btnLimpiarTexto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				list.removeAll();
				list1.removeAll();
				list2.removeAll();
				list3.removeAll();
				list4.removeAll();
				list5.removeAll();
				list6.removeAll();
				list7.removeAll();
				
			}
		});
		btnLimpiarTexto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLimpiarTexto.setBounds(257, 300, 133, 23);
		contentPane.add(btnLimpiarTexto);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
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
			        String sql="DELETE FROM Producto where Nombre_Comercial='"+Nombre+"'";
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
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEliminar.setBounds(137, 300, 89, 25);
		contentPane.add(btnEliminar);
		
		lblAlmacnDeProductos = new JLabel("ALMAC\u00C9N DE PRODUCTOS");
		lblAlmacnDeProductos.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAlmacnDeProductos.setForeground(Color.PINK);
		lblAlmacnDeProductos.setBounds(323, 6, 308, 32);
		contentPane.add(lblAlmacnDeProductos);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Busqueda.class.getResource("/Farm/Image/Fondooo.png")));
		label.setBounds(0, 0, 894, 361);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Busqueda.class.getResource("/Farm/Image/Fondoo.png")));
		label_1.setBounds(893, -74, 41, 435);
		contentPane.add(label_1);
	}
}
