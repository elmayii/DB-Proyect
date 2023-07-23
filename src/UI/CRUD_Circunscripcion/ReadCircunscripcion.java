package UI.CRUD_Circunscripcion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dto.Circunscripcion;
import Dto.Municipio;
import Service.Circunscripcion_service;
import Service.Municipio_service;
import UI.MainView;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReadCircunscripcion extends JFrame {

	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadCircunscripcion frame = new ReadCircunscripcion();
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
	public ReadCircunscripcion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispose();
		setBounds(100, 100, 490, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 451, 374);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel model= new DefaultTableModel();
		model.addColumn("Circunscripcion");
		model.addColumn("Municipio Asociado");
		table.setModel(model);
		loadToTable(table);
		
		JLabel lblNewLabel_2 = new JLabel("Circunscripciones en el sistema");
		lblNewLabel_2.setBounds(10, 56, 201, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Insertar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try{
					Create frame = new Create();
					frame.setVisible(true);
					dispose();
				}
				catch (Exception exep){
					System.out.println(exep);
				}

				/*try{
					if(!textField.getText().equals("")  && table_2.getSelectedRow()!=-1){
						Circunscripcion_service.Create(textField.getText(),Municipio_service.ReadAll().get(table_2.getSelectedRow()).getId());
						System.out.println("pincho");
						refreshTable(table);
					}
				}
				catch (Exception exep){
					System.out.println(exep);
				}*/

			}
		});
		btnNewButton.setBounds(10, 486, 89, 23);
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
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try{
					if(table.getSelectedRow()!=-1){
						Update frame = new Update(Circunscripcion_service.ReadAll().get(table.getSelectedRow()).getId());
						frame.setVisible(true);
						dispose();
					}
				}
				catch (Exception exep){
					System.out.println(exep);
				}

				/*System.out.println(table.getSelectedRow()+10);
				System.out.println(table_2.getSelectedRow()+10);
				if(!textField.getText().equals("") && table_2.getSelectedRow()!=-1){
					if(table.getSelectedRow()!=-1){
						Circunscripcion_service.Update(textField.getText(),Municipio_service.ReadAll().get(table_2.getSelectedRow()).getId(),Circunscripcion_service.ReadAll().get(table.getSelectedRow()).getId());
						refreshTable(table);
					}
				}*/
			}
		});
		btnNewButton_2.setBounds(187, 486, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Eliminar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1){
					Circunscripcion_service.Delete(Circunscripcion_service.ReadAll().get(table.getSelectedRow()).getId());
				}
			}
		});
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setBounds(372, 486, 89, 23);
		contentPane.add(btnNewButton_3);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRow()!=-1){
					btnNewButton_2.setEnabled(true);
				}
			}
		});

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
