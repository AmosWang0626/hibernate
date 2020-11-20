package com.amos.hibernate.dao.repository;

import com.amos.hibernate.common.api.BaseRepository;
import com.amos.hibernate.dao.entity.NoteEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 模块名称: hibernate
 * 模块描述: NoteRepository
 *
 * @author amos.wang
 * @date 2020/11/20 15:24
 */
@Repository
public interface NoteRepository extends BaseRepository<NoteEntity, String> {

    /**
     * 根据标题查询
     *
     * @param title 标题
     * @return entity
     */
    Optional<List<NoteEntity>> findByTitle(String title);

}
