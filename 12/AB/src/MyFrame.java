
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author adcerro
 */
public class MyFrame extends javax.swing.JFrame {

    private ABin tree = new ABin();

    /**
     * Creates new form MyFrame
     */
    public MyFrame() {
        initComponents();
    }
    int expansions = 1, firstX = 300, firstY = 20;

    /**
     * the following method draws a tree given it's starting position, the root
     * and the space in between nodes
     *
     * @author sachin uptail
     * https://coderanch.com/t/558985/java/Draw-binary-tree-structure
     */
    public void drawTree(NodoArbol nodo, int x, int y, Graphics g, int space) {

        g.drawOval(x - 10, y - 10, 2 * 10, 2 * 10);
        if (nodo != null) {
            g.setColor(Color.black);
            g.drawString(nodo.dato + "", x - 6, y + 4);
        }
        if (nodo.izq != null) {
            g.setColor(Color.blue);
            hIzq(g, x - space, y + space, x, y, space);
            g.setColor(Color.BLACK);
            drawTree(nodo.izq, x - space, y + space, g, space / 2);
        }
        if (nodo.der != null) {
            g.setColor(Color.blue);
            hDer(g, x + space, y + space, x, y, space);
            g.setColor(Color.BLACK);
            drawTree(nodo.der, x + space, y + space, g, space / 2);
        }
        if (x >= this.getSize().width - 20) {
            this.setSize(this.getSize().width + 150, this.getSize().height + 150);
            space = 140 + 25 * expansions;
            expansions++;
            firstX += 100;
            drawTree(tree.Raiz, firstX, firstY, g, space);
        }
    }

    /**
     * @author sachin uptail
     * https://coderanch.com/t/558985/java/Draw-binary-tree-structure
     */
    private void hIzq(Graphics g, int x1, int y1, int x2, int y2, int space) {
        double d = Math.sqrt(space * space + (x2 - x1) * (x2 - x1));
        int x11 = (int) (x1 + 10 * (x2 - x1) / d);
        int y11 = (int) (y1 - 10 * space / d);
        int x21 = (int) (x2 - 10 * (x2 - x1) / d);
        int y21 = (int) (y2 + 10 * space / d);
        g.drawLine(x11, y11, x21, y21);
    }

    /**
     * @author sachin uptail
     * https://coderanch.com/t/558985/java/Draw-binary-tree-structure
     */
    private void hDer(Graphics g, int x1, int y1, int x2, int y2, int space) {
        double d = Math.sqrt(space * space + (x2 - x1) * (x2 - x1));
        int x11 = (int) (x1 - 10 * (x1 - x2) / d);
        int y11 = (int) (y1 - 10 * space / d);
        int x21 = (int) (x2 + 10 * (x1 - x2) / d);
        int y21 = (int) (y2 + 10 * space / d);
        g.drawLine(x11, y11, x21, y21);
    }

    public void nodeAdder() {
        String data = nodeField.getText();
        int valid = 1;
        int dataInt = 0;
        try {
            dataInt = Integer.parseInt(data);
        } catch (Exception e) {
            statusLabel.setText("Status: Dato no aceptado");
            valid = 0;
        }
        if (tree.contains(Integer.parseInt(data), tree.Raiz)) {
            statusLabel.setText("Status: Dato ya existente");
            valid = 0;
        }
        if (valid != 0) {
            statusLabel.setText("Status: Añadido");
            tree.insertarNodo(dataInt);
            drawTree(tree.Raiz, firstX, firstY, panel.getGraphics(), 150);
        }
    }

    public void stringToList(String str) {
        ListaEnlazada list = new ListaEnlazada();
        String[] vec = str.split("->");
        for (int i = 0; i < vec.length; i++) {
            list.insertarNodo(Integer.parseInt(vec[i]));
        }
    }

    public void levelGetter() {
        int level = ((SpinnerNumberModel) levelSpinner.getModel()).getNumber().intValue();
        if (level > tree.altura(tree.Raiz) || level < 0) {
            statusLabel.setText("Status: Level doesn't exist");
        } else {
            levelLabel.setText("Lista: " + tree.getNodesFromLevel(tree.Raiz, tree.Raiz, level));
            stringToList(tree.getNodesFromLevel(tree.Raiz, tree.Raiz, level));
        }

    }

    public void uncleFinder() {
        String data = uncleField.getText();
        int valid = 1;
        int dataInt = 0;
        try {
            dataInt = Integer.parseInt(data);
        } catch (Exception e) {
            statusLabel.setText("Status: Dato no aceptado");
            valid = 0;
        }
        if (!tree.contains(Integer.parseInt(data), tree.Raiz)) {
            statusLabel.setText("Status: Dato inexistente");
            valid = 0;
        }
        if (valid != 0) {
            int elem = tree.buscarTio(dataInt).dato;
            uncleLabel.setText("Tio: " + elem);
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

        jPanel1 = new javax.swing.JPanel();
        insertButton = new javax.swing.JButton();
        nodeField = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        levelButton = new javax.swing.JButton();
        levelSpinner = new javax.swing.JSpinner();
        levelLabel = new javax.swing.JLabel();
        destroyButton = new javax.swing.JButton();
        uncleButton = new javax.swing.JButton();
        uncleField = new javax.swing.JTextField();
        uncleLabel = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        insertButton.setText("Insertar Elemento");
        insertButton.setFocusable(false);
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        nodeField.setToolTipText("Type a number here");
        nodeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nodeFieldKeyReleased(evt);
            }
        });

        statusLabel.setText("Status:");
        statusLabel.setToolTipText("");

        levelButton.setText("Obtener nodos del nivel");
        levelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelButtonActionPerformed(evt);
            }
        });

        levelSpinner.setToolTipText("Please, pick a level from the tree (starting from 0)");
        levelSpinner.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                levelSpinnerKeyReleased(evt);
            }
        });

        destroyButton.setText("Destruir arbol");
        destroyButton.setFocusable(false);
        destroyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destroyButtonActionPerformed(evt);
            }
        });

        uncleButton.setText("Encontrar tio");
        uncleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uncleButtonActionPerformed(evt);
            }
        });

        uncleField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                uncleFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(uncleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(levelButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(insertButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nodeField, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(levelSpinner)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(uncleField)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(uncleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addComponent(destroyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                        .addComponent(levelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(insertButton)
                        .addComponent(nodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(levelButton)
                    .addComponent(levelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(levelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uncleButton)
                            .addComponent(uncleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(uncleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(destroyButton))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        nodeAdder();
        nodeField.setText("");
    }//GEN-LAST:event_insertButtonActionPerformed

    private void nodeFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nodeFieldKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            nodeAdder();
            nodeField.setText("");
        }
    }//GEN-LAST:event_nodeFieldKeyReleased

    private void levelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelButtonActionPerformed
        levelGetter();
    }//GEN-LAST:event_levelButtonActionPerformed

    private void levelSpinnerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_levelSpinnerKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            levelGetter();
        }
    }//GEN-LAST:event_levelSpinnerKeyReleased

    private void destroyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destroyButtonActionPerformed
        tree.EliminarArbol();
        //drawTree(tree.Raiz, firstX, firstY, panel.getGraphics(), 150);
    }//GEN-LAST:event_destroyButtonActionPerformed

    private void uncleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uncleButtonActionPerformed
        uncleFinder();
        uncleField.setText("");
    }//GEN-LAST:event_uncleButtonActionPerformed

    private void uncleFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uncleFieldKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            uncleFinder();
            uncleField.setText("");
        }
    }//GEN-LAST:event_uncleFieldKeyReleased

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
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton destroyButton;
    private javax.swing.JButton insertButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton levelButton;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JSpinner levelSpinner;
    private javax.swing.JTextField nodeField;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton uncleButton;
    private javax.swing.JTextField uncleField;
    private javax.swing.JLabel uncleLabel;
    // End of variables declaration//GEN-END:variables
}
