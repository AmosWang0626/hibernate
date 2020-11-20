package com.amos.hibernate.dao.entity;

import com.amos.hibernate.common.api.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 模块名称: hibernate
 * 模块描述: 文章
 *
 * @author amos.wang
 * @date 11/20/2020 3:07 PM
 */
@Getter
@Setter
@Entity
@Table(name = "dev_note")
public class NoteEntity extends BaseEntity {

    private String title;

    private String content;

    private String tags;

    private String category;
}
