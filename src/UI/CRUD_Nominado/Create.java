package UI.CRUD_Nominado;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dto.Circunscripcion;
import Dto.Elector;
import Dto.Nominado;
import Service.CDR_service;
import Service.Circunscripcion_service;
import Service.Elector_service;
import Service.Municipio_service;
import Service.Nominado_service;
import UI.CRUD_Municipio.ReadMunicipio;
import UI.MainView;
import javax.swing.JScrollPane;

public class Create extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table_2;
	private JTable table_1;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create frame = new Create();
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
	public Create() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispose();
		setBounds(100, 100, 629, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 392, 279, 301);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(299, 392, 247, 301);
		contentPane.add(scrollPane_1);
		
		JLabel lblNewLabel = new JLabel("Profesion");
		lblNewLabel.setBounds(10, 101, 139, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ocupacion");
		lblNewLabel_1.setBounds(244, 101, 118, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 126, 159, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 228, 279, 128);
		contentPane.add(textPane);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(299, 228, 247, 128);
		contentPane.add(textPane_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(244, 126, 169, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(10, 172, 89, 20);
		contentPane.add(spinner);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(244, 172, 89, 20);
		contentPane.add(spinner_1);
		
		JButton btnNewButton = new JButton("Insertar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					System.out.println(table_1.getSelectedRow());
					if(!textField.getText().equals("") && !textField_1.getText().equals("") && table_2.getSelectedRow()!=-1){
						if(table_1.getSelectedRow()!=-1 && !textPane.getText().equals("") && !textPane_1.getText().equals("")){
							if(!textField_5.getText().equals("")){
								if(spinner.getComponentCount()>0 && spinner_1.getComponentCount()>0){
									Elector el= Elector_service.ReadOne(Elector_service.ReadAll().get(table_1.getSelectedRow()).getId());
									Nominado_service.Create(el.getNombre(),el.getApellido(),el.getFecha_nacimiento(),el.getDireccion(),findAge(el),textPane.getText(),textField_5.getText(),textField_1.getText(),textField.getText(),textPane_1.getText(),spinner.getComponentCount(),spinner_1.getComponentCount(),Circunscripcion_service.ReadAll().get(table_2.getSelectedRow()).getId());
									System.out.println("pincho");
									ReadNominado frame= new ReadNominado();
									frame.setVisible(true);
									dispose();
								}
							}
						}
					}
				}
				catch (Exception exep){
					System.out.println(exep);
				}

			}
		});
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(457, 171, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadNominado frame = new ReadNominado();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Mario\\IdeaProjects\\Bd\\src\\UI\\Img\\go-back256_24856 (1).png"));
		btnNewButton_1.setBounds(0, 0, 38, 31);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Elija la cicunscripcion a la que pertenece");
		lblNewLabel_4.setBounds(299, 367, 218, 14);
		contentPane.add(lblNewLabel_4);
		
		table_2 = new JTable();
		table_2.setBounds(299, 392, 247, 301);
		table_2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Circunscripcion", "Municipio Asociado"
				}
		));
		loadToTableCircunscripcion(table_2);
		
		JLabel lblNewLabel_6 = new JLabel("Encuentre el Elector");
		lblNewLabel_6.setBounds(10, 367, 169, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("*ATENCION*");
		lblNewLabel_7.setBounds(244, 17, 108, 14);
		contentPane.add(lblNewLabel_7);
		
		JTextPane txtpnElNominadoA = new JTextPane();
		txtpnElNominadoA.setEditable(false);
		txtpnElNominadoA.setText("El Nominado a insertar debe de ser previamente insertado en el sistema como Elector en su respectiva Circunscripcion, en caso de no encontrarlo en la lista de electores, vuelva cuando haya insertado como Elector");
		txtpnElNominadoA.setBounds(137, 42, 365, 50);
		contentPane.add(txtpnElNominadoA);
		
		table_1 = new JTable();
		table_1.setBounds(20, 367, 277, 14);
		table_1.setModel(new DefaultTableModel(
				new Object[][][][][] {
				},
				new String[] {
						"Nombre", "Apellidos","Fecha de Nacimiento","direccion","CDR Asociado"
				}
		));
		loadToTableElector(table_1);
		scrollPane.add(table_1);
		scrollPane_1.add(table_2);
		
		JLabel lblNewLabel_8 = new JLabel("Integracion Revolucionaria");
		lblNewLabel_8.setBounds(10, 203, 159, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Datos Biograficos");
		lblNewLabel_9.setBounds(299, 203, 169, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Vuelta");
		lblNewLabel_10.setBounds(10, 158, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Votos");
		lblNewLabel_11.setBounds(244, 157, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Telefono");
		lblNewLabel_12.setBounds(457, 101, 128, 14);
		contentPane.add(lblNewLabel_12);
		
		textField_5 = new JTextField();
		textField_5.setBounds(457, 126, 139, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		
		
		
	}

	public static void loadToTable(JTable table) {		 
		for(Nominado nominado: Nominado_service.ReadAll()) {
			Object [] row = new Object [] {nominado.getNombre(),nominado.getApellido(),nominado.getFecha_nacimiento(),nominado.getDireccion(),nominado.getEdad(),nominado.getIntegracion_revolucionaria(),nominado.getTelefono(),nominado.getOcupacion(),nominado.getProfesion(),nominado.getDatos_biograficos(),nominado.getVuelta(),nominado.getVotos(), Circunscripcion_service.ReadOne(nominado.getCircunscripcion()).getNombre()};
			((DefaultTableModel)table.getModel()).addRow(row);
		}
}

public static void loadToTableElector(JTable table) {
	for(Elector elector: Elector_service.ReadAll()) {
		Object [] row = new Object [] {elector.getNombre(), elector.getApellido(),elector.getFecha_nacimiento(),elector.getDireccion(),CDR_service.ReadOne(elector.getCdr_id()).getNombre()};
		((DefaultTableModel)table.getModel()).addRow(row);
	}
}

public static void loadToTableCircunscripcion(JTable table) {
	for(Circunscripcion circunscripcion: Circunscripcion_service.ReadAll()) {
		Object [] row = new Object [] {circunscripcion.getNombre(),Municipio_service.ReadOne(circunscripcion.getMunicipio_id()).getNombre()};
		((DefaultTableModel)table.getModel()).addRow(row);
	}
}

public static void refreshTable(JTable table) {
	 table.setModel(new DefaultTableModel(
				new Object[][][] {
				},
				new String[] {
						"CDR", "Nombre del Presidente","Colegio Asociado"
				}
			));
			loadToTable(table);
 }

 public static int findAge(Elector e){
	Date d= new Date();
	 System.out.println(d.getYear());
	 System.out.println(e.getFecha_nacimiento().getYear());
	return d.getYear() - e.getFecha_nacimiento().getYear();
 }
}
