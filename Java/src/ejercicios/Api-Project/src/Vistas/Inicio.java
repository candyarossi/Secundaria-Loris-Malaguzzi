package Vistas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Inicio {

	private JFrame frmIssyapp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frmIssyapp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIssyapp = new JFrame();
		frmIssyapp.setTitle("ISSYapp");
		frmIssyapp.setBackground(Color.WHITE);
		frmIssyapp.setBounds(140, 80, 1100, 600);
		frmIssyapp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIssyapp.getContentPane().setBackground(Color.DARK_GRAY);
		
		
	}

}
