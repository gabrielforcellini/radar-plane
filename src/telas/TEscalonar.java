package telas;

import java.util.List;

import javax.swing.JOptionPane;

import classes.Aviao;
import main.Calculo;

public class TEscalonar extends javax.swing.JFrame {
    private final TMain principal;
    private final List<Aviao> planes;

    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnScale;
    private javax.swing.JLabel lblPercentX;
    private javax.swing.JLabel lblPercentY;
    private javax.swing.JLabel lblScale;
    private javax.swing.JPanel pnlLayout;
    private javax.swing.JTextField txtX;
    private javax.swing.JTextField txtY;

    public TEscalonar(TMain main, List<Aviao> planes) {
        initComponents();

        this.principal = main;
        this.planes = planes;
    }

    private void initComponents() {

        pnlLayout = new javax.swing.JPanel();
        pnlLayout.setPreferredSize(new java.awt.Dimension(400, 300));

        lblPercentX = new javax.swing.JLabel();
        lblPercentY = new javax.swing.JLabel();
        lblScale = new javax.swing.JLabel();

        lblPercentX.setText("X(%) :");
        lblPercentY.setText("Y(%) :");
        lblScale.setFont(new java.awt.Font("Arial", 1, 14));
        lblScale.setText("Escalonar");

        txtX = new javax.swing.JTextField();
        txtY = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Escalonar");

        btnScale = new javax.swing.JButton();
        btnScale.setText("Escalonar");
        btnScale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScaleActionPerformed(evt);
            }
        });

        btnCancel = new javax.swing.JButton();
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLayoutLayout = new javax.swing.GroupLayout(pnlLayout);
        pnlLayout.setLayout(pnlLayoutLayout);
        pnlLayoutLayout.setHorizontalGroup(
                pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlLayoutLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlLayoutLayout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(btnScale)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnCancel))
                                        .addGroup(pnlLayoutLayout.createSequentialGroup()
                                                .addComponent(lblPercentX)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtX, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblPercentY)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtY, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(49, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLayoutLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblScale)
                                .addGap(119, 119, 119)));
        pnlLayoutLayout.setVerticalGroup(
                pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlLayoutLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lblScale)
                                .addGap(18, 18, 18)
                                .addGroup(
                                        pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblPercentX)
                                                .addComponent(txtX, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblPercentY)
                                                .addComponent(txtY, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(
                                        pnlLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnScale)
                                                .addComponent(btnCancel))
                                .addContainerGap(90, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 318,
                                javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
        setLocationRelativeTo(null);
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void btnScaleActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtX.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe um valor para X.");
            txtX.selectAll();
            return;
        }

        if (txtY.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe um valor para Y.");
            txtY.selectAll();
            return;
        }

        double x, y;

        try {
            x = Double.parseDouble(txtX.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Informe um valor válido para X.");
            txtX.selectAll();
            return;
        }

        try {
            y = Double.parseDouble(txtY.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Informe um valor válido para Y.");
            txtY.selectAll();
            return;
        }

        for (Aviao aviao : planes) {
            Calculo.escalonar(aviao, x, y);
            principal.updateTable();
        }

        this.dispose();
    }
}
