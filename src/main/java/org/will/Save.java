package org.will;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;

public class Save {
    private static final Path dirBase = Paths.get(System.getProperty("user.dir")).getParent();
    private static final Path caminho = dirBase.resolve("contents");
    private static final Path archive = caminho.resolve("checked.json");
    private static final Gson gson = new Gson();

    public static void salvar(Set<File> arquivo) throws IOException {
        if (!Files.exists(caminho)) {
            Files.createDirectories(caminho);
        }

        try (Writer writer = new FileWriter(archive.toFile())) {
            Set<String> path = new HashSet<>();
            for (File f : arquivo) {
                path.add(f.getAbsolutePath());
            }
            gson.toJson(path, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
