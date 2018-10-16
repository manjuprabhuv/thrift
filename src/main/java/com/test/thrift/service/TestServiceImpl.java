package com.test.thrift.service;

import java.util.List;

import org.apache.thrift.TException;

import com.test.thrift.*;
/**
 * Hello world!
 *
 */
public class TestServiceImpl implements TestService.Iface
{

	public long put(List<Item> items) throws TException {
		// TODO Auto-generated method stub
		
		for(Item item:items) {
			System.out.println(item.content);
			System.out.println(item.id);
		}
		return items.size();
	}

	public int add(int n1, int n2) throws TException {
		// TODO Auto-generated method stub
		return n1+n2;
	}
    

}
