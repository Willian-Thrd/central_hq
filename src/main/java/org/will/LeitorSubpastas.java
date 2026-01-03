package org.will;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LeitorSubpastas {
    ObservableList<File> content = FXCollections.observableArrayList();
    File dir = new File("HQ_Files");

    public LeitorSubpastas() {
        Subpastas(dir);
    }

    public void Subpastas (File sub) {
        File[] listFile = sub.listFiles();
        if (listFile == null) return;

        for (File files : listFile) {

            if (files.isDirectory()) {
                content.add(files);
                Subpastas(files);
            }
        }
    }

    public ObservableList<File> getContent() {
        return content;
    }
}
