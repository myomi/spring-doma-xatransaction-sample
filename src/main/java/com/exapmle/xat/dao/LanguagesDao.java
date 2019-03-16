package com.exapmle.xat.dao;

import com.exapmle.xat.entity.Languages;
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
public interface LanguagesDao {

    /**
     * @param languageId
     * @return the Languages entity
     */
    @Select
    Languages selectById(Long languageId);

    /**
     * @param languageId
     * @param versionNo
     * @return the Languages entity
     */
    @Select(ensureResult = true)
    Languages selectByIdAndVersion(Long languageId, Integer versionNo);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Languages entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Languages entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Languages entity);
}