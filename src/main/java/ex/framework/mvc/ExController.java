package ex.framework.mvc;

import org.springframework.stereotype.Controller;

@Controller
public class ExController {
	public static void main(String[] args) {
		double number = 11 / 5;
		number = Math.round(number * 10.0) / 10.0;
		System.out.println(number);
	}
}
