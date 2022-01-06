package com.example.eatclipse.model.member;

import java.util.List;

import com.example.eatclipse.model.commons.CommonsDTO;
import com.example.eatclipse.model.commons.LogDTO;





public interface RiderDAO {

		List<LogDTO> delivery_list(); // 
		List<LogDTO> accept_list(String name);  //  
	

	
	
}
