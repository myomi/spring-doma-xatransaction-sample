package com.example.xat.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 */
public class LanguagesListener implements EntityListener<Languages> {

    @Override
    public void preInsert(Languages entity, PreInsertContext<Languages> context) {
    }

    @Override
    public void preUpdate(Languages entity, PreUpdateContext<Languages> context) {
    }

    @Override
    public void preDelete(Languages entity, PreDeleteContext<Languages> context) {
    }

    @Override
    public void postInsert(Languages entity, PostInsertContext<Languages> context) {
    }

    @Override
    public void postUpdate(Languages entity, PostUpdateContext<Languages> context) {
    }

    @Override
    public void postDelete(Languages entity, PostDeleteContext<Languages> context) {
    }
}