package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Arrays;

/**
 * 参数配置表 sys_config
 * 
 * @author ruoyi
 */
public class SysLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 参数主键 */
    @Excel(name = "代码主键", cellType = ColumnType.NUMERIC)
    private Long logId;

    /** 参数名称 */
    @Excel(name = "代码名称")
    private String logName;

    private String[] codes;


    public Long getLogId()
    {
        return logId;
    }

    public void setLogId(Long logId)
    {
        this.logId = logId;
    }

    @NotBlank(message = "参数名称不能为空")
    @Size(min = 0, max = 1000, message = "参数名称不能超过1000个字符")
    public String getLogName()
    {
        return logName;
    }

    public void setLogName(String logName)
    {
        this.logName = logName;
    }

    public String[] getCodes() {
        return codes;
    }

    public void setCodes(String[] codes) {
        this.codes = codes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("logId", getLogId())
            .append("logName", getLogName())
            .append("codes", Arrays.toString(getCodes()))
            .toString();
    }
}
