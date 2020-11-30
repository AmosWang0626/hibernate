package com.amos.hibernate.core.impl;

import com.amos.hibernate.core.NoteVersionService;
import com.amos.hibernate.dao.entity.NoteEntity;
import com.amos.hibernate.dao.entity.NoteVersionEntity;
import com.amos.hibernate.dao.repository.NoteVersionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 模块名称: hibernate
 * 模块描述: 笔记版本
 *
 * @author amos.wang
 * @date 2020/11/30 17:06
 */
@Service("noteVersionService")
public class NoteVersionServiceImpl implements NoteVersionService {

    @Resource
    private NoteVersionRepository noteVersionRepository;


    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void saveVersion(NoteEntity note) {
        NoteVersionEntity versionEntity = new NoteVersionEntity();
        versionEntity.setNoteId(note.getId());
        versionEntity.setVersionId(System.currentTimeMillis());

        versionEntity.setTitle(note.getTitle());
        versionEntity.setContent(note.getContent());
        versionEntity.setTags(note.getTags());
        versionEntity.setCategory(note.getCategory());

        noteVersionRepository.save(versionEntity);

        throw new RuntimeException("严重异常 :: 保存版本出错！");
    }

}
