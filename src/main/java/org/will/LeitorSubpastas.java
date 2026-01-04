package org.will;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LeitorSubpastas {
    private ObservableList<File> content = FXCollections.observableArrayList();
    private int nivelInicial = 2;

    public LeitorSubpastas(File dir, int nivel) {
        this.nivelInicial = nivel;
        subpastas(dir, 0);
    }

    private void subpastas (File sub, int nivel) {
        File[] listFile = sub.listFiles();
        if (listFile == null) return;

        for (File files : listFile) {
            if (files.isDirectory()) {

                if (nivel >= nivelInicial) {
                    content.add(files);
                }
                subpastas(files, nivel + 1);
            }
        }
    }

    public ObservableList<File> getContent() {
        return content;
    }
}
