package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import classes.Aviao;
import main.Calculo;

public class TAdcAviao extends JDialog {

    private javax.swing.JPanel pnlLayout;
	private static final long serialVersionUID = 1L;
	private final JPanel pnlPrincipal = new JPanel();
	private JTextField edtX;
	private JTextField edtRaio;
	private JTextField edtVelocidade;
	private JTextField edtY;
	private JTextField edtAngulo;
	private JTextField edtDirecao;
	private JPanel pnlTitle;
	private ButtonGroup grpRdbButtons;
	private JRadioButton rdbCartesiana;
	private JRadioButton rdbPolar;
	private JLabel lblX;
	private JLabel lblY;
	private JLabel lblRaio;
	private JLabel lblAngulo;
	private JLabel lblVelocidade;
	private JLabel lblDirecao;
	private JLabel lblTitle;
	private JPanel pnlButton;
	private JButton btnSalvar;
	private JButton btnCancel;

	public TAdcAviao(TMain p) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setLocationRelativeTo(this);
		setModal(true);
		setTitle("Registrar avião");
		setBounds(300, 300, 408, 322);
		getContentPane().setLayout(new BorderLayout());
		pnlPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
		setPreferredSize(new java.awt.Dimension(350, 300));
		setLocationRelativeTo(null);

		pnlLayout = new javax.swing.JPanel();

		pnlTitle = new JPanel();
		pnlTitle.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));

		lblTitle = new JLabel("Adicionar avião");
		pnlTitle.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setIcon(new ImageIcon(TAdcAviao.class.getResource("/images/baseline.png")));
		lblTitle.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));

		rdbCartesiana = new JRadioButton("Cartesiano");
		rdbCartesiana.setSelected(true);
		rdbCartesiana.setFont(new Font("Arial", Font.PLAIN, 16));

		rdbPolar = new JRadioButton("Polar");
		rdbPolar.setFont(new Font("Arial", Font.PLAIN, 16));

		grpRdbButtons = new ButtonGroup();
		grpRdbButtons.add(rdbCartesiana);
		grpRdbButtons.add(rdbPolar);

		lblX = new JLabel("X:");
		lblX.setHorizontalAlignment(SwingConstants.RIGHT);
		lblX.setFont(new Font("Arial", Font.PLAIN, 16));
		edtX = new JTextField();
		edtX.setColumns(10);

		lblY = new JLabel("Y:");
		lblY.setHorizontalAlignment(SwingConstants.RIGHT);
		lblY.setFont(new Font("Arial", Font.PLAIN, 16));
		edtY = new JTextField();
		edtY.setColumns(10);

		lblRaio = new JLabel("Raio:");
		lblRaio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRaio.setFont(new Font("Arial", Font.PLAIN, 16));
		edtRaio = new JTextField();
		edtRaio.setEditable(false);
		edtRaio.setColumns(10);

		lblVelocidade = new JLabel("Velocidade:");
		lblVelocidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVelocidade.setFont(new Font("Arial", Font.PLAIN, 16));
		edtVelocidade = new JTextField();
		edtVelocidade.setColumns(10);

		lblAngulo = new JLabel("Angulo:");
		lblAngulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAngulo.setFont(new Font("Arial", Font.PLAIN, 16));
		edtAngulo = new JTextField();
		edtAngulo.setEditable(false);
		edtAngulo.setColumns(10);

		lblDirecao = new JLabel("Direcao:");
		lblDirecao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDirecao.setFont(new Font("Arial", Font.PLAIN, 16));
		edtDirecao = new JTextField();
		edtDirecao.setColumns(10);


		pnlButton = new JPanel();
		getContentPane().add(pnlButton, BorderLayout.SOUTH);
		pnlButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnSalvar = new JButton("Salvar");
		pnlButton.add(btnSalvar);
		getRootPane().setDefaultButton(btnSalvar);


        btnCancel = new JButton("Cancelar");
		btnCancel.setActionCommand("Cancel");
		pnlButton.add(btnCancel);


		GroupLayout gl_pnlPrincipal = new GroupLayout(pnlPrincipal);
		pnlLayout.setLayout(gl_pnlPrincipal);
		gl_pnlPrincipal.setHorizontalGroup(
			gl_pnlPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPrincipal.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlPrincipal.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlPrincipal.createSequentialGroup()
							.addGroup(gl_pnlPrincipal.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_pnlPrincipal.createSequentialGroup()
									.addGroup(gl_pnlPrincipal.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblRaio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblX, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblVelocidade, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(4)
									.addGroup(gl_pnlPrincipal.createParallelGroup(Alignment.LEADING, false)
										.addComponent(edtX, 0, 0, Short.MAX_VALUE)
										.addComponent(edtRaio, 0, 0, Short.MAX_VALUE)
										.addComponent(edtVelocidade, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)))
								.addComponent(rdbCartesiana))
							.addGroup(gl_pnlPrincipal.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlPrincipal.createSequentialGroup()
									.addGap(15)
									.addGroup(gl_pnlPrincipal.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_pnlPrincipal.createSequentialGroup()
											.addComponent(lblDirecao, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(edtDirecao, 0, 0, Short.MAX_VALUE))
										.addGroup(gl_pnlPrincipal.createSequentialGroup()
											.addComponent(lblAngulo, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(edtAngulo, 0, 0, Short.MAX_VALUE))
										.addGroup(gl_pnlPrincipal.createSequentialGroup()
											.addComponent(lblY, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(edtY, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_pnlPrincipal.createSequentialGroup()
									.addGap(61)
									.addComponent(rdbPolar)))
							.addGap(11))
						.addComponent(pnlTitle, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pnlPrincipal.setVerticalGroup(
			gl_pnlPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPrincipal.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnlTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlPrincipal.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbCartesiana)
						.addComponent(rdbPolar))
					.addGap(18)
					.addGroup(gl_pnlPrincipal.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnlPrincipal.createSequentialGroup()
							.addGroup(gl_pnlPrincipal.createParallelGroup(Alignment.TRAILING)
								.addComponent(edtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblX))
							.addGap(18)
							.addGroup(gl_pnlPrincipal.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRaio, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(edtRaio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_pnlPrincipal.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblVelocidade, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(edtVelocidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pnlPrincipal.createSequentialGroup()
							.addGroup(gl_pnlPrincipal.createParallelGroup(Alignment.LEADING)
								.addComponent(lblY, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(edtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_pnlPrincipal.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAngulo, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(edtAngulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_pnlPrincipal.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlPrincipal.createSequentialGroup()
									.addGap(2)
									.addComponent(edtDirecao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblDirecao, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		pnlPrincipal.setLayout(gl_pnlPrincipal);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar(p);
			}
		});

		this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				cancelar(p);
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar(p);
			}
		});

		rdbCartesiana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitaCartesiane();
			}
		});

		rdbPolar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitaAngulo();
			}
		});
	}

	private void habilitaCartesiane() {
		edtX.setEditable(true);
		edtY.setEditable(true);
		edtAngulo.setText(null);
		edtRaio.setText(null);
		edtAngulo.setEditable(false);
		edtRaio.setEditable(false);
	}

	private void habilitaAngulo() {
		edtAngulo.setEditable(true);
		edtRaio.setEditable(true);
		edtX.setText(null);
		edtY.setText(null);
		edtX.setEditable(false);
		edtY.setEditable(false);
	}

	private void cancelar(TMain p) {
		p.setEnableBtnAdd(true);
		this.dispose();
	}

	private void salvar(TMain p) {
		try {
			Aviao aviao = new Aviao();
			aviao.setVelocidade(Double.parseDouble(edtVelocidade.getText()));
			aviao.setDirecao(Double.parseDouble(edtDirecao.getText()));

			if (rdbCartesiana.isSelected()) {
				aviao.setPontoX(Double.parseDouble(edtX.getText()));
				aviao.setPontoY(Double.parseDouble(edtY.getText()));
				aviao = Calculo.cartersianoParaPolar(aviao);
			}else{
				aviao.setAngulo(Double.parseDouble(edtAngulo.getText()));
				aviao.setRaio(Double.parseDouble(edtRaio.getText()));
				Calculo.polarParaCartesiano(aviao);
			}

			System.out.println(aviao);
			p.planeTableModel.addAviao(aviao);
			p.updateTable();
			this.dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha os dados corretamente");
		}
	}

}
