package com.scut.cts.service.Impl;

import com.scut.cts.mapper.CommentMapper;
import com.scut.cts.mapper.ProblemMapper;
import com.scut.cts.mapper.TutorialMapper;
import com.scut.cts.pojo.Tutorial;
import com.scut.cts.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialServiceImpl implements TutorialService {
    @Autowired
    private TutorialMapper tutorialMapper;
    @Autowired
    private ProblemMapper problemMapper;
    @Autowired
    private CommentMapper commentMapper;

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
    public Tutorial getTutorial(Integer tutorialId) {
        Tutorial result = tutorialMapper.selectByPrimaryKey(tutorialId);
        result.setProblemList(problemMapper.selectProblemByTutoId(tutorialId));
        result.setCommentList(commentMapper.selectByTutoId(tutorialId));
        return result;
    }

    @Override
    public List<String> getTitle(Double titleNum) {
        List<String> result;
        if(titleNum == null) {
            result = tutorialMapper.selectTitles();
        } else {
            result = tutorialMapper.selectSubTitles(titleNum);
        }
        return result;
    }


}
