package com.yx.oa.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Accessors(chain = true)
@Data
public class ProcessFlow {
    private Long processId;
    private Long formId;
    private Long operatorId;
    private String action;
    private String result;
    private String reason;
    private Date createTime;
    private Date auditTime;
    private Integer OrderNo;
    private String state;
    private Integer isLast;
}
