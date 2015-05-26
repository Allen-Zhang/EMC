package com.mercury.service;

import java.io.*;
import java.net.*;
import java.util.List;

import com.mercury.bean.Stock;

public class YahooFinance {
	private static void getPrice(Stock stock) {
		String yahoo_quote = "http://finance.yahoo.com/d/quotes.csv?s=" + stock.getId() + "&f=snc1l1&e=.c";
		double price = 0;
		double change = 0;
		try {
			URL url = new URL(yahoo_quote);
			URLConnection urlconn = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
			String content = in.readLine();
			content = content.replace((char)34, (char)32);
			String[] tokens = content.split(",");
			price = Double.parseDouble(tokens[tokens.length-1].trim());
			change = Double.parseDouble(tokens[tokens.length-2].trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
		stock.setPrice(price);
		stock.setChange(change);
	}
	public static void marketData(List<Stock> stocks) {
		for (Stock stock:stocks) {
			getPrice(stock);
		}
	}
}
