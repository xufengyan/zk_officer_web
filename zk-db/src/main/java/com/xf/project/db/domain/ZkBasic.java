package com.xf.project.db.domain;

import java.util.Date;
/**
 * 官网基本信息对象 zk_basic
 *
 * @author ruoyi
 * @date 2021-04-12
 */
public class ZkBasic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** logo地址 */
    private String owLogo;

    /** 网站名称 */
    private String owName;

    /** 网站简介 */
    private String owBriefIntroduction;

    /** 二维码地址 */
    private String owQrcodePath;

    /** 电话 */
    private String owPhone;

    /** 手机号 */
    private String owTel;

    /** 工作时间 */
    private String owWoekTime;

    /** 备案 */
    private String owInternetcp;

    /** 公司网址 */
    private String owUrl;

    /** 邮箱地址 */
    private String owMail;

    /** 公司地址 */
    private String owAddress;

    /** 语言类型 */
    private String owLuaType;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setOwLogo(String owLogo)
    {
        this.owLogo = owLogo;
    }

    public String getOwLogo()
    {
        return owLogo;
    }
    public void setOwName(String owName)
    {
        this.owName = owName;
    }

    public String getOwName()
    {
        return owName;
    }
    public void setOwBriefIntroduction(String owBriefIntroduction)
    {
        this.owBriefIntroduction = owBriefIntroduction;
    }

    public String getOwBriefIntroduction()
    {
        return owBriefIntroduction;
    }
    public void setOwQrcodePath(String owQrcodePath)
    {
        this.owQrcodePath = owQrcodePath;
    }

    public String getOwQrcodePath()
    {
        return owQrcodePath;
    }
    public void setOwPhone(String owPhone)
    {
        this.owPhone = owPhone;
    }

    public String getOwPhone()
    {
        return owPhone;
    }
    public void setOwTel(String owTel)
    {
        this.owTel = owTel;
    }

    public String getOwTel()
    {
        return owTel;
    }

    public String getOwWoekTime() {
        return owWoekTime;
    }

    public void setOwWoekTime(String owWoekTime) {
        this.owWoekTime = owWoekTime;
    }

    public void setOwInternetcp(String owInternetcp)
    {
        this.owInternetcp = owInternetcp;
    }

    public String getOwInternetcp()
    {
        return owInternetcp;
    }
    public void setOwUrl(String owUrl)
    {
        this.owUrl = owUrl;
    }

    public String getOwUrl()
    {
        return owUrl;
    }
    public void setOwMail(String owMail)
    {
        this.owMail = owMail;
    }

    public String getOwMail()
    {
        return owMail;
    }
    public void setOwAddress(String owAddress)
    {
        this.owAddress = owAddress;
    }

    public String getOwAddress()
    {
        return owAddress;
    }
    public void setOwLuaType(String owLuaType)
    {
        this.owLuaType = owLuaType;
    }

    public String getOwLuaType()
    {
        return owLuaType;
    }


}
