package com.football.pms.util;

import java.util.Random;

public class Prompt {

  public int age() {
    Random age = new Random();
    int i = age.nextInt(38)+18;
    return i;
  }

  public int height() {
    Random tall = new Random();
    int i = tall.nextInt(199)+168;
    return i;
  }

  public int weight() {
    Random kg = new Random();
    int i = kg.nextInt(99)+60;
    return i;
  }

}
