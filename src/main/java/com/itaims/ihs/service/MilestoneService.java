package com.itaims.ihs.service;

import com.itaims.ihs.dao.MilestoneDao;
import com.itaims.ihs.dao.ProjectDao;
import com.itaims.ihs.entity.Milestone;
import com.itaims.ihs.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MilestoneService {
    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private MilestoneDao milestoneDao;

    @Transactional
    public List<Milestone> getAll() {
        return milestoneDao.getAll();
    }


    @Transactional
    public Milestone get(long primaryKey) {
        return milestoneDao.get(primaryKey);
    }

    @Transactional
    public void save(Milestone object) {
        Project project = projectDao.get(object.getProject().getId());
        project.getMilestones().add(object);
    }

    @Transactional
    public void update(Milestone object) {
        milestoneDao.update(object);
    }

    @Transactional
    public void delete(long primaryKey) {
        Milestone milestone = milestoneDao.get(primaryKey);
        milestoneDao.delete(milestone);
    }
}
