package org.example.bilibili.json;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import lombok.experimental.UtilityClass;

/**
 * @author Xiaobo Bi (869384236@qq.com)
 */
@UtilityClass
public class SubtitleUtil {

    public String downloadJson(String url) throws IOException {
        InputStream in = new URL(url).openStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream))) {
            bufferedReader.lines().forEach(sb::append);
        }
        return sb.toString();
    }
}
