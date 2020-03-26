package kr.co.mayfarm.system.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringTrimConverter implements Converter<String, String> {

	@Override
	public String convert(String source) {
		return source.trim();
	}

}
