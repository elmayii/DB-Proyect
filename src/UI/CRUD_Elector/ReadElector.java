package UI.CRUD_Elector;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dto.CDR;
import Dto.Elector;
import Service.CDR_service;
import Service.Circunscripcion_service;
import Service.Elector_service;
import UI.MainView;

import javax.swing.JScrollPane;

public class ReadElector extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadElector frame = new ReadElector();
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
	public ReadElector() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispose();
		setBounds(100, 100, 561, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 510, 339);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel model= new DefaultTableModel();
		model.addColumn("Nombre");
		model.addColumn("Apellidos");
		model.addColumn("Fecha de Nacimiento");
		model.addColumn("direccion");
		model.addColumn("CDR Asociado");
		table.setModel(model);
		loadToTable(table);
		
		JLabel lblNewLabel_2 = new JLabel("Electores en el sistema");
		lblNewLabel_2.setBounds(10, 42, 201, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Insertar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*try{
					if(!textField.getText().equals("") && !textField_1.getText().equals("") && table_2.getSelectedRow()!=-1){
						if(!textField_3.getText().equals("")){
							Elector_service.Create(textField.getText(),textField_1.getText(), changeDate(calendar.getDate()) ,textField_3.getText(),CDR_service.ReadAll().get(table_2.getSelectedRow()).getId(),textField_2.getText());
							System.out.println("pincho");
							refreshTable(table);
						}
					}
				}
				catch (Exception exep){
					System.out.println(exep);
				}
*/
			}
		});
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(10, 417, 89, 23);
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
				/*System.out.println(table.getSelectedRow()+10);
				System.out.println(table_2.getSelectedRow()+10);
				if(!textField.getText().equals("") && !textField_1.getText().equals("") && table_2.getSelectedRow()!=-1){
					if(table.getSelectedRow()!=-1 && !textField_3.getText().equals("")){
						Elector_service.Update(Elector_service.ReadAll().get(table.getSelectedRow()).getId(),textField.getText(),textField_1.getText(),changeDate(calendar.getDate()),textField_3.getText(),CDR_service.ReadAll().get(table_2.getSelectedRow()).getId(),textField_2.getText());
						refreshTable(table);
					}
				}*/
			}
		});
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(211, 417, 89, 23);
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
		btnNewButton_3.setBounds(431, 417, 89, 23);
		contentPane.add(btnNewButton_3);
		
		
		
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

/*limitMax.setYear(105);
		calendar.setMaxSelectableDate(limitMax);
		calendar.setDate(limitMax);*/
