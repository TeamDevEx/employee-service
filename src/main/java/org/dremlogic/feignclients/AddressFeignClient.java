package org.dremlogic.feignclients;



import org.dremlogic.dto.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="address-service")
//@FeignClient(url="${address.service.url}" , value = "address-feign-client")
public interface AddressFeignClient {
	
	@GetMapping("/findById/{id}")
	public AddressResponse findEmplAddressById(@PathVariable Long id);	
	
	

}
