package com.ezen.phonefly2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.phonefly2.dao.IMobileDao;

@Service
public class MobileService {

	@Autowired
	IMobileDao mdao;

}
