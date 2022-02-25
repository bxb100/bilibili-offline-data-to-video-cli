package org.example.bilibili;

import org.example.bilibili.json.Entry;
import org.example.bilibili.json.JsonUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonUtilTest {
    String testJson = "{\"media_type\":2,\"has_dash_audio\":true,\"is_completed\":true,\"total_bytes\":3830239,\"downloaded_bytes\":3830239,\"title\":\"软件架构：领域驱动设计【中英字幕 Software Architecture: Domain-Driven Design】\",\"type_tag\":\"64\",\"cover\":\"http:\\/\\/i1.hdslb.com\\/bfs\\/archive\\/ba67d6026ecf6abc03d9983365ca2a174a989d9a.png\",\"video_quality\":64,\"prefered_video_quality\":64,\"guessed_total_bytes\":0,\"total_time_milli\":57962,\"danmaku_count\":0,\"time_update_stamp\":1645702545669,\"time_create_stamp\":1645702544025,\"can_play_in_advance\":true,\"interrupt_transform_temp_file\":false,\"quality_pithy_description\":\"720P\",\"quality_superscript\":\"\",\"cache_version_code\":6610300,\"preferred_audio_quality\":0,\"audio_quality\":0,\"avid\":551400760,\"spid\":0,\"seasion_id\":0,\"bvid\":\"BV15i4y1f7gU\",\"owner_id\":314509002,\"owner_name\":\"Serverless-X\",\"owner_avatar\":\"http:\\/\\/i0.hdslb.com\\/bfs\\/face\\/99492a512d2412bbd2f8f2b6342cd7fc4f8f1ed9.jpg\",\"page_data\":{\"cid\":505965444,\"page\":1,\"from\":\"vupload\",\"part\":\"01 - Better apps with domain-driven design\",\"link\":\"\",\"vid\":\"\",\"has_alias\":false,\"tid\":122,\"width\":1280,\"height\":720,\"rotate\":0,\"download_title\":\"视频已缓存完成\",\"download_subtitle\":\"软件架构：领域驱动设计【中英字幕 Software Architecture: Domain-Driven Design】 01 - Better apps with domain-driven design\"}}";

    @Test
    void toObject() {
        Entry entry = JsonUtil.toObject(testJson, Entry.class);
        assertEquals("软件架构：领域驱动设计【中英字幕 Software Architecture: Domain-Driven Design】", entry.getTitle());
        assertEquals("64", entry.getTypeTag());
        assertEquals("01 - Better apps with domain-driven design", entry.getPageData().getPart());
    }
}