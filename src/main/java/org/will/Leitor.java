package org.will;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class Leitor {
    ObservableList<File> content = FXCollections.observableArrayList();
    private ListView<File> list;
    File dir = new File("HQ_Files");

    public Leitor (ListView<File> list) {
        this.list = list;
        File[] listFile = dir.listFiles();
        

        for (File files : listFile) {
            if (files.isDirectory()) {
                content.add(files);
            }
        }

        list.setItems(content);
    }

    public ListView<File> getList() {
        return list;
    }

    public void setList(ListView<File> list) {
        this.list = list;
    }
}
