package com.udaan;

import com.udaan.constants.Constant;
import com.udaan.models.Application;
import com.udaan.services.ApplicationService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
        System.out.println("Application Started");
        //Scanner input = new Scanner(new File(args[0]));
        Scanner input = new Scanner(System.in);
        ApplicationService applicationService = new ApplicationService();
        while (true) {
            String line = input.nextLine().trim();
            if (line.equalsIgnoreCase(Constant.EXIT)) {
                break;
            }
            String[] commands = line.split(" ");
            switch (commands[0]) {
                case Constant.ADD_USER:
                    if (commands.length != 2) {
                        System.out.println(Constant.INVALID_INPUT);
                    } else {
                        applicationService.createUser(commands[1]);
                    }

                    break;
                case Constant.ADD_DEAL:
                    if (commands.length != 5) {
                        System.out.println(Constant.INVALID_INPUT);
                    } else {
                        applicationService.addDeal(commands[1], Integer.parseInt(commands[2]), Double.parseDouble(commands[3]), Integer.parseInt(commands[4]));
                    }
                    break;
                case Constant.CLAIM_DEAL:
                    if (commands.length != 3 ){
                        System.out.println(Constant.INVALID_INPUT);
                    } else {
                        applicationService.claimDeal(commands[1], commands[2]);
                    }
                    break;
                case Constant.UPDATE_DEAL:
                    if (commands.length != 5) {
                        System.out.println(Constant.INVALID_INPUT);
                    } else {
                        applicationService.updateDeal(commands[1], Integer.parseInt(commands[2]), Double.parseDouble(commands[3]), Integer.parseInt(commands[4]));
                    }
                    break;
                case Constant.END_DEAL:
                    if (commands.length != 2) {
                        System.out.println(Constant.INVALID_INPUT);
                    } else {
                        applicationService.endDeal(commands[1]);
                    }
                    break;
                case Constant.TXN_DETAILS:
                    applicationService.printTransactionDetails();
                    break;
//                default:
//                    System.out.println("Invalid input format please try again");
            }
        }
    }
}
