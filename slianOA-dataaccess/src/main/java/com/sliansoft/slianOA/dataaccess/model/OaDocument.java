package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaDocument {
    private Integer documentId;

    private String docNumber;

    private String docPostMan;

    private String docRegistPerson;

    private Date docTime;

    private String title;

    private String subtitle;

    private String docFromInstitution;

    private String docIsEmergency;

    private String docFromNum;

    private Integer docPages;

    private Integer docCopies;

    private String docOfficeHanding;

    private String status;

    private Date docDraftTime;

    private String type;

    private String docMainToUnit;

    private String docCopyToUnits;

    private Date docSendTime;

    private String remark;

    private Integer accessGroup;

    private Date amendTime;

    private Integer amender;

    private Date createTime;

    private Integer creator;

    private String viewEmployeeIds;

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber == null ? null : docNumber.trim();
    }

    public String getDocPostMan() {
        return docPostMan;
    }

    public void setDocPostMan(String docPostMan) {
        this.docPostMan = docPostMan == null ? null : docPostMan.trim();
    }

    public String getDocRegistPerson() {
        return docRegistPerson;
    }

    public void setDocRegistPerson(String docRegistPerson) {
        this.docRegistPerson = docRegistPerson == null ? null : docRegistPerson.trim();
    }

    public Date getDocTime() {
        return docTime;
    }

    public void setDocTime(Date docTime) {
        this.docTime = docTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    public String getDocFromInstitution() {
        return docFromInstitution;
    }

    public void setDocFromInstitution(String docFromInstitution) {
        this.docFromInstitution = docFromInstitution == null ? null : docFromInstitution.trim();
    }

    public String getDocIsEmergency() {
        return docIsEmergency;
    }

    public void setDocIsEmergency(String docIsEmergency) {
        this.docIsEmergency = docIsEmergency == null ? null : docIsEmergency.trim();
    }

    public String getDocFromNum() {
        return docFromNum;
    }

    public void setDocFromNum(String docFromNum) {
        this.docFromNum = docFromNum == null ? null : docFromNum.trim();
    }

    public Integer getDocPages() {
        return docPages;
    }

    public void setDocPages(Integer docPages) {
        this.docPages = docPages;
    }

    public Integer getDocCopies() {
        return docCopies;
    }

    public void setDocCopies(Integer docCopies) {
        this.docCopies = docCopies;
    }

    public String getDocOfficeHanding() {
        return docOfficeHanding;
    }

    public void setDocOfficeHanding(String docOfficeHanding) {
        this.docOfficeHanding = docOfficeHanding == null ? null : docOfficeHanding.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getDocDraftTime() {
        return docDraftTime;
    }

    public void setDocDraftTime(Date docDraftTime) {
        this.docDraftTime = docDraftTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDocMainToUnit() {
        return docMainToUnit;
    }

    public void setDocMainToUnit(String docMainToUnit) {
        this.docMainToUnit = docMainToUnit == null ? null : docMainToUnit.trim();
    }

    public String getDocCopyToUnits() {
        return docCopyToUnits;
    }

    public void setDocCopyToUnits(String docCopyToUnits) {
        this.docCopyToUnits = docCopyToUnits == null ? null : docCopyToUnits.trim();
    }

    public Date getDocSendTime() {
        return docSendTime;
    }

    public void setDocSendTime(Date docSendTime) {
        this.docSendTime = docSendTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getAccessGroup() {
        return accessGroup;
    }

    public void setAccessGroup(Integer accessGroup) {
        this.accessGroup = accessGroup;
    }

    public Date getAmendTime() {
        return amendTime;
    }

    public void setAmendTime(Date amendTime) {
        this.amendTime = amendTime;
    }

    public Integer getAmender() {
        return amender;
    }

    public void setAmender(Integer amender) {
        this.amender = amender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getViewEmployeeIds() {
        return viewEmployeeIds;
    }

    public void setViewEmployeeIds(String viewEmployeeIds) {
        this.viewEmployeeIds = viewEmployeeIds == null ? null : viewEmployeeIds.trim();
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
        OaDocument other = (OaDocument) that;
        return (this.getDocumentId() == null ? other.getDocumentId() == null : this.getDocumentId().equals(other.getDocumentId()))
            && (this.getDocNumber() == null ? other.getDocNumber() == null : this.getDocNumber().equals(other.getDocNumber()))
            && (this.getDocPostMan() == null ? other.getDocPostMan() == null : this.getDocPostMan().equals(other.getDocPostMan()))
            && (this.getDocRegistPerson() == null ? other.getDocRegistPerson() == null : this.getDocRegistPerson().equals(other.getDocRegistPerson()))
            && (this.getDocTime() == null ? other.getDocTime() == null : this.getDocTime().equals(other.getDocTime()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getSubtitle() == null ? other.getSubtitle() == null : this.getSubtitle().equals(other.getSubtitle()))
            && (this.getDocFromInstitution() == null ? other.getDocFromInstitution() == null : this.getDocFromInstitution().equals(other.getDocFromInstitution()))
            && (this.getDocIsEmergency() == null ? other.getDocIsEmergency() == null : this.getDocIsEmergency().equals(other.getDocIsEmergency()))
            && (this.getDocFromNum() == null ? other.getDocFromNum() == null : this.getDocFromNum().equals(other.getDocFromNum()))
            && (this.getDocPages() == null ? other.getDocPages() == null : this.getDocPages().equals(other.getDocPages()))
            && (this.getDocCopies() == null ? other.getDocCopies() == null : this.getDocCopies().equals(other.getDocCopies()))
            && (this.getDocOfficeHanding() == null ? other.getDocOfficeHanding() == null : this.getDocOfficeHanding().equals(other.getDocOfficeHanding()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDocDraftTime() == null ? other.getDocDraftTime() == null : this.getDocDraftTime().equals(other.getDocDraftTime()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getDocMainToUnit() == null ? other.getDocMainToUnit() == null : this.getDocMainToUnit().equals(other.getDocMainToUnit()))
            && (this.getDocCopyToUnits() == null ? other.getDocCopyToUnits() == null : this.getDocCopyToUnits().equals(other.getDocCopyToUnits()))
            && (this.getDocSendTime() == null ? other.getDocSendTime() == null : this.getDocSendTime().equals(other.getDocSendTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getViewEmployeeIds() == null ? other.getViewEmployeeIds() == null : this.getViewEmployeeIds().equals(other.getViewEmployeeIds()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDocumentId() == null) ? 0 : getDocumentId().hashCode());
        result = prime * result + ((getDocNumber() == null) ? 0 : getDocNumber().hashCode());
        result = prime * result + ((getDocPostMan() == null) ? 0 : getDocPostMan().hashCode());
        result = prime * result + ((getDocRegistPerson() == null) ? 0 : getDocRegistPerson().hashCode());
        result = prime * result + ((getDocTime() == null) ? 0 : getDocTime().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getSubtitle() == null) ? 0 : getSubtitle().hashCode());
        result = prime * result + ((getDocFromInstitution() == null) ? 0 : getDocFromInstitution().hashCode());
        result = prime * result + ((getDocIsEmergency() == null) ? 0 : getDocIsEmergency().hashCode());
        result = prime * result + ((getDocFromNum() == null) ? 0 : getDocFromNum().hashCode());
        result = prime * result + ((getDocPages() == null) ? 0 : getDocPages().hashCode());
        result = prime * result + ((getDocCopies() == null) ? 0 : getDocCopies().hashCode());
        result = prime * result + ((getDocOfficeHanding() == null) ? 0 : getDocOfficeHanding().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDocDraftTime() == null) ? 0 : getDocDraftTime().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getDocMainToUnit() == null) ? 0 : getDocMainToUnit().hashCode());
        result = prime * result + ((getDocCopyToUnits() == null) ? 0 : getDocCopyToUnits().hashCode());
        result = prime * result + ((getDocSendTime() == null) ? 0 : getDocSendTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getViewEmployeeIds() == null) ? 0 : getViewEmployeeIds().hashCode());
        return result;
    }
}