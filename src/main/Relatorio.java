package main;

import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import classes.Aviao;
import classes.InfoColisao;
import telas.TAviaoTableModel;

public class Relatorio {

	public static void tempColisao(TAviaoTableModel planeTableModel, JTextArea txtReport) {
		if (planeTableModel.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Não há aviões no radar");
			return;
		}

		double tempoMinimo;
		txtReport.setText(null);

		try {
			tempoMinimo = Double
					.parseDouble(JOptionPane.showInputDialog("Distância mínima para alertar a colisão (Segundos):"));
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Insira um valor válido");
			return;
		}

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < planeTableModel.getRowCount(); i++) {
			Aviao aviaoA = planeTableModel.getPlane(i);

			for (int j = i; j < planeTableModel.getRowCount(); j++) {
				Aviao aviaoB = planeTableModel.getPlane(j);

				if (aviaoA.getCodigo() == aviaoB.getCodigo()) {
					continue;
				}

				InfoColisao info = Calculo.calcularColisao(aviaoA, aviaoB);

				if (info.getDiferencaTempo() <= tempoMinimo) {

					stringBuilder.append(
							"O avião: " + aviaoA.getCodigo() + " está em rota de colisão com o avião " + aviaoB.getCodigo() + "\n");

				}
			}
		}
		if (stringBuilder.length() != 0) {
			txtReport.setText(stringBuilder.toString());
		} else {
			txtReport.setText("Não há avião em rota de colisão no tempo definido!");
		}
	}

	public static void distanciaAvioes(TAviaoTableModel planeTableModel, JTextArea txtReport) {
		Double distancia = 0.0;
		StringBuilder stringBuilder = new StringBuilder();
		HashMap<Integer, Integer> map = new HashMap<>();

		try {
			distancia = Double
					.parseDouble(JOptionPane.showInputDialog("informar a distância mínima entre as aeronaves! (km)"));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Enter valid value" + e);
		}

		for (int i = 0; i < planeTableModel.getRowCount(); i++) {
			Aviao aviaoA = planeTableModel.getPlane(i);

			for (int j = 0; j < planeTableModel.getRowCount(); j++) {
				Aviao aviaoB = planeTableModel.getPlane(j);

				if (aviaoA.getCodigo() == aviaoB.getCodigo()) {
					continue;
				}

				Integer alreadyExistis = map.get(aviaoB.getCodigo());

				if (alreadyExistis != null) {
					continue;
				}

				double distanciaCalc = Calculo.distancia(aviaoA.getPontoX(), aviaoA.getPontoY(), aviaoB.getPontoX(),
						aviaoB.getPontoY());

				if (distanciaCalc <= distancia) {
					map.put(aviaoA.getCodigo(), aviaoB.getCodigo());
					stringBuilder.append("O avião: " + aviaoA.getCodigo() + " está abaixo da distância mínima do avião "
							+ aviaoB.getCodigo() + "\n");
				}
			}
		}

		if (stringBuilder.length() != 0) {
			txtReport.setText(stringBuilder.toString());
		} else {
			txtReport.setText("Não há nenhum plano abaixo da distância mínima de outro plano!");
		}
	}

	public static void distanciaAeoporto(TAviaoTableModel planeTableModel, JTextArea txtReport) {
		Double distancia = 0.0;
		txtReport.setText(null);
		try {
			distancia = Double.parseDouble(JOptionPane.showInputDialog("informe a distância mínima até o aeroporto (km)"));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Insira um valor válido" + e);
		}

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < planeTableModel.getRowCount(); i++) {
			Aviao aviaoA = planeTableModel.getPlane(i);

			double distanciaCalc = Calculo.distancia(0, 0, aviaoA.getPontoX(), aviaoA.getPontoY());

			if (distanciaCalc <= distancia) {
				stringBuilder.append("O avião " + aviaoA.getCodigo() + " está abaixo da distância mínima do aeroporto!\n");
			}

		}
		if (stringBuilder.length() != 0) {
			txtReport.setText(stringBuilder.toString());
		} else {
			txtReport.setText("Não existe avião abaixo da distância mínima do aeroporto!");
		}
	}
}
