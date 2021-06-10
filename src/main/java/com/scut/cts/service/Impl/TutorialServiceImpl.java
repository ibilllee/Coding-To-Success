package com.scut.cts.service.Impl;

import com.scut.cts.mapper.*;
import com.scut.cts.pojo.Problem;
import com.scut.cts.dto.TitleContent;
import com.scut.cts.pojo.Tutorial;
import com.scut.cts.service.CommentService;
import com.scut.cts.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Math.floor;

@Service
public class TutorialServiceImpl implements TutorialService {
    @Autowired
    private TutorialMapper tutorialMapper;
    @Autowired
    private ProblemMapper problemMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private TutorialTitleMapper tutorialTitleMapper;
    @Autowired
    private CommentService commentService;

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
        Tutorial tutorial = new Tutorial(tutorialId);
        Tutorial tutorialComplete = tutorialMapper.selectByPrimaryKey(tutorial);
        if(tutorialComplete.getTitleNum() == floor(tutorialComplete.getTitleNum())) {
            List<Tutorial> subTutorialList = tutorialMapper.selectByTitleNum(tutorialComplete.getTitleNum());
            for (Tutorial tuto : subTutorialList) {
                commentMapper.deleteByTutoId(tuto.getTutoId());
                List<Problem> problemList = problemMapper.selectProblemByTutoId(tuto.getTutoId());
                for (Problem prob : problemList) {
                    answerMapper.deleteByProbId(prob);
                }
                problemMapper.deleteByTutoId(tuto.getTutoId());
            }
            tutorialMapper.deleteSubTutorials(tutorialComplete);
        }
        commentMapper.deleteByTutoId(tutorialId);
        List<Problem> problemList = problemMapper.selectProblemByTutoId(tutorial.getTutoId());
        for (Problem prob : problemList) {
            answerMapper.deleteByProbId(prob);
        }
        problemMapper.deleteByTutoId(tutorialId);
        return tutorialMapper.deleteByPrimaryKey(tutorial)==1;
    }

    @Override
    public Tutorial getTutorial(Integer tutorialId) {
        Tutorial result = tutorialMapper.selectByPrimaryKey(tutorialId);
        result.setProblemList(problemMapper.selectProblemByTutoId(tutorialId));
        //result.setCommentList(commentMapper.selectByTutoId(tutorialId));
        result.setCommentList(commentService.getComments(tutorialId));
        return result;
    }

    @Override
    public List<TitleContent> getTitle(Double titleNum) {
        List<TitleContent> result;
        if(titleNum == null) {
            result = tutorialTitleMapper.selectTitlesInfo();
        } else {
            result=tutorialTitleMapper.selectSubTitlesInfo(titleNum);
        }
        return result;
    }

}
