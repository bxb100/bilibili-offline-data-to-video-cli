package org.example.bilibili.entity;

import java.nio.file.Path;
import java.nio.file.Paths;

import lombok.Data;
import org.example.bilibili.json.Entry;
import org.example.bilibili.json.JsonUtil;

/**
 * @author Xiaobo Bi (869384236@qq.com)
 */
@Data
public class OffLineFile {

    private String videoTitle;
    private Path videoPath;
    private Path audioPath;
    private String partTitle;

    public void parse(String pwd, String entryJson) {
        Entry entry = JsonUtil.toObject(entryJson, Entry.class);
        this.videoTitle = entry.getTitle();
        this.partTitle = entry.getPageData().getPart();
        this.videoPath = Paths.get(pwd, entry.getTypeTag(), "video.m4s");
        this.audioPath = Paths.get(pwd, entry.getTypeTag(), "audio.m4s");
    }
}
