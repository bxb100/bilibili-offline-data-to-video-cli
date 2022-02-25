package org.example.bilibili;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.example.bilibili.entity.IOUtil;
import org.example.bilibili.entity.OffLineFile;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProcessorTest extends IOUtilTest {

    @Test
    void ffmpegExist() {
        assertTrue(Processor.ffmpegExist());
    }

    @Test
    void multipleFilesToMp4() throws IOException, InterruptedException {
        String tempDir = System.getProperty("java.io.tmpdir");
        OffLineFile offLineFile = IOUtil.readSingleDir(subPath.toString());
        Path outputPath = Paths.get(tempDir, offLineFile.getPartTitle() + ".mp4");
        System.out.println(outputPath);
        Processor.multipleFilesToMp4(outputPath,
                offLineFile.getVideoPath(),
                offLineFile.getAudioPath()
        );
        assertTrue(outputPath.toFile().exists());
    }
}