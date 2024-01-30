package ru.didcvee.consumesoap;

import com.javatechie.spring.soap.api.loaneligibility.Acknowledgement;
import com.javatechie.spring.soap.api.loaneligibility.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.didcvee.consumesoap.client.SoapClient;

@SpringBootApplication
@RestController
public class ConsumeSoapApplication {
    @Autowired
    private SoapClient client;
    @PostMapping("/getLoanStatus")
    public Acknowledgement invokeSoapClientToGetLoanStatus(@RequestBody CustomerRequest request) {
        return client.getLoanStatus(request);
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumeSoapApplication.class, args);
    }

}
