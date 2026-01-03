package org.will;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.input.KeyCode;

import java.awt.Desktop;

public class MainController {
    @FXML
    private ListView<File> lista, pastas, sub;

    private Set<File> selected = new HashSet<>();

    // Diretório onde estará os HQ's
    File dir = new File("HQ_Files");

    @FXML
    private void initialize() throws IOException {
        System.out.println("Iniciando...");

        // Adiciona todos os itens (Pastas, subpastas e arquivos) ao iniciar o programa
        pastas.setItems(FXCollections.observableArrayList(dir));

        LeitorSubpastas subpastas = new LeitorSubpastas();
        sub.setItems(subpastas.getContent());

        sub.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                LeitorArquivos leitorArquivos = new LeitorArquivos(newVal);
                lista.setItems(leitorArquivos.getContent());
            }
        });

        // Evento para entrar nos arquivos
        lista.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                File archiveSelected = lista.getSelectionModel().getSelectedItem();

                if (archiveSelected != null) {
                    abrirArquivo(archiveSelected);
                }
            }
        });

        // Evento de deletar pastas
        sub.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.DELETE) {
                File archiveSelected = sub.getSelectionModel().getSelectedItem();

                if (archiveSelected != null) {
                    excluir(archiveSelected);
                }
            }
        });

        // Evento de deletar arquivos
        lista.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.DELETE) {
                File archiveSelected = lista.getSelectionModel().getSelectedItem();

                if (archiveSelected != null) {
                    excluir(archiveSelected);
                }
            }
        });

        // Adicionar imagens aos arquivos
        lista.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(File item, boolean empty) {
            super.updateItem(item, empty); 

            if (empty || item == null) {
                setText(null);
            } else {
                setText("📄 " + item.getName());
            }

            }
        });

        // Adicionar imagens às pastas
        sub.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(File item, boolean empty) {
            super.updateItem(item, empty); 

            if (empty || item == null) {
                setText(null);
            } else {
                setText("📁 " + item.getName());
            }

            }
        });
    }


    // eventos de botões ---------------------


    @FXML // Atualiza a lista de pastas e de arquivos
    private void cadastrar(ActionEvent event) throws IOException {
        System.out.println("Cadastrando...");

        pastas.setItems(FXCollections.observableArrayList(dir));

        LeitorSubpastas subpastas = new LeitorSubpastas();
        sub.setItems(subpastas.getContent());
    }

    @FXML // Deleta pastas ou arquivos selecionados
    private void excluir(ActionEvent event) {
        System.out.println("Excluindo...");
        File archiveSelected = lista.getSelectionModel().getSelectedItem();
        delete(archiveSelected);
    }

    @FXML
    private void visto() {
        File selecionado = lista.getSelectionModel().getSelectedItem();

        if (selecionado != null) {
            selected.add(selecionado);  
            lista.refresh();
        }
    }

        lista.setCellFactory(lv -> new ListCell<>() {
        @Override
        protected void updateItem(File item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setText(null);
            } else {
                String icon = item.isDirectory() ? "📁 " : "📄 ";
                String confere =  "✅";

                setText(icon + item.getName() + confere);
            }
        }
    });


    // classes a parte --------------------------


    // Classe para abrir arquivos selecionados
    private void abrirArquivo(File archive) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(archive);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Classe para executar comando de deletar arquivos e pastas
    private void excluir(File archive) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Excluir");
        alert.setHeaderText("Deseja realmente excluir este item?");
        alert.setContentText(archive.getName());

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            boolean deletado = archive.delete();

            if (deletado) {
                delete(archive);
                lista.getItems().remove(archive);
            } else {
                System.out.println("Não foi possível deletar");
            }
        }
    }

    private void delete(File file) {
        if (file.isDirectory()) {
            File[] filhos = file.listFiles();
            if (filhos != null) {
                for (File f : filhos) {
                    delete(f);
                }
            }
        }
        file.delete();
    }
}
