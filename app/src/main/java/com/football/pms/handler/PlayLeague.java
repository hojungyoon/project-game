package com.football.pms.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import com.football.pms.domain.LeagueTeam;
import com.football.pms.domain.fieldplay.PlayerProfile;
import com.football.pms.util.PersnalRankDecending;
import com.football.pms.util.Prompt;
import com.football.pms.util.TeamDecending1;

public class PlayLeague {

  List<LeagueTeam> list;

  public PlayLeague(List<LeagueTeam> list) {
    this.list = list;
  }

  private int teamSize = 16;

  private int teamStriker = 4;
  private int teamMidfielder = 7;
  private int teamDefender = 6;
  private int allRounder = teamStriker + teamMidfielder + teamDefender;

  private int day = 1;

  Random r;
  int[] nums;

  TeamSetting set = new TeamSetting(list);

  public void playLeagues() {
    int awayDivision = 8;

    System.out.printf("\n============================================="
        + "\n\t      [%d라운드 대진표]\n"
        + "=============================================\n", day);

    nums = makeRandomNumberArray(nums, teamSize, teamSize);

    List<LeagueTeam> home = new ArrayList<>();
    List<LeagueTeam> away = new ArrayList<>();

    for (int o = 0; o < teamSize / 2; o++) {
      if (list.get(o).getTeamCode() == nums[o]) {
        home.add(list.get(o));
      } else {
        away.add(list.get(o + awayDivision));
      }
    }

    System.out.printf("\n[ %s ]",league.getTeamName());
    System.out.printf(" vs [ %s ]\n", league.getTeamName());

    String play = Prompt.inputString("\n경기를 시작하겠습니까? [y/N]> ");
    if (play.equalsIgnoreCase("y")) {
      System.out.printf("\n============================================="
          + "\n\t    [경기를 시작합니다!]\n"
          + "=============================================\n");
    } else {
      return;
    }

    int chance = 6;

    for (int o = 0; o < (teamSize / 2); o++) {
      int homeTeam = 0, awayTeam = 0, second = 60, minute = 96, timeS = 0;

      int[] timeM = new int[chance];
      timeM = makeRandomNumberArray(timeM, chance, minute);
      Arrays.sort(timeM);

      int goalTime = 0;
      int percent = 10;

      for (int x = 0; x < chance; x++) {
        r = new Random();
        timeS = r.nextInt(second);

        int home = r.nextInt(2);
        int away = r.nextInt(2);

        int goal = r.nextInt(allRounder);
        int assist = r.nextInt(percent);

        if (home == away) {
          continue;

        } else if(home > away) {

          league = set.findByNo(nums[o]);
          homeTeam += 1;

          league.playerProfile.get(goal).setGoal(league.playerProfile.get(goal).getGoal() + 1);
          System.out.printf("\n[%s] - %s(%s) + 1 \"%d'%d\n",
              league.getTeamName(),
              league.playerProfile.get(goal).getName(),
              league.playerProfile.get(goal).getPosition(),
              timeM[goalTime], timeS);

          if (league.playerProfile.get(goal).getName().equals(
              league.playerProfile.get(assist).getName())) {
            continue;
          } else {
            league.playerProfile.get(assist).setAssist(
                league.playerProfile.get(assist).getAssist() + 1);
            System.out.printf("Assist.[%s] (%s)\n",
                league.playerProfile.get(assist).getName(),
                league.playerProfile.get(assist).getPosition());
          }

        } else if(home < away) {
          league = set.findByNo(nums[o + awayDivision]);
          awayTeam += 1;
          league.playerProfile.get(goal).setGoal(league.playerProfile.get(goal).getGoal() + 1);
          System.out.printf("\n[%s] - %s(%s) + 1 \"%d'%d\n",
              league.getTeamName(),
              league.playerProfile.get(goal).getName(),
              league.playerProfile.get(goal).getPosition(),
              timeM[goalTime], timeS);

          if (league.playerProfile.get(goal).getName().equals(
              league.playerProfile.get(assist).getName())) {
            continue;
          } else {
            league.playerProfile.get(assist).setAssist(
                league.playerProfile.get(assist).getAssist() + 1);
            System.out.printf("Assist.[%s] (%s)\n",
                league.playerProfile.get(assist).getName(),
                league.playerProfile.get(assist).getPosition());
          }
        }
        goalTime++;
      }

      int winPoint = 3, drawPoint = 1;

      if (homeTeam > awayTeam) {
        league = set.findByNo(nums[o]);
        league.setWin(league.getWin() + 1);
        league.setPoint(league.getPoint() + winPoint);
        league.setPlusPoint(league.getPlusPoint() + homeTeam);
        league.setMinusPoint(league.getMinusPoint() - awayTeam);
        league.setScores(league.getPlusPoint() + league.getMinusPoint());

        league = set.findByNo(nums[o + awayDivision]);
        league.setLoose(league.getLoose() + 1);
        league.setPlusPoint(league.getPlusPoint() + awayTeam);
        league.setMinusPoint(league.getMinusPoint() - homeTeam);
        league.setScores(league.getPlusPoint() + league.getMinusPoint());

      } else if (homeTeam < awayTeam) {
        league = set.findByNo(nums[o]);
        league.setLoose(league.getLoose() + 1);
        league.setPlusPoint(league.getPlusPoint() + homeTeam);
        league.setMinusPoint(league.getMinusPoint() - awayTeam);
        league.setScores(league.getPlusPoint() + league.getMinusPoint());

        league = set.findByNo(nums[o + awayDivision]);
        league.setWin(league.getWin()+ 1);
        league.setPoint(league.getPoint() + winPoint);
        league.setPlusPoint(league.getPlusPoint() + awayTeam);
        league.setMinusPoint(league.getMinusPoint() - homeTeam);
        league.setScores(league.getPlusPoint() + league.getMinusPoint());

      } else if (homeTeam == awayTeam) {
        league = set.findByNo(nums[o]);
        league.setDraw(league.getDraw()+ 1);
        league.setPoint(league.getPoint() + drawPoint);
        league.setPlusPoint(league.getPlusPoint() + homeTeam);
        league.setMinusPoint(league.getMinusPoint() - awayTeam);
        league.setScores(league.getPlusPoint() + league.getMinusPoint());

        league = set.findByNo(nums[o + awayDivision]);
        league.setDraw(league.getDraw()+ 1);
        league.setPoint(league.getPoint() + drawPoint);
        league.setPlusPoint(league.getPlusPoint() + awayTeam);
        league.setMinusPoint(league.getMinusPoint() - homeTeam);
        league.setScores(league.getPlusPoint() + league.getMinusPoint());
      }

      league = set.findByNo(nums[o]);
      String a = String.format("[ %s ] %d : ", league.getTeamName(), homeTeam);

      league = set.findByNo(nums[o + awayDivision]);
      String b = String.format("%d [ %s ]", awayTeam, league.getTeamName());

      System.out.printf("\n%s%s\n", a, b);

      System.out.println("=============================================");
    }
    System.out.printf("\t         [경기종료]\n"
        + "=============================================\n");
    day++;
  }

  @SuppressWarnings("unused")
  public int[] makeRandomNumberArray(int[] nums, int size, int randomSize) {
    Random r = new Random();
    nums = new int[size];

    for (int i = 0; i < nums.length; i++) {
      int temp = r.nextInt(randomSize);
      nums[i] = temp;

      for (int j = 0; j < i; j++) {
        if (nums[j] == temp) {
          i--;
          break;
        }
      }
    }
    return nums;
  }



  public void teamRanking() {
    if (day == 1) {
      System.out.printf("\n============================================="
          + "\n         [경기를 먼저 진행해 주세요!]\n"
          + "=============================================\n");
      return;
    }
    ArrayList<LeagueTeam> rank = new ArrayList<LeagueTeam>();

    for (int r = 0; r < teamSize; r++) {
      league = set.findByNo(r);
      rank.add(league);
    }

    TeamDecending1 teamDecending = new TeamDecending1();
    Collections.sort(rank, teamDecending);

    for (int o = 0; o < teamSize; o++) {
      System.out.printf("[ %02d위 ]> %02d 승 %02d 무 %02d 패 / %02d 승점 %02d 득실차 / [%s]\n",
          o + 1,
          rank.get(o).getWin(),
          rank.get(o).getDraw(),
          rank.get(o).getLoose(),
          rank.get(o).getPoint(),
          rank.get(o).getScores(),
          rank.get(o).getTeamName());
    }
  }

  public void personalGoalRank() {
    ArrayList<PlayerProfile> gRank = new ArrayList<>();

    if (day == 1) {
      System.out.printf("\n============================================="
          + "\n         [경기를 먼저 진행해 주세요!]\n"
          + "=============================================\n");
      return;
    }

    for (int o = 0; o < teamSize; o++) {
      league = set.findByNo(o);
      for (int p = 0; p < allRounder; p++) {
        gRank.add(league.playerProfile.get(p));
      }
    }

    PersnalRankDecending persnalRankDecending = new PersnalRankDecending();
    Collections.sort(gRank, persnalRankDecending);

    for (int o = 0; o < allRounder; o++) {
      System.out.printf("[ %02d위 ]> - %02d Goal [%s]\n",
          o,
          gRank.get(o).getGoal(),
          gRank.get(o).getName());
    }
  }

  public void personalAssistRank() {
    ArrayList<PlayerProfile> aRank = new ArrayList<>();

    if (day == 1) {
      System.out.printf("\n============================================="
          + "\n         [경기를 먼저 진행해 주세요!]\n"
          + "=============================================\n");
      return;
    }

    for (int o = 0; o < teamSize; o++) {
      league = set.findByNo(o);
      for (int p = 0; p < allRounder; p++) {
        aRank.add(league.playerProfile.get(p));
      }
    }

    PersnalRankDecending persnalRankDecending = new PersnalRankDecending();
    Collections.sort(aRank, persnalRankDecending);

    for (int o = 0; o < allRounder; o++) {
      System.out.printf("[ %02d위 ]> - %02d Assist [%s]\n",
          o,
          aRank.get(o).getAssist(),
          aRank.get(o).getName());
    }
  }


}
