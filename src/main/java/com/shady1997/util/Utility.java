package com.shady1997.util;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Utility {
    // TODO: use robot library for keyboard control
    public static void changeKeyBoard() throws AWTException {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ALT);
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyRelease(KeyEvent.VK_ALT);
        r.keyRelease(KeyEvent.VK_SHIFT);
    }

    // TODO: generate random string for data driven test
    public static String generateString(int StringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = StringLength;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

    // TODO: generate random character
    public static char generateCharacter() {

        return generateString(1).charAt(0);
    }

    // TODO: generate random integer number
    public static int generateInteger(int upperBound) {
        Random rand = new Random(); // instance of random class
        // generate random values from 0-24
        int int_random = rand.nextInt(upperBound);
        return int_random;
    }

    // TODO: generate integer of specific digits
    public static int generateRandomIntWithDigitSize(int digitSize) {
        Random random = new Random();
        int min = 100000000; // smallest 9-digit number
        int max = 999999999; // Largest 9-digit number
        return random.nextInt(max - min + 1) + min;
    }

    // TODO: generate random float number
    public static float generateFloat(int digitLength) {
        Random rand = new Random(); // instance of random class
        float float_random = rand.nextFloat();
        DecimalFormat df = new DecimalFormat(getDecimalFormat(digitLength));// format double digits
        float p = Float.parseFloat(df.format(float_random));
        return p;
    }

    // TODO: generate random double number
    public static double generateDouble(int digitLength) {
        Random rand = new Random(); // instance of random class
        double double_random = rand.nextDouble();// generate double number
        DecimalFormat df = new DecimalFormat(getDecimalFormat(digitLength));// format double digits
        double p = Double.parseDouble(df.format(double_random));
        return p;
    }

    // TODO: get decimal format
    public static String getDecimalFormat(int digitLength) {
        String doubleFormat = "#.";
        for (int i = 0; i < digitLength; i++) {
            doubleFormat += "#";
        }
        return doubleFormat;
    }

    // TODO: generate Random Plate Number
    public static String generateRandomPlateNumber() {
        StringBuilder plateNumber = new StringBuilder();

        // Generate 3 random uppercase letters
        for (int i = 0; i < 3; i++) {
            char randomLetter = (char) (new Random().nextInt(26) + 'A');
            plateNumber.append(randomLetter);
        }

        // Generate 4 random digits
        for (int i = 0; i < 4; i++) {
            int randomDigit = new Random().nextInt(10);
            plateNumber.append(randomDigit);
        }

        return plateNumber.toString();
    }

    // TODO: start html report
    public static void startHtmlReport(String reportDirName, String reportFileName) throws IOException {
        String path = System.getProperty("user.dir") + "/testReport.html";
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd " + reportDirName + " && " + reportFileName);
        builder.redirectErrorStream(true);
        Process p = builder.start();
    }

    // TODO: delete screenshots
    public static void deleteFilesInFolder(String folderPath) {
        File folder = new File(folderPath);
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        boolean isDeleted = file.delete();
                        if (isDeleted) {
                            System.out.println("Deleted: " + file.getName());
                        } else {
                            System.out.println("Failed to delete: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("The specified folder is empty or an error occurred.");
            }
        } else {
            System.out.println("The specified path is not a folder.");
        }
    }

    // TODO: Generate random unique int
    public static List<Integer> generateUniqueRandomNumbers(int count) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }
    // TODO: Support multi language on generated extend report and allure report
    public static void replaceLinesInExtendReportHtmlFile(String filePath) throws IOException {
        // Read the HTML file into a list of strings (each string is a line)
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        // Define the new content for the specific lines
        String line25 = "<style>\n" +
                "    .goog-te-gadget-simple{\n" +
                "    display:flex !important;\n" +
                "    width:100% !important;\n" +
                "    height:40px !important;\n" +
                "    }\n" +
                "    .goog-te-gadget-icon{\n" +
                "    padding-bottom:10px !important;\n" +
                "    }\n" +
                "    .goog-te-gadget-simple span{\n" +
                "    padding-top:15px !important;\n" +
                "    }\n" +
                "    .VIpgJd-ZVi9od-xl07Ob-lTBxed{\n" +
                "    height:20px!important;\n" +
                "    }\n";

        String line31 = "</style>\n" +
                "<script type=\"text/javascript\">// <![CDATA[\n" +
                "function googleTranslateElementInit() {\n" +
//                "    new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE,includedLanguages: 'az,br,de,en,ar,es,fr,he,isv,ja,ka,kr,nl,pl,ru,sv,tr,zh-CN'}, 'google_translate_element');\n" +
                "    new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');\n" +
                "}\n" +
                "// ]]></script>\n" +
                "<script src=\"//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit\" type=\"text/javascript\"></script>";

        String line67 = "<div id=\"google_translate_element\" style=\"float:right;height: 43px!important;width: 150px;\"></div>";

        // Replace specific lines
        lines.set(24, line25); // Line 25 (index 24 in zero-indexed list)
        lines.set(30, line31); // Line 31 (index 30 in zero-indexed list)
        lines.set(66, line67); // Line 67 (index 66 in zero-indexed list)

        // Write the updated content back to the file
        Files.write(Paths.get(filePath), lines);
    }
    public static void replaceLinesInAllureReportHtmlFile(String filePath) throws IOException {
        // Read the HTML file into a list of strings (each string is a line)
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        // Define the new content for the specific lines
        String line5 = "<title>Allure Report</title><div id=\"google_translate_element\" style=\"float:right; height: 43px !important; width: auto !important;\"></div>\n" +
                "\n" +
                "<style>\n" +
                "    .goog-te-gadget-simple {\n" +
                "        display: flex !important;\n" +
                "        justify-content: flex-end !important; /* Align content to the right */\n" +
                "        width: 100% !important;\n" +
                "        height: 40px !important;\n" +
                "        align-items: center !important; /* Vertically center the content */\n" +
                "    }\n" +
                "    .goog-te-gadget-icon {\n" +
                "        padding-bottom: 10px !important;\n" +
                "    }\n" +
                "    .goog-te-gadget-simple span {\n" +
                "        padding-top: 15px !important;\n" +
                "    }\n" +
                "    .VIpgJd-ZVi9od-xl07Ob-lTBxed {\n" +
                "        height: 20px !important;\n" +
                "    }\n" +
                "</style>\n" +
                "\n" +
                "<script type=\"text/javascript\">// <![CDATA[\n" +
                "function googleTranslateElementInit() {\n" +
                "    new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');\n" +
                "}\n" +
                "// ]]></script>\n" +
                "\n" +
                "<script src=\"//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit\" type=\"text/javascript\"></script>\n";

        // Replace specific lines
        lines.set(4, line5); // Line 5 (index 4 in zero-indexed list)

        // Write the updated content back to the file
        Files.write(Paths.get(filePath), lines);
    }
    // TODO: generate allure report after test finish as single html file
    public static void executeCommand(String command) throws IOException, InterruptedException {
        // Set default command if none is provided
        if (command == null || command.isEmpty()) {
            command = "allure generate --single-file target/allure-results";
        }

        // Create a ProcessBuilder instance
        ProcessBuilder processBuilder = new ProcessBuilder();

        // Detect the operating system
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            // For Windows, use cmd to run the command
            processBuilder.command("cmd.exe", "/c", command);
        } else {
            // For Unix-based systems, use bash to run the command
            processBuilder.command("bash", "-c", command);
        }

        // Redirect error stream (optional, if you want to merge standard error with standard output)
        processBuilder.redirectErrorStream(true);

        // Start the process
        Process process = processBuilder.start();

        // Capture the output of the command
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Print the output to the console (or handle it as needed)
            }
        }

        // Wait for the process to complete and get the exit value
        int exitCode = process.waitFor();
        System.out.println("Command executed with exit code: " + exitCode);
    }
}
