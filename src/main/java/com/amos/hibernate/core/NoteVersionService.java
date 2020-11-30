package com.amos.hibernate.core;

import com.amos.hibernate.dao.entity.NoteEntity;

/**
 * 模块名称: hibernate
 * 模块描述: 笔记版本
 *
 * @author amos.wang
 * @date 2020/11/30 17:06
 */
public interface NoteVersionService {

    /**
     * 保存笔记版本
     *
     * @param note 笔记
     */
    void saveVersion(NoteEntity note);
    
}
