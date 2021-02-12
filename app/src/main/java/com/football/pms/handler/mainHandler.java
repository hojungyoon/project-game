package com.football.pms.handler;

import com.football.pms.domain.LeagueTeam;
import com.football.pms.util.List;
import com.football.pms.util.Prompt;

public class mainHandler {
  LeagueTeam league;

  private List list = new List();
  TeamSetting setting = new TeamSetting();

  public void makeMyTeam() {
    while(true) {
      String tName = Prompt.inputString("\n팀의 이름을 정해주세요.\n> ");
      String cName = Prompt.inputString("\n감독의 이름을 정해주세요.\n> ");
      String c = Prompt.inputString("이름으로 진행 하시겠습니까? [y/N] > ");
      if (c.equalsIgnoreCase("y")) {
        System.out.printf("\n팀을 꾸리는 중입니다."
            + "\n."
            + "\n."
            + "\n."
            + "\n완료되었습니다.\n");
        setting.makeTeam(tName, cName);
        setting.makeFAplayer();

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
        int c2 = Prompt.inputInt("\n0.게임종료"
            + "\n1.내 팀정보"
            + "\n2.팀 선수정보"
            + "\n3.타팀 정보"
            + "\n4.FA 리스트"
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
            setting.teamInfo();
            continue;
          case 2:
            setting.privacy();
            continue;
          case 3:
            setting.otherTeam();
            setting.otherTeamInfo();
            continue;
          case 4:
            setting.FAplayerList();
            continue;

        }
        break;
      }
  }


  private LeagueTeam findByNo(int No) {
    Object[] list = this.list.toArray();
    for (Object obj : list) {
      LeagueTeam b = (LeagueTeam) obj;
      if (b.getTeamCode() == No) {
        return b;
      }
    }
    return null;
  }

}
