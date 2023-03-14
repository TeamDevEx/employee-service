package org.dremlogic.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AddressResponse {
	
	private Long id;
	
	private String street;
	
	private String city;

}
