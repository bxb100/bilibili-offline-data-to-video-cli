package org.example.bilibili.entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.experimental.UtilityClass;

/**
 * @author Xiaobo Bi (869384236@qq.com)
 */
@UtilityClass
public class IOUtil {

    public List<OffLineFile> iterateReadDir(Path dirPath) throws IOException {
        boolean directory = Files.isDirectory(dirPath);
        if (!directory) {
            throw new IllegalArgumentException("dirPath must be a directory");
        }
        try (Stream<Path> list = Files.list(dirPath)) {
            return list.filter(path -> path.toFile().isDirectory())
                    .map(path -> readSingleDir(path.toString()))
                    .collect(Collectors.toList());
        }
    }

    public OffLineFile readSingleDir(String dirPath) {
        OffLineFile offLineFile = new OffLineFile();
        // entry.json
        try {
            Path entry = Paths.get(dirPath, "entry.json");
            offLineFile.parse(dirPath, new String(Files.readAllBytes(entry)));
        } catch (IOException e) {
            System.err.println(e);
        }
        return offLineFile;
    }
}
