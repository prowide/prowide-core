package com.prowidesoftware.swift.model.field;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import org.junit.Test;

public class CurrencyResolverTest {
	private final class DummyCurrencyContainer implements CurrencyContainer {
		private List<String>currencies;
		
		DummyCurrencyContainer(List<String> list) {
			this.currencies = list;
		}
		public String componentsPattern() {
			// TODO Auto-generated method stub
			return null;
		}
		public String parserPattern() {
			// TODO Auto-generated method stub
			return null;
		}
		public List<String> currencyStrings() {
			return this.currencies;
		}
		public String currencyString() {
			// TODO Auto-generated method stub
			return null;
		}
		public List<Currency> currencies() {
			// TODO Auto-generated method stub
			return null;
		}
		public Currency currency() {
			// TODO Auto-generated method stub
			return null;
		}
		public void initializeCurrencies(String cur) {
			// TODO Auto-generated method stub
			
		}
		public void initializeCurrencies(Currency cur) {
			// TODO Auto-generated method stub
			
		}
	
	}
	@Test
	public void testResolveComponentsPattern() {
		List<String> components = new ArrayList<String>();
		components.add("c1");
		components.add("c2");
		components.add("c3");
		components.add("c4");
		components.add("c5");
		
		List<String> o = CurrencyResolver.resolveComponentsPattern("SC", components);
		assertEquals(1, o.size());
		assertEquals("c2", o.get(0));
		
		o = CurrencyResolver.resolveComponentsPattern("CS", components);
		assertEquals(1, o.size());
		assertEquals("c1", o.get(0));
		
		o = CurrencyResolver.resolveComponentsPattern("SCS", components);
		assertEquals(1, o.size());
		assertEquals("c2", o.get(0));
		
	}

	// FIXME fallo por un refactor que dejo mal el dummy container
	@Test
	public void testResolveCurrency() {
		List<String> list = new ArrayList<String>();
		list.add("USD");
		DummyCurrencyContainer o = new DummyCurrencyContainer(list);
		assertEquals("USD", CurrencyResolver.resolveCurrencyString(o));
	}
}
