package com.ruoyi.system.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysConfig;
import com.ruoyi.system.domain.SysLog;
import com.ruoyi.system.domain.SysZ;
import com.ruoyi.system.mapper.SysLogMapper;
import com.ruoyi.system.mapper.SysLogZMapper;
import com.ruoyi.system.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;

/**
 * 参数配置 服务层实现
 * 
 * @author ruoyi
 */
@Service
public class SysLogServiceImpl implements ISysLogService
{
    @Autowired
    private SysLogMapper logMapper;

    @Autowired
    private SysLogZMapper logZMapper;


    @Autowired
    private RedisCache redisCache;


    /**
     * 查询参数配置信息
     * 
     * @param logId 参数配置ID
     * @return 参数配置信息
     */
    @Override
    @DataSource(DataSourceType.MASTER)
    public SysLog selectLogById(Long logId)
    {
        SysLog log = new SysLog();
        log.setLogId(logId);
        return logMapper.selectLog(log);
    }



    /**
     * 查询参数配置列表
     * 
     * @param log 参数配置信息
     * @return 参数配置集合
     */
    @Override
    public List<SysLog> selectLogList(SysLog log)
    {
        return logMapper.selectConfigList(log);
    }


    /**
     * 查询参数配置列表
     *
     * @param zLog 参数配置信息
     * @return 参数配置集合
     */
    @Override
    public List<SysZ> selectLogZList(SysZ zLog)
    {
        return logZMapper.selectLogZList(zLog);
    }

    /**
     * 新增参数配置
     * 
     * @param log 参数配置信息
     * @return 结果
     */
    @Override
    public int insertLog(SysLog log)
    {
        String[] strArr = log.getLogName().split(",");
        int row = 0;
        for (String code : strArr) {
            SysLog sysLog = new SysLog();
            sysLog.setLogName(code);
            SysLog info = logMapper.checkConfigKeyUnique(sysLog.getLogName());
            if (StringUtils.isNull(info))
            {
                row += logMapper.insertLog(sysLog);
            }
        }
        return row;
    }

    /**
     * 修改参数配置
     * 
     * @param log 参数配置信息
     * @return 结果
     */
    @Override
    public int updateLog(SysLog log)
    {
        int row = logMapper.updateLog(log);
        return row;
    }

    /**
     * 批量删除参数信息
     * 
     * @param logIds 需要删除的参数ID
     */
    @Override
    public void deleteLogByIds(Long[] logIds)
    {
        for (Long logId : logIds)
        {
            SysLog log = selectLogById(logId);
            logMapper.deleteLogById(logId);
        }
    }



    /**
     * 校验参数键名是否唯一
     * 
     * @param log 参数配置信息
     * @return 结果
     */
    @Override
    public String checkConfigKeyUnique(SysLog log)
    {
        String[] strArr = log.getLogName().split(",");
        for (String code : strArr) {
            SysLog info = logMapper.checkConfigKeyUnique(log.getLogName());
            if (StringUtils.isNotNull(info) && info.getLogName().equals(log.getLogName()))
            {
                return UserConstants.NOT_UNIQUE;
            }
        }
        return UserConstants.UNIQUE;
}

    /**
     * 设置cache key
     * 
     * @param configKey 参数键
     * @return 缓存键key
     */
    private String getCacheKey(String configKey)
    {
        return Constants.SYS_CONFIG_KEY + configKey;
    }
}
