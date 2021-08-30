package comcast.digital.assignment.lcs.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import comcast.digital.assignment.commons.LCSGeneratorException;
import comcast.digital.assignment.lcs.model.LCSRequest;
import comcast.digital.assignment.lcs.model.LCSResponse;
import comcast.digital.assignment.lcs.model.SetOfString;
import comcast.digital.assignment.lcs.service.LCSGeneratorService;

@RestController
public class LCSController {
	
	@Autowired
	private LCSGeneratorService lcsGeneratorService;
	private static List<SetOfString> lcs;
	Set<String> uniqueInputSet;
	
	@PostMapping("/lcs")
	public ResponseEntity<LCSResponse> findLongestCommonSubstring(@RequestBody LCSRequest lcsRequest) {
		lcs = lcsRequest.getSetOfStrings();
		uniqueInputSet = lcs.stream().map(SetOfString::getValue).collect(Collectors.toSet());
		validateLCSRequest(lcsRequest);// uniqueSet
		return ResponseEntity.ok().body(lcsGeneratorService.getLongestCommonString(uniqueInputSet));
	}

	public void validateLCSRequest(LCSRequest lcsRequest) {
		
		if (lcs.isEmpty())
			throw new LCSGeneratorException("set of string in request body should not be empty");
		else if (lcs.size() < 2)
			throw new LCSGeneratorException("atleast 2 strings should be placed in request body for comparision");
		else if (uniqueInputSet.size() == 1)
			throw new LCSGeneratorException("all String are same , so we cannot compare ");
	}
}
