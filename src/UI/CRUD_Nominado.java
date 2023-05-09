package UI;

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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dto.*;
import Service.*;

import javax.swing.JTextPane;

import com.toedter.calendar.JCalendar;
import javax.swing.JSpinner;
import javax.xml.crypto.Data;

public class CRUD_Nominado extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_2;
	private JTextField textField_2;
	private JTable table_1;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUD_Nominado frame = new CRUD_Nominado();
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
	public CRUD_Nominado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispose();
		setBounds(100, 100, 888, 798);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Profesion");
		lblNewLabel.setBounds(10, 101, 139, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ocupacion");
		lblNewLabel_1.setBounds(244, 101, 118, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(10, 126, 159, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 228, 255, 128);
		contentPane.add(textPane);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(299, 228, 277, 128);
		contentPane.add(textPane_1);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(244, 126, 169, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(694, 228, 89, 20);
		contentPane.add(spinner);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(694, 323, 89, 20);
		contentPane.add(spinner_1);
		
		table = new JTable();
		table.setBounds(10, 392, 255, 301);
		contentPane.add(table);
		table.setModel(new DefaultTableModel(
				new Object[][][] {
				},
				new String[] {
					"CDR", "Nombre del Presidente","Colegio Asociado"
				}
			));
		loadToTable(table);
		
		JLabel lblNewLabel_2 = new JLabel("Nominados en el sistema");
		lblNewLabel_2.setBounds(10, 367, 201, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Insertar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					System.out.println(table_1.getSelectedRow());
					if(!textField.getText().equals("") && !textField_1.getText().equals("") && table_2.getSelectedRow()!=-1){
						Elector el= Elector_service.ReadOne(Elector_service.ReadAll().get(table_1.getSelectedRow()).getId());
						Nominado_service.Create(el.getNombre(),el.getApellido(),el.getFecha_nacimiento(),el.getDireccion(),2,textPane.getText(),textField_5.getText(),textField_1.getText(),textField.getText(),textPane_1.getText(),spinner.getComponentCount(),spinner_1.getComponentCount(),Circunscripcion_service.ReadAll().get(table_2.getSelectedRow()).getId());
						System.out.println("pincho");
						refreshTable(table);
					}
				}
				catch (Exception exep){
					System.out.println(exep);
				}

			}
		});
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(10, 726, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainView frame = new MainView();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Mario\\IdeaProjects\\Bd\\src\\UI\\Img\\go-back256_24856 (1).png"));
		btnNewButton_1.setBounds(0, 0, 38, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modificar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(table.getSelectedRow()+10);
				System.out.println(table_1.getSelectedRow()+1);
				System.out.println(table_2.getSelectedRow()+10);
				if(!textField.getText().equals("") && !textField_1.getText().equals("") && table_2.getSelectedRow()!=-1){
					if(table.getSelectedRow()!=-1){
						Elector el= Elector_service.ReadOne(Elector_service.ReadAll().get(table_1.getSelectedRow()).getId());
						Nominado_service.Update(Nominado_service.ReadAll().get(table.getSelectedRow()).getId(),el.getNombre(),el.getApellido(),el.getFecha_nacimiento(),el.getDireccion(),2,textPane.getText(),textField_5.getText(),textField_1.getText(),textField.getText(),textPane_1.getText(),spinner.getComponentCount(),spinner_1.getComponentCount(),Circunscripcion_service.ReadAll().get(table_2.getSelectedRow()).getId());
						System.out.println("pincho");
						refreshTable(table);
					}
				}
			}
		});
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(400, 726, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Eliminar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1){
					for (int i:table.getSelectedRows()) {
						Nominado_service.Delete(Nominado_service.ReadAll().get(i).getId());
						refreshTable(table);
					}
				}
			}
		});
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setBounds(775, 726, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("Que desea hacer?");
		lblNewLabel_3.setBounds(694, 40, 102, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem()=="Insertar") {
					textField.setEnabled(true);
					textField_1.setEnabled(true);
					btnNewButton.setEnabled(true);
					btnNewButton_2.setEnabled(false);
					btnNewButton_3.setEnabled(false);
				} else if (comboBox.getSelectedItem()=="Modificar") {
					textField.setEnabled(true);
					textField_1.setEnabled(true);
					btnNewButton_2.setEnabled(true);
					btnNewButton.setEnabled(false);
					btnNewButton_3.setEnabled(false);
				} else if (comboBox.getSelectedItem()=="Eliminar") {
					btnNewButton_3.setEnabled(true);
					textField.setEnabled(false);
					textField_1.setEnabled(false);
					btnNewButton_2.setEnabled(false);
					btnNewButton.setEnabled(false);
				}
			}
		});
		comboBox.setBounds(694, 61, 89, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Elija la cicunscripcion a la que pertenece");
		lblNewLabel_4.setBounds(646, 367, 218, 14);
		contentPane.add(lblNewLabel_4);
		
		table_2 = new JTable();
		table_2.setBounds(615, 392, 247, 301);
		contentPane.add(table_2);
		table_2.setModel(new DefaultTableModel(
				new Object[][][] {
				},
				new String[] {
						"Colegio", "Direccion","Circunscripcion Asociada"
				}
		));
		loadToTableCircunscripcion(table_2);
		
		JLabel lblNewLabel_5 = new JLabel("Direccion Particular");
		lblNewLabel_5.setBounds(694, 101, 150, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(694, 126, 150, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Encuentre el Elector");
		lblNewLabel_6.setBounds(357, 367, 169, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("*ATENCION*");
		lblNewLabel_7.setBounds(381, 17, 108, 14);
		contentPane.add(lblNewLabel_7);
		
		JTextPane txtpnElNominadoA = new JTextPane();
		txtpnElNominadoA.setEditable(false);
		txtpnElNominadoA.setText("El Nominado a insertar debe de ser previamente insertado en el sistema como Elector en su respectiva Circunscripcion, en caso de no encontrarlo en la lista de electores, vuelva cuando haya insertado como Elector");
		txtpnElNominadoA.setBounds(244, 40, 365, 50);
		contentPane.add(txtpnElNominadoA);
		
		table_1 = new JTable();
		table_1.setBounds(299, 392, 277, 301);
		contentPane.add(table_1);
		table_1.setModel(new DefaultTableModel(
				new Object[][][] {
				},
				new String[] {
						"Colegio", "Direccion","Circunscripcion Asociada"
				}
		));
		loadToTableElector(table_1);
		
		JLabel lblNewLabel_8 = new JLabel("Integracion Revolucionaria");
		lblNewLabel_8.setBounds(10, 203, 159, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Datos Biograficos");
		lblNewLabel_9.setBounds(299, 203, 169, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Vuelta");
		lblNewLabel_10.setBounds(694, 203, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Votos");
		lblNewLabel_11.setBounds(694, 299, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Telefono");
		lblNewLabel_12.setBounds(494, 101, 128, 14);
		contentPane.add(lblNewLabel_12);
		
		textField_5 = new JTextField();
		textField_5.setBounds(494, 126, 139, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		

		comboBox.addItem("Insertar");
		comboBox.addItem("Modificar");
		comboBox.addItem("Eliminar");
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

}
