package org.will;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Leitor {
    private ObservableList<File> content = FXCollections.observableArrayList();

    public Leitor(File dir) {
        leitorPastas(dir);
    }

    private void leitorPastas (File file) {
        File[] listFile = file.listFiles();
        if (listFile == null) return;

        for (File files : listFile) {
            if (files.isDirectory()) {
                content.add(files);
            }
        }
    }

    public ObservableList<File> getContent() {
        return content;
    }
}
