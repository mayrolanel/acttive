package br.com.cursocucumber.config;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;

public class RegistryCucumber implements TypeRegistryConfigurer {

	public Locale locale() {
		return Locale.ENGLISH;
	}

	public void configureTypeRegistry(TypeRegistry registry) {
		registry.defineParameterType(new ParameterType<>("data", ".*", Date.class, (String s) -> {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dataFormatada;

			try {
				dataFormatada = dateFormat.parse(s);
				return dataFormatada;
			} catch (ParseException e) {
				return null;
			}
		}));
	}

}
