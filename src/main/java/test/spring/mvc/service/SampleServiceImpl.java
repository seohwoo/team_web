package test.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.spring.mvc.repository.Sample1Mapper;
import test.spring.mvc.repository.Sample2Mapper;

@Service
public class SampleServiceImpl {
	
	@Autowired
	private Sample1Mapper mapper1;
	
	@Autowired
	private Sample2Mapper mapper2;
	
	public void add(String data) {
		mapper1.insertCol1(data);
		
		mapper2.insertCol2(data);
	}
}
