package org.moshun.botscrew_university_app.controller;

import org.moshun.botscrew_university_app.service.CommandVerifier;
import org.moshun.botscrew_university_app.service.DepartmentService;
import org.moshun.botscrew_university_app.service.LectorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleController implements CommandLineRunner {

    private final DepartmentService departmentService;
    private final LectorService lectorService;
    private final CommandVerifier commandVerifier;

    public ConsoleController(DepartmentService departmentService,
                             LectorService lectorService,
                             CommandVerifier commandVerifier) {
        this.departmentService = departmentService;
        this.lectorService = lectorService;
        this.commandVerifier = commandVerifier;
    }


    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        String command = "";
        String query = "";
        showInterface();
        while (true) {
            System.out.println("Please enter a command: ");
            command = scanner.nextLine();
            if (!commandVerifier.checkCommand(command)) {
                System.out.println("Invalid command");
                showCommands();
            } else {
                System.out.println("Please enter department name or template for Global search : ");
                query = scanner.nextLine();
            }


            switch (command) {
                case "1":
                    String headOfDepartment = departmentService
                            .getHeadOfDepartment(query);
                    System.out.println("Head of " + query
                            + " department is " + headOfDepartment);
                    break;
                case "2":
                    String lectorsStatistic = departmentService
                            .getLectorsStatistic(query);
                    System.out.println(lectorsStatistic);
                    break;
                case "3":
                    String lectorsAverageSalary = departmentService
                            .getLectorsAverageSalary(query);
                    System.out.println("The average salary of "
                            + query + " is " + lectorsAverageSalary);
                    break;
                case "4":
                    String countOfEmployee = departmentService.
                            getCountOfEmployee(query);
                    System.out.println("Employee in "
                            + query + " : " + countOfEmployee);
                    break;
                case "5":
                    List<String> globalSearch = lectorService.globalSearch(query);
                    System.out.println(globalSearch);
                    break;
                case "quit":
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
            }
        }
    }

    private static void showInterface() {
        showDepartments();
        showCommands();
    }

    private static void showCommands() {
        System.out.println("--------------------COMMANDS----------------------------------------");
        System.out.println("1# Who is head of department {department_name}");
        System.out.println("2# Show {department_name} statistics");
        System.out.println("3# Show the average salary for the department {department_name}");
        System.out.println("4# Show count of employee for {department_name}");
        System.out.println("5# Global search by {template}");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("quit to exit ");
        System.out.println("---------------------------------------------------------------------");
    }

    private static void showDepartments() {
        System.out.println("--------------------DEPARTMENTS---------------------------------------");
        System.out.println("computer science");
        System.out.println("physics");
        System.out.println("history");
        System.out.println("mathematics");
        System.out.println("english");
    }
}
