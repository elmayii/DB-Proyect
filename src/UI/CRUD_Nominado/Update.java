package UI.CRUD_Nominado;

import Dto.Circunscripcion;
import Dto.Elector;
import Dto.Nominado;
import Service.*;
import UI.MainView;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JCalendar;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table_2;
	private JTable table_1;
	private JTextField textField_5;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
	public Update(int id) {setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispose();
		setBounds(100, 100, 888, 798);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nueva Profesion");
		lblNewLabel.setBounds(10, 101, 159, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nueva Ocupacion");
		lblNewLabel_1.setBounds(244, 101, 169, 14);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(10, 126, 159, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 405, 279, 301);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(299, 405, 277, 301);
		contentPane.add(scrollPane_1);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 228, 279, 128);
		contentPane.add(textPane);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(299, 228, 277, 128);
		contentPane.add(textPane_1);

		textField_1 = new JTextField();
		textField_1.setBounds(244, 126, 169, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(694, 65, 89, 20);
		contentPane.add(spinner);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(694, 126, 89, 20);
		contentPane.add(spinner_1);

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
		
		JLabel lblNewLabel_8 = new JLabel("Integracion Revolucionaria");
		lblNewLabel_8.setBounds(10, 203, 159, 14);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Datos Biograficos");
		lblNewLabel_9.setBounds(299, 203, 169, 14);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Vuelta");
		lblNewLabel_10.setBounds(694, 40, 113, 14);
		contentPane.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Votos");
		lblNewLabel_11.setBounds(694, 101, 131, 14);
		contentPane.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("Nuevo Telefono");
		lblNewLabel_12.setBounds(494, 101, 139, 14);
		contentPane.add(lblNewLabel_12);

		textField_5 = new JTextField();
		textField_5.setBounds(494, 126, 139, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nuevo Nombre");
		lblNewLabel_2.setBounds(652, 203, 155, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nuevos apellidos");
		lblNewLabel_3.setBounds(652, 298, 173, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Nueva fecha de nacimiento");
		lblNewLabel_5.setBounds(652, 380, 184, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(652, 232, 155, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(652, 323, 155, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(652, 405, 184, 153);
		contentPane.add(calendar);
		
		JLabel lblNewLabel_4 = new JLabel("Elija la cicunscripcion a la que pertenece");
		lblNewLabel_4.setBounds(299, 380, 218, 14);
		contentPane.add(lblNewLabel_4);

		table_2 = new JTable();
		table_2.setBounds(299, 405, 277, 301);
		scrollPane_1.add(table_2);
		table_2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Circunscripcion", "Municipio Asociado"
				}
		));
		loadToTableCircunscripcion(table_2);

		JLabel lblNewLabel_6 = new JLabel("Encuentre el Elector");
		lblNewLabel_6.setBounds(10, 380, 169, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("*ATENCION*");
		lblNewLabel_7.setBounds(381, 17, 108, 14);
		contentPane.add(lblNewLabel_7);

		JTextPane txtpnElNominadoA = new JTextPane();
		txtpnElNominadoA.setEditable(false);
		txtpnElNominadoA.setText("La informacion proporcionada tambien provocara cambios en el elector seleccionado");
		txtpnElNominadoA.setBounds(244, 40, 365, 31);
		contentPane.add(txtpnElNominadoA);

		table_1 = new JTable();
		table_1.setBounds(10, 407, 277, 301);
		scrollPane.add(table_1);
		table_1.setModel(new DefaultTableModel(
				new Object[][][][][] {
				},
				new String[] {
						"Nombre", "Apellidos","Fecha de Nacimiento","direccion","CDR Asociado"
				}
		));
		loadToTableElector(table_1);
		

		JButton btnNewButton_2 = new JButton("Modificar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().equals("") && !textField_1.getText().equals("") && table_2.getSelectedRow()!=-1){
					if(table_1.getSelectedRow()!=-1 && table_2.getSelectedRow()!=-1){
						if(table_1.getSelectedRow()!=-1 && !textPane.getText().equals("") && !textPane_1.getText().equals("")) {
							if (!textField_5.getText().equals("")) {
								if (spinner.getComponentCount()>0 && spinner_1.getComponentCount()>0) {
									Nominado_service.Update(Nominado_service.ReadAll().get(id).getId(), textField_2.getText(), textField_3.getText(), (java.sql.Date) calendar.getDate(), textField_4.getText(), findAge(calendar.getDate()), textPane.getText(), textField_5.getText(), textField_1.getText(), textField.getText(), textPane_1.getText(), spinner.getComponentCount(), spinner_1.getComponentCount(), Circunscripcion_service.ReadAll().get(table_2.getSelectedRow()).getId());
									System.out.println("pincho");
									ReadNominado frame = new ReadNominado();
									frame.setVisible(true);
									dispose();
								}
							}
						}
					}
				}
			}
		});
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(400, 726, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_13 = new JLabel("Nueva direccion particular");
		lblNewLabel_13.setBounds(652, 633, 184, 14);
		contentPane.add(lblNewLabel_13);
		
		textField_4 = new JTextField();
		textField_4.setBounds(652, 658, 184, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
	}

	public static void loadToTable(JTable table) {
		for(Nominado nominado: Nominado_service.ReadAll()) {
			Object [] row = new Object [] {nominado.getNombre(),nominado.getApellido(),nominado.getFecha_nacimiento(),nominado.getDireccion(),nominado.getEdad(),nominado.getIntegracion_revolucionaria(),nominado.getTelefono(),nominado.getOcupacion(),nominado.getProfesion(),nominado.getDatos_biograficos(),nominado.getVuelta(),nominado.getVotos(), Circunscripcion_service.ReadOne(nominado.getCircunscripcion()).getNombre()};
			((DefaultTableModel)table.getModel()).addRow(row);
		}
	}

	public static void loadToTableElector(JTable table) {
		for(Elector elector: Elector_service.ReadAll()) {
			Object [] row = new Object [] {elector.getNombre(), elector.getApellido(),elector.getFecha_nacimiento(),elector.getDireccion(), CDR_service.ReadOne(elector.getCdr_id()).getNombre()};
			((DefaultTableModel)table.getModel()).addRow(row);
		}
	}

	public static void loadToTableCircunscripcion(JTable table) {
		for(Circunscripcion circunscripcion: Circunscripcion_service.ReadAll()) {
			Object [] row = new Object [] {circunscripcion.getNombre(), Municipio_service.ReadOne(circunscripcion.getMunicipio_id()).getNombre()};
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

	public static int findAge(Date date){
		Date d= new Date();
		System.out.println(d.getYear());
		System.out.println(date.getYear());
		return d.getYear() - date.getYear();
	}
}
