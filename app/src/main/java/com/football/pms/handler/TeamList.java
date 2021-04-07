package com.football.pms.handler;

import java.util.List;
import com.football.pms.domain.LeagueTeam;
import com.football.pms.util.Prompt;

public class TeamList {

  List<LeagueTeam> list;

  public TeamList(List<LeagueTeam> list) {
    this.list = list;
  }

  private int teamSize = 16;
  private int teamStriker = 4;
  private int teamMidfielder = 7;
  private int teamDefender = 6;
  private int allRounder = teamStriker + teamMidfielder + teamDefender;
  private int teamKipper = 2;

  TeamSetting set = new TeamSetting(list);

  public void TeamPlayerInfo
  (String name, String nation, int age, int height, int weight, int assi, int goal) {
    System.out.printf("\n  이 름  : %s"
        + "\n  국 적  : %s"
        + "\n  나 이  : %d세"
        + "\n  신 장  : %dcm"
        + "\n  몸무게 : %dkg"
        + "\n어시스트 : %d번"
        + "\n    골   : %d골"
        + "\n--------------------\n"
        , name, nation, age, height, weight, assi, goal);

  }

  public void privacy(LeagueTeam league) {
    System.out.printf("\n[  팀 및 선수 정보  ]\n");
    league = set.findByNo(0);
    System.out.printf(
        "=============================================\n"
            + "팀 이 름 : %s\n"
            + "팀 감 독 : %s\n"
            + "전    적 : %d승 %d무 %d패\n"
            + "득/실 점 : %d / %d\n"
            + "리그우승 : %d회\n"
            + "=============================================\n"
            , league.getTeamName(), league.getCoachName()
            , league.getWin(), league.getDraw(), league.getLoose()
            , league.getPlusPoint(), league.getMinusPoint(), league.getLeagueWin());

    int c = Prompt.inputInt(" - 선수군 선택\n"
        + "1. 공격수\n"
        + "2. 미드필더\n"
        + "3. 수비수\n"
        + "4. 골키퍼\n"
        + "5. 뒤로가기\n"
        + "> ");
    switch (c) {
      case 1:
        myTeamPlayerInfo(league, "St");
        break;
      case 2:
        myTeamPlayerInfo(league, "Md");
        break;
      case 3:
        myTeamPlayerInfo(league, "Df");
        break;
      case 4:
        for (int i = 0; i < teamKipper; i++) {
          System.out.printf("\n 이 름 : %s"
              + "\n 국 적 : %s"
              + "\n 나 이 : %d세"
              + "\n 신 장 : %dcm"
              + "\n몸무게 : %dkg"
              + "\n--------------------\n", 
              league.kipper.get(i).getName(),
              league.kipper.get(i).getNation(),
              league.kipper.get(i).getAge(),
              league.kipper.get(i).getHeight(),
              league.kipper.get(i).getWeight());
        }
        break;

      case 5:
        return;
    }
    return;
  }

  public void myTeamPlayerInfo(LeagueTeam league, String position) {
    for (int i = 0; i < allRounder; i++) {
      if (league.playerProfile.get(i).getPosition().equals(position)) {
        TeamPlayerInfo(
            league.playerProfile.get(i).getName(), league.playerProfile.get(i).getNation()
            , league.playerProfile.get(i).getAge(), league.playerProfile.get(i).getHeight()
            , league.playerProfile.get(i).getWeight(), league.playerProfile.get(i).getAssist()
            , league.playerProfile.get(i).getGoal());
      }
    }    
  }

  public void otherTeam() {
    for (int x = 1; x < teamSize; x++) {
      System.out.printf("\n%d. %s\n"
          , x, list.get(x).getTeamName());
    }
    int no = Prompt.inputInt("\n(뒤로가기 : 99)> ");
    if (no == 99) {
      return;
    } else {

      System.out.printf("\n[  팀 정보  ]\n");
      System.out.printf("팀 이름 : %s\n", list.get(no).getTeamName());
      System.out.printf("팀 감독 : %s\n", list.get(no).getCoachName());
      System.out.printf("전   적 : %d승 %d무 %d패\n"
          + "득/실점 : %d / %d\n"
          , list.get(no).getWin(), list.get(no).getDraw(), list.get(no).getLoose()
          , list.get(no).getPlusPoint(), list.get(no).getMinusPoint());
      System.out.printf("<<<<< 선수목록 >>>>>\n");

      System.out.printf("1. 공격수\n");
      otherTeamPlayerInfo(list.get(no), "St");

      System.out.printf("\n2. 미드필더\n");
      otherTeamPlayerInfo(list.get(no), "Md");

      System.out.printf("\n3. 수비수\n");
      otherTeamPlayerInfo(list.get(no), "Df");

      System.out.printf("\n4. 골키퍼\n");
      for (int i = 0; i < teamKipper; i++) {
        System.out.printf("> %s (%d)\n",
            list.get(no).kipper.get(i).getName(),
            list.get(no).kipper.get(i).getAge());
      }
      return;
    }
  }

  public void otherTeamPlayerInfo(LeagueTeam leagueTeam, String position) {
    for (int i = 0; i < allRounder; i++) {
      if (leagueTeam.playerProfile.get(i).getPosition().equals(position)) {
        otherTeamPlayList(
            leagueTeam.playerProfile.get(i).getGoal(), leagueTeam.playerProfile.get(i).getAssist()
            , leagueTeam.playerProfile.get(i).getName(), leagueTeam.playerProfile.get(i).getAge());
      }
    }
  }

  public void otherTeamPlayList(int goal, int assist, String name, int age) {
    System.out.printf("> %d G/%d A - %s (%d)\n", goal, assist, name, age);
  }

}
