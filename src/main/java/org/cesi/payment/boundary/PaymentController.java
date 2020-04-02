package org.cesi.payment.boundary;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.cesi.payment.entity.Payment;
import org.cesi.payment.entity.PaymentRequest;
import org.cesi.payment.integration.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.annotations.ApiOperation;



@RestController
@CrossOrigin
@RequestMapping(value="payment",produces="application/json")
@RequestScope
public class PaymentController {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@ApiOperation(value="création d'un ordre de paiement")
	@RequestMapping(
			consumes = "application/json",
			method = RequestMethod.POST)
	public Payment placePayment(@RequestBody @Valid PaymentRequest paymentRequest) {
            Payment payment = new Payment();
            payment.setAmount(paymentRequest.getAmount());
			payment.setCreated(LocalDateTime.now());
			paymentRepository.save(payment);
			return payment;		
	}
	@ApiOperation(value="accéder à tous les paiements créés")
	@RequestMapping(value="all", method = RequestMethod.GET)
	public List<Payment> retrieveAllPayments(){
		return paymentRepository.findAll();
	}
	
	@ApiOperation(value="retrouver un paiement en fonction de son id")
	@RequestMapping(value="{id}",method = RequestMethod.GET)
	public Payment retrievePaymentById(@PathVariable Long id) {
		return paymentRepository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "id non valide"));
	}
}
