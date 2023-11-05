package org.moshun.botscrew_university_app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import jakarta.annotation.PostConstruct;
import org.moshun.botscrew_university_app.command.Command;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleController implements CommandLineRunner {

    private final List<Command> commands;
    private final Map<String, Command> commandMap = new HashMap<>();

    public ConsoleController(List<Command> commands) {
        this.commands = commands;
    }

    @PostConstruct
    public void init() {
        for (Command command : commands) {
            commandMap.put(command.getName(), command);
        }
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        String query;
        showInterface();

        while (true) {
            System.out.print("Please enter a command: ");
            command = scanner.nextLine();

            if ("quit".equalsIgnoreCase(command)) {
                System.out.println("Goodbye!");
                System.exit(0);
                return;
            }

            if (!commandMap.containsKey(command)) {
                System.out.println("Invalid command");
                showCommands();
                continue;
            }

            System.out.print("Please enter department name or template for Global search: ");
            query = scanner.nextLine();

            Command cmd = commandMap.get(command);
            if (cmd != null) {
                cmd.execute(query);
            } else {
                System.out.println("Command not found.");
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
