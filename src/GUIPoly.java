/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextArea;
import polynomial.Pair;
import polynomial.MatrixFunctions;

/**
 *
 * @author Yamil Elías
 */
public final class GUIPoly extends javax.swing.JFrame {

    private boolean applet = true;
    String nameVersion = "Regresión Polinomial"; //Aquí está el nombre de la aplicación
    public String pageData;
    public String errorMsg = "";
    public boolean data_valid = false;
    public int poly_order = 2;
    public double xmin;
    public double xmax;
    public double ymin;
    public double ymax;
    public double dataXmin;
    public double dataXmax;
    public double dataYmin;
    public double dataYmax;
    public double eps;
    public int listingForm = 1;
    public boolean error;
    public boolean reverseMode = false;
    //private final String defaultData = "-1 -1\n0 3\n1 2.5\n2 5\n3 4\n5 2\n7 5\n9 4\n"; //Aquí está la información que viene por default en el programa
    ArrayList<Pair> userDataList;
    ArrayList<Double> terms;
    double result_cc;
    double result_se;
    
    /**
     * Creates new form GUIPoly
     */
    public GUIPoly() {
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

        resultScrollPane = new javax.swing.JScrollPane();
        resultTextArea = new javax.swing.JTextArea();
        inputScrollPane = new javax.swing.JScrollPane();
        inputTextArea = new javax.swing.JTextArea();
        principalButton = new javax.swing.JButton();
        ValuesPanel = new javax.swing.JPanel();
        GradePanel = new javax.swing.JPanel();
        gradeField = new javax.swing.JSpinner();
        gradeLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        resultTextArea.setColumns(20);
        resultTextArea.setRows(5);
        resultScrollPane.setViewportView(resultTextArea);

        inputTextArea.setColumns(20);
        inputTextArea.setRows(5);
        inputTextArea.setText("1 2\n3 4\n2 3\n-1 2\n2 2");
        inputScrollPane.setViewportView(inputTextArea);

        principalButton.setText("Principal");
        principalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                principalButtonActionPerformed(evt);
            }
        });

        gradeField.setModel(new javax.swing.SpinnerNumberModel(2, 1, 512, 1));
        gradeField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gradeField.setOpaque(false);

        gradeLabel.setText("Grado de la función");

        javax.swing.GroupLayout GradePanelLayout = new javax.swing.GroupLayout(GradePanel);
        GradePanel.setLayout(GradePanelLayout);
        GradePanelLayout.setHorizontalGroup(
            GradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GradePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GradePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(gradeLabel)
                        .addGap(26, 26, 26))
                    .addComponent(gradeField))
                .addContainerGap())
        );
        GradePanelLayout.setVerticalGroup(
            GradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GradePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gradeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gradeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ValuesPanelLayout = new javax.swing.GroupLayout(ValuesPanel);
        ValuesPanel.setLayout(ValuesPanelLayout);
        ValuesPanelLayout.setHorizontalGroup(
            ValuesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ValuesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(ValuesPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(GradePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        ValuesPanelLayout.setVerticalGroup(
            ValuesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ValuesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GradePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(principalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(ValuesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 67, Short.MAX_VALUE))))
                    .addComponent(resultScrollPane))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(inputScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(principalButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ValuesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addComponent(resultScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        process(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void principalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_principalButtonActionPerformed
        GUI gui = new GUI();
        gui.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_principalButtonActionPerformed

    
    /**
     * Method to create pairs from the input the user gave
     */
    void readData() {
        String s; // Aux String
        this.userDataList = new ArrayList(); // ArrayList<Pair> object
        double x = 0.0;
        double y = 0.0;
        double q = 0.0;
        
        s = this.inputTextArea.getText(); // Get the text from the TextArea
            
        try {
            s = s.replaceAll("[^\\.0-9eE+-]+", " ").trim();
            String[] num_array = s.split(" "); // Split values into an String Array
            boolean paired = true;
            for (String qs : num_array) { // For every spot in the array...
                if (qs.equalsIgnoreCase("e")) continue; //If the string is equal to "e" (no mather the Case) continue to next iteration
                try {
                    q = Double.valueOf(qs); // Similar to Double.parseDouble()
                }
                catch (Exception e) {
                    String es = "";
                    es = qs.length() == 0 ? "No hay información." : "No se puede parsear \"" + qs + "\" en la entrada.";
                    // If qs.length() == 0... TRUE: "No hay información." | FALSE: "No se puede parsear \"" + qs + "\" en la entrada."
                    throw new Exception(es);
                }
                if (paired) { // ?
                    x = q;
                } else {
                    y = q;
                    if (this.reverseMode) { // If reverse mode is on, then change variables
                        double t = x;
                        x = y;
                        y = t;
                    }
                    this.userDataList.add(new Pair(x, y)); // Add new pair to the ArrayList
                    
                    //Find the maximum X and Y, also their minimum
                    this.ymin = Math.min(y, this.ymin);
                    this.ymax = Math.max(y, this.ymax);
                    this.xmin = Math.min(x, this.xmin);
                    this.xmax = Math.max(x, this.xmax);
                }
                paired = !paired; // Revert the value (If it was true, then false and viceversa)
            }
            if (!paired) {
                String exc = "La informacion no esta en pares de x,y favor de editarla.";
                this.writeResult(exc, this.resultTextArea);
                throw new Exception("La informacion no esta en pares de x,y favor de editarla.");
            }
        }
        catch (Exception e) {
            this.data_valid = false;
            this.errorMsg = e.getMessage();
            this.userDataList.clear();
        }
    }

    /**
     * Change xmin, xmax, ymin and ymax values
     */
    void getData(boolean update) {
        this.eps = 1.0E-12;
        this.ymin = this.xmin = 1.0E30; // Set xmin and ymin to 1.0E30
        this.ymax = this.xmax = 1.0E-30; // Set ymax and xmax to 1.0E-30
        this.readData();
        int n = this.userDataList.size(); // Size of pairs ArrayList
        if (n > 0) { // If is not empty
            if (Math.abs(this.xmin - this.xmax) < 0.001) {
                this.xmin -= 0.001;
                this.xmax += 0.001;
            }
            if (Math.abs(this.ymin - this.ymax) < 0.001) {
                this.ymin -= 0.001;
                this.ymax += 0.001;
            }
            this.dataXmax = this.xmax;
            this.dataXmin = this.xmin;
            this.dataYmax = this.ymax;
            this.dataYmin = this.ymin;
            /*if (update) { // If update is true, then change TextArea
                this.tableStartTextField.setText(String.format("%.2f", this.dataXmin));
                this.tableEndTextField.setText(String.format("%.2f", this.dataXmax));
                double step = (this.dataXmax - this.dataXmin) / 20.0;
                this.tableStepSizeTextField.setText(String.format("%.2f", step));
            }*/
            double q = (this.ymax - this.ymin) / 6.0;
            this.ymin -= q;
            this.ymax += q;
            q = (this.xmax - this.xmin) / 6.0;
            this.xmin -= q;
            this.xmax += q;
        }
    }

    /**
     *  This method is only to print in console
     */
    void p(String s) {
        System.out.println(s);
    }

    public void process(boolean update) {
        this.data_valid = false;
        this.errorMsg = "";
        this.getData(update);
        int size = this.userDataList.size();
        if (size > 1) {
            this.terms = MatrixFunctions.compute_coefficients(this.userDataList, this.poly_order);
            this.result_cc = MatrixFunctions.corr_coeff(this.userDataList, this.terms);
            this.result_se = MatrixFunctions.std_error(this.userDataList, this.terms);
            String r = this.showResult();
            this.writeResult(r, this.resultTextArea);
            this.data_valid = true;
        } else {
            this.data_valid = false;
            if (this.errorMsg.length() == 0) {
                this.errorMsg = "Información insuficiente para realizar cálculos (mínimo dos pares de datos necesarios)";
                this.writeResult(errorMsg, this.resultTextArea);
            }
            this.writeResult("", this.resultTextArea);
        }
    }

    private void writeResult(String s, JTextArea jta) {
            jta.setText(s);
    }

    void newDegree(int v) {
        this.poly_order += v;
        this.poly_order = this.poly_order < 0 ? 0 : this.poly_order;
        this.process(false);
    }

    void setDegree(int v) {
        this.poly_order = v;
        this.newDegree(0);
    }

    String formatNum(double n, boolean wide) {
        String w = wide ? "21" : "";
        return String.format("%" + w + ".12e", n);
    }

    String showResult() {
        int n = this.userDataList.size();
        String r = "Resultado \n\n";
        r += "Grado del polinomio " + this.poly_order; 
        r += "\n" + n + " Pares de x,y brindados\n\n";
        r += "(r^2) = " + this.formatNum(this.result_cc, false) + "\n\n";
        r += "f(x) =";
        for (int i = 0; i <= this.poly_order; ++i) {
            double a = this.terms.get(i);
            if (i > 0) {
                if (this.listingForm > 1) {
                    r = r + "    ";
                }
                if (this.listingForm > 0) {
                    r = r + "     +";
                }
            }
            r = r + this.formatNum(a, true);
            if (i == 1 && this.listingForm > 0) {
                r = r + " * x";
            }
            if (i >= this.poly_order) continue;
            r = r + "\n";
        }
        if (this.listingForm > 1) {
            r = r + ";\n}";
        }
        if (this.poly_order > n - 1) {
            r = r + "\n\nPrecaución: El grado del polinomio es demasiado grande para la cantidad de datos.";
        }
        return r;
    }

    void show_mat(double[][] data) {
        double[][] arr$ = data;
        int len$ = arr$.length;
        for (int i$ = 0; i$ < len$; ++i$) {
            double[] y;
            for (double x : y = arr$[i$]) {
                System.out.printf("%25.16g,", x);
            }
            System.out.println("");
        }
        System.out.println("***************");
    }

    double findRoot2(double y, double x, ArrayList<Double> terms, double scale) {
        int max = 256;
        boolean positive = true;
        double epsilon = 1.0E-8;
        double dy = 0.0;
        double ody = Double.NaN;
        while (Math.abs(dy = MatrixFunctions.regress(x, terms) - y) > epsilon && max-- > 0 && !Double.isInfinite(x)) {
            if (!Double.isNaN(ody) && Math.abs(dy) > ody) {
                positive = !positive;
            }
            ody = Math.abs(dy);
            x += positive ? dy : - (dy *= scale);
        }
        if (max <= 0 || Double.isInfinite(x)) {
            x = Double.NaN;
        }
        return x;
    }

    double findRoot(double y, double x, ArrayList<Double> terms) {
        double rx;
        double scale = Math.pow(2.0, -32.0);
        int max = 64;
        while (Double.isNaN(rx = this.findRoot2(y, x, terms, scale)) && max-- > 0) {
            scale *= 2.0;
        }
        return rx;
    }

    double plotFunct(double x) {
        return MatrixFunctions.regress(x, this.terms);
    }
 
    double ntrp(double xa, double xb, double ya, double yb, double x) {
        return (x - xa) * (yb - ya) / (xb - xa) + ya;
    }

    String generateRow(double a, double p, double b, int places) {
        double pct = this.ntrp(a, b, 0.0, 100.0, p);
        double y = MatrixFunctions.regress(p, this.terms);
        String format = String.format("%%.%df,%%.%df,%%.%df\n", places, places, places);
        String row = String.format(format, p, y, pct);
        return row;
    }

    /*public void generateTable() {
        try {
            String newRow;
            double a = Double.parseDouble(this.tableStartTextField.getText());
            double b = Double.parseDouble(this.tableEndTextField.getText());
            double stepSize = Double.parseDouble(this.tableStepSizeTextField.getText());
            int places = Integer.parseInt(this.decimalPlacesTextField.getText());
            if (stepSize <= 0.0) {
                throw new Exception("Step size must be > 0");
            }
            double lp = 0.0;
            StringBuilder sb = new StringBuilder();
            String oldRow = "";
            sb.append("x,y,%\n");
            for (double p = a; p <= b; p += stepSize) {
                lp = p;
                oldRow = this.generateRow(a, p, b, places);
                sb.append(oldRow);
            }
            if (lp < b && !oldRow.equals(newRow = this.generateRow(a, b, b, places))) {
                sb.append(newRow);
            }
            this.writeResult(sb.toString(), this.tableResultTextArea);
        }
        catch (Exception e) {
            this.writeResult(e.toString(), this.tableResultTextArea);
        }
    }*/
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIPoly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPoly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPoly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPoly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPoly().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GradePanel;
    private javax.swing.JPanel ValuesPanel;
    private javax.swing.JSpinner gradeField;
    private javax.swing.JLabel gradeLabel;
    private javax.swing.JScrollPane inputScrollPane;
    private javax.swing.JTextArea inputTextArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton principalButton;
    private javax.swing.JScrollPane resultScrollPane;
    private javax.swing.JTextArea resultTextArea;
    // End of variables declaration//GEN-END:variables
} // End of GUIPoly

/*
class MyDocumentListener implements DocumentListener {
    MyDocumentListener() {}

    public void insertUpdate(DocumentEvent e) {
        GUIPoly.this.process(true);
    }

    public void removeUpdate(DocumentEvent e) {
        GUIPoly.this.process(true);
    }

    public void changedUpdate(DocumentEvent e) {
        GUIPoly.this.process(true);
    }
}*/
