package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

import Dto.CDR;
import Dto.Colegio;
import Dto.Elector;
import Service.CDR_service;
import Service.Circunscripcion_service;
import Service.Colegio_service;
import Service.Elector_service;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;

public class CRUD_Elector extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUD_Elector frame = new CRUD_Elector();
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
	public CRUD_Elector() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispose();
		setBounds(100, 100, 734, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre del Elector");
		lblNewLabel.setBounds(10, 40, 124, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos");
		lblNewLabel_1.setBounds(244, 40, 152, 14);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(10, 62, 159, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(244, 62, 169, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		table = new JTable();
		table.setBounds(10, 310, 315, 339);
		contentPane.add(table);
		table.setModel(new DefaultTableModel(
				new Object[][][] {
				},
				new String[] {
					"CDR", "Nombre del Presidente","Colegio Asociado"
				}
			));
		loadToTable(table);
		
		JLabel lblNewLabel_2 = new JLabel("Electores en el sistema");
		lblNewLabel_2.setBounds(10, 282, 201, 14);
		contentPane.add(lblNewLabel_2);

		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 118, 184, 153);

		Date limitMax= new Date();
		limitMax.setYear(105);
		calendar.setMaxSelectableDate(limitMax);
		calendar.setDate(limitMax);

		Date limitMin= new Date();
		limitMin.setYear(30);
		calendar.setMinSelectableDate(limitMin);

		System.out.println(calendar.getMaxSelectableDate().toString());

		contentPane.add(calendar);
		
		JButton btnNewButton = new JButton("Insertar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(!textField.getText().equals("") && !textField_1.getText().equals("") && table_2.getSelectedRow()!=-1){
						Elector_service.Create(textField.getText(),textField_1.getText(), changeDate(calendar.getDate()) ,textField_3.getText(),CDR_service.ReadAll().get(table_2.getSelectedRow()).getId());
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
		btnNewButton.setBounds(10, 687, 89, 23);
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
				if(!textField.getText().equals("") && !textField_1.getText().equals("") && table_2.getSelectedRow()!=-1){
					if(table.getSelectedRow()!=-1){
						Elector_service.Update(Elector_service.ReadAll().get(table.getSelectedRow()).getId(),textField.getText(),textField_1.getText(),changeDate(calendar.getDate()),textField_3.getText(),CDR_service.ReadAll().get(table_2.getSelectedRow()).getId());
						refreshTable(table);
					}
				}
			}
		});
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(320, 687, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Eliminar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1){
					for (int i:table.getSelectedRows()) {
						Elector_service.Delete(Elector_service.ReadAll().get(i).getId());
						refreshTable(table);
					}
				}
			}
		});
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setBounds(619, 687, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("Que desea hacer?");
		lblNewLabel_3.setBounds(553, 40, 102, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem()=="Insertar") {
					textField.setEnabled(true);
					textField_1.setEnabled(true);
					textField_3.setEnabled(true);
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
					textField_3.setEnabled(false);
					btnNewButton_2.setEnabled(false);
					btnNewButton.setEnabled(false);
				}
			}
		});
		comboBox.setBounds(553, 61, 89, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Elija el CDR al que pertenece");
		lblNewLabel_4.setBounds(433, 282, 218, 14);
		contentPane.add(lblNewLabel_4);
		
		table_2 = new JTable();
		table_2.setBounds(433, 310, 275, 339);
		contentPane.add(table_2);
		table_2.setModel(new DefaultTableModel(
				new Object[][][] {
				},
				new String[] {
						"Colegio", "Direccion","Circunscripcion Asociada"
				}
		));
		loadToTableCDR(table_2);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de nacimiento");
		lblNewLabel_5.setBounds(10, 93, 124, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Direccion particular");
		lblNewLabel_6.setBounds(254, 93, 124, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(244, 118, 169, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		comboBox.addItem("Insertar");
		comboBox.addItem("Modificar");
		comboBox.addItem("Eliminar");
		
	}
	
	public static void loadToTable(JTable table) {		 
			for(Elector elector: Elector_service.ReadAll()) {
				Object [] row = new Object [] {elector.getNombre(), elector.getApellido(),elector.getDireccion(),CDR_service.ReadOne(elector.getCdr_id()).getNombre()};
				((DefaultTableModel)table.getModel()).addRow(row);
			}
	}

	public static void loadToTableCDR(JTable table) {
		for(CDR cdr: CDR_service.ReadAll()) {
			Object [] row = new Object [] {cdr.getNombre(), cdr.getNombre_presidente(), Circunscripcion_service.ReadOne(cdr.getColegio_id()).getNombre()};
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

	public static java.sql.Date changeDate(Date date){
		return new java.sql.Date(date.getYear(),date.getMonth(),date.getDate());
	}
}
