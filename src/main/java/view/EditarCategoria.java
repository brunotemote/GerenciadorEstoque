/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import view.configuration.TypeSelectMenu;
import model.dao.CategoriaDao;
import model.dao.DaoFactory;
import view.configuration.ConfigurationComponents;

import javax.swing.*;


public class EditarCategoria extends javax.swing.JFrame implements Navegacao {

    public EditarCategoria() {
        initComponents();
        ConfigurationComponents.iniciationSelectMenu(selectMenuCategoria, TypeSelectMenu.CATEGORIA);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonVoltar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textFieldNovaDescricao = new javax.swing.JTextField();
        textFieldNovoNome = new javax.swing.JTextField();
        buttonAtualizar = new javax.swing.JButton();
        selectMenuCategoria = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome Categoria:");

        buttonVoltar.setText("Voltar");
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt, EditarCategoria.this);
            }
        });

        jLabel2.setText("Novo nome:");

        jLabel3.setText("Nova descricao:");

        buttonAtualizar.setText("Atualizar");
        buttonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtualizarActionPerformed(evt);
            }
        });

        selectMenuCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectMenuCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                        .addComponent(buttonVoltar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldNovaDescricao)
                            .addComponent(textFieldNovoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonAtualizar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(buttonVoltar)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(selectMenuCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textFieldNovoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textFieldNovaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAtualizar))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }


    private void buttonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectMenuCategoria.getSelectedIndex() == 0) {
            JOptionPane.showInternalMessageDialog(null, "Por favor selecione uma categoria para edicao.");
        }

        if (textFieldNovoNome.getText().equals("") && textFieldNovaDescricao.getText().equals("")) {
            JOptionPane.showInternalMessageDialog(null, "Por favor digite pelo menos um dos valores.");
            return;
        }

        String novoNome = textFieldNovoNome.getText();
        String novaDescricao = textFieldNovaDescricao.getText();

        CategoriaDao categoriaDao = DaoFactory.createCategoriaDao();
        int rowsAffected = categoriaDao.update(novoNome, novaDescricao , selectMenuCategoria.getSelectedItem().toString());

        if (rowsAffected <= 0) {
            JOptionPane.showInternalMessageDialog(null, "Erro ao atualizar categoria.");
            return;
        }

        textFieldNovoNome.setText("");
        textFieldNovaDescricao.setText("");

        JOptionPane.showInternalMessageDialog(null, "Categoria atualizada com sucesso!");

    }

    private javax.swing.JButton buttonAtualizar;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JComboBox<String> selectMenuCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField textFieldNovaDescricao;
    private javax.swing.JTextField textFieldNovoNome;
}
