package com.sliansoft.slianOA.dataaccess.model;

public class SystemSetting {
    private String stKey;

    private String stValue;

    private String decription;

    public String getStKey() {
        return stKey;
    }

    public void setStKey(String stKey) {
        this.stKey = stKey == null ? null : stKey.trim();
    }

    public String getStValue() {
        return stValue;
    }

    public void setStValue(String stValue) {
        this.stValue = stValue == null ? null : stValue.trim();
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription == null ? null : decription.trim();
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
        SystemSetting other = (SystemSetting) that;
        return (this.getStKey() == null ? other.getStKey() == null : this.getStKey().equals(other.getStKey()))
            && (this.getStValue() == null ? other.getStValue() == null : this.getStValue().equals(other.getStValue()))
            && (this.getDecription() == null ? other.getDecription() == null : this.getDecription().equals(other.getDecription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStKey() == null) ? 0 : getStKey().hashCode());
        result = prime * result + ((getStValue() == null) ? 0 : getStValue().hashCode());
        result = prime * result + ((getDecription() == null) ? 0 : getDecription().hashCode());
        return result;
    }
}