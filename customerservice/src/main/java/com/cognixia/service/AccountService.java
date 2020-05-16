package com.cognixia.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognixia.model.Account;

@Service
@FeignClient(name = "account-service", fallback = AccountServiceImpl.class)
public interface AccountService {

	@GetMapping(value = "/account/customer/{customer}")
	List<Account> findByCutomer(@PathVariable("customer") Integer customer);

	@PutMapping(value = "/account/{accountId}")
	Account update(@PathVariable("accountId") Integer accountId,@RequestBody Account account);

	@DeleteMapping(value = "/account/{accountId}")
	void delete(@PathVariable("accountId") Integer accountId);

	
	@PostMapping(value = "/account")
	Account update(@RequestBody Account account);

}