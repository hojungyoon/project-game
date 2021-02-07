package com.football.pms.util;

import java.sql.Date;
import java.util.Scanner;

public class Prompt {
  public static Scanner scanner = new Scanner(System.in);

  public static String inputString(String title) {
    System.out.printf(title);
    return scanner.nextLine();
  }

  public static int inputInt(String title) {
    return Integer.parseInt(inputString(title));
  }

  public static Date inputDay(String title) {
    return Date.valueOf(inputString(title));
  }

  static void close() {
    scanner.close();
  }
}
