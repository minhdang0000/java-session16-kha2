package Kha2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Event> events = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        while (true) {
            String name = "";
            while (true) {
                System.out.println("Nhập tên sự kiện (hoặc 'exit' để thoát):");
                name = scanner.nextLine();

                if (name.equalsIgnoreCase("exit")) {
                    break;
                }

                if (name.trim().isEmpty()) {
                    System.out.println("\nCan not enter empty string");
                    continue;
                }
                break;
            }

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            LocalDateTime startDate = null;
            while (true) {
                System.out.println("Nhập thời gian bắt đầu (dd-MM-yyyy HH:mm):");
                String startStr = scanner.nextLine();
                try {
                    startDate = LocalDateTime.parse(startStr, formatter);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Enter not valid date");
                }
            }

            LocalDateTime endDate = null;
            while (true) {
                System.out.println("Nhập thời gian kết thúc (dd-MM-yyyy HH:mm):");
                String endStr = scanner.nextLine();
                try {
                    endDate = LocalDateTime.parse(endStr, formatter);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Enter not valid date");
                }
            }

            events.add(new Event(name, startDate, endDate));
        }

        System.out.println("Danh sách sự kiện:");
        for (Event event : events) {
            System.out.println(event);
        }

        scanner.close();
    }
}
