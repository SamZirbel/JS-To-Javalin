package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Grapes;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class TesterController implements Controller {

	// VV Example Calling Java Functionality Without Parameter
	// VV And Obtaining Input
	// VV Handler Uses app.get
	public Handler oranges = (ctx) -> {
		
		String one = "One Orange Recieved From Java";
		
		ctx.json(one);
		ctx.status(200);
		
	};
	
	// VV Example Calling Java Functionality With Parameters
	// VV Printing Parameters To STD ERR
	// VV And Returning Another Output
	// VV Handler Uses app.post
	public Handler apples = (ctx) -> {
		
		String request = ctx.body();
		
		System.err.println("Apple Body Object : " + request);
		
		String response = "Received Apple";
		
		ctx.json(response);
		ctx.status(200);
		
	};
	
	// VV Example Of Using A Path Parameter For Function Input
	// VV No Other Input
	// VV Handler Uses app.get
	public Handler pears = (ctx) -> {
		
		String pathParam = ctx.pathParam("color");
		
		int intparam = Integer.parseInt(pathParam);
		
		System.out.println("Got Pear Path Param : " + intparam);
		
		List<String> stringList = new ArrayList<String>();
		
		stringList.add("String One");
		stringList.add("Pears PEARS Pears PEARS");
		stringList.add("String two");
		
		ctx.json(stringList);
		ctx.status(200);
		
	};
	
	// VV Example Calling Java Functionality With Parameters
	// VV And Uses A Path Parameter As Well!!
	//     ^^ 2 Different Types Wooh!!
	// VV Printing Parameters To STD ERR
	// VV And Returning An Output List Of Objects
	// VV Handler Uses app.post
	public Handler grapes = (ctx) -> {
		
		String request = ctx.body();
		
		System.err.println("Grape Request : " + request);
		
		String stringParam = ctx.pathParam("redBalloon");
		
		int intparam = Integer.parseInt(stringParam);
		
		System.err.println("How Many? : " + intparam);
		
		List<Grapes> grapevine = new ArrayList<Grapes>();
		
		for (int i = 0; i < intparam; ++ i) {
			
			String name = "Silly Grape Number : " + (i + 1);
			
			// VV Grapes Have 2 Seeds - Clearly
			int seeds = 2;
			
			grapevine.add(new Grapes(name, seeds));
			
		}
		
		
		ctx.json(grapevine);
		ctx.status(200);
		
	};
	
	
	
	@Override
	public void addRoutes(Javalin app) {
		
		app.get("tester", this.oranges);
		// VV Don't Forget The Colon Before Your Path Param
		app.get("tester/:color", this.pears);
		
		app.post("tester", this.apples);
		// VV Don't Forget The Colon Before Your Path Param
		app.post("tester/:redBalloon", this.grapes);
		
	}

}
