package org.example.bilibili.json;

import java.util.List;

import lombok.Data;

/**
 * @author Xiaobo Bi (869384236@qq.com)
 */
@Data
public class Subtitle {

    private String fontSize;
    private String fontColor;
    private String backgroundAlpha;
    private String backgroundColor;
    private String stroke;
    private List<BodyItem> body;

    @Data
    public static class BodyItem {

        private double from;
        private double to;
        private int location;
        private String content;
    }
}

