package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ItemManagmtSystemServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemManagmtSystemServerApplication.class, args);
	}
	
	/* Do not delete, to use later for internalization
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US); // Set default Locale as US
		return slr;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasenames("i18n/messages");  // name of the resource bundle 
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}
	*/
}
