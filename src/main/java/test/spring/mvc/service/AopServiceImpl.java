package test.spring.mvc.service;

import org.springframework.stereotype.Service;

@Service
public class AopServiceImpl implements AopService {

	@Override
	public void test() {
		System.out.println("========AopService test()======");
	}

	@Override
	public String msg(String s) {
		System.out.println("======AopService msg()======");
		return "hello world="+s;
	}

	@Override
	public int doAdd(int a, int b) {
		System.out.println("======AopService doAdd()======");
		return a+b;
	}

}
