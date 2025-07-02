/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package codigo;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;

/**
 *
 * @author MND
 */
public class FrmPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmPrincipal.class.getName());

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
    }
    
private void analizarLexico() throws IOException {
    int cont = 1;
    String expr = txtCodigo.getText();
    Lexer lexer = new Lexer(new StringReader(expr));
    String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";

    while (true) {
        Tokens token = lexer.yylex();
        if (token == null) {
            txtLexico.setText(resultado);
            return;
        }

        switch (token) {
            case Linea:
                cont++;
                resultado += "LINEA " + cont + "\n";
                break;
            case INI:
                resultado += "  <Reservada INI>\t\t" + lexer.lexeme + "\n";
                break;
            case FIN:
                resultado += "  <Reservada FIN>\t\t" + lexer.lexeme + "\n";
                break;
            case REPEAT:
                resultado += "  <Reservada REPEAT>\t" + lexer.lexeme + "\n";
                break;
            case CHECK:
                resultado += "  <Reservada CHECK>\t" + lexer.lexeme + "\n";
                break;
            case INTER:
                resultado += "  <Reservada INTER>\t" + lexer.lexeme + "\n";
                break;
            case PRINT:
                resultado += "  <Reservada PRINT>\t" + lexer.lexeme + "\n";
                break;
            case ELSE:
                resultado += "  <Reservada ELSE>\t" + lexer.lexeme + "\n";
                break;
            case WHILE:
                resultado += "  <Reservada WHILE>\t" + lexer.lexeme + "\n";
                break;
            case FOR:
                resultado += "  <Reservada FOR>\t\t" + lexer.lexeme + "\n";
                break;
            case FUNCTION:
                resultado += "  <Reservada FUNCTION>\t" + lexer.lexeme + "\n";
                break;
            case RETURN:
                resultado += "  <Reservada RETURN>\t" + lexer.lexeme + "\n";
                break;
            case INT:
                resultado += "  <Reservada INT>\t\t" + lexer.lexeme + "\n";
                break;
            case LANG:
                resultado += "  <Reservada LANG>\t" + lexer.lexeme + "\n";
                break;
            case ARRAY:
                resultado += "  <Reservada ARRAY>\t" + lexer.lexeme + "\n";
                break;
            case Igual:
                resultado += "  <Asignación = >\t" + lexer.lexeme + "\n";
                break;
            case Igual_Comparacion:
                resultado += "  <Comparación == >\t" + lexer.lexeme + "\n";
                break;
            case Diferente:
                resultado += "  <Comparación != >\t" + lexer.lexeme + "\n";
                break;
            case Menor:
                resultado += "  <Comparación < >\t" + lexer.lexeme + "\n";
                break;
            case Mayor:
                resultado += "  <Comparación > >\t" + lexer.lexeme + "\n";
                break;
            case Menor_Igual:
                resultado += "  <Comparación <= >\t" + lexer.lexeme + "\n";
                break;
            case Mayor_Igual:
                resultado += "  <Comparación >= >\t" + lexer.lexeme + "\n";
                break;
            case AND:
                resultado += "  <Operador lógico AND>\t" + lexer.lexeme + "\n";
                break;
            case OR:
                resultado += "  <Operador lógico OR>\t" + lexer.lexeme + "\n";
                break;
            case Suma:
                resultado += "  <Suma>\t\t" + lexer.lexeme + "\n";
                break;
            case Resta:
                resultado += "  <Resta>\t\t" + lexer.lexeme + "\n";
                break;
            case Multiplicacion:
                resultado += "  <Multiplicación>\t" + lexer.lexeme + "\n";
                break;
            case Division:
                resultado += "  <División>\t\t" + lexer.lexeme + "\n";
                break;
            case Modulo:
                resultado += "  <Módulo>\t\t" + lexer.lexeme + "\n";
                break;
            case Parentesis_A:
                resultado += "  <Paréntesis ( >\t\t" + lexer.lexeme + "\n";
                break;
            case Parentesis_C:
                resultado += "  <Paréntesis ) >\t\t" + lexer.lexeme + "\n";
                break;
            case Llave_Apertura:
                resultado += "  <Llave { >\t\t" + lexer.lexeme + "\n";
                break;
            case Llave_Cierre:
                resultado += "  <Llave } >\t\t" + lexer.lexeme + "\n";
                break;
            case PuntoYComa:
                resultado += "  <Punto y coma>\t" + lexer.lexeme + "\n";
                break;
            case Coma:
                resultado += "  <Coma>\t\t" + lexer.lexeme + "\n";
                break;
            case Identificador:
                resultado += "  <Identificador>\t\t" + lexer.lexeme + "\n";
                break;
            case Numero:
                resultado += "  <Número>\t\t" + lexer.lexeme + "\n";
                break;
            case ERROR:
                resultado += "  <Símbolo no definido>\n";
                break;
            default:
                resultado += "  < " + lexer.lexeme + " >\n";
                break;
        }
    }
}

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAbrir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLexico = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCodigo = new javax.swing.JTextArea();
        btnLimpiarSintactico = new javax.swing.JButton();
        btnAnalizarSintactico = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtSintactico = new javax.swing.JTextArea();
        btnLimpiarLexico = new javax.swing.JButton();
        btnAnalizarLexico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAbrir.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnAbrir.setText("Abrir archivo");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        txtLexico.setEditable(false);
        txtLexico.setColumns(20);
        txtLexico.setRows(5);
        jScrollPane1.setViewportView(txtLexico);

        txtCodigo.setColumns(20);
        txtCodigo.setRows(5);
        jScrollPane2.setViewportView(txtCodigo);

        btnLimpiarSintactico.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnLimpiarSintactico.setText("Limpiar");
        btnLimpiarSintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarSintacticoActionPerformed(evt);
            }
        });

        btnAnalizarSintactico.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnAnalizarSintactico.setText("Analizar");
        btnAnalizarSintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSintacticoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Analizador Sintáctico");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Analizador Lexico");

        txtSintactico.setColumns(20);
        txtSintactico.setRows(5);
        jScrollPane3.setViewportView(txtSintactico);

        btnLimpiarLexico.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnLimpiarLexico.setText("Limpiar");
        btnLimpiarLexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarLexicoActionPerformed(evt);
            }
        });

        btnAnalizarLexico.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnAnalizarLexico.setText("Analizar");
        btnAnalizarLexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarLexicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 23, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btnAnalizarSintactico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(149, 149, 149)
                                .addComponent(btnLimpiarSintactico)))
                        .addGap(8, 8, 8)))
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(btnAbrir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(364, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(295, 295, 295)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(711, 711, 711)
                    .addComponent(btnLimpiarLexico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(25, 25, 25)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(476, 476, 476)
                    .addComponent(btnAnalizarLexico)
                    .addContainerGap(254, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnAbrir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiarSintactico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAnalizarSintactico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(212, 212, 212)))
                .addGap(132, 132, 132))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel2)
                    .addContainerGap(840, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(btnLimpiarLexico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(786, 786, 786)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(btnAnalizarLexico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(786, 786, 786)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());

        try {
             String ST = new String(Files.readAllBytes(archivo.toPath()));
             txtCodigo.setText(ST);
        } catch (FileNotFoundException ex) {
            System.getLogger(FrmPrincipal.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(FrmPrincipal.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnLimpiarSintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarSintacticoActionPerformed
        // TODO add your handling code here:
        txtSintactico.setText(null);
        
    }//GEN-LAST:event_btnLimpiarSintacticoActionPerformed

    private void btnAnalizarSintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarSintacticoActionPerformed
        // TODO add your handling code here:
        String ST = txtCodigo.getText();
        Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        
        try {
            s.parse();
            txtSintactico.setText("Analisis realizado correctamente");
            txtSintactico.setForeground(new Color(25,111,61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtSintactico.setText("Error de sintaxis. Línea: " + (sym.right + 1) + " columna: " + (sym.left + 1) + ", Texto: \"" + sym.value +" \"" );
            txtSintactico.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnAnalizarSintacticoActionPerformed

    private void btnLimpiarLexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarLexicoActionPerformed
        // TODO add your handling code here:
        txtLexico.setText(null);
    }//GEN-LAST:event_btnLimpiarLexicoActionPerformed

    private void btnAnalizarLexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarLexicoActionPerformed
        try {
            // TODO add your handling code here:
            analizarLexico();
        } catch (IOException ex) {
            System.getLogger(FrmPrincipal.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_btnAnalizarLexicoActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAnalizarLexico;
    private javax.swing.JButton btnAnalizarSintactico;
    private javax.swing.JButton btnLimpiarLexico;
    private javax.swing.JButton btnLimpiarSintactico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtCodigo;
    private javax.swing.JTextArea txtLexico;
    private javax.swing.JTextArea txtSintactico;
    // End of variables declaration//GEN-END:variables
}
