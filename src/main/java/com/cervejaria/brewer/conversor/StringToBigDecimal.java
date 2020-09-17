package com.cervejaria.brewer.conversor;

import java.math.BigDecimal;

import org.springframework.core.convert.converter.Converter;

public class StringToBigDecimal implements Converter<String, BigDecimal> {

	@Override
	public BigDecimal convert(String text) {
		text = text.trim();
		
		if (text.matches("[0-9]+")){
			return new BigDecimal(text);
		}
		
		return null;
	}
}
