package com.scut.cts.mapper;

import com.scut.cts.pojo.Tutorial;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TutorialMapper extends Mapper<Tutorial> {
    @Select("SELECT * FROM tutorial WHERE title_num >= floor(#{titleNum}) and title_num <= ceil(#{titleNum})")
    public List<Tutorial> selectTutorialsByTitleNum(double titleNum);
}
