package org.example.bilibili;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import lombok.experimental.UtilityClass;

/**
 * @author Xiaobo Bi (869384236@qq.com)
 */
@UtilityClass
public class Processor {

    private final String FFMPEG = "ffmpeg";

    public boolean ffmpegExist() {
        Process process;
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(FFMPEG, "-version");
            process = processBuilder.inheritIO().start();
            process.waitFor();
            return true;
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    /**
     * In the android offline cache, just need to merge two m4s files to mp4 file,
     * don't need to refactor the video type, just copy is fine.
     * <p>
     * The command example: {@code ffmpeg -loglevel warning -y -i audio.m4s -i video.m4s -c copy cs.mp4}
     * <p>
     * <a href="https://github.com/nilaoda/BBDown/blob/16655a9322094b0d35a94dbd840cd8047142971a/BBDown/BBDownMuxer.cs">
     * relative code</a>
     *
     * @param output the output file path
     * @param inputs input file paths
     * @throws IOException          if an I/O error occurs
     * @throws InterruptedException timeout
     */
    public void multipleFilesToMp4(Path output, Path... inputs) throws IOException, InterruptedException {
        if (!output.toString().endsWith(".mp4")) {
            throw new IllegalArgumentException("output must be mp4 file");
        }
        // make sure the directory exists
        if (!output.getParent().toFile().exists()) {
            //noinspection ResultOfMethodCallIgnored
            output.getParent().toFile().mkdirs();
        }

        List<String> commands = new ArrayList<>();
        commands.add(FFMPEG);
        commands.add("-loglevel");
        commands.add("warning");
        commands.add("-y");
        for (Path input : inputs) {
            commands.add("-i");
            commands.add(input.toString());
        }
        commands.add("-c");
        commands.add("copy");
        commands.add(output.toString());

        Process process;
        ProcessBuilder processBuilder = new ProcessBuilder(commands);
        process = processBuilder.inheritIO().start();
        process.waitFor();
    }
}
