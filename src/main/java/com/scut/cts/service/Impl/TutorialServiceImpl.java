package com.scut.cts.service.Impl;

import com.scut.cts.mapper.ProblemMapper;
import com.scut.cts.mapper.TutorialMapper;
import com.scut.cts.pojo.Tutorial;
import com.scut.cts.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TutorialServiceImpl implements TutorialService {
    @Autowired
    private TutorialMapper tutorialMapper;
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public boolean addTutorial(Tutorial tutorial) {
        return tutorialMapper.insert(tutorial)==1;
    }

    @Override
    public boolean updateTutorial(Tutorial tutorial) {
        return tutorialMapper.updateByPrimaryKeySelective(tutorial)==1;
    }

    @Override
    public boolean deleteTutorial(Integer tutorialId) {
        return tutorialMapper.deleteByPrimaryKey(new Tutorial(tutorialId))==1;
    }

    @Override
    public List<Tutorial> getTutorials(double titleNum) {
        return tutorialMapper.selectTutorialsByTitleNum(titleNum);
    }
}
