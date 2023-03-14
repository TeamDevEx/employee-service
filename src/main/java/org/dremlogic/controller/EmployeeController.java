package org.dremlogic.controller;

import java.util.Optional;

import org.dremlogic.dto.AddressResponse;
import org.dremlogic.entity.Employee;
import org.dremlogic.entity.EmployeeResponse;
import org.dremlogic.feignclients.AddressFeignClient;
import org.dremlogic.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	WebClient webClient;
	
	@Autowired
	AddressFeignClient addressFeignClient;

	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		return this.employeeRepository.save(employee);

	}

	@GetMapping("/findById/{id}")
	public EmployeeResponse findEmployeeById(@PathVariable Long id) {

		Optional<Employee> employee = this.employeeRepository.findById(id);

		EmployeeResponse response = new EmployeeResponse();
		response.setId(employee.get().getId());
		response.setFirstname(employee.get().getFirstname());
		response.setLastname(employee.get().getLastname());		
		
		//response.setAddressResponse(getAddressEmployee(id));
		response.setAddressResponse(addressFeignClient.findEmplAddressById(id));
		
		return response;
	}

	public AddressResponse getAddressEmployee(Long id) {
		Mono<AddressResponse> addressResponse = webClient.get().uri("/findById/" + id).retrieve()
				.bodyToMono(AddressResponse.class);
		return addressResponse.block();
	}

}
