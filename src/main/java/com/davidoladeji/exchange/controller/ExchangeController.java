package com.davidoladeji.exchange.controller;

import com.davidoladeji.exchange.model.Exchange;
import com.davidoladeji.exchange.repository.ExchangeRepository;
import com.davidoladeji.exchange.util.CustomNumber;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by Daveola on 2/22/2015.
 */


@Controller
public class ExchangeController {

    double conversionresult;

    @Autowired
    ExchangeRepository currencyExchangeRepository;

    @RequestMapping (value = "/exchange/{symbone}/{symbtwo}/{amount}")
    @ResponseBody
    public ConversionResponse exchangeUtil(@PathVariable("symbone") String symbOne,@PathVariable("symbtwo") String symbTwo, @PathVariable("amount") double amount) {

        String message = "Successful conversion";
        Exchange exchange;
        CustomNumber number = new CustomNumber();
        ConversionResponse conversionResponse = new ConversionResponse();


        exchange = currencyExchangeRepository.findBySymbOneAndSymbTwo(symbOne, symbTwo);
        if (exchange != null) {
            conversionresult = number.round(exchange.getExchangerate() * amount, 3);
            conversionResponse.setConversionresult(conversionresult);
            conversionResponse.setMessage(message);
        }else if (exchange == null){
            conversionresult = 0.00000;
            message = "Unsuccessful conversion";
            conversionResponse.setConversionresult(conversionresult);
            conversionResponse.setMessage(message);
        }

        return conversionResponse;
    }


    public class ConversionResponse{

        private double conversionresult;
        private String message;

        public double getConversionresult() {
            return conversionresult;
        }

        public void setConversionresult(double conversionresult) {
            this.conversionresult = conversionresult;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}