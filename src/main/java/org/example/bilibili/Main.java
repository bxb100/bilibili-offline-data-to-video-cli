package org.example.bilibili;

import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;

import org.example.bilibili.entity.IOUtil;
import org.example.bilibili.entity.OffLineFile;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

/**
 * @author Xiaobo Bi (869384236@qq.com)
 */
@Command(name = "BiliBiliHelper",
        mixinStandardHelpOptions = true,
        version = {"BiliBiliHelper 1.0.0"},
        resourceBundle = "Messages")
public class Main implements Runnable {

    ResourceBundle bundle = ResourceBundle.getBundle("Messages");

    @Option(names = {"-i", "--input"}, descriptionKey = "input", required = true)
    private String input;

    @Option(names = {"-o", "--output"}, descriptionKey = "output", defaultValue = "empty")
    private String output;

    public static void main(String[] args) {
        CommandLine cmd = new CommandLine(new Main());
        cmd.execute(args);
    }

    public void run() {

        if (output.equals("empty")) {
            output = System.getProperty("java.io.tmpdir");
        }

        try {
            List<OffLineFile> offLineFiles =
                    IOUtil.iterateReadDir(Paths.get(input));

            for (OffLineFile offLineFile : offLineFiles) {
                String outputFile = Paths.get(
                        output,
                        offLineFile.getVideoTitle(),
                        offLineFile.getPartTitle(),
                        ".mp4"
                ).toString();
                Processor.multipleFilesToMp4(
                        outputFile,
                        offLineFile.getVideoPath().toString(),
                        offLineFile.getAudioPath().toString()
                );

                System.out.printf((bundle.getString("success")) + "%n", outputFile);
            }
            System.exit(0);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
