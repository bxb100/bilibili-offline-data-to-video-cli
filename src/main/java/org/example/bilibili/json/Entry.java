package org.example.bilibili.json;

import lombok.Data;

/**
 * @author Xiaobo Bi (869384236@qq.com)
 */
@Data
public class Entry {

    private String title;
    private String typeTag;
    private PageData pageData;

    @Data
    public static class PageData {
        private String part;
    }
}
