package com.football.pms.handler;

import java.util.LinkedList;
import java.util.List;
import com.football.pms.domain.LeagueTeam;
import com.football.pms.util.Prompt;

public class MainHandler {

  private List<LeagueTeam> list = new LinkedList<>();

  TeamSetting setting = new TeamSetting(list);
  TeamList teamlist = new TeamList(list);
  PlayLeague playLeague = new PlayLeague(list);

  public void makeMyTeam() {
    while(true) {
      String tName = Prompt.inputString("\n팀의 이름을 정해주세요.\n> ");
      String cName = Prompt.inputString("\n감독의 이름을 정해주세요.\n> ");
      String c = Prompt.inputString("입력하신 이름으로 진행 하시겠습니까? [y/N] > ");
      if (c.equalsIgnoreCase("y")) {

        System.out.println("팀 세팅이 완료되었습니다.");

        setting.makeTeam(league, tName, cName);
        menu();
      } else if (c.equalsIgnoreCase("n")) {
        continue;
      }
      break;
    }
  }

  public void menu() {
    menu:
      while(true) {
        int c2 = Prompt.inputInt("\n[_____Play Menu_____]"
            + "\n0.게임종료"
            + "\n1.내 팀 확인하기"
            + "\n2.타 팀 정보"
            + "\n3.경기진행"
            + "\n4.순위확인"
            + "\n5.리그개인순위"
            + "\n> ");
        switch (c2) {
          case 0:
            while(true) {
              String exit = Prompt.inputString("정말 종료하시겠습니까? [y/N]> ");
              if (exit.equalsIgnoreCase("y")) {
                System.out.println("다시오시길 기다리겠습니다..수고하셨습니다!");
                break menu;
              } else if (exit.equalsIgnoreCase("n")) {
                continue menu;
              } else {
                System.out.printf("\n<<<<<다시 입력해 주세요>>>>>\n");
                continue;
              }
            }
          case 1:
            list.privacy(league);
            continue;
          case 2:
            list.otherTeam();
            continue;
          case 3:
            playLeague.playLeagues();
            continue;
          case 4:
            playLeague.teamRanking();
            continue;
          case 5:
            int c3 = Prompt.inputInt("\n1.다득점 순위\n2.어시스트 순위\n3.뒤로가기\n> ");
            switch(c3) {
              case 1:
                playLeague.personalGoalRank();
                break;
              case 2:
                playLeague.personalAssistRank();
                break;
              case 3:
                break;
            }
            continue;
        }
        break;
      }
  }

}
