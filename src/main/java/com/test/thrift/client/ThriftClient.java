package com.test.thrift.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.test.thrift.Item;
import com.test.thrift.TestService;

public class ThriftClient {
	 public static void main(String [] args) {

		   
		    try {
		      TTransport transport;
		     
		      transport = new TSocket("localhost", 9090);
		      transport.open();

		      TProtocol protocol = new  TBinaryProtocol(transport);
		      TestService.Client client = new TestService.Client(protocol);

		      perform(client);

		      transport.close();
		    } catch (TException x) {
		      x.printStackTrace();
		    }  
		  }

		  private static void perform(TestService.Client client) throws TException
		  {
		   Item item = new Item();
		   item.setContent("content");
		   item.setId(1);
		   List<Item> list = new ArrayList<Item>();
		   list.add(item);
		   
		    long output = client.put(list);
		    System.out.println("output" + output);
		    int sum = client.add(2, 3);
		    System.out.println("sum" + sum);
		  }
}
