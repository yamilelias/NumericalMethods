/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import newton.NewtonCalculator;

/**
 *
 * @author Yamil Elías
 */
public class GUINewtonMethod extends javax.swing.JFrame {

    NewtonCalculator calculator;
    /**
     * Creates new form GUINewtonMethod
     */
    public GUINewtonMethod() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        dataPanel = new javax.swing.JPanel();
        x_panel = new javax.swing.JPanel();
        x_value_label = new javax.swing.JLabel();
        x_value = new javax.swing.JTextField();
        err_panel = new javax.swing.JPanel();
        iter_value_label = new javax.swing.JLabel();
        iter_value = new javax.swing.JTextField();
        calculate = new javax.swing.JButton();
        x_values_panel = new javax.swing.JPanel();
        x_exp1_value = new javax.swing.JTextField();
        x_exp3_value = new javax.swing.JTextField();
        x_exp2_value = new javax.swing.JTextField();
        x_exp4_label = new javax.swing.JLabel();
        x_exp4_value = new javax.swing.JTextField();
        x_exp0_value = new javax.swing.JTextField();
        function_label = new javax.swing.JLabel();
        x_exp3_label = new javax.swing.JLabel();
        x_exp2_label = new javax.swing.JLabel();
        x_exp1_label = new javax.swing.JLabel();
        principalButton = new javax.swing.JButton();
        resultScrollpane = new javax.swing.JScrollPane();
        resultArea = new javax.swing.JTextArea();
        labelPanel = new javax.swing.JPanel();
        label_i = new javax.swing.JLabel();
        label_Xi = new javax.swing.JLabel();
        label_fx = new javax.swing.JLabel();
        label_fprime = new javax.swing.JLabel();
        label_error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titleLabel.setText("Newton");

        x_value_label.setText("x=");

        x_value.setText(" ");
        x_value.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x_valueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout x_panelLayout = new javax.swing.GroupLayout(x_panel);
        x_panel.setLayout(x_panelLayout);
        x_panelLayout.setHorizontalGroup(
            x_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(x_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(x_value_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(x_value, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        x_panelLayout.setVerticalGroup(
            x_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(x_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(x_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(x_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x_value_label))
                .addContainerGap())
        );

        iter_value_label.setText("Iteraciones =");

        iter_value.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iter_valueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout err_panelLayout = new javax.swing.GroupLayout(err_panel);
        err_panel.setLayout(err_panelLayout);
        err_panelLayout.setHorizontalGroup(
            err_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(err_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iter_value_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iter_value, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        err_panelLayout.setVerticalGroup(
            err_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(err_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(err_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iter_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iter_value_label))
                .addContainerGap())
        );

        calculate.setText("Calcular");
        calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateActionPerformed(evt);
            }
        });

        x_exp1_value.setText(" ");

        x_exp3_value.setText(" ");
        x_exp3_value.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x_exp3_valueActionPerformed(evt);
            }
        });

        x_exp2_value.setText(" ");

        x_exp4_label.setText("x^4  +");

        x_exp4_value.setText(" ");

        x_exp0_value.setText(" ");

        function_label.setText("f(x)=");

        x_exp3_label.setText("x^3  +");

        x_exp2_label.setText("x^2  +");

        x_exp1_label.setText("x  +");

        javax.swing.GroupLayout x_values_panelLayout = new javax.swing.GroupLayout(x_values_panel);
        x_values_panel.setLayout(x_values_panelLayout);
        x_values_panelLayout.setHorizontalGroup(
            x_values_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(x_values_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(function_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(x_exp4_value, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(x_exp4_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(x_exp3_value, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(x_exp3_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(x_exp2_value, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(x_exp2_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(x_exp1_value, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(x_exp1_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(x_exp0_value, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );
        x_values_panelLayout.setVerticalGroup(
            x_values_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(x_values_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(x_values_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(x_exp4_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x_exp3_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x_exp2_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x_exp1_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x_exp0_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x_exp4_label)
                    .addComponent(function_label)
                    .addComponent(x_exp3_label)
                    .addComponent(x_exp2_label)
                    .addComponent(x_exp1_label))
                .addContainerGap())
        );

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(x_values_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dataPanelLayout.createSequentialGroup()
                        .addComponent(x_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(calculate)
                        .addGap(18, 18, 18)
                        .addComponent(err_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(x_values_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(x_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(err_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataPanelLayout.createSequentialGroup()
                        .addComponent(calculate)
                        .addContainerGap())))
        );

        principalButton.setText("Principal");
        principalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                principalButtonActionPerformed(evt);
            }
        });

        resultArea.setEditable(false);
        resultArea.setColumns(20);
        resultArea.setRows(5);
        resultScrollpane.setViewportView(resultArea);

        label_i.setText("i");

        label_Xi.setText("Xi");

        label_fx.setText("f(x)");

        label_fprime.setText("f'(x)");

        label_error.setText("Error");

        javax.swing.GroupLayout labelPanelLayout = new javax.swing.GroupLayout(labelPanel);
        labelPanel.setLayout(labelPanelLayout);
        labelPanelLayout.setHorizontalGroup(
            labelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_i, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(label_Xi, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(label_fx, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135)
                .addComponent(label_fprime, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_error, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        labelPanelLayout.setVerticalGroup(
            labelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, labelPanelLayout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addGroup(labelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_i)
                    .addComponent(label_Xi)
                    .addComponent(label_fx)
                    .addComponent(label_fprime)
                    .addComponent(label_error)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(principalButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(titleLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resultScrollpane, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(principalButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultScrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void x_valueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x_valueActionPerformed

    }//GEN-LAST:event_x_valueActionPerformed

    private void iter_valueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iter_valueActionPerformed

    }//GEN-LAST:event_iter_valueActionPerformed

    private void calculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateActionPerformed

        String[] data = new String[6];

        if(x_exp0_value.getText()==null)
            x_exp0_value.setText("0");
        if(x_exp1_value.getText().equals(""))
            x_exp1_value.setText("0");
        if(x_exp2_value.getText().equals(""))
            x_exp2_value.setText("0");
        if(x_exp3_value.getText().equals(""))
            x_exp3_value.setText("0");
        if(x_exp4_value.getText().equals(""))
            x_exp4_value.setText("0");

        // Get data from Text Fields
        data[0] = x_value.getText();
        data[1] = x_exp0_value.getText();
        data[2] = x_exp1_value.getText();
        data[3] = x_exp2_value.getText();
        data[4] = x_exp3_value.getText();
        data[5] = x_exp4_value.getText();

        int iterations = Integer.parseInt(iter_value.getText());

        calculator = new NewtonCalculator(data, iterations);

        resultArea.setText(calculator.getResult());
    }//GEN-LAST:event_calculateActionPerformed

    private void x_exp3_valueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x_exp3_valueActionPerformed

    }//GEN-LAST:event_x_exp3_valueActionPerformed

    private void principalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_principalButtonActionPerformed
        GUI gui = new GUI();
        gui.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_principalButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calculate;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JPanel err_panel;
    private javax.swing.JLabel function_label;
    private javax.swing.JTextField iter_value;
    private javax.swing.JLabel iter_value_label;
    private javax.swing.JPanel labelPanel;
    private javax.swing.JLabel label_Xi;
    private javax.swing.JLabel label_error;
    private javax.swing.JLabel label_fprime;
    private javax.swing.JLabel label_fx;
    private javax.swing.JLabel label_i;
    private javax.swing.JButton principalButton;
    private javax.swing.JTextArea resultArea;
    private javax.swing.JScrollPane resultScrollpane;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField x_exp0_value;
    private javax.swing.JLabel x_exp1_label;
    private javax.swing.JTextField x_exp1_value;
    private javax.swing.JLabel x_exp2_label;
    private javax.swing.JTextField x_exp2_value;
    private javax.swing.JLabel x_exp3_label;
    private javax.swing.JTextField x_exp3_value;
    private javax.swing.JLabel x_exp4_label;
    private javax.swing.JTextField x_exp4_value;
    private javax.swing.JPanel x_panel;
    private javax.swing.JTextField x_value;
    private javax.swing.JLabel x_value_label;
    private javax.swing.JPanel x_values_panel;
    // End of variables declaration//GEN-END:variables
}
