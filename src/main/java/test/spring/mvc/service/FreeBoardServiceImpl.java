package test.spring.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("free")
public class FreeBoardServiceImpl implements CrudService, Cloneable {

	@Override
	public void create(Object dto) {
		
	}
	
	@Override
	public void delete(Object dto) {
		
	}
	
	@Override
	public void update(Object dto) {
		
	}
	
	@Override
	public List<Object> read() {
		return null;
	}
	
}
