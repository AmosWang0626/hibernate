package com.amos.hibernate.dao;

import com.amos.hibernate.core.NoteService;
import com.amos.hibernate.dao.entity.NoteEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 模块名称: hibernate
 * 模块描述: NoteTests
 *
 * @author amos.wang
 * @date 11/20/2020 3:44 PM
 */
@SpringBootTest
public class NoteTests {

    @Resource
    private NoteService noteService;

    @Test
    public void saveNote() {
        NoteEntity entity = new NoteEntity();
        entity.setTitle("念奴娇赤壁怀古");
        entity.setContent("大江东去，浪淘尽，千古风流人物。故垒西边，人道是：三国周郎赤壁。乱石穿空，惊涛拍岸，卷起千堆雪。江山如画，一时多少豪杰。" +
                "遥想公瑾当年，小乔初嫁了，雄姿英发。羽扇纶巾，谈笑间樯橹灰飞烟灭。故国神游，多情应笑我，早生华发。人生如梦，一尊还酹江月。");
        entity.setTags("苏轼,宋代");
        entity.setCategory("苏轼诗词");

        noteService.save(entity);
    }

}
