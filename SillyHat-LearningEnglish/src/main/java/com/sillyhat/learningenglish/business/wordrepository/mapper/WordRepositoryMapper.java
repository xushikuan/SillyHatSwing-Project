package com.sillyhat.learningenglish.business.wordrepository.mapper;

import com.sillyhat.learningenglish.business.wordrepository.dto.WordRepositoryDTO;
import com.sillyhat.swing.dto.PageDTO;

import java.util.List;

/**
 * WordRepositoryService
 *
 * @author 徐士宽
 * @date 2017/3/13 11:46
 */
public interface WordRepositoryMapper {

    public List<WordRepositoryDTO> queryWordRepositoryAll();

    public List<WordRepositoryDTO> queryWordRepositoryByPage(PageDTO page);

    public int queryWordRepositoryTotalCountByPage(PageDTO page);

    public WordRepositoryDTO getWordRepositoryById(String id);

    public void addWordRepository(WordRepositoryDTO dto);

    public void updateWordRepository(WordRepositoryDTO dto);

    public void deleteWordRepository(String id);

}
