package com.example.xat.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.xat.dao.LanguagesDao;
import com.example.xat.entity.Languages;

@Service
@Transactional
public class LanguageService {
	private final LanguagesDao languagesDao;
		
	public LanguageService(LanguagesDao languagesDao) {
		this.languagesDao = languagesDao;
	}

	public Languages selectById(long languageId) {
		return this.languagesDao.selectById(languageId);
	}
	
	public Languages insertTest(String languageCode) {
		var result = new Languages();
		result.setLanguageCode(languageCode);
		this.languagesDao.insert(result);
		return result;
	}
}
