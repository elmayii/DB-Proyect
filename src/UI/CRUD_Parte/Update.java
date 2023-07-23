package UI.CRUD_Parte;

import Service.Colegio_service;
import Service.Parte_service;
import UI.MainView;

import com.toedter.calendar.JCalendar;
import com.toedter.components.JSpinField;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		setBounds(100, 100, 660, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadParte frame = new ReadParte();
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

		JLabel lblNewLabel = new JLabel("Elija el colegio ");
		lblNewLabel.setBounds(381, 11, 253, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("electores eliminados");
		lblNewLabel_2.setBounds(10, 37, 193, 14);
		contentPane.add(lblNewLabel_2);

		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 190, 184, 153);
		contentPane.add(calendar);

		JLabel lblNewLabel_3 = new JLabel("Fecha del parte");
		lblNewLabel_3.setBounds(10, 167, 193, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("electores agregados");
		lblNewLabel_4.setBounds(205, 37, 166, 14);
		contentPane.add(lblNewLabel_4);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(205, 63, 30, 20);
		contentPane.add(spinner_1);

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(10, 63, 30, 20);
		contentPane.add(spinner_2);

		JLabel lblNewLabel_6 = new JLabel("Hora");
		lblNewLabel_6.setBounds(205, 167, 30, 14);
		contentPane.add(lblNewLabel_6);

		JSpinField spinField = new JSpinField();
		spinField.setBounds(204, 195, 30, 20);
		contentPane.add(spinField);

		JSpinField spinField_1 = new JSpinField();
		spinField_1.setBounds(244, 195, 30, 20);
		contentPane.add(spinField_1);

		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					if(table.getSelectedRow()!=-1){
						Timestamp fecha_hora = new Timestamp(calendar.getYearChooser().getYear(),calendar.getMonthChooser().getMonth(),calendar.getDayChooser().getDay(),spinField.getValue(),spinField_1.getValue(),0,0);
						Parte_service.Update(id,fecha_hora, (Integer) spinner_2.getValue(), (Integer) spinner_1.getValue(), Colegio_service.ReadAll().get(table.getSelectedRow()).getId());
						System.out.println("pincho");

						ReadParte frame= new ReadParte();
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

		JLabel lblNewLabel_7 = new JLabel("Min");
		lblNewLabel_7.setBounds(245, 167, 29, 14);
		contentPane.add(lblNewLabel_7);
	}

}
