package com.project.Member;

import java.util.ArrayList;
import java.util.Scanner;

class Members {
    String name;
    String gender;
    String phoneNumber;

    Members(String name, String gender, String phoneNumber) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Members{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

public class Member {
    private static ArrayList<Members> members = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addMember();
                    break;
                case 2:
                    viewMembers();
                    break;
                case 3:
                    updateMember();
                    break;
                case 4:
                    deleteMember();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Member");
        System.out.println("2. View Members");
        System.out.println("3. Update Member");
        System.out.println("4. Delete Member");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addMember() {
        System.out.print("Enter member's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter member's gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter member's phone number: ");
        String phoneNumber = scanner.nextLine();
        members.add(new Members(name, gender, phoneNumber));
        System.out.println("Member added successfully!");
    }

    private static void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members found.");
        } else {
            for (Members member : members) {
                System.out.println(member);
            }
        }
    }

    private static void updateMember() {
        System.out.print("Enter the name of the member to update: ");
        String name = scanner.nextLine();
        for (Members member : members) {
            if (member.name.equalsIgnoreCase(name)) {
                System.out.print("Enter new gender: ");
                member.gender = scanner.nextLine();
                System.out.print("Enter new phone number: ");
                member.phoneNumber = scanner.nextLine();
                System.out.println("Member updated successfully!");
                return;
            }
        }
        System.out.println("Member not found.");
    }

    private static void deleteMember() {
        System.out.print("Enter the name of the member to delete: ");
        String name = scanner.nextLine();
        for (Members member : members) {
            if (member.name.equalsIgnoreCase(name)) {
                members.remove(member);
                System.out.println("Member deleted successfully!");
                return;
            }
        }
        System.out.println("Member not found.");
    }
}
