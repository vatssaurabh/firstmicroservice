package com.matchscore.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	@Autowired
    private ExchangeValueRepository exchangevaluerepository;
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@ResponseStatus(HttpStatus.GATEWAY_TIMEOUT)
	public ExchangeValue retrieveExchangeValue(@PathVariable String from,
			@PathVariable String to) {
		ExchangeValue exchangevalue =exchangevaluerepository.findByFromAndTo(from, to);
		exchangevalue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangevalue;
	}
}
