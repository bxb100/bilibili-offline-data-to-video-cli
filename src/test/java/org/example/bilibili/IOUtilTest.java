package org.example.bilibili;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import org.example.bilibili.entity.IOUtil;
import org.example.bilibili.entity.OffLineFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class IOUtilTest {

    protected Path path;
    protected Path subPath;

    @BeforeEach
    void setUp() {
        String rootPath = Objects.requireNonNull(IOUtilTest.class.getClassLoader().getResource("")).getPath();
        path = Paths.get(rootPath, "551400760");
        subPath = Paths.get(rootPath, "551400760", "c_505965444");
    }

    @Test
    void iterateReadDir() throws IOException {
        List<OffLineFile> offLineFiles = IOUtil.iterateReadDir(path);
        assertEquals(1, offLineFiles.size());

        OffLineFile offLineFile = offLineFiles.stream().findFirst().orElse(null);
        checkObject(offLineFile);
    }

    @Test
    void readSingleDir() {
        OffLineFile offLineFile = IOUtil.readSingleDir(subPath.toString());
        checkObject(offLineFile);
    }

    private void checkObject(OffLineFile offLineFile) {
        assertNotNull(offLineFile);
        assertNotNull(offLineFile.getVideoTitle());
        assertNotNull(offLineFile.getVideoPath());
        assertNotNull(offLineFile.getAudioPath());
        assertNotNull(offLineFile.getPartTitle());
    }
}