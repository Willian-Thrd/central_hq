package org.will;

import java.nio.file.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class MainController {
    private static <T> void print(T txt) {
        System.out.println(txt);
    }

    @FXML
    private void initializa() {
        Path arquivo = Paths.get("/d %~dp0/HQ_Files");

        if (Files.notExists(arquivo)) {
            try {
                Files.createDirectory(arquivo);
                print("Pasta criada com sucesso.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
