package telas;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import classes.Aviao;
import main.Relatorio;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class TMain extends JFrame {
	public TAviaoTableModel planeTableModel = new TAviaoTableModel();

	private JButton btnAdd;
	private JButton btnScale;
	private JButton btnRemove;
	private JButton btnRotate;
	private JButton btnTranslate;
	private JButton btnDistPlanes;
	private JButton btnDistAirport;
	private JButton btnCollisionCourse;

	private JLabel lblReport;

	private JPanel pnlLayout;
	private JPanel pnlRadar;

	private JScrollPane scpPlane;

	private JTable tblPlane;

	private DefaultTableModel defaultTableModel;

	private JTextArea txtReport;

	public List<Aviao> avioes;

	public TMain() {
		initComponents();
		updateTable();
	}

	private void initComponents() {
		final java.awt.Color colorFirstButton = new java.awt.Color(230, 230, 230);
		final java.awt.Color colorSecondButton = new java.awt.Color(153, 230, 255);
		final java.awt.Color colorTables = new java.awt.Color(255, 255, 255);

		avioes = new ArrayList<>();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Plane radar");

		pnlLayout = new JPanel();
		pnlLayout.setPreferredSize(new java.awt.Dimension(900, 600));

		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("X");
		defaultTableModel.addColumn("Y");
		defaultTableModel.addColumn("R");
		defaultTableModel.addColumn("A");
		defaultTableModel.addColumn("V");
		defaultTableModel.addColumn("D");

		tblPlane = new JTable(defaultTableModel);

		scpPlane = new JScrollPane(tblPlane);

		btnAdd = new JButton();
		btnAdd.setText("Inserir");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setEnableBtnAdd(false);
				AdicionaAviao();
			}
		});

		btnRemove = new JButton();
		btnRemove.setText("Remover");
		btnRemove.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnRemovePlaneActionPerformed(evt);
			}
		});

		lblReport = new JLabel();
		lblReport.setFont(new Font("Arial", Font.BOLD, 20));
		lblReport.setText("Relatorio");

		pnlRadar = new JPanel();
		pnlRadar.setBackground(colorTables);
		pnlRadar.setPreferredSize(new java.awt.Dimension(300, 300));

		GroupLayout pnlRadarLayout = new GroupLayout(pnlRadar);
		pnlRadar.setLayout(pnlRadarLayout);
		pnlRadarLayout.setHorizontalGroup(pnlRadarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE));
		pnlRadarLayout.setVerticalGroup(pnlRadarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE));

		btnScale = new JButton();
		btnScale.setBackground(colorFirstButton);
		btnScale.setText("Escalonar");
		btnScale.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnScaleActionPerformed(evt);
			}
		});

		btnTranslate = new JButton();
		btnTranslate.setBackground(colorFirstButton);
		btnTranslate.setText("Translandar");
		btnTranslate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTranslateActionPerformed(evt);
			}
		});

		btnRotate = new JButton();
		btnRotate.setBackground(colorFirstButton);
		btnRotate.setText("Rotacionar");
		btnRotate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnRotateActionPerformed(evt);
			}
		});

		btnDistAirport = new JButton();
		btnDistAirport.setBackground(colorSecondButton);
		btnDistAirport.setText("Distância Min. Aeroporto");
		btnDistAirport.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Relatorio.distanciaAeoporto(planeTableModel, txtReport);
			}
		});

		btnDistPlanes = new JButton();
		btnDistPlanes.setBackground(colorSecondButton);
		btnDistPlanes.setText("Distância Mínima Aviões Próx.");
		btnDistPlanes.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Relatorio.distanciaAvioes(planeTableModel, txtReport);
			}
		});

		btnCollisionCourse = new JButton();
		btnCollisionCourse.setBackground(colorSecondButton);
		btnCollisionCourse.setText("Tempo Mín. em rota de Colisão");
		btnCollisionCourse.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Relatorio.tempColisao(planeTableModel, txtReport);
			}
		});

		txtReport = new JTextArea();
		txtReport.setEditable(false);
		txtReport.setColumns(20);
		txtReport.setRows(5);
		txtReport.setFocusable(false);

		GroupLayout pnlLayoutLayout = new GroupLayout(pnlLayout);
		pnlLayoutLayout.setHorizontalGroup(
				pnlLayoutLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, pnlLayoutLayout.createSequentialGroup()
								.addGap(31)
								.addGroup(pnlLayoutLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(pnlLayoutLayout.createSequentialGroup()
												.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
										.addGroup(pnlLayoutLayout.createSequentialGroup()
												.addGroup(pnlLayoutLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(pnlRadar, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
														.addGroup(pnlLayoutLayout.createSequentialGroup()
																.addGap(295)
																.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
														.addGroup(pnlLayoutLayout.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(scpPlane, 0, 0, Short.MAX_VALUE)))
												.addGroup(pnlLayoutLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(pnlLayoutLayout.createSequentialGroup()
																.addGap(58)
																.addGroup(pnlLayoutLayout.createParallelGroup(Alignment.LEADING)
																		.addGroup(pnlLayoutLayout.createSequentialGroup()
																				.addGroup(pnlLayoutLayout.createParallelGroup(Alignment.LEADING)
																						.addComponent(btnScale, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
																						.addComponent(btnDistAirport, Alignment.TRAILING, 0, 0, Short.MAX_VALUE))
																				.addGap(14)
																				.addGroup(pnlLayoutLayout.createParallelGroup(Alignment.LEADING)
																						.addComponent(btnDistPlanes, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
																						.addComponent(btnTranslate, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
																								131, Short.MAX_VALUE))
																				.addGap(18)
																				.addGroup(pnlLayoutLayout.createParallelGroup(Alignment.LEADING)
																						.addComponent(btnCollisionCourse, GroupLayout.DEFAULT_SIZE, 131,
																								Short.MAX_VALUE)
																						.addComponent(btnRotate, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)))
																		.addComponent(txtReport, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)))
														.addGroup(Alignment.TRAILING, pnlLayoutLayout.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(lblReport)
																.addGap(177)))
												.addGap(116)))));
		pnlLayoutLayout.setVerticalGroup(
				pnlLayoutLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(pnlLayoutLayout.createSequentialGroup()
								.addGroup(pnlLayoutLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(pnlLayoutLayout.createSequentialGroup()
												.addGap(16)
												.addGroup(pnlLayoutLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(btnScale, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnTranslate, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnRotate, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(pnlLayoutLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(btnDistAirport, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnDistPlanes, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnCollisionCourse, GroupLayout.PREFERRED_SIZE, 58,
																GroupLayout.PREFERRED_SIZE))
												.addGap(33)
												.addComponent(lblReport)
												.addGap(18)
												.addComponent(txtReport, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
										.addGroup(pnlLayoutLayout.createSequentialGroup()
												.addComponent(pnlRadar, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(scpPlane, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)))
								.addPreferredGap(ComponentPlacement.RELATED, 18, GroupLayout.PREFERRED_SIZE)
								.addGroup(pnlLayoutLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnAdd)
										.addComponent(btnRemove))
								.addContainerGap()));
		pnlLayout.setLayout(pnlLayoutLayout);

		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, layout.createSequentialGroup()
								.addGap(40)
								.addComponent(pnlLayout, GroupLayout.PREFERRED_SIZE, 1045, Short.MAX_VALUE)
								.addContainerGap()));
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(26)
								.addComponent(pnlLayout, GroupLayout.PREFERRED_SIZE, 727, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(46, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);

		pack();
		setLocationRelativeTo(null);
	}

	public final void updateTable() {
		this.planeTableModel.update();
		this.tblPlane.setModel(this.planeTableModel);

		this.pnlRadar.removeAll();

		for (int i = 0; i < planeTableModel.getRowCount(); i++) {
			try {
				JLabel label = generatePlaneImage(planeTableModel.getPlane(i));
				pnlRadar.add(label);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
		}

		startPlaneLayout();
		pnlRadar.revalidate();
		pnlRadar.repaint();
	}

	private void startPlaneLayout() {
		URL url = getClass().getResource("../images/airport.png");
		JLabel label = new JLabel(new ImageIcon(url));
		label.setBounds(201 - (30 / 2), 200 - (30 / 2), 30, 30);
		pnlRadar.add(label);

		// Horizontal lines
		JSeparator sep1 = new JSeparator();
		sep1.setBounds(0, 50, pnlRadar.getWidth(), 5);
		sep1.setVisible(true);
		pnlRadar.add(sep1);

		JSeparator sep2 = new JSeparator();
		sep2.setBounds(0, 100, pnlRadar.getWidth(), 5);
		sep2.setVisible(true);
		pnlRadar.add(sep2);

		JSeparator sep3 = new JSeparator();
		sep3.setBounds(0, 150, pnlRadar.getWidth(), 5);
		sep3.setVisible(true);
		pnlRadar.add(sep3);

		JSeparator sep4 = new JSeparator();
		sep4.setBounds(0, 200, pnlRadar.getWidth(), 5);
		sep4.setVisible(true);
		pnlRadar.add(sep4);

		JSeparator sep5 = new JSeparator();
		sep5.setBounds(0, 250, pnlRadar.getWidth(), 5);
		sep5.setVisible(true);
		pnlRadar.add(sep5);

		JSeparator sep6 = new JSeparator();
		sep6.setBounds(0, 300, pnlRadar.getWidth(), 5);
		sep6.setVisible(true);
		pnlRadar.add(sep6);

		JSeparator sep7 = new JSeparator();
		sep7.setBounds(0, 350, pnlRadar.getWidth(), 5);
		sep7.setVisible(true);
		pnlRadar.add(sep7);

		// Vertical lines
		JSeparator sep8 = new JSeparator();
		sep8.setOrientation(SwingConstants.VERTICAL);
		sep8.setBounds(50, 0, 5, pnlRadar.getHeight());
		sep8.setVisible(true);
		pnlRadar.add(sep8);

		JSeparator sep9 = new JSeparator();
		sep9.setOrientation(SwingConstants.VERTICAL);
		sep9.setBounds(100, 0, 5, pnlRadar.getHeight());
		sep9.setVisible(true);
		pnlRadar.add(sep9);

		JSeparator sep10 = new JSeparator();
		sep10.setOrientation(SwingConstants.VERTICAL);
		sep10.setBounds(150, 0, 5, pnlRadar.getHeight());
		sep10.setVisible(true);
		pnlRadar.add(sep10);

		JSeparator sep11 = new JSeparator();
		sep11.setOrientation(SwingConstants.VERTICAL);
		sep11.setBounds(200, 0, 5, pnlRadar.getHeight());
		sep11.setVisible(true);

		pnlRadar.add(sep11);

		JSeparator sep12 = new JSeparator();
		sep12.setOrientation(SwingConstants.VERTICAL);
		sep12.setBounds(250, 0, 5, pnlRadar.getHeight());
		sep12.setVisible(true);
		pnlRadar.add(sep12);

		JSeparator sep13 = new JSeparator();
		sep13.setOrientation(SwingConstants.VERTICAL);
		sep13.setBounds(300, 0, 5, pnlRadar.getHeight());
		sep13.setVisible(true);
		pnlRadar.add(sep13);

		JSeparator sep14 = new JSeparator();
		sep14.setOrientation(SwingConstants.VERTICAL);
		sep14.setBounds(350, 0, 5, pnlRadar.getHeight());
		sep14.setVisible(true);
		pnlRadar.add(sep14);
	}

	private void AdicionaAviao() {
		TAdcAviao adicionaAvi = new TAdcAviao(this);
		adicionaAvi.setVisible(true);
	}

	private void btnRemovePlaneActionPerformed(java.awt.event.ActionEvent evt) {
		int linhaSelecionada = tblPlane.getSelectedRow();

		if (linhaSelecionada >= 0) {
			planeTableModel.removeAviao(linhaSelecionada);
			updateTable();
		} else {
			JOptionPane.showMessageDialog(null, "É necessário selecionar um avião");
		}
	};

	public void setEnableBtnAdd(boolean enable) {
		btnAdd.setEnabled(enable);
	}

	public void addGrade(Aviao aviao) throws IOException {
		aviao.setCodigo(defaultTableModel.getRowCount() + 1);
		defaultTableModel.addRow(new Object[] {
				aviao.getCodigo(),
				aviao.getPontoX(),
				aviao.getPontoY(),
				aviao.getRaio(),
				aviao.getAngulo(),
				aviao.getVelocidade(),
				aviao.getDirecao(),
		});
		generatePlaneImage(aviao);
	}

	private void btnScaleActionPerformed(java.awt.event.ActionEvent evt) {

		int selectedLine[] = tblPlane.getSelectedRows();

		if (selectedLine.length < 1) {
			JOptionPane.showMessageDialog(null, "É necessário selecionar um avião");
			return;
		}

		List<Aviao> list = new ArrayList<Aviao>();
		for (int i = 0; i < selectedLine.length; i++) {
			list.add(planeTableModel.getPlane(selectedLine[i]));
		}

		TEscalonar scaleFrame = new TEscalonar(this, list);
		scaleFrame.setVisible(true);
		tblPlane.clearSelection();
	}

	private JLabel generatePlaneImage(Aviao aviao) throws IOException {
		URL url = getClass().getResource("../images/plane.png");

		BufferedImage img = ImageIO.read(url);

		img = rotateImage(img, -1 * (aviao.getDirecao() - 45.0));

		Icon icon = new ImageIcon(img);
		JLabel label = new JLabel(icon);

		int x = (int) ((aviao.getPontoX() > 0) ? 200 + aviao.getPontoX() : 200 + aviao.getPontoX());
		int y = (int) ((aviao.getPontoY() > 0) ? 200 - aviao.getPontoY() : 200 - aviao.getPontoY());

		label.setBounds(x - (30 / 2), y - (30 / 2), 30, 30);

		return label;
	}

	public static BufferedImage rotateImage(BufferedImage imagem, double angle) {
		angle %= 360;
		if (angle < 0)
			angle += 360;

		AffineTransform tx = new AffineTransform();
		tx.rotate(Math.toRadians(angle), imagem.getWidth() / 2.0, imagem.getHeight() / 2.0);

		double ytrans = 0;
		double xtrans = 0;
		if (angle <= 90) {
			xtrans = tx.transform(new Point2D.Double(0, imagem.getHeight()), null).getX();
			ytrans = tx.transform(new Point2D.Double(0.0, 0.0), null).getY();
		} else if (angle <= 180) {
			xtrans = tx.transform(new Point2D.Double(imagem.getWidth(), imagem.getHeight()), null).getX();
			ytrans = tx.transform(new Point2D.Double(0, imagem.getHeight()), null).getY();
		} else if (angle <= 270) {
			xtrans = tx.transform(new Point2D.Double(imagem.getWidth(), 0), null).getX();
			ytrans = tx.transform(new Point2D.Double(imagem.getWidth(), imagem.getHeight()), null).getY();
		} else {
			xtrans = tx.transform(new Point2D.Double(0, 0), null).getX();
			ytrans = tx.transform(new Point2D.Double(imagem.getWidth(), 0), null).getY();
		}

		AffineTransform translationTransform = new AffineTransform();
		translationTransform.translate(-xtrans, -ytrans);
		tx.preConcatenate(translationTransform);

		return new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR).filter(imagem, null);
	}

	private void btnTranslateActionPerformed(java.awt.event.ActionEvent evt) {
		int selectedLine[] = tblPlane.getSelectedRows();

		if (selectedLine.length < 1) {
			JOptionPane.showMessageDialog(null, "É necessário selecionar um avião!");
			return;
		}

		List<Aviao> list = new ArrayList<Aviao>();
		for (int i = 0; i < selectedLine.length; i++) {
			list.add(planeTableModel.getPlane(selectedLine[i]));
		}

		TTranslandar frameTranslate = new TTranslandar(this, list);
		frameTranslate.setVisible(true);
		tblPlane.clearSelection();
	}

	private void btnRotateActionPerformed(java.awt.event.ActionEvent evt) {
		int selectedLine[] = tblPlane.getSelectedRows();

		if (selectedLine.length < 1) {
			JOptionPane.showMessageDialog(null, "É necessário selecionar um avião!");
			return;
		}

		List<Aviao> list = new ArrayList<Aviao>();
		for (int i = 0; i < selectedLine.length; i++) {
			list.add(planeTableModel.getPlane(selectedLine[i]));
		}

		TRotacionar frameTranslate = new TRotacionar(this, list);
		frameTranslate.setVisible(true);
		tblPlane.clearSelection();
	}

}
