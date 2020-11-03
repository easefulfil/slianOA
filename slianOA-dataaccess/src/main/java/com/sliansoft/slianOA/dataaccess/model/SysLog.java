package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class SysLog {
    private Integer logId;

    private Date logTime;

    private String logType;

    private Integer logUserId;

    private String logUserIp;

    private String logClass;

    private String logFunction;

    private String logParameters;

    private String logReturn;

    private String logMessage;

    private String logStatus;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    public Integer getLogUserId() {
        return logUserId;
    }

    public void setLogUserId(Integer logUserId) {
        this.logUserId = logUserId;
    }

    public String getLogUserIp() {
        return logUserIp;
    }

    public void setLogUserIp(String logUserIp) {
        this.logUserIp = logUserIp == null ? null : logUserIp.trim();
    }

    public String getLogClass() {
        return logClass;
    }

    public void setLogClass(String logClass) {
        this.logClass = logClass == null ? null : logClass.trim();
    }

    public String getLogFunction() {
        return logFunction;
    }

    public void setLogFunction(String logFunction) {
        this.logFunction = logFunction == null ? null : logFunction.trim();
    }

    public String getLogParameters() {
        return logParameters;
    }

    public void setLogParameters(String logParameters) {
        this.logParameters = logParameters == null ? null : logParameters.trim();
    }

    public String getLogReturn() {
        return logReturn;
    }

    public void setLogReturn(String logReturn) {
        this.logReturn = logReturn == null ? null : logReturn.trim();
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage == null ? null : logMessage.trim();
    }

    public String getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(String logStatus) {
        this.logStatus = logStatus == null ? null : logStatus.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysLog other = (SysLog) that;
        return (this.getLogId() == null ? other.getLogId() == null : this.getLogId().equals(other.getLogId()))
            && (this.getLogTime() == null ? other.getLogTime() == null : this.getLogTime().equals(other.getLogTime()))
            && (this.getLogType() == null ? other.getLogType() == null : this.getLogType().equals(other.getLogType()))
            && (this.getLogUserId() == null ? other.getLogUserId() == null : this.getLogUserId().equals(other.getLogUserId()))
            && (this.getLogUserIp() == null ? other.getLogUserIp() == null : this.getLogUserIp().equals(other.getLogUserIp()))
            && (this.getLogClass() == null ? other.getLogClass() == null : this.getLogClass().equals(other.getLogClass()))
            && (this.getLogFunction() == null ? other.getLogFunction() == null : this.getLogFunction().equals(other.getLogFunction()))
            && (this.getLogParameters() == null ? other.getLogParameters() == null : this.getLogParameters().equals(other.getLogParameters()))
            && (this.getLogReturn() == null ? other.getLogReturn() == null : this.getLogReturn().equals(other.getLogReturn()))
            && (this.getLogMessage() == null ? other.getLogMessage() == null : this.getLogMessage().equals(other.getLogMessage()))
            && (this.getLogStatus() == null ? other.getLogStatus() == null : this.getLogStatus().equals(other.getLogStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLogId() == null) ? 0 : getLogId().hashCode());
        result = prime * result + ((getLogTime() == null) ? 0 : getLogTime().hashCode());
        result = prime * result + ((getLogType() == null) ? 0 : getLogType().hashCode());
        result = prime * result + ((getLogUserId() == null) ? 0 : getLogUserId().hashCode());
        result = prime * result + ((getLogUserIp() == null) ? 0 : getLogUserIp().hashCode());
        result = prime * result + ((getLogClass() == null) ? 0 : getLogClass().hashCode());
        result = prime * result + ((getLogFunction() == null) ? 0 : getLogFunction().hashCode());
        result = prime * result + ((getLogParameters() == null) ? 0 : getLogParameters().hashCode());
        result = prime * result + ((getLogReturn() == null) ? 0 : getLogReturn().hashCode());
        result = prime * result + ((getLogMessage() == null) ? 0 : getLogMessage().hashCode());
        result = prime * result + ((getLogStatus() == null) ? 0 : getLogStatus().hashCode());
        return result;
    }
}