package org.cesi.payment.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class PaymentRequest {
	
	@ApiModelProperty(example = "999",required = true,allowableValues = "range[1,infinity]")
	@Min(value = 1)
	@NotNull
	private Long amount;

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}	
	

}
