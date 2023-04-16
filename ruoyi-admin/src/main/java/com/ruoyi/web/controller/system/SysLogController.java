package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysLog;
import com.ruoyi.system.domain.SysZ;
import com.ruoyi.system.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 参数配置 信息操作处理
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/system/log")
public class SysLogController extends BaseController
{
    @Autowired
    private ISysLogService logService;

    /**
     * 获取参数配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:log:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysLog log)
    {
        startPage();
        List<SysLog> list = logService.selectLogList(log);
        return getDataTable(list);
    }

    @Log(title = "参数管理", businessType = BusinessType.EXPORT)
//    @PreAuthorize("@ss.hasPermi('system:log:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysLog log)
    {
        List<SysLog> list = logService.selectLogList(log);
        ExcelUtil<SysLog> util = new ExcelUtil<SysLog>(SysLog.class);
        util.exportExcel(response, list, "日志数据");
    }

    @Log(title = "参数管理", businessType = BusinessType.EXPORT)
//    @PreAuthorize("@ss.hasPermi('system:log:export')")
    @PostMapping("/exportZ")
    public void exportZ(HttpServletResponse response, SysZ zLog)
    {
        List<SysZ> list = logService.selectLogZList(zLog);
        ExcelUtil<SysZ> util = new ExcelUtil<SysZ>(SysZ.class);
        util.exportExcel(response, list, "日志数据");
    }

    /**
     * 根据参数编号获取详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:log:query')")
    @GetMapping(value = "/{logId}")
    public AjaxResult getInfo(@PathVariable Long logId)
    {
        return AjaxResult.success(logService.selectLogById(logId));
    }

    /**
     * 新增参数配置
     */
//    @PreAuthorize("@ss.hasPermi('system:config:add')")
    @Log(title = "代码管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@Validated @RequestBody SysLog log)
    {
        if (UserConstants.NOT_UNIQUE.equals(logService.checkConfigKeyUnique(log)))
        {
            return AjaxResult.error("新增参数'" + log.getLogName() + "'失败，代码名称已存在");
        }
//        log.setCreateBy(getUsername());
        return toAjax(logService.insertLog(log));
    }

    /**
     * 修改参数配置
     */
//    @PreAuthorize("@ss.hasPermi('system:config:edit')")
    @Log(title = "代码管理", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@Validated @RequestBody SysLog log)
    {
        if (UserConstants.NOT_UNIQUE.equals(logService.checkConfigKeyUnique(log)))
        {
            return AjaxResult.error("修改参数'" + log.getLogName() + "'失败，参数键名已存在");
        }
//        log.setUpdateBy(getUsername());
        return toAjax(logService.updateLog(log));
    }

    /**
     * 删除参数配置
     */
    @PreAuthorize("@ss.hasPermi('system:config:remove')")
    @Log(title = "参数管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{configIds}")
    public AjaxResult remove(@PathVariable Long[] configIds)
    {
        logService.deleteLogByIds(configIds);
        return success();
    }

}
