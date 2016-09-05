package com.unj.dubbotest.provider.impl;

import com.unj.dubbotest.provider.CalcService;

public class CalcServiceImpl implements CalcService {

	@Override
	public long factorial(int num) {
		long res = 1;
		for(int i=1;i<=num;i++){
			res *= i;
		}
		return res;
	}

}
