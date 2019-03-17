package com.example.xat;

import java.util.Map;

import javax.sql.XADataSource;

import org.postgresql.xa.PGXADataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.boot.jta.atomikos.AtomikosXADataSourceWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "datasource")
public class DataSourceConfigulation {
	private final DataSourceProperties properties;

	public DataSourceConfigulation(DataSourceProperties properties) {
		super();
		this.properties = properties;
	}

	/**
	 * ルーティングデータソースを作る
	 * @return
	 */
	// @Bean
	private XADataSource dataSource(DataSourceKeyStore store) {
		// setup routing
		// parent db
//		DataSource defaultTargetDataSource = DataSourceBuilder.create()
//				.driverClassName(this.properties.determineDriverClassName())
//				.url(this.properties.determineUrl())
//				.username(this.properties.determineUsername())
//				.password(this.properties.determinePassword())
//				.build();
		
		var defaultTargetDataSource = new PGXADataSource();
		defaultTargetDataSource.setUrl(this.properties.determineUrl());
		defaultTargetDataSource.setUser(this.properties.determineUsername());
		defaultTargetDataSource.setPassword(this.properties.determinePassword());
		var x = new AtomikosDataSourceBean();
		x.setXaDataSource(defaultTargetDataSource);
		
		// child1 db
//		DataSource child1 = DataSourceBuilder.create()
//				.driverClassName(this.properties.determineDriverClassName())
//				.url("jdbc:postgresql://localhost:5432/child1")
//				.username(this.properties.determineUsername())
//				.password(this.properties.determinePassword())
//				.build();


		var child1 = new PGXADataSource();
		child1.setUrl("jdbc:postgresql://localhost:5432/child1");
		child1.setUser(this.properties.determineUsername());
		child1.setPassword(this.properties.determinePassword());
		var y = new AtomikosDataSourceBean();
		y.setXaDataSource(child1);
		
		// child2 db
//		DataSource child2 = DataSourceBuilder.create()
//				.driverClassName(this.properties.determineDriverClassName())
//				.url("jdbc:postgresql://localhost:5432/child2")
//				.username(this.properties.determineUsername())
//				.password(this.properties.determinePassword())
//				.build();


		var child2 = new PGXADataSource();
		child2.setUrl("jdbc:postgresql://localhost:5432/child2");
		child2.setUser(this.properties.determineUsername());
		child2.setPassword(this.properties.determinePassword());
		var z = new AtomikosDataSourceBean();
		z.setXaDataSource(child2);

		
		Map<Object, Object> targetDataSources = Map.of(
				"default", x, //defaultTargetDataSource,
				"child1", y, //child1,
				"child2", z //child2
				);
		
		var resolver = new DynamicRoutingDataSource(store);
		resolver.setTargetDataSources(targetDataSources);
		resolver.afterPropertiesSet();

		return resolver;
	}

	
	/**
	 * 案2 Atomikos の AtomikosDataSourceBean を改造して何とかならないか
	 * @return
	 * @throws Exception
	 */
	@Bean
	public AtomikosXADataSourceWrapper wrapDataSource(DataSourceKeyStore store) throws Exception {
		final XADataSource xaDataSource = dataSource(store);
		
		return new AtomikosXADataSourceWrapper() {
			@Override
			public AtomikosDataSourceBean wrapDataSource(XADataSource dataSource)
					throws Exception {
				AtomikosDataSourceBean bean = new AtomikosDataSourceBean();
				// データソースを DynamicRoutingDataSourceに差し替えてしまう
				bean.setXaDataSource(xaDataSource);
				return bean;
			}
		};
	}
}
