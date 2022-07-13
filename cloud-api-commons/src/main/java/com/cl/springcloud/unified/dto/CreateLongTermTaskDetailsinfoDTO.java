package com.cl.springcloud.unified.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @version 1.0
 * @Author cl
 * @Date 2022/6/24 11:15
 *
 *  @Validated 参数校验 （枚举类型可以限制值,留待补充,并且该类建立在老项目上,暂时手动get、set,抽取出来之后使用lombok）
 */
@Data
public class CreateLongTermTaskDetailsinfoDTO {
    /**
     * 任务标题
     */
    @NotNull(message = "任务标题不允许为空")
    private String taskTitle;
    /**
     * 任务主(发布人)
     */
    @NotNull(message = "任务主名字不允许为空")
    private String taskMaster;
    /**
     * 任务类别  枚举: 1(A类)/2(B类)/3(C类)
     */
    @Min(value = 0, message = "任务类别不允许为负数")
    private Integer taskCategory;
    /**
     * 任务类型
     */
    @NotNull(message = "任务类型不允许为空")
    private String taskType;
    /**
     * 任务简述
     */
    @NotNull(message = "任务简述不允许为空")
    private String taskSketch;
    /**
     * 任务内容
     */
    @NotNull(message = "任务内容不允许为空")
    private String taskContent;
    /**
     * 任务贡献值
     */
    @Min(value = 0, message = "任务贡献值不允许为负数")
    private Double taskContributionValue;
    /**
     * 任务允许最大未通过次数(回到已认领状态,超过次数后该次任务失效,重新开始认领)
     */
    @Min(value = 0, message = "任务允许最大未通过次数不允许为负数")
    private Integer taskUnfinishedNumber;
    /**
     * 完成任务天数
     */
    @Min(value = 0, message = "完成任务天数不允许为负数")
    private Integer taskCompletionDays;


}
