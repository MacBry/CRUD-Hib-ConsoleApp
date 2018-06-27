package com.mac.bry.application;

import com.mac.bry.appController.AppController;

public class Application {

	public static void main(String[] args) {

		AppController appController = new AppController();
		
		appController.programLoop();
	}

}
