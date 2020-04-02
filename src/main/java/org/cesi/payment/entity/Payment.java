package org.cesi.payment.entity;

import java.time.LocalDateTime;

import javax.persistence.*;
import io.swagger.annotations.ApiModelProperty;


@Entity
public class Payment {
	
	@ApiModelProperty(example = "1", required = true)
	@Id
	@Column(name="pk")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ApiModelProperty(example = "999", required = true)
	private Long amount;
	@ApiModelProperty(required = true)
	private LocalDateTime created;
		
	public Long getId() {
		return id;
	}
	
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	
	
	
	

}
