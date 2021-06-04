package com.scut.cts.service;

import com.scut.cts.pojo.Tutorial;

import java.util.List;

public interface TutorialService {
    public boolean addTutorial(Tutorial tutorial);
    public boolean updateTutorial(Tutorial tutorial);
    public boolean deleteTutorial(Integer tutorialId);

    public List<Tutorial> getTutorials(double titleNum);
}
