package telas;

import java.util.List;

import javax.swing.JOptionPane;

import classes.Aviao;
import main.Calculo;

@SuppressWarnings("serial")
public class TRotacionar extends javax.swing.JFrame {
	private final TMain principal;
    private final List<Aviao> planes;
    
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRotate;
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    
    private javax.swing.JPanel pnlLayout;
    
    private javax.swing.JTextField txtAngle;
    private javax.swing.JTextField txtX;
    private javax.swing.JTextField txtY;
    
	public TRotacionar(TMain main, List<Aviao> planes) {
    	initComponents();
    	
    	this.principal = main;
    	this.planes = planes;
    }
	
	private void initComponents() {
		pnlLayout = new javax.swing.JPanel();
		
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        
        btnRotate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        
        txtAngle = new javax.swing.JTextField();
        txtX = new javax.swing.JTextField();
        txtY = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rotate");

        jLabel1.setText("Angle:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Rotate");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Center in");

        jLabel4.setText("X:");

        jLabel5.setText("Y:");

        btnRotate.setText("Rotate");
        btnRotate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRotateActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLayoutLayout = new javax.swing.GroupLayout(pnlLayout);
        pnlLayout.setLayout(pnlLayoutLayout);
        pnlLayoutLayout.setHorizontalGroup(
            pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLayoutLayout.createSequentialGroup()
                .addGap(0, 35, Short.MAX_VALUE)
                .addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLayoutLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel3)
                        .addGap(47, 47, 47))
                    .addGroup(pnlLayoutLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAngle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtX, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtY, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
            .addGroup(pnlLayoutLayout.createSequentialGroup()
                .addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayoutLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel2))
                    .addGroup(pnlLayoutLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btnRotate)
                        .addGap(42, 42, 42)
                        .addComponent(btnCancel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLayoutLayout.setVerticalGroup(
            pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayoutLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAngle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRotate)
                    .addComponent(btnCancel))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLayout, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLayout, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
	}
	
	private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }
	
	private void btnRotateActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtX.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Insira o valor de X.");
            txtX.selectAll();
            return;
        }
        
        if (txtY.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Insira um valor válido para Y.");
            txtY.selectAll();
            return;
        }
        
        if (txtAngle.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Insira o valor do ângulo.");
            txtAngle.selectAll();
            return;
        }
        
        double x, y, angulo;
        
        try {
            x = Double.parseDouble(txtX.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Insira um valor válido para X.");
            txtX.selectAll();
            return;
        }
        
        try {
            y = Double.parseDouble(txtY.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Insira um valor válido para Y.");
            txtY.selectAll();
            return;
        }
        
        try {
            angulo = Double.parseDouble(txtAngle.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Informe um valor de ângulo válido.");
            txtAngle.selectAll();
            return;
        }
        
        for (Aviao aviao : planes) {
        	Calculo.rotacionar(aviao, x, y, angulo);		
		}
        
        principal.updateTable();
        
        this.dispose();
    }
}
