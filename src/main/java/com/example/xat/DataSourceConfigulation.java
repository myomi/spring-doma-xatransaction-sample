package com.example.xat;

import java.util.Map;

import javax.sql.DataSource;
import javax.sql.XADataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jdbc.XADataSourceWrapper;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.boot.jta.atomikos.AtomikosXADataSourceWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

@Configuration
@ConfigurationProperties(prefix = "datasource")
public class DataSourceConfigulation {
	private final DataSourceProperties properties;

	public DataSourceConfigulation(DataSourceProperties properties) {
		super();
		this.properties = properties;
	}

	/**
	 * 案1 AbstractRoutingDataSource() で頑張る - 無理
	 * @return
	 */
	@Bean
	public DataSource dataSource(DataSourceKeyStore store) {
		var resolver = new AbstractRoutingDataSource() {
			@Override
			protected Object determineCurrentLookupKey() {
				var key = store.get();
				if (key == null) {
					return "default";
				}
				return key;
			}
		};

		// setup routing
		DataSource defaultTargetDataSource = DataSourceBuilder.create()
				.driverClassName(this.properties.determineDriverClassName())
				.url(this.properties.determineUrl())
				.username(this.properties.determineUsername())
				.password(this.properties.determinePassword())
				.build();
		
		DataSource child1 = DataSourceBuilder.create()
				.driverClassName(this.properties.determineDriverClassName())
				.url("jdbc:postgresql://localhost:5432/child1")
				.username(this.properties.determineUsername())
				.password(this.properties.determinePassword())
				.build();
		DataSource child2 = DataSourceBuilder.create()
				.driverClassName(this.properties.determineDriverClassName())
				.url("jdbc:postgresql://localhost:5432/child2")
				.username(this.properties.determineUsername())
				.password(this.properties.determinePassword())
				.build();
		
				
				
		Map<Object, Object> targetDataSources = Map.of(
				"default", defaultTargetDataSource,
				"child1", child1,
				"child2", child2
				);
		resolver.setTargetDataSources(targetDataSources);
		// resolver.setDefaultTargetDataSource(defaultTargetDataSource);

		return resolver;
	}
	
//	/**
//	 * 案2 Atomikos の AtomikosDataSourceBean を改造して何とかならないか
//	 * @return
//	 * @throws Exception
//	 */
//	// @Bean
//	public AtomikosXADataSourceWrapper wrapDataSource() throws Exception {
//		return new AtomikosXADataSourceWrapper() {
//			@Override
//			public AtomikosDataSourceBean wrapDataSource(XADataSource dataSource)
//					throws Exception {
//				AtomikosDataSourceBean bean = new AtomikosDataSourceBean();
//				
//				bean.setXaDataSource(dataSource);
//				return bean;
//			}
//		};
//	}
}
