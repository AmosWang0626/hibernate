package com.amos.hibernate.core.impl;

import com.amos.hibernate.common.api.CommonResponse;
import com.amos.hibernate.core.NoteService;
import com.amos.hibernate.core.NoteVersionService;
import com.amos.hibernate.dao.entity.NoteEntity;
import com.amos.hibernate.dao.repository.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 模块名称: hibernate
 * 模块描述: NoteService
 *
 * @author amos.wang
 * @date 11/20/2020 3:20 PM
 */
@Service("noteService")
public class NoteServiceImpl implements NoteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoteServiceImpl.class);

    @Resource
    private NoteRepository noteRepository;
    @Resource
    private NoteVersionService noteVersionService;


    @Transactional(rollbackFor = Throwable.class)
    @Override
    public CommonResponse<NoteEntity> save(NoteEntity note) {
        NoteEntity entity = noteRepository.save(note);

        try {
            noteVersionService.saveVersion(note);
        } catch (Exception e) {
            LOGGER.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> [{}]", e.getMessage());
        }

        return CommonResponse.success(entity);
    }

    @Override
    public CommonResponse<List<NoteEntity>> find(String title) {
        List<NoteEntity> noteEntities = noteRepository.findByTitle(title).orElse(new ArrayList<>());

        return CommonResponse.success(noteEntities);
    }

}
