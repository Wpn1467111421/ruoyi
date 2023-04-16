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
public class SysZ extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 参数主键 */
    @Excel(name = "代码主键", cellType = ColumnType.NUMERIC)
    private Long id;

    /** 出版社名称 */
    @Excel(name = "代码")
    private String logName;

    /** 出版社名称 */
    @Excel(name = "出版社名称")
    private String publisher;

    /** 出版社名称 */
    @Excel(name = "单库检索")
    private String singleSearch;

    /** 出版社名称 */
    @Excel(name = "跨库检索")
    private String crossSearch;
    /** 出版社名称 */
    @Excel(name = "浏览")
    private int browse;

    /** 出版社名称 */
    @Excel(name = "下载")
    private int download;
    /** 出版社名称 */
    @Excel(name = "外文浏览下载")
    private int foreignBrowseDownload;

    /** 出版社名称 */
    @Excel(name = "DOI浏览下载")
    private int doiBrowseDownload;

    /** 出版社名称 */
    @Excel(name = "月份")
    private String month;

    private String[] codes;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogName() {
        return logName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSingleSearch() {
        return singleSearch;
    }

    public void setSingleSearch(String singleSearch) {
        this.singleSearch = singleSearch;
    }

    public String getCrossSearch() {
        return crossSearch;
    }

    public void setCrossSearch(String crossSearch) {
        this.crossSearch = crossSearch;
    }

    public int getBrowse() {
        return browse;
    }

    public void setBrowse(int browse) {
        this.browse = browse;
    }

    public int getDownload() {
        return download;
    }

    public void setDownload(int download) {
        this.download = download;
    }

    public int getForeignBrowseDownload() {
        return foreignBrowseDownload;
    }

    public void setForeignBrowseDownload(int foreignBrowseDownload) {
        this.foreignBrowseDownload = foreignBrowseDownload;
    }

    public int getDoiBrowseDownload() {
        return doiBrowseDownload;
    }

    public void setDoiBrowseDownload(int doiBrowseDownload) {
        this.doiBrowseDownload = doiBrowseDownload;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setLogName(String logName) {
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
        return "SysZ{" +
                "id=" + id +
                ", logName='" + logName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", singleSearch='" + singleSearch + '\'' +
                ", crossSearch='" + crossSearch + '\'' +
                ", browse=" + browse +
                ", download=" + download +
                ", foreignBrowseDownload=" + foreignBrowseDownload +
                ", doiBrowseDownload=" + doiBrowseDownload +
                ", month='" + month + '\'' +
                ", codes=" + Arrays.toString(codes) +
                '}';
    }
}
