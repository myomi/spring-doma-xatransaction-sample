package com.exapmle.xat.dao;

import com.exapmle.xat.entity.Sites;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

/**
 */
@ConfigAutowireable
@Dao
public interface SitesDao {

    /**
     * @param siteId
     * @return the Sites entity
     */
    @Select
    Sites selectById(Long siteId);

    /**
     * @param siteId
     * @param versionNo
     * @return the Sites entity
     */
    @Select(ensureResult = true)
    Sites selectByIdAndVersion(Long siteId, Integer versionNo);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Sites entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Sites entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Sites entity);
}