package com.rays.ctl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;
import com.rays.common.SpringResponse;
import com.rays.dto.UserDTO;

@RestController
@RequestMapping(value = "TestCtl")
public class TestCtl {

	@GetMapping
	public SpringResponse display() {

		SpringResponse res = new SpringResponse();

		res.setMessage("data addedd successfully");

         UserDTO dto = new UserDTO();
       //  dto.setId(101);
         dto.setFirstName("Yash");
         dto.setLastName("Kumbhkar");
         dto.setLoginId("yash@gmail.com");
         dto.setPassword("1222323");
         
           Map map = new HashMap();
           map.put("dto", dto);
           res.setResult(map);
		 
		return res;
	}

	@GetMapping("testORSResponse")
	public ORSResponse testORSResponse() {

		ORSResponse res = new ORSResponse();

		Map errors = new HashMap();
		errors.put("firstName", "first name is required");
		errors.put("lastName", "last name is required");
		errors.put("loginId", "login id is required");
		errors.put("password", "password is required");

		res.addInputError(errors);

		UserDTO dto = new UserDTO();
		//dto.setId(100);
		dto.setFirstName("Yash");
		dto.setLastName("kumbhkar");
		dto.setLoginId("Yash@gmail.com");
		dto.setPassword("Yash@123");

		res.addData(dto);

		res.addMessage("login & password invalid");

		res.addResult("hello", "hi");
		res.addResult("data added", "success");
		res.addMessage(" please re login ");

		return res;
	}
	}
