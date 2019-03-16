package com.exapmle.xat.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

/**
 */
@Entity(listener = LanguagesListener.class)
@Table(name = "languages")
public class Languages {

    /** */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    Long languageId;

    /** */
    @Column(name = "language_code")
    String languageCode;

    /** */
    @Version
    @Column(name = "version_no")
    Integer versionNo;

    /** 
     * Returns the languageId.
     * 
     * @return the languageId
     */
    public Long getLanguageId() {
        return languageId;
    }

    /** 
     * Sets the languageId.
     * 
     * @param languageId the languageId
     */
    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    /** 
     * Returns the languageCode.
     * 
     * @return the languageCode
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /** 
     * Sets the languageCode.
     * 
     * @param languageCode the languageCode
     */
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    /** 
     * Returns the versionNo.
     * 
     * @return the versionNo
     */
    public Integer getVersionNo() {
        return versionNo;
    }

    /** 
     * Sets the versionNo.
     * 
     * @param versionNo the versionNo
     */
    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }
}