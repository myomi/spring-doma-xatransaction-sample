package com.example.xat.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.xat.DataSourceKeyStore;

@Aspect
@Component
@Order(Ordered.LOWEST_PRECEDENCE - 1)	// トランザクションマネージャよりも先に実行する
public class SampleAspect {
	private final DataSourceKeyStore store;
	
    public SampleAspect(DataSourceKeyStore store) {
		this.store = store;
	}

	@Before("execution(* *..LanguageService.*(..)) && args(siteName,..)")
	public void saveStore(String siteName) {
		System.out.println("SiteName: " + siteName);
		this.store.set(siteName);
	}
	
	@After("execution(* *..LanguageService.*(..))")
    public void clear() {
		this.store.clear();
    }
}
