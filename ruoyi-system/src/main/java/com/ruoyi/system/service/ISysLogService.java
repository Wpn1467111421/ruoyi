package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysConfig;
import com.ruoyi.system.domain.SysLog;
import com.ruoyi.system.domain.SysZ;

import java.util.List;

/**
 * 参数配置 服务层
 * 
 * @author ruoyi
 */
public interface ISysLogService
{
    /**
     * 查询参数配置信息
     * 
     * @param logId 参数配置ID
     * @return 参数配置信息
     */
    public SysLog selectLogById(Long logId);


    /**
     * 查询参数配置列表
     * 
     * @param log 参数配置信息
     * @return 参数配置集合
     */
    public List<SysLog> selectLogList(SysLog log);


    /**
     * 查询参数配置列表
     *
     * @param zLog 参数配置信息
     * @return 参数配置集合
     */
    public List<SysZ> selectLogZList(SysZ zLog);

    /**
     * 新增参数配置
     * 
     * @param log 参数配置信息
     * @return 结果
     */
    public int insertLog(SysLog log);

    /**
     * 修改参数配置
     * 
     * @param log 参数配置信息
     * @return 结果
     */
    public int updateLog(SysLog log);

    /**
     * 批量删除参数信息
     * 
     * @param logIds 需要删除的参数ID
     */
    public void deleteLogByIds(Long[] logIds);


    /**
     * 校验参数键名是否唯一
     * 
     * @param log 参数信息
     * @return 结果
     */
    public String checkConfigKeyUnique(SysLog log);
}
