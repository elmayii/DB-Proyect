package UI.CRUD_Elector;

import Service.CDR_service;
import Service.Circunscripcion_service;
import Service.Elector_service;
import Service.Municipio_service;
import UI.MainView;
import UI.CRUD_Circunscripcion.ReadCircunscripcion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;

public class Create extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setBounds(100, 100, 660, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadElector frame = new ReadElector();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Mario\\IdeaProjects\\Bd\\src\\UI\\Img\\go-back256_24856 (1).png"));
		btnNewButton_1.setBounds(0, 0, 38, 31);
		contentPane.add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(381, 36, 253, 377);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Elija el CDR al que pertenece");
		lblNewLabel.setBounds(381, 11, 253, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre del Elector");
		lblNewLabel_1.setBounds(10, 38, 209, 14);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(10, 63, 136, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setBounds(10, 101, 193, 14);
		contentPane.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBounds(10, 126, 136, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 190, 184, 153);
		contentPane.add(calendar);

		JLabel lblNewLabel_3 = new JLabel("Elija su fecha de nacimiento");
		lblNewLabel_3.setBounds(10, 167, 209, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Direccion particular");
		lblNewLabel_4.setBounds(205, 37, 166, 14);
		contentPane.add(lblNewLabel_4);

		textField_2 = new JTextField();
		textField_2.setBounds(205, 63, 166, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton = new JButton("Insertar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					if(!textField.getText().equals("") && !textField_1.getText().equals("") && table.getSelectedRow()!=-1){
						Elector_service.Create(textField.getText(),textField_1.getText(), (Date) calendar.getDate(),textField_2.getText(), CDR_service.ReadAll().get(table.getSelectedRow()).getId());
						System.out.println("pincho");

						ReadElector frame= new ReadElector();
						frame.setVisible(true);
						dispose();
					}
				}
				catch (Exception exep){
					System.out.println(exep);
				}
			}
		});
		btnNewButton.setBounds(157, 390, 89, 23);
		contentPane.add(btnNewButton);
	}
}
