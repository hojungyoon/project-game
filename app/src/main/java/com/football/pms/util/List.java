package com.football.pms.util;

import java.util.Random;

public class List {

  public static String makeRanName(String[] str, String[] str2) {
    Random randomNum = new Random();

    int random1 = randomNum.nextInt(str.length);
    String a = str[random1];

    int random2 = randomNum.nextInt(str2.length);
    String b = str[random2];

    return a + " " + b;
  }

  public String nameReturn() {
    Name name = new Name();
    return makeRanName(name.getSecoundNames(), name.getFirstNames());

  }


}
