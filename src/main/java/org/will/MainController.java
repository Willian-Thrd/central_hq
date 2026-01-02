package org.will;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {
    private static <T> void print(T txt) {
        System.out.println(txt);
    }

    @FXML
    private void initializa() {
    
    }

    @FXML
    private void cadastrar(ActionEvent event) {
        System.out.println("Cadastrando...");
    }

    @FXML
    private void excluir(ActionEvent event) {
        System.out.println("Excluindo...");
    }
}
