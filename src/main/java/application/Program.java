package application; // pacote da aplicação

import view.Menu; // importa a classe Menu do pacote view

public class Program { // classe principal do programa

    public static void main(String[] args) { // método principal que inicia a aplicação
        Menu menu = new Menu(); // cria um novo objeto Menu
        menu.setVisible(true); // torna o menu visível para o usuário
    }
}
