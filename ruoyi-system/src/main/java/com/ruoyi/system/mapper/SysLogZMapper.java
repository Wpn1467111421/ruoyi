package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysZ;

import java.util.List;

/**
 * 参数配置 数据层
 * 
 * @author ruoyi
 */
public interface SysLogZMapper
{

    /**
     * 查询参数配置列表
     *
     * @param zLog 参数配置信息
     * @return 参数配置集合
     */
    public List<SysZ> selectLogZList(SysZ zLog);

}
