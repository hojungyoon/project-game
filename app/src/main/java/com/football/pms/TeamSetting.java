package com.football.pms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import com.football.pms.domain.FA;
import com.football.pms.domain.LeagueTeam;
import com.football.pms.domain.fieldplay.Kipper;
import com.football.pms.domain.fieldplay.PlayerProfile;
import com.football.pms.util.ProfileSetting;
import com.football.pms.util.Prompt;

public class TeamSetting {

  LeagueTeam league;
  FA fa = new FA(); ;

  private int count = 0;

  private int teamSize = 16;

  private int teamStriker = 4;
  private int teamMidfielder = 7;
  private int teamDefender = 6;
  private int allRounder = teamStriker + teamMidfielder + teamDefender;
  private int teamKipper = 2;

  private int day = 1;

  private List<LeagueTeam> list = new LinkedList<>();
  private 

  //  private List FAlist = new List();
  String[] matchRecodes = new String[5];
  Random r;
  int[] nums;

  public PlayerProfile[] makeTeamAllPlayer() {
    PlayerProfile[] pp = new PlayerProfile[allRounder];

    for (int i = 0; i < teamStriker; i++) {
      pp[i] = makeTeamPlayer("St");
    }

    for (int i = teamStriker; i < teamStriker + teamMidfielder; i++) {
      pp[i] = makeTeamPlayer("Md");
    }

    for (int i = teamStriker + teamMidfielder; i < allRounder; i++) {
      pp[i] = makeTeamPlayer("Df");
    }

    return pp;
  }

  public PlayerProfile makeTeamPlayer(String position) {
    PlayerProfile pl = new PlayerProfile();

    pl.setHeight(ProfileSetting.height());
    pl.setWeight(ProfileSetting.weight(pl.getHeight()));
    pl.setName(ProfileSetting.makeRanName()); 
    pl.setAge(ProfileSetting.age());
    pl.setPosition(position);
    pl.setNation(ProfileSetting.nationality());
    pl.setDismissal(0);
    pl.setGoal(0);

    return pl;
  }

  public void makeTeam(String tName, String tCoach) {

    while(this.count < teamSize) {
      league = new LeagueTeam();

      league.setTeamCode(this.count);
      league.setTeamName(ProfileSetting.makeTeamName(this.count));
      league.setCoachName(ProfileSetting.coachName(this.count));

      league.setPlayerProfile(makeTeamAllPlayer());

      Kipper[] kpa = new Kipper[teamKipper];

      for (int i = 0; i < teamKipper; i++) {
        Kipper kp = new Kipper();
        kp.setHeight(kipperHei()); 
        kp.setWeight(ProfileSetting.weight(kp.getHeight())); 
        kp.setName(ProfileSetting.makeRanName()); 
        kp.setAge(ProfileSetting.age()); 
        kp.setPosition("Kip");
        kp.setNation(ProfileSetting.nationality());

        kpa[i] = kp;

        league.setKipper(kpa);
      }

      list.add(league);
      count++;

    }

    league = findByNo(0);
    league.setTeamName(String.format("%s %s", tName, ProfileSetting.SecondTeamName()));
    league.setCoachName(tCoach);
  }

  public int kipperHei() {
    int i = 0;
    while(i < 185) {
      i = ProfileSetting.height();
      if (i < 185) {
        continue;
      }
    }
    return i;
  }

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

  public void privacy() {
    System.out.printf("\n[  팀 및 선수 정보  ]\n");
    league = findByNo(0);
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
              + "\n--------------------\n"
              , league.kipper[i].getName(), league.kipper[i].getNation()
              , league.kipper[i].getAge(), league.kipper[i].getHeight()
              , league.kipper[i].getWeight());
        }
        break;
      case 5:
        return;
    }
    return;
  }

  public void myTeamPlayerInfo(LeagueTeam league, String position) {
    for (int i = 0; i < allRounder; i++) {
      if (league.playerProfile[i].getPosition().equals(position)) {
        TeamPlayerInfo(
            league.playerProfile[i].getName(), league.playerProfile[i].getNation()
            , league.playerProfile[i].getAge(), league.playerProfile[i].getHeight()
            , league.playerProfile[i].getWeight(), league.playerProfile[i].getAssist()
            , league.playerProfile[i].getGoal());
      }
    }    
  }

  public void otherTeam() {
    for (int h = 1; h < teamSize; h++) {
      league = findByNo(h);
      System.out.printf("\n%d. %s\n"
          , h, league.getTeamName());
    }
    int no = Prompt.inputInt("\n(뒤로가기 : 99)> ");
    if (no == 99) {
      return;
    } else {
      league = findByNo(no);

      System.out.printf("\n[  팀 정보  ]\n");
      System.out.printf("팀 이름 : %s\n", league.getTeamName());
      System.out.printf("팀 감독 : %s\n", league.getCoachName());
      System.out.printf("전   적 : %d승 %d무 %d패\n"
          + "득/실점 : %d / %d\n"
          , league.getWin(), league.getDraw(), league.getLoose()
          , league.getPlusPoint(), league.getMinusPoint());
      System.out.printf("<<<<< 선수목록 >>>>>\n");

      System.out.printf("1. 공격수\n");
      otherTeamPlayerInfo(league, "St");

      System.out.printf("\n2. 미드필더\n");
      otherTeamPlayerInfo(league, "Md");

      System.out.printf("\n3. 수비수\n");
      otherTeamPlayerInfo(league, "Df");

      System.out.printf("\n4. 골키퍼\n");
      for (int i = 0; i < teamKipper; i++) {
        System.out.printf("> %s (%d)\n", league.kipper[i].getName(), league.kipper[i].getAge());
      }
      return;
    }
  }

  public void otherTeamPlayerInfo(LeagueTeam league, String position) {
    for (int i = 0; i < allRounder; i++) {
      if (league.playerProfile[i].getPosition().equals(position)) {
        otherTeamPlayList(
            league.playerProfile[i].getGoal(), league.playerProfile[i].getAssist()
            , league.playerProfile[i].getName(), league.playerProfile[i].getAge());
      }
    }
  }

  public void otherTeamPlayList(int goal, int assist, String name, int age) {
    System.out.printf("> %d G/%d A - %s (%d)\n", goal, assist, name, age);
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

  public void assistPlus() {
    int percent = 10;
    int assistPosition = r.nextInt(allRounder);
    int temp = r.nextInt(percent);


    if (temp >= 0 && temp <= 5) {
      findAssistPlayer(league);

    } else if (temp >= 6 && temp <= 8) {
      int st2 = r.nextInt(teamStriker);
      if (league.playerProfile[st].getName().equals(league.playerProfile[st2].getName())) {
        continue;

      } else {
        league.playerProfile[st2].setAssist(league.playerProfile[st2].getAssist() + 1);
        System.out.printf("Assist.[%s] (%s)\n",
            league.playerProfile[st2].getName(),
            league.playerProfile[st2].getPosition());
      }
    }

  }

  public void findAssistPlayer(LeagueTeam league) {
    int p = r.nextInt(allRounder);
    league.playerProfile[p].setAssist(league.playerProfile[p].getAssist() + 1);
    System.out.printf("Assist.[%s] (%s)\n",
        league.playerProfile[p].getName(),
        league.playerProfile[p].getPosition());
  }

  public void playLeague() {
    int awayDivision = 8;

    System.out.printf("\n============================================="
        + "\n\t      [%d라운드 대진표]\n"
        + "=============================================\n", day);

    nums = makeRandomNumberArray(nums, teamSize, teamSize);

    for (int o = 0; o < teamSize / 2; o++) {
      league = findByNo(nums[o]);
      System.out.printf("\n[ %s ]",league.getTeamName());
      league = findByNo(nums[o + awayDivision]);
      System.out.printf(" vs [ %s ]\n", league.getTeamName());
    }
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

      int chanceNum = 0;
      int percent = 10;

      for (int x = 0; x < chance; x++) {
        r = new Random();
        timeS = r.nextInt(second);

        int home = r.nextInt(2);

        int away = r.nextInt(2);

        if (home == away) {
          continue;

        } else if(home > away) {
          league = findByNo(nums[o]);
          homeTeam += 1;

          int st = r.nextInt(teamStriker);
          int mid = r.nextInt(teamMidfielder);
          int def = r.nextInt(teamDefender);

          int temp = r.nextInt(percent);
          if(temp >= 0 && temp <= 5) {
            league.playerProfile[st].setGoal(league.playerProfile[st].getGoal() + 1);
            System.out.printf("\n[%s] - %s(%s) + 1 \"%d'%d\n",
                league.getTeamName(),
                league.playerProfile[st].getName(),
                league.playerProfile[st].getPosition(),
                timeM[chanceNum], timeS);

            temp = r.nextInt(percent);
            if (temp >= 0 && temp <= 5) {
              int mid2 = r.nextInt(teamMidfielder);
              league.playerProfile[mid2].setAssist(league.playerProfile[mid2].getAssist() + 1);
              System.out.printf("Assist.[%s] (%s)\n",
                  league.playerProfile[mid2].getName(),
                  league.playerProfile[mid2].getPosition());

            } else if (temp >= 6 && temp <= 8) {
              int st2 = r.nextInt(teamStriker);
              if (league.playerProfile[st].getName().equals(league.playerProfile[st2].getName())) {
                continue;

              } else {
                league.playerProfile[st2].setAssist(league.playerProfile[st2].getAssist() + 1);
                System.out.printf("Assist.[%s] (%s)\n",
                    league.playerProfile[st2].getName(),
                    league.playerProfile[st2].getPosition());
              }

            } else {
              int def2 = r.nextInt(teamDefender);
              league.playerProfile[def2].setAssist(league.playerProfile[def2].getAssist() + 1);
              System.out.printf("Assist.[%s] (%s)\n"
                  , league.playerProfile[def2].getName(), league.playerProfile[def2].getPosition());
            }

          } else if(temp >= 6 && temp <= 8) {
            league.playerProfile[mid].setGoal(league.playerProfile[mid].getGoal() + 1);
            System.out.printf("\n[%s] - %s(%s) + 1 \"%d'%d\n"
                , league.getTeamName(), league.playerProfile[mid].getName(),
                league.playerProfile[mid].getPosition(), timeM[chanceNum], timeS);

            temp = r.nextInt(percent);
            if (temp >= 0 && temp <= 5) {
              int mid2 = r.nextInt(teamMidfielder);
              if (league.playerProfile[mid].getName().equals(league.playerProfile[mid2].getName())) {
                continue;
              } else {
                league.playerProfile[mid2].setAssist(league.playerProfile[mid2].getAssist() + 1);
                System.out.printf("Assist.[%s] (%s)\n"
                    , league.playerProfile[mid2].getName(), league.playerProfile[mid2].getPosition());
              }
            } else if (temp >= 6 && temp <= 8) {
              int st2 = r.nextInt(teamStriker);
              league.playerProfile[st2].setAssist(league.playerProfile[st2].getAssist() + 1);
              System.out.printf("Assist.[%s] (%s)\n"
                  , league.playerProfile[st2].getName(), league.playerProfile[st2].getPosition());
            } else {
              int def2 = r.nextInt(teamDefender);
              league.playerProfile[def2].setAssist(league.playerProfile[def2].getAssist() + 1);
              System.out.printf("Assist.[%s] (%s)\n"
                  , league.playerProfile[def2].getName(), league.playerProfile[def2].getPosition());
            }

          } else {
            league.playerProfile[def].setGoal(league.playerProfile[def].getGoal() + 1);
            System.out.printf("\n[%s] - %s(%s) + 1 \"%d'%d\n"
                , league.getTeamName(), league.playerProfile[def].getName(),
                league.playerProfile[def].getPosition(), timeM[chanceNum], timeS);

            temp = r.nextInt(percent);
            if (temp >= 0 && temp <= 5) {
              int mid2 = r.nextInt(teamMidfielder);
              league.playerProfile[mid2].setAssist(league.playerProfile[mid2].getAssist() + 1);
              System.out.printf("Assist.[%s] (%s)\n"
                  , league.playerProfile[mid2].getName(), league.playerProfile[mid2].getPosition());
            } else if (temp >= 6 && temp <= 8) {
              int st2 = r.nextInt(teamStriker);
              league.playerProfile[st2].setAssist(league.playerProfile[st2].getAssist() + 1);
              System.out.printf("Assist.[%s] (%s)\n"
                  , league.playerProfile[st2].getName(), league.playerProfile[st2].getPosition());
            } else {
              int def2 = r.nextInt(teamDefender);
              if (league.playerProfile[def].getName().equals(league.playerProfile[def2].getName())) {
                continue;
              } else {
                league.playerProfile[def2].setAssist(league.playerProfile[def2].getAssist() + 1);
                System.out.printf("Assist.[%s] (%s)\n"
                    , league.playerProfile[def2].getName(), league.playerProfile[def2].getPosition());
              }
            }
          }

        } else if(home < away) {
          league = findByNo(nums[o + awayDivision]);
          awayTeam += 1;

          int temp = r.nextInt(percent);
          int st = r.nextInt(teamStriker);
          int mid = r.nextInt(teamMidfielder);
          int def = r.nextInt(teamDefender);

          if(temp >= 0 && temp <= 4) {
            league.striker[st].setGoal(league.striker[st].getGoal() + 1);
            System.out.printf("\n[%s] - %s(%s) + 1 \"%d'%d\n"
                , league.getTeamName(), league.striker[st].getName(),
                league.striker[st].getPosition(), timeM[chanceNum], timeS);

            temp = r.nextInt(percent);
            if (temp >= 0 && temp <= 5) {
              int mid2 = r.nextInt(teamMidfielder);
              league.midfielder[mid2].setAssist(league.midfielder[mid2].getAssist() + 1);
              System.out.printf("Assist.[%s] (%s)\n"
                  , league.midfielder[mid2].getName(), league.midfielder[mid2].getPosition());
            } else if (temp >= 6 && temp <= 8) {
              int st2 = r.nextInt(teamStriker);
              if (league.striker[st].getName().equals(league.striker[st2].getName())) {
                continue;
              } else {
                league.striker[st2].setAssist(league.striker[st2].getAssist() + 1);
                System.out.printf("Assist.[%s] (%s)\n"
                    , league.striker[st2].getName(), league.striker[st2].getPosition());
              }
            } else {
              int def2 = r.nextInt(teamDefender);
              league.defender[def2].setAssist(league.defender[def2].getAssist() + 1);
              System.out.printf("Assist.[%s] (%s)\n"
                  , league.defender[def2].getName(), league.defender[def2].getPosition());
            }

          } else if(temp >= 5 && temp <= 8) {
            league.midfielder[mid].setGoal(league.midfielder[mid].getGoal() + 1);
            System.out.printf("\n[%s] - %s(%s) + 1 \"%d'%d\n"
                , league.getTeamName(), league.midfielder[mid].getName(),
                league.midfielder[mid].getPosition(), timeM[chanceNum], timeS);

            temp = r.nextInt(percent);
            if (temp >= 0 && temp <= 5) {
              int mid2 = r.nextInt(teamMidfielder);
              if (league.midfielder[mid].getName().equals(league.midfielder[mid2].getName())) {
                continue;
              } else {
                league.midfielder[mid2].setAssist(league.midfielder[mid2].getAssist() + 1);
                System.out.printf("Assist.[%s] (%s)\n"
                    , league.midfielder[mid2].getName(), league.midfielder[mid2].getPosition());
              }
            } else if (temp >= 6 && temp <= 8) {
              int st2 = r.nextInt(teamStriker);
              league.striker[st2].setAssist(league.striker[st2].getAssist() + 1);
              System.out.printf("Assist.[%s] (%s)\n"
                  , league.striker[st2].getName(), league.striker[st2].getPosition());
            } else {
              int def2 = r.nextInt(teamDefender);
              league.defender[def2].setAssist(league.defender[def2].getAssist() + 1);
              System.out.printf("Assist.[%s] (%s)\n"
                  , league.defender[def2].getName(), league.defender[def2].getPosition());
            }

          } else {
            league.defender[def].setGoal(league.midfielder[def].getGoal() + 1);
            System.out.printf("\n[%s] - %s(%s) + 1 \"%d'%d\n"
                , league.getTeamName(), league.defender[def].getName(),
                league.defender[def].getPosition(), timeM[chanceNum], timeS);

            temp = r.nextInt(percent);
            if (temp >= 0 && temp <= 5) {
              int mid2 = r.nextInt(teamMidfielder);
              league.midfielder[mid2].setAssist(league.midfielder[mid2].getAssist() + 1);
              System.out.printf("Assist.[%s] (%s)\n"
                  , league.midfielder[mid2].getName(), league.midfielder[mid2].getPosition());
            } else if (temp >= 6 && temp <= 8) {
              int st2 = r.nextInt(teamStriker);
              league.striker[st2].setAssist(league.striker[st2].getAssist() + 1);
              System.out.printf("Assist.[%s] (%s)\n"
                  , league.striker[st2].getName(), league.striker[st2].getPosition());
            } else {
              int def2 = r.nextInt(teamDefender);
              if (league.defender[def].getName().equals(league.defender[def2].getName())) {
                continue;
              } else {
                league.defender[def2].setAssist(league.defender[def2].getAssist() + 1);
                System.out.printf("Assist.[%s] (%s)\n"
                    , league.defender[def2].getName(), league.defender[def2].getPosition());
              }
            }
          }
        }
        chanceNum++;
      }

      int winPoint = 3, drawPoint = 1;

      if (homeTeam > awayTeam) {
        league = findByNo(nums[o]);
        league.setWin(league.getWin() + 1);
        league.setPoint(league.getPoint() + winPoint);
        league.setPlusPoint(league.getPlusPoint() + homeTeam);
        league.setMinusPoint(league.getMinusPoint() - awayTeam);
        league.setScores(league.getPlusPoint() + league.getMinusPoint());

        league = findByNo(nums[o + awayDivision]);
        league.setLoose(league.getLoose() + 1);
        league.setPlusPoint(league.getPlusPoint() + awayTeam);
        league.setMinusPoint(league.getMinusPoint() - homeTeam);
        league.setScores(league.getPlusPoint() + league.getMinusPoint());

      } else if (homeTeam < awayTeam) {
        league = findByNo(nums[o]);
        league.setLoose(league.getLoose() + 1);
        league.setPlusPoint(league.getPlusPoint() + homeTeam);
        league.setMinusPoint(league.getMinusPoint() - awayTeam);
        league.setScores(league.getPlusPoint() + league.getMinusPoint());

        league = findByNo(nums[o + awayDivision]);
        league.setWin(league.getWin()+ 1);
        league.setPoint(league.getPoint() + winPoint);
        league.setPlusPoint(league.getPlusPoint() + awayTeam);
        league.setMinusPoint(league.getMinusPoint() - homeTeam);
        league.setScores(league.getPlusPoint() + league.getMinusPoint());

      } else if (homeTeam == awayTeam) {
        league = findByNo(nums[o]);
        league.setDraw(league.getDraw()+ 1);
        league.setPoint(league.getPoint() + drawPoint);
        league.setPlusPoint(league.getPlusPoint() + homeTeam);
        league.setMinusPoint(league.getMinusPoint() - awayTeam);
        league.setScores(league.getPlusPoint() + league.getMinusPoint());

        league = findByNo(nums[o + awayDivision]);
        league.setDraw(league.getDraw()+ 1);
        league.setPoint(league.getPoint() + drawPoint);
        league.setPlusPoint(league.getPlusPoint() + awayTeam);
        league.setMinusPoint(league.getMinusPoint() - homeTeam);
        league.setScores(league.getPlusPoint() + league.getMinusPoint());
      }

      league = findByNo(nums[o]);
      String a = String.format("[ %s ] %d : ", league.getTeamName(), homeTeam);

      league = findByNo(nums[o + awayDivision]);
      String b = String.format("%d [ %s ]", awayTeam, league.getTeamName());

      System.out.printf("\n%s%s\n", a, b);

      System.out.println("=============================================");
    }
    System.out.printf("\t         [경기종료]\n"
        + "=============================================\n");
    day++;
  }

  //  public void ranking() {
  //    if (day == 1) {
  //      System.out.printf("\n============================================="
  //          + "\n         [경기를 먼저 진행해 주세요!]\n"
  //          + "=============================================\n");
  //      return;
  //    }
  //    ArrayList<LeagueTeam> rank = new ArrayList<LeagueTeam>();
  //    int rankNum = 1;
  //
  //    for (int r = 0; r < teamSize; r++) {
  //      league = findByNo(r);
  //      rank.add(league);
  //    }
  //
  //    TeamDecending1 teamDecending = new TeamDecending1();
  //    Collections.sort(rank, teamDecending);
  //
  //    for (LeagueTeam league : rank) {
  //      System.out.printf("[ %02d위 ]> %s\n", rankNum, league);
  //      rankNum++;
  //    }
  //  }
  //
  //  public void personalGoalRank() {
  //    ArrayList<String> gRank = new ArrayList<String>();
  //
  //    if (day == 1) {
  //      System.out.printf("\n============================================="
  //          + "\n         [경기를 먼저 진행해 주세요!]\n"
  //          + "=============================================\n");
  //      return;
  //    }
  //
  //    for (int o = 0; o < teamSize; o++) {
  //      league = findByNo(o);
  //      for (int p = 0; p < teamStriker; p++) {
  //
  //        gRank.add(setRankList(
  //            league.getTeamName(),
  //            "goal",
  //            league.striker[p].getAssist(),
  //            league.striker[p].getPosition(),
  //            league.striker[p].getName()));
  //      }
  //    }
  //
  //    for (int o = 0; o < teamSize; o++) {
  //      league = findByNo(o);
  //      for (int p = 0; p < teamMidfielder; p++) {
  //
  //        gRank.add(setRankList(
  //            league.getTeamName(),
  //            "goal",
  //            league.midfielder[p].getAssist(),
  //            league.midfielder[p].getPosition(),
  //            league.midfielder[p].getName()));
  //      }
  //    }
  //
  //    for (int o = 0; o < teamSize; o++) {
  //      league = findByNo(o);
  //      for (int p = 0; p < teamDefender; p++) {
  //
  //        gRank.add(setRankList(
  //            league.getTeamName(),
  //            "goal",
  //            league.defender[p].getAssist(),
  //            league.defender[p].getPosition(),
  //            league.defender[p].getName()));
  //      }
  //    }
  //
  //    Collections.sort(gRank, Collections.reverseOrder());
  //
  //    for (int o = 0; o < teamSize; o++) {
  //      System.out.printf("[ %02d위 ]> %s\n", o + 1, gRank.get(o));
  //    }
  //  }
  //
  //  public void personalAssistRank() {
  //    ArrayList<String> aRank = new ArrayList<String>();
  //
  //    if (day == 1) {
  //      System.out.printf("\n============================================="
  //          + "\n         [경기를 먼저 진행해 주세요!]\n"
  //          + "=============================================\n");
  //      return;
  //    }
  //
  //    for (int o = 0; o < teamSize; o++) {
  //      league = findByNo(o);
  //      for (int p = 0; p < teamStriker; p++) {
  //
  //        aRank.add(setRankList(
  //            league.getTeamName(),
  //            "Assist",
  //            league.striker[p].getAssist(),
  //            league.striker[p].getPosition(),
  //            league.striker[p].getName()));
  //      }
  //    }
  //
  //    for (int o = 0; o < teamSize; o++) {
  //      league = findByNo(o);
  //      for (int p = 0; p < teamMidfielder; p++) {
  //
  //        aRank.add(setRankList(
  //            league.getTeamName(),
  //            "Assist",
  //            league.midfielder[p].getAssist(),
  //            league.midfielder[p].getPosition(),
  //            league.midfielder[p].getName()));
  //      }
  //    }
  //
  //    for (int o = 0; o < teamSize; o++) {
  //      league = findByNo(o);
  //      for (int p = 0; p < teamDefender; p++) {
  //
  //        aRank.add(setRankList(
  //            league.getTeamName(),
  //            "Assist",
  //            league.defender[p].getAssist(),
  //            league.defender[p].getPosition(),
  //            league.defender[p].getName()));
  //      }
  //    }
  //    Collections.sort(aRank, Collections.reverseOrder());
  //    for (int o = 0; o < teamSize; o++) {
  //      System.out.printf("[ %02d위 ]> - [ %s ]%d %s / %s(%s)\n", o + 1, aRank.get(o));
  //    }
  //  }
  //
  //  public String setRankList(String teamNames,
  //      String rank, int playerAssist, String playerPosition, String playName) {
  //
  //    String teamName = String.format(" - [ %s ]", teamNames);
  //    String str = String.format("%d %s / %s(%s)",
  //        playerAssist, rank, playName, playerPosition);
  //
  //    return teamName + str;
  //  }

}
