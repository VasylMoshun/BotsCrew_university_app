package org.moshun.botscrew_university_app.service.impl;

import java.util.Set;
import org.moshun.botscrew_university_app.service.CommandVerifier;
import org.springframework.stereotype.Service;

@Service
public class CommandVerifierImpl implements CommandVerifier {
    private static final Set<String> COMMANDS = Set.of(
            "1",
            "2",
            "3",
            "4",
            "5",
            "quit");
    @Override
    public boolean checkCommand(String command) {
        return COMMANDS.contains(command);
    }
//    private final static String WHO_IS_HEAD_OF_DEPARTMENT_COMMAND = "1";
//    private final static String SHOW_STATISTICS_COMMAND = "2";
//    private final static String SHOW_AVERAGE_SALARY_FOR_DEPARTMENT = "3";
//    private final static String SHOW_COUNT_OF_EMPLOYEE_COMMAND = "4";
//    private final static String GLOBAL_SEARCH_COMMAND = "5";
//    private final static String QUIT_COMMAND = "quit";
//
//    @Override
//    public String checkCommand(String command) {
//        Pattern pattern = Pattern.compile(QUIT_COMMAND);
//        Matcher matcher = pattern.matcher(command);
//        if (matcher.find()) {
//
//        }
//        return null;
//    }

}
