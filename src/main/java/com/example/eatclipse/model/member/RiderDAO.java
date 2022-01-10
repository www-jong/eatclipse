package com.example.eatclipse.model.member;

import java.util.List;
import java.util.Map;

import com.example.eatclipse.model.commons.CommonsDTO;
import com.example.eatclipse.model.commons.LogDTO;





public interface RiderDAO {

		List<LogDTO> delivery_list(); // 
		List<LogDTO> accept_list(String name);  //  
		
		void accept(LogDTO dto);
		void complete(Map<String,Object> map);
		List<LogDTO> detail(int no);
		//유저정보 업데이트
		void update(CommonsDTO dto);

		//유저탈퇴
		void delete(String userid);
		
		int getmoney(Map<String,Object> map);
		
		void addmoney(Map<String,Object> map);
		
		String getuserid(String name);
		
		void logtoupdate(Map<String,Object> map);
		
		String getshopname(String userid);
		List<LogDTO> complete_list(String userid);  //  
		
}
