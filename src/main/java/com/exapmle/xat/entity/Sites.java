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
@Entity(listener = SitesListener.class)
@Table(name = "sites")
public class Sites {

    /** */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "site_id")
    Long siteId;

    /** */
    @Column(name = "site_name")
    String siteName;

    /** */
    @Column(name = "db_name")
    String dbName;

    /** */
    @Column(name = "db_url")
    String dbUrl;

    /** */
    @Column(name = "db_user")
    String dbUser;

    /** */
    @Column(name = "db_password")
    String dbPassword;

    /** */
    @Version
    @Column(name = "version_no")
    Integer versionNo;

    /** 
     * Returns the siteId.
     * 
     * @return the siteId
     */
    public Long getSiteId() {
        return siteId;
    }

    /** 
     * Sets the siteId.
     * 
     * @param siteId the siteId
     */
    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    /** 
     * Returns the siteName.
     * 
     * @return the siteName
     */
    public String getSiteName() {
        return siteName;
    }

    /** 
     * Sets the siteName.
     * 
     * @param siteName the siteName
     */
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    /** 
     * Returns the dbName.
     * 
     * @return the dbName
     */
    public String getDbName() {
        return dbName;
    }

    /** 
     * Sets the dbName.
     * 
     * @param dbName the dbName
     */
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    /** 
     * Returns the dbUrl.
     * 
     * @return the dbUrl
     */
    public String getDbUrl() {
        return dbUrl;
    }

    /** 
     * Sets the dbUrl.
     * 
     * @param dbUrl the dbUrl
     */
    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    /** 
     * Returns the dbUser.
     * 
     * @return the dbUser
     */
    public String getDbUser() {
        return dbUser;
    }

    /** 
     * Sets the dbUser.
     * 
     * @param dbUser the dbUser
     */
    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    /** 
     * Returns the dbPassword.
     * 
     * @return the dbPassword
     */
    public String getDbPassword() {
        return dbPassword;
    }

    /** 
     * Sets the dbPassword.
     * 
     * @param dbPassword the dbPassword
     */
    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
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