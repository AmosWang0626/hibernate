package com.amos.hibernate.dao;

import com.amos.hibernate.core.NoteService;
import com.amos.hibernate.dao.entity.NoteEntity;
import com.amos.hibernate.dao.repository.NoteRepository;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.UUID;

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
    @Resource
    private NoteRepository noteRepository;

    @Test
    public void saveNote() {
        NoteEntity entity = new NoteEntity();
        entity.setTitle("念奴娇赤壁怀古");
        entity.setContent("大江东去，浪淘尽，千古风流人物。故垒西边，人道是：三国周郎赤壁。乱石穿空，惊涛拍岸，卷起千堆雪。江山如画，一时多少豪杰。" +
                "遥想公瑾当年，小乔初嫁了，雄姿英发。羽扇纶巾，谈笑间樯橹灰飞烟灭。故国神游，多情应笑我，早生华发。人生如梦，一尊还酹江月。");
        entity.setTags("苏轼,宋代");
        entity.setCategory("苏轼诗词");

        try {
            noteService.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(">>>>>>>>>> " + e.getMessage());
        }
    }

    /**
     * 保存笔记
     * <p>
     * NOTE: 设置的ID并不会生效，JPA会先根据这个ID查询数据，如果数据不存在，就会插入一条，ID并不是设置的ID
     */
    @Test
    public void saveNote2() {
        NoteEntity entity = new NoteEntity();
        entity.setId(UUID.randomUUID().toString().replace("-", ""));
        entity.setTitle("念奴娇赤壁怀古");
        entity.setContent("大江东去，浪淘尽，千古风流人物。故垒西边，人道是：三国周郎赤壁。乱石穿空，惊涛拍岸，卷起千堆雪。江山如画，一时多少豪杰。" +
                "遥想公瑾当年，小乔初嫁了，雄姿英发。羽扇纶巾，谈笑间樯橹灰飞烟灭。故国神游，多情应笑我，早生华发。人生如梦，一尊还酹江月。");
        entity.setTags("苏轼,宋代");
        entity.setCategory("苏轼诗词");

        System.out.println(ToStringBuilder.reflectionToString(entity, ToStringStyle.JSON_STYLE));

        noteRepository.save(entity);
    }

}
