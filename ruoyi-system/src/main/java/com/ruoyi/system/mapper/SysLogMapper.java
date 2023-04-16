package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysConfig;
import com.ruoyi.system.domain.SysLog;
import com.ruoyi.system.domain.SysZ;

import java.util.List;

/**
 * 参数配置 数据层
 * 
 * @author ruoyi
 */
public interface SysLogMapper
{
    /**
     * 查询参数配置信息
     * 
     * @param log 参数配置信息
     * @return 参数配置信息
     */
    public SysLog selectLog(SysLog log);

    /**
     * 查询参数配置列表
     * 
     * @param log 参数配置信息
     * @return 参数配置集合
     */
    public List<SysLog> selectConfigList(SysLog log);

    /**
     * 查询参数配置列表
     *
     * @param zLog 参数配置信息
     * @return 参数配置集合
     */
    public List<SysZ> selectLogZList(SysZ zLog);

    /**
     * 根据键名查询参数配置信息
     * 
     * @param configKey 参数键名
     * @return 参数配置信息
     */
    public SysLog checkConfigKeyUnique(String configKey);

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
     * 删除参数配置
     * 
     * @param logId 参数ID
     * @return 结果
     */
    public int deleteLogById(Long logId);

    /**
     * 批量删除参数信息
     * 
     * @param logIds 需要删除的参数ID
     * @return 结果
     */
    public int deleteLogByIds(Long[] logIds);
}
