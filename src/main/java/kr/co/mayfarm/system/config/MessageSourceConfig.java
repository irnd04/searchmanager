package kr.co.mayfarm.system.config;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import net.rakugakibox.util.YamlResourceBundle;

@SpringBootConfiguration
public class MessageSourceConfig {
	@Bean
	public MessageSource messageSource(
			@Value("${spring.messages.basename}") String basename,
			@Value("${spring.messages.encoding}") String encoding,
			@Value("${spring.messages.cache-duration}") int cacheSeconds,
			@Value("${spring.messages.fallback-to-system-locale}") boolean fullbackToSystemLocale) {
		YamlMessageSource ms = new YamlMessageSource();
		ms.setBasename(basename);
		ms.setDefaultEncoding(encoding);
		ms.setCacheSeconds(cacheSeconds);
		return ms;
	}
}

class YamlMessageSource extends ResourceBundleMessageSource {

	@Override
	protected ResourceBundle doGetBundle(String basename, Locale locale) throws MissingResourceException {
		return ResourceBundle.getBundle(basename, locale, YamlResourceBundle.Control.INSTANCE);
	}
	
}
