package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import Dto.CDR;
import Dto.Circunscripcion;
import Dto.Colegio;
import Dto.Municipio;
import Service.CDR_service;
import Service.Circunscripcion_service;
import Service.Colegio_service;
import Service.Municipio_service;

public class CRUD_Circunscripcion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUD_Circunscripcion frame = new CRUD_Circunscripcion();
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
	public CRUD_Circunscripcion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispose();
		setBounds(100, 100, 734, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de la Circunscripcion");
		lblNewLabel.setBounds(10, 40, 159, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(10, 62, 159, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBounds(10, 118, 315, 301);
		contentPane.add(table);
		table.setModel(new DefaultTableModel(
				new Object[][][] {
				},
				new String[] {
					"CDR", "Nombre del Presidente","Colegio Asociado"
				}
			));
		loadToTable(table);
		
		JLabel lblNewLabel_2 = new JLabel("Circunscripciones en el sistema");
		lblNewLabel_2.setBounds(10, 93, 201, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Insertar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(!textField.getText().equals("")  && table_2.getSelectedRow()!=-1){
						Circunscripcion_service.Create(textField.getText(),Municipio_service.ReadAll().get(table_2.getSelectedRow()).getId());
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
		btnNewButton.setBounds(45, 503, 89, 23);
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
				System.out.println(table_2.getSelectedRow()+10);
				if(!textField.getText().equals("") && table_2.getSelectedRow()!=-1){
					if(table.getSelectedRow()!=-1){
						Circunscripcion_service.Update(textField.getText(),Municipio_service.ReadAll().get(table_2.getSelectedRow()).getId(),Circunscripcion_service.ReadAll().get(table.getSelectedRow()).getId());
						refreshTable(table);
					}
				}
			}
		});
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(324, 503, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Eliminar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1){
					for (int i:table.getSelectedRows()) {
						Circunscripcion_service.Delete(Circunscripcion_service.ReadAll().get(i).getId());
						refreshTable(table);
					}
				}
			}
		});
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setBounds(591, 503, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("Que desea hacer?");
		lblNewLabel_3.setBounds(553, 40, 102, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem()=="Insertar") {
					textField.setEnabled(true);
					btnNewButton.setEnabled(true);
					btnNewButton_2.setEnabled(false);
					btnNewButton_3.setEnabled(false);
				} else if (comboBox.getSelectedItem()=="Modificar") {
					textField.setEnabled(true);
					btnNewButton_2.setEnabled(true);
					btnNewButton.setEnabled(false);
					btnNewButton_3.setEnabled(false);
				} else if (comboBox.getSelectedItem()=="Eliminar") {
					btnNewButton_3.setEnabled(true);
					textField.setEnabled(false);
					btnNewButton_2.setEnabled(false);
					btnNewButton.setEnabled(false);
				}
			}
		});
		comboBox.setBounds(553, 61, 89, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Elija el municipio al que pertenece");
		lblNewLabel_4.setBounds(462, 93, 218, 14);
		contentPane.add(lblNewLabel_4);
		
		table_2 = new JTable();
		table_2.setBounds(433, 118, 275, 301);
		contentPane.add(table_2);
		table_2.setModel(new DefaultTableModel(
				new Object[][][] {
				},
				new String[] {
						"Colegio", "Direccion","Circunscripcion Asociada"
				}
		));
		loadToTableMunicipio(table_2);
		comboBox.addItem("Insertar");
		comboBox.addItem("Modificar");
		comboBox.addItem("Eliminar");
	}
	
	public static void loadToTable(JTable table) {		 
			for(Circunscripcion circunscripcion: Circunscripcion_service.ReadAll()) {
				Object [] row = new Object [] {circunscripcion.getNombre(),Municipio_service.ReadOne(circunscripcion.getMunicipio_id()).getNombre()};
				((DefaultTableModel)table.getModel()).addRow(row);
			}
	}

	public static void loadToTableMunicipio(JTable table) {
		for(Municipio municipio: Municipio_service.ReadAll()) {
			Object [] row = new Object [] {municipio.getNombre()};
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
