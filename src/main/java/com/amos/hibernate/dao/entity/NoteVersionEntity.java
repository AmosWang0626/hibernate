package com.amos.hibernate.dao.entity;

import com.amos.hibernate.common.api.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 模块名称: hibernate
 * 模块描述: 笔记版本
 *
 * @author amos.wang
 * @date 2020/11/30 16:32
 */
@Getter
@Setter
@Entity
@Table(name = "dev_note_version")
public class NoteVersionEntity extends BaseEntity {

    private String noteId;

    private Long versionId;

    /**
     * 笔记信息
     */
    private String title;

    private String content;

    private String tags;

    private String category;

}
