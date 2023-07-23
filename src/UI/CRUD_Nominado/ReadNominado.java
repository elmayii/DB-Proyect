package UI.CRUD_Nominado;

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

import Dto.*;
import Service.*;
import UI.MainView;

import javax.swing.JScrollPane;

public class ReadNominado extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadNominado frame = new ReadNominado();
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
	public ReadNominado() {
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
		model.addColumn("Nombre");
		model.addColumn("Apellidos");
		model.addColumn("Fecha de Nacimiento");
		model.addColumn("direccion");
		model.addColumn("CDR Asociado");
		table.setModel(model);
		loadToTable(table);
		
		JLabel lblNewLabel_2 = new JLabel("Nominados en el sistema");
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
				if(table.getSelectedRow()!=-1){
					Update frame = new Update(Nominado_service.ReadAll().get(table.getSelectedRow()).getId());
					frame.setVisible(true);
					dispose();
				}
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
						Nominado_service.Delete(Nominado_service.ReadAll().get(i).getId());
						refreshTable(table);
					}
				}
			}
		});
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setBounds(555, 379, 89, 23);
		contentPane.add(btnNewButton_3);
		
		
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

	 public static int findAge(Elector e){
		Date d= new Date();
		 System.out.println(d.getYear());
		 System.out.println(e.getFecha_nacimiento().getYear());
		return d.getYear() - e.getFecha_nacimiento().getYear();
	 }
}
