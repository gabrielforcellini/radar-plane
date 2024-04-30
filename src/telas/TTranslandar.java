package telas;

import java.util.List;

import javax.swing.JOptionPane;

import classes.Aviao;
import main.Calculo;

@SuppressWarnings("serial")
public class TTranslandar extends javax.swing.JFrame {
	private final TMain principal;
    private final List<Aviao> planes;
    
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnTranslate;
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    
    private javax.swing.JPanel pnlLayout;
    
    private javax.swing.JTextField txtX;
    private javax.swing.JTextField txtY;
    
    public TTranslandar(TMain main, List<Aviao> planes) {
    	initComponents();
    	
    	this.principal = main;
    	this.planes = planes;
    }
    
    private void initComponents() {
    	pnlLayout = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtX = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtY = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnTranslate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Translate");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Translandar");

        jLabel2.setText("X:");

        jLabel3.setText("Y:");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnTranslate.setText("Translate");
        btnTranslate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTranslateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLayoutLayout = new javax.swing.GroupLayout(pnlLayout);
        pnlLayout.setLayout(pnlLayoutLayout);
        pnlLayoutLayout.setHorizontalGroup(
            pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayoutLayout.createSequentialGroup()
                .addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayoutLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1))
                    .addGroup(pnlLayoutLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtX, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtY, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLayoutLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnTranslate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        pnlLayoutLayout.setVerticalGroup(
            pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayoutLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnTranslate))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLayout, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }
    
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }
    
    private void btnTranslateActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtX.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter the value of X.");
            txtX.selectAll();
            return;
        }
        
        if (txtY.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter the value of Y.");
            txtY.selectAll();
            return;
        }
        
        double x, y;
        
        try {
            x = Double.parseDouble(txtX.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Enter a valid value for X.");
            txtX.selectAll();
            return;
        }
        
        try {
            y = Double.parseDouble(txtY.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Enter a valid value for Y.");
            txtY.selectAll();
            return;
        }
        
        for (Aviao aviao : planes) {
        	 Calculo.transladar(aviao, x, y);		
		}       
        principal.updateTable();
        
        this.dispose();
    }
}
