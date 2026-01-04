package org.will;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LeitorArquivos {
    private ObservableList<File> content = FXCollections.observableArrayList();

    public LeitorArquivos(File dir) {
        arquivos(dir);
    }

    private void arquivos(File archives) {
        File[] listFiles = archives.listFiles();
        if (listFiles == null) return;

        for (File f : listFiles) {

            if (f.isFile()) {
                content.add(f);
            }
        }
    }

    public ObservableList<File> getContent() {
        return content;
    }
}
