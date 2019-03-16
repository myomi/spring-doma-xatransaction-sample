package com.example.xat.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.xat.dao.LanguagesDao;
import com.example.xat.entity.Languages;
import com.example.xat.service.LanguageService;

@RestController
@RequestMapping("/languages")
public class LanguageController {
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}

	@GetMapping(path="/{languageId}")
	public Languages selectById(@PathVariable("languageId") Long languageId) {
		return this.languageService.selectById(languageId);
	}
	
	@PostMapping
	public Languages insert(@RequestBody String languageCode) {
		return this.languageService.insertTest(languageCode);
	}
}
