package com.itaims.ihs.service;

import com.itaims.ihs.dao.MilestoneDao;
import com.itaims.ihs.dao.MilestoneModuleDao;
import com.itaims.ihs.entity.Milestone;
import com.itaims.ihs.entity.MilestoneModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MilestoneModuleService {

    @Autowired
    private MilestoneModuleDao milestoneModuleDao;

    @Autowired
    private MilestoneDao milestoneDao;

    @Transactional
    public List<MilestoneModule> getAll() {
        return milestoneModuleDao.getAll();
    }

    @Transactional
    public MilestoneModule get(long primaryKey) {
        return milestoneModuleDao.get(primaryKey);
    }

    @Transactional
    public void save(MilestoneModule object) {
        Milestone milestone = milestoneDao.get(object.getMilestone().getId());
        milestone.getMilestoneModules().add(object);
    }

    @Transactional
    public void update(MilestoneModule object) {
        milestoneModuleDao.update(object);
    }

    @Transactional
    public void delete(long primaryKey) {
        MilestoneModule milestoneModule = milestoneModuleDao.get(primaryKey);
        milestoneModuleDao.delete(milestoneModule);
    }
}
