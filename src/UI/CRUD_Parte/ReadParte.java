package UI.CRUD_Parte;

import Dto.Nominado;
import Dto.Parte;
import Service.Circunscripcion_service;
import Service.Colegio_service;
import Service.Nominado_service;
import Service.Parte_service;
import UI.MainView;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ReadParte extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadParte frame = new ReadParte();
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
	public ReadParte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispose();
		setBounds(100, 100, 670, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 634, 301);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel model= new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Fecha y Hora");
		model.addColumn("Electores actual");
		model.addColumn("Electores agregados");
		model.addColumn("Electores Eliminados");
		model.addColumn("Colegio");
		table.setModel(model);
		loadToTable(table);

		JLabel lblNewLabel_2 = new JLabel("Partes en el sistema");
		lblNewLabel_2.setBounds(10, 42, 201, 14);
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

			}
		});
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(10, 379, 89, 23);
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
				Update frame = new Update(Parte_service.ReadAll().get(table.getSelectedRow()).getId());
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(284, 379, 89, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Eliminar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1){
					for (int i:table.getSelectedRows()) {
						Parte_service.Delete(Parte_service.ReadAll().get(i).getId());
						refreshTable(table);
					}
				}
			}
		});
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setBounds(555, 379, 89, 23);
		contentPane.add(btnNewButton_3);


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

	public static void loadToTable(JTable table) {
		for(Parte parte: Parte_service.ReadAll()) {
			Object [] row = new Object [] {parte.getId(),parte.getFecha_hora(),parte.getElectores_actual(),parte.getElectores_agregados(),parte.getElectores_eliminados(), Colegio_service.ReadOne(parte.getColegio_id()).getNombre()};
			((DefaultTableModel)table.getModel()).addRow(row);
		}
	}

}
