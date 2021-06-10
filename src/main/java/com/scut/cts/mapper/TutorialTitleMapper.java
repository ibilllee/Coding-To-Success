package com.scut.cts.mapper;

import com.scut.cts.dto.TitleContent;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TutorialTitleMapper extends Mapper<TitleContent>
{
	@Select("SELECT tuto_id,title_content,title_num FROM tutorial WHERE title_num=floor(title_num)")
	List<TitleContent> selectTitlesInfo();

	@Select("SELECT tuto_id,title_content,title_num FROM tutorial WHERE title_num>floor(#{titleNum}) and title_num<floor(#{titleNum})+1")
	List<TitleContent> selectSubTitlesInfo(Double titleNum);
}
