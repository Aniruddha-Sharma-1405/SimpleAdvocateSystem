package com.amdocs.service.advocate;

import java.util.Scanner;

import com.amdocs.exception.InvalidServiceChoice;
import com.amdocs.exception.InvalidTimeException;

public class AdvocateChoices {
	Scanner sc = new Scanner(System.in);
	AdvocateService advocateService = new AdvocateService();

	public void advocateChoices() throws InvalidTimeException, InvalidServiceChoice {
		boolean flag = true;
		while (flag) {
			System.out.println("--------------------------Appointment Page--------------------------");
			System.out.println("Please Select an option from below");
			System.out.println("1. Book an appointment ");
			System.out.println("2. Modify appointment details");
			System.out.println("3. Delete an appointment");
			System.out.println("4. View single record");
			System.out.println("5. View all records");
			System.out.println("0. Exit");
			try {
				int ch = Integer.parseInt(sc.nextLine());
				switch (ch) {
				case 1:
					advocateService.bookAppointment();
					break;
				case 2:
					advocateService.modifyAppointment();
					break;
				case 3:
					advocateService.deleteAppointment();
					break;
				case 4:
					advocateService.viewOneAppointment();
					break;
				case 5:
					advocateService.viewAllAppointment();
					break;
				case 0:
					System.out.println("Returning to Home Page.....");
					flag = false;
				default:
					System.out.println("Please Try Again");
				}

			} catch (NumberFormatException e) {
				System.err.println("Please Enter Integer as Input");
			}
		}

	}
}
