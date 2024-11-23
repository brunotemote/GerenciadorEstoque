/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import model.dao.DaoFactory;
import model.dao.ProdutoDao;

import javax.swing.*;

public class RemoverProduto extends javax.swing.JFrame implements Navegacao{


    public RemoverProduto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textFieldRemover = new javax.swing.JTextField();
        buttonRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonVoltar.setText("Voltar");
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt, RemoverProduto.this);
            }
        });

        jLabel1.setText("Digite o Produto para remover");

        buttonRemover.setText("Remover");
        buttonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonVoltar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldRemover)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(24, 24, 24))
                            .addComponent(buttonRemover, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonVoltar)
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(textFieldRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void buttonRemoverActionPerformed(java.awt.event.ActionEvent evt) {
        String nome = textFieldRemover.getText();

        ProdutoDao produtoDao = DaoFactory.createProdutoDao();
        Integer rowsAffected = produtoDao.deleteByName(nome);

        if(rowsAffected <= 0){
            JOptionPane.showInternalMessageDialog(null, "Erro ao remover produto. Verifique se digitou corretamente.");
            return;
        }
        textFieldRemover.setText("");
        JOptionPane.showInternalMessageDialog(null, "Produto " + nome + " removido com sucesso!"   );


    }


    private javax.swing.JButton buttonRemover;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField textFieldRemover;
}
