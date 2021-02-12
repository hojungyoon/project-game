package com.football.pms;

import com.football.pms.handler.mainHandler;
import com.football.pms.util.List;
import com.football.pms.util.Prompt;

public class Main {

  public static void main(String[] args) {

    List list = new List();
    mainHandler play = new mainHandler();

    while(true) {
      System.out.println("[ 운빨 축구 게임 ]");
      String i = Prompt.inputString("1. Start"
          + "\n2. exit"
          + "\n> ");
      switch(i) {
        case "1":
          play.makeMyTeam();
        case "2":
          break;
        default : 
          System.out.printf("\n<<<<<다시 입력해 주세요.>>>>>\n");
          continue;
      }
      System.out.println("[ GoodBye! ]");
      break;
    }

  }
}
