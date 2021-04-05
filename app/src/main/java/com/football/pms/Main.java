package com.football.pms;

import com.football.pms.domain.LeagueTeam;
import com.football.pms.handler.MainHandler;
import com.football.pms.util.Prompt;

public class Main {

  public static void main(String[] args) {

    LeagueTeam league = null;
    MainHandler play = new MainHandler(league);

    while(true) {
      System.out.println("[ Soccer ]");
      String i = Prompt.inputString("1. Start"
          + "\n2. exit"
          + "\n> ");
      switch(i) {
        case "1":
          play.makeMyTeam();
        case "2":
          break;
        default : 
          System.out.printf("\n<<<<<다시 입력해 주세요>>>>>\n");
          continue;
      }
      System.out.println("[ GoodBye! ]");
      break;
    }

  }
}
