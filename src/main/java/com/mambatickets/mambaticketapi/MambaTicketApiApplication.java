package com.mambatickets.mambaticketapi;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import controller.SignUpController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import service.SignUpService;

import java.io.FileInputStream;

@SpringBootApplication
@ComponentScan({"controller"})
@ComponentScan({"model"})
@ComponentScan({"request"})
@ComponentScan({"response"})
@ComponentScan({"service"})
public class MambaTicketApiApplication {

	public static void main(String[] args) throws java.io.IOException {
		java.io.FileInputStream serviceAccount =
			new FileInputStream("mamba-tickets-firebase-adminsdk-16dde-de85233ff7.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
			.setCredentials(GoogleCredentials.fromStream(serviceAccount))
			.setDatabaseUrl("https://mamba-tickets.firebaseio.com")
			.build();

		// Initialize the default app
		FirebaseApp defaultApp = FirebaseApp.initializeApp(options);

		// Retrieve services by passing the defaultApp variable...
		FirebaseAuth defaultAuth = FirebaseAuth.getInstance(defaultApp);
		FirebaseDatabase defaultDatabase = FirebaseDatabase.getInstance(defaultApp);

		// Services
		SignUpService signUpService = new SignUpService();

		// Controllers
		SignUpController signUpController = new SignUpController(signUpService);

		SpringApplication.run(MambaTicketApiApplication.class, args);
	}

}
