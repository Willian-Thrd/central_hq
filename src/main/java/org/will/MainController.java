package org.will;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class MainController {
    @FXML
    private ListView<File> lista;

    @FXML
    private void initialize() throws IOException {
        System.out.println("Iniciando...");
    }

    @FXML
    private void cadastrar(ActionEvent event) throws IOException {
        System.out.println("Cadastrando...");
    }

    @FXML
    private void excluir(ActionEvent event) {
        System.out.println("Excluindo...");
    }

    // Elementos não FXML

    
}
