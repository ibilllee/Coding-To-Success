package com.scut.cts.mapper;

import com.scut.cts.pojo.Tutorial;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TutorialMapper extends Mapper<Tutorial> {
    @Select("SELECT title_content FROM tutorial WHERE title_num=floor(title_num)")
    List<String> selectTitles();

    @Select("SELECT title_content FROM tutorial WHERE title_num>floor(#{titleNum}) and title_num<floor(#{titleNum})+1")
    List<String> selectSubTitles(Double titleNum);

    @Select("SELECT * FROM tutorial WHERE title_num > floor(#{titleNum}) and title_num < floor(#{titleNum})+1")
    List<Tutorial> selectByTitleNum(Double titleNum);

    @Delete("DELETE FROM tutorial WHERE title_num>floor(#{titleNum}) and title_num<floor(#{titleNum})+1")
    int deleteSubTutorials(Tutorial tutorial);
}
