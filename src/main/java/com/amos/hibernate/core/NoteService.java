package com.amos.hibernate.core;

import com.amos.hibernate.common.api.CommonResponse;
import com.amos.hibernate.dao.entity.NoteEntity;

import java.util.List;

/**
 * 模块名称: hibernate
 * 模块描述: NoteService
 *
 * @author amos.wang
 * @date 11/20/2020 3:12 PM
 */
public interface NoteService {

    /**
     * 保存笔记
     *
     * @param note 笔记
     * @return resp
     */
    CommonResponse<NoteEntity> save(NoteEntity note);

    /**
     * 查询笔记
     *
     * @param title 笔记名称
     * @return resp
     */
    CommonResponse<List<NoteEntity>> find(String title);

}
