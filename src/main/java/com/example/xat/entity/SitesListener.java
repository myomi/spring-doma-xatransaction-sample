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
public class SitesListener implements EntityListener<Sites> {

    @Override
    public void preInsert(Sites entity, PreInsertContext<Sites> context) {
    }

    @Override
    public void preUpdate(Sites entity, PreUpdateContext<Sites> context) {
    }

    @Override
    public void preDelete(Sites entity, PreDeleteContext<Sites> context) {
    }

    @Override
    public void postInsert(Sites entity, PostInsertContext<Sites> context) {
    }

    @Override
    public void postUpdate(Sites entity, PostUpdateContext<Sites> context) {
    }

    @Override
    public void postDelete(Sites entity, PostDeleteContext<Sites> context) {
    }
}