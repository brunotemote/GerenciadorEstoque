package view;

import javax.swing.*;

public interface Navegacao {

    default void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt, JFrame frame) {
        Menu menu = new Menu();
        menu.setVisible(true);
        frame.dispose();
    }
}
