package org.will;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class MainController {
    ObservableList<Files> content = FXCollections.observableArrayList();
    ListView<Files> lista;
    
    Path caminho = Paths.get("HQ_Files");

    @FXML
    private void initialize() throws IOException {
        System.out.println("Iniciando...");
        content.add(Files.exists(caminho));
        addArchive( null, content);
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

    private void addArchive(Files file, ObservableList<Files> list) {
        ObservableList<Files> archives = FXCollections.observableArrayList();
        
        for (Files contents : list) {
            archives.add(contents);
        }

        lista.setItems(archives);
    } 
    
}
