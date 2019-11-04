/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package chenzpMybatis.entity;

import java.util.Date;

public class BusinessConfigEntity {

    /**
     * 机构业务配置信息
     */
    public static final Integer BUSINESS_TYPE_ORG = 1;

    /**
     * 项目业务配置信息
     */
    public static final Integer BUSINESS_TYPE_PRO = 0;

    /**
     * id
     */
    private Integer id;
    /**
     * 业务编码
     */
    private String businessCode;
    /**
     * 业务类型 0 项目, 1 机构
     */
    private Integer businessType;
    /**
     * 配置类型，redeem 赎回，buyback 回购
     */
    private String configType;
    /**
     * 项目配置key值
     */
    private String configKey;
    /**
     * 项目配置value值
     */
    private String configValue;
    /**
     * 注释描述
     */
    private String comment;
    /**
     * 修改人
     */
    private String modifyUser;
    /**
     * 是否有效1有效0无效
     */
    private Integer yn;
    /**
     * 新建时间
     */
    private Date createdDate;
    /**
     * 修改时间
     */
    private Date modifiedDate;

    public BusinessConfigEntity() {
    }

    public BusinessConfigEntity(String businessCode, Integer businessType) {
        this(businessCode, businessType, null, null, null);
    }

    public BusinessConfigEntity(String businessCode, Integer businessType, String configType) {
        this(businessCode, businessType, configType, null, null);
    }

    public BusinessConfigEntity(String businessCode, Integer businessType, String configType,
                                String configKey) {
        this(businessCode, businessType, configType, configKey, null);
    }

    public BusinessConfigEntity(String businessCode, Integer businessType, String configType,
                                String configKey, String configValue) {
        this.businessCode = businessCode;
        this.businessType = businessType;
        this.configType = configType;
        this.configKey = configKey;
        this.configValue = configValue;
        this.yn = Integer.valueOf(1);
    }


    public BusinessConfigEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public BusinessConfigEntity setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
        return this;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public BusinessConfigEntity setBusinessType(Integer businessType) {
        this.businessType = businessType;
        return this;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public BusinessConfigEntity setConfigType(String configType) {
        this.configType = configType;
        return this;
    }

    public String getConfigType() {
        return configType;
    }

    public BusinessConfigEntity setConfigKey(String configKey) {
        this.configKey = configKey;
        return this;
    }

    public String getConfigKey() {
        return configKey;
    }

    public BusinessConfigEntity setConfigValue(String configValue) {
        this.configValue = configValue;
        return this;
    }

    public String getConfigValue() {
        return configValue;
    }

    public BusinessConfigEntity setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public BusinessConfigEntity setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public BusinessConfigEntity setYn(Integer yn) {
        this.yn = yn;
        return this;
    }

    public Integer getYn() {
        return yn;
    }

    public BusinessConfigEntity setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public BusinessConfigEntity setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    @Override
    public String toString() {
        return "BusinessConfigEntity{" +
                "id=" + id +
                ", businessCode='" + businessCode + '\'' +
                ", businessType=" + businessType +
                ", configType='" + configType + '\'' +
                ", configKey='" + configKey + '\'' +
                ", configValue='" + configValue + '\'' +
                ", comment='" + comment + '\'' +
                ", modifyUser='" + modifyUser + '\'' +
                ", yn=" + yn +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}