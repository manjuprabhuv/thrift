package com.test.thrift.service;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import com.test.thrift.TestService;

public class Server {
	public static TestServiceImpl handler;

	  public static TestService.Processor processor;

	  public static void main(String [] args) {
	    try {
	      handler = new TestServiceImpl();
	      processor = new TestService.Processor(handler);

	      Runnable simple = new Runnable() {
	        public void run() {
	          simple(processor);
	        }
	      };      
	     
	      new Thread(simple).start();
	    } catch (Exception x) {
	      x.printStackTrace();
	    }
	  }

	  public static void simple(TestService.Processor processor) {
	    try {
	      TServerTransport serverTransport = new TServerSocket(9090);
	      TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));

	      System.out.println("Starting the simple server...");
	      server.serve();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	 
}