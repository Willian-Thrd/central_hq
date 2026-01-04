package org.will;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Leitor {
    ObservableList<File> content = FXCollections.observableArrayList();
    File dir = new File("HQ_Files");

    public Leitor() {
        leitorPastas(dir);
    }

    public void leitorPastas (File file) {
        File[] listFile = dir.listFiles();
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
