package com.amos.hibernate.dao.repository;

import com.amos.hibernate.common.api.BaseRepository;
import com.amos.hibernate.dao.entity.NoteVersionEntity;
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
public interface NoteVersionRepository extends BaseRepository<NoteVersionEntity, String> {

    Optional<List<NoteVersionEntity>> findByNoteId(String noteId);

}
