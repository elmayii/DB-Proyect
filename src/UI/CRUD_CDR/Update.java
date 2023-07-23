package UI.CRUD_CDR;

import Service.Circunscripcion_service;
import Service.Municipio_service;
import UI.MainView;
import UI.CRUD_Circunscripcion.ReadCircunscripcion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Update(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(315, 37, 253, 285);
		contentPane.add(scrollPane);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadCDR frame = new ReadCDR();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Mario\\IdeaProjects\\Bd\\src\\UI\\Img\\go-back256_24856 (1).png"));
		btnNewButton_1.setBounds(0, 0, 38, 31);
		contentPane.add(btnNewButton_1);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Elija el Municipio al que pertenece");
		lblNewLabel.setBounds(315, 11, 253, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nuevo Nombre de la Circunscripcion");
		lblNewLabel_1.setBounds(10, 38, 209, 14);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(10, 63, 193, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.setBounds(114, 299, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre del nuevo presidente");
		lblNewLabel_2.setBounds(10, 119, 193, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 144, 193, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!textField.getText().equals("") && !textField_1.getText().equals("") && table.getSelectedRow() != -1) {
						Circunscripcion_service.Update(textField.getText(), Municipio_service.ReadAll().get(table.getSelectedRow()).getId(), id);

						ReadCDR frame = new ReadCDR();
						frame.setVisible(true);
						dispose();
					}
				} catch (Exception exep) {
					System.out.println(exep);
				}
			}
		});
	}

}
