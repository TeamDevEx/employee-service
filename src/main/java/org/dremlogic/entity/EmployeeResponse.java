package org.dremlogic.entity;

import java.util.Optional;

import org.dremlogic.dto.AddressResponse;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmployeeResponse {
	
	private Long id;
	
	private String firstname;
	
	private String lastname;
	
	
	private AddressResponse addressResponse;
	

	public AddressResponse getAddressResponse() {
		return addressResponse;
	}

	public void setAddressResponse(AddressResponse addressResponse) {
		this.addressResponse = addressResponse;
	}

	public EmployeeResponse(Optional<Employee> employee) {
		// TODO Auto-generated constructor stub
	}

	
	

}
