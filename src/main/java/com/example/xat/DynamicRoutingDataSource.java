package com.example.xat;

import java.sql.SQLException;

import javax.sql.XAConnection;
import javax.sql.XADataSource;

import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicRoutingDataSource extends AbstractRoutingDataSource implements XADataSource {
	private final DataSourceKeyStore store;
	
	public DynamicRoutingDataSource(DataSourceKeyStore store) {
		this.store = store;
	}

	/**
	 * from AbstractRoutingDataSource
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		var key = store.get();
		if (key == null) {
			return "default";
		}
		return key;
	}

	/**
	 * from XADataSource
	 */
	@Override
	public XAConnection getXAConnection() throws SQLException {
		var dataSource = (AtomikosDataSourceBean)this.determineTargetDataSource();
		return dataSource.getXaDataSource().getXAConnection();
	}

	/**
	 * from XADataSource
	 */
	@Override
	public XAConnection getXAConnection(String user, String password) throws SQLException {
		var dataSource = (AtomikosDataSourceBean)this.determineTargetDataSource();
		return dataSource.getXaDataSource().getXAConnection();
	}
}
