package main;

import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;

import telas.TMain;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatDarkLaf());
		} catch (Exception ex) {
			System.err.println("Falha ao inicializar LaF");
		}
		new TMain().setVisible(true);
	}
}
