package com.yx.oa.dao;

import com.yx.oa.entity.ProcessFlow;

import java.util.List;

public interface ProcessFlowDao {
    public void insert(ProcessFlow processFlow);

    public void update(ProcessFlow processFlow);

    public List<ProcessFlow> selectByFormId(Long formId);
}
