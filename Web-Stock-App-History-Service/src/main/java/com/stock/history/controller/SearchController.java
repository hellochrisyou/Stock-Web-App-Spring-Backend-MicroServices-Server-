package com.stock.history.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stock.history.model.SearchHistory;
import com.stock.history.service.SearchService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/history")
public class SearchController {

	@Autowired
	SearchService historyService;
	
	@CrossOrigin
	@RequestMapping(value = "/findSearchHistory/", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SearchHistory> findSearchHistory(@RequestBody String email) {
		List<SearchHistory> check = historyService.findSearchHistory(email);
		return check;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/addSearchHistory", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SearchHistory addSearchHistory(@RequestBody SearchHistory history) {
		SearchHistory check = historyService.addSearchHistory(history);
		return check;
	}
		
	@CrossOrigin
	@RequestMapping(value = "/deleteSearchHistory", method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void clearSearchHistory(@RequestBody SearchHistory history) {
		historyService.clearSearchHistory(history);
		return;
	}
}