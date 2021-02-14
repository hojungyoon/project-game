package com.football.pms.handler;

import java.util.ArrayList;
import java.util.Random;
import com.football.pms.domain.FA;
import com.football.pms.domain.LeagueTeam;
import com.football.pms.domain.TeamDecending;
import com.football.pms.domain.fieldplay.Defender;
import com.football.pms.domain.fieldplay.Kipper;
import com.football.pms.domain.fieldplay.Midfielder;
import com.football.pms.domain.fieldplay.Striker;
import com.football.pms.util.List;
import com.football.pms.util.ProfileSetting;
import com.football.pms.util.Prompt;

public class TeamSetting {

  LeagueTeam league;
  FA fa = new FA(); ;

  private int i = 0;

  private int teamSize = 16;

  private int teamStriker = 4;
  private int teamMidfielder = 7;
  private int teamDefender = 6;
  private int teamKipper = 2;

  private int day = 1;

  private List list = new List();
  //  private List FAlist = new List();
  Random r;
  int[] nums;

  public void makeTeam(String tName, String tCoach) {
    r = new Random();
    nums = new int[teamSize];

    for (int i1 = 0; i1 < nums.length; i1++) {
      int temp = r.nextInt(teamSize);
      nums[i1] = temp;

      for (int j = 0; j < i1; j++) {
        if (nums[j] == temp) {
          i1--;
          break;
        }
      }
    }

    while(this.i < teamSize) {
      league = new LeagueTeam();
      league.setTeamCode(this.i);
      league.setTeamName(ProfileSetting.makeTeamName(nums[this.i]));
      league.setCoachName(ProfileSetting.coachName(nums[this.i]));


      Striker[] sta = new Striker[teamStriker];

      for (int i = 0; i < teamStriker; i++) {
        Striker st = new Striker();
        st.setName(ProfileSetting.makeRanName()); 
        st.setAge(ProfileSetting.age()); 
        st.setHeight(ProfileSetting.height()); 
        st.setWeight(ProfileSetting.weight()); 
        st.setPosition("St");
        st.setNation(ProfileSetting.nationality());
        st.setDismissal(0);
        st.setGoal(0);

        sta[i] = st;

        league.setStriker(sta);
      }

      Midfielder[] mda = new Midfielder[teamMidfielder];

      for (int i = 0; i < teamMidfielder; i++) {
        Midfielder md = new Midfielder();
        md.setName(ProfileSetting.makeRanName()); 
        md.setAge(ProfileSetting.age()); 
        md.setHeight(ProfileSetting.height()); 
        md.setWeight(ProfileSetting.weight()); 
        md.setPosition("Mid");
        md.setNation(ProfileSetting.nationality());
        md.setDismissal(0);
        md.setGoal(0);

        mda[i] = md;

        league.setMidfielder(mda);
      }

      Defender[] dfa = new Defender[teamDefender];

      for (int i = 0; i < teamDefender; i++) {
        Defender df = new Defender();
        df.setName(ProfileSetting.makeRanName()); 
        df.setAge(ProfileSetting.age()); 
        df.setHeight(ProfileSetting.height()); 
        df.setWeight(ProfileSetting.weight()); 
        df.setPosition("Def");
        df.setNation(ProfileSetting.nationality());
        df.setDismissal(0);
        df.setGoal(0);

        dfa[i] = df;

        league.setDefender(dfa);
      }

      Kipper[] kpa = new Kipper[teamKipper];

      for (int i = 0; i < teamKipper; i++) {
        Kipper kp = new Kipper();
        kp.setName(ProfileSetting.makeRanName()); 
        kp.setAge(ProfileSetting.age()); 
        kp.setHeight(kipperHei()); 
        kp.setWeight(ProfileSetting.weight()); 
        kp.setPosition("Kip");
        kp.setNation(ProfileSetting.nationality());

        kpa[i] = kp;

        league.setKipper(kpa);
      }

      list.add(league);
      i++;

      league = findByNo(0);
      league.setTeamName(tName);
      league.setCoachName(tCoach);
    }
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

  public void teamInfo() {
    System.out.printf("\n[  내 팀 정보  ]\n");
    league = findByNo(0);

    System.out.printf("팀 이름 : %s\n", league.getTeamName());
    System.out.printf("팀 감독 : %s\n", league.getCoachName());
    System.out.printf("전   적 : %d승 %d무 %d패\n"
        , league.getWin(), league.getDraw(), league.getLoose());
    System.out.printf("리그우승 : %d회\n", league.getLeagueWin());
    System.out.printf("<<<<< 선수목록 >>>>>\n");
    System.out.printf("1. 공격수\n");
    for (int i = 0; i < teamStriker; i++) {
      System.out.printf("- %s (%d)\n", league.striker[i].getName(), league.striker[i].getAge());
    }
    System.out.printf("2. 미드필더\n");
    for (int i = 0; i < teamMidfielder; i++) {
      System.out.printf("- %s (%d)\n", league.midfielder[i].getName(), league.midfielder[i].getAge());
    }
    System.out.printf("3. 수비수\n");
    for (int i = 0; i < teamDefender; i++) {
      System.out.printf("- %s (%d)\n", league.defender[i].getName(), league.defender[i].getAge());
    }
    System.out.printf("4. 골키퍼\n");
    for (int i = 0; i < teamKipper; i++) {
      System.out.printf("- %s (%d)\n", league.kipper[i].getName(), league.kipper[i].getAge());
    }
    return;
  }

  public void privacy() {
    System.out.printf("\n[  선수 정보  ]\n");
    league = findByNo(0);
    int c = Prompt.inputInt(" - 선수군 선택\n"
        + "1. 공격수\n"
        + "2. 미드필더\n"
        + "3. 수비수\n"
        + "4. 골키퍼\n> ");
    switch (c) {
      case 1:
        for (int i = 0; i < teamStriker; i++) {
          System.out.printf("\n이름 : %s"
              + "\n국적 : %s"
              + "\n나이 : %d세"
              + "\n신장 : %dcm"
              + "\n몸무게 : %dkg"
              + "\n퇴장 : %d번"
              + "\n골 : %d골"
              + "\n--------------------\n"
              , league.striker[i].getName(), league.striker[i].getNation()
              , league.striker[i].getAge(), league.striker[i].getHeight()
              , league.striker[i].getWeight(), league.striker[i].getDismissal()
              , league.striker[i].getGoal());
        }
        break;
      case 2:
        for (int i = 0; i < teamMidfielder; i++) {
          System.out.printf("\n이름 : %s"
              + "\n국적 : %s"
              + "\n나이 : %d세"
              + "\n신장 : %dcm"
              + "\n몸무게 : %dkg"
              + "\n퇴장 : %d번"
              + "\n골 : %d골"
              + "\n--------------------\n"
              , league.midfielder[i].getName(), league.midfielder[i].getNation()
              , league.midfielder[i].getAge(), league.midfielder[i].getHeight()
              , league.midfielder[i].getWeight(), league.midfielder[i].getDismissal()
              , league.midfielder[i].getGoal());
        }
        break;
      case 3:
        for (int i = 0; i < teamDefender; i++) {
          System.out.printf("\n이름 : %s"
              + "\n국적 : %s"
              + "\n나이 : %d세"
              + "\n신장 : %dcm"
              + "\n몸무게 : %dkg"
              + "\n퇴장 : %d번"
              + "\n골 : %d골"
              + "\n--------------------\n"
              , league.defender[i].getName(), league.defender[i].getNation()
              , league.defender[i].getAge(), league.defender[i].getHeight()
              , league.defender[i].getWeight(), league.defender[i].getDismissal()
              , league.defender[i].getGoal());
        }
        break;
      case 4:
        for (int i = 0; i < teamKipper; i++) {
          System.out.printf("\n이름 : %s"
              + "\n국적 : %s"
              + "\n나이 : %d세"
              + "\n신장 : %dcm"
              + "\n몸무게 : %dkg"
              + "\n--------------------\n"
              , league.kipper[i].getName(), league.kipper[i].getNation()
              , league.kipper[i].getAge(), league.kipper[i].getHeight()
              , league.kipper[i].getWeight());
        }
        break;
    }
    return;
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
          , league.getWin(), league.getDraw(), league.getLoose());
      System.out.printf("<<<<< 선수목록 >>>>>\n");
      System.out.printf("1. 공격수\n");
      for (int i = 0; i < teamStriker; i++) {
        System.out.printf("- %s (%d)\n", league.striker[i].getName(), league.striker[i].getAge());
      }
      System.out.printf("2. 미드필더\n");
      for (int i = 0; i < teamMidfielder; i++) {
        System.out.printf("- %s (%d)\n", league.midfielder[i].getName(), league.midfielder[i].getAge());
      }
      System.out.printf("3. 수비수\n");
      for (int i = 0; i < teamDefender; i++) {
        System.out.printf("- %s (%d)\n", league.defender[i].getName(), league.defender[i].getAge());
      }
      System.out.printf("4. 골키퍼\n");
      for (int i = 0; i < teamKipper; i++) {
        System.out.printf("- %s (%d)\n", league.kipper[i].getName(), league.kipper[i].getAge());
      }
      return;
    }
  }

  //  private int faSize = 5;
  //
  //  public void makeFAplayer() {
  //
  //    Striker[] faSta = new Striker[faSize];
  //    Midfielder[] faMda = new Midfielder[faSize];
  //    Defender[] faDfa = new Defender[faSize];
  //
  //    for (int i = 0; i < faSize; i++) {
  //      Striker fast = new Striker();
  //      fast.setName(ProfileSetting.makeRanName()); 
  //      fast.setAge(ProfileSetting.age()); 
  //      fast.setHeight(ProfileSetting.height()); 
  //      fast.setWeight(ProfileSetting.weight()); 
  //      fast.setPosition("Striker");
  //      fast.setNation(ProfileSetting.nationality());
  //      fast.setDismissal(0);
  //      fast.setGoal(0);
  //
  //      faSta[i] = fast;
  //      fa.setStriker(faSta);
  //
  //      Midfielder md = new Midfielder();
  //      md.setName(ProfileSetting.makeRanName()); 
  //      md.setAge(ProfileSetting.age()); 
  //      md.setHeight(ProfileSetting.height()); 
  //      md.setWeight(ProfileSetting.weight()); 
  //      md.setPosition("Midfielder");
  //      md.setNation(ProfileSetting.nationality());
  //      md.setDismissal(0);
  //      md.setGoal(0);
  //
  //      faMda[i] = md;
  //      fa.setMidfielder(faMda);
  //
  //      Defender df = new Defender();
  //      df.setName(ProfileSetting.makeRanName()); 
  //      df.setAge(ProfileSetting.age()); 
  //      df.setHeight(ProfileSetting.height()); 
  //      df.setWeight(ProfileSetting.weight()); 
  //      df.setPosition("Defender");
  //      df.setNation(ProfileSetting.nationality());
  //      df.setDismissal(0);
  //      df.setGoal(0);
  //
  //      faDfa[i] = df;
  //      fa.setDefender(faDfa);
  //    }
  //
  //    Kipper[] faKpa = new Kipper[teamKipper];
  //
  //    for (int i = 0; i < teamKipper; i++) {
  //      Kipper kp = new Kipper();
  //      kp.setName(ProfileSetting.makeRanName()); 
  //      kp.setAge(ProfileSetting.age()); 
  //      kp.setHeight(kipperHei()); 
  //      kp.setWeight(ProfileSetting.weight()); 
  //      kp.setPosition("Kipper");
  //      kp.setNation(ProfileSetting.nationality());
  //
  //      faKpa[i] = kp;
  //      fa.setKipper(faKpa);
  //    }
  //
  //    FAlist.add(fa);
  //  }
  //
  //  public void FAplayerList() {
  //
  //    System.out.printf("\n<<<<< FA선수 >>>>>\n");
  //    for (int i = 0; i < faSize; i++) {
  //      System.out.printf("\n%d. %s\n  - 국적 : %s, %d세, %dcm %dkg"
  //          , i+1, fa.striker[i].getName(), fa.striker[i].getNation(), fa.striker[i].getAge()
  //          ,fa.striker[i].getHeight(), fa.striker[i].getWeight());
  //    }
  //    for (int i = 0; i < faSize; i++) {
  //      System.out.printf("\n%d. %s\n  - 국적 : %s, %d세, %dcm %dkg"
  //          , i+1, fa.midfielder[i].getName(), fa.midfielder[i].getNation(), fa.midfielder[i].getAge()
  //          ,fa.midfielder[i].getHeight(), fa.midfielder[i].getWeight());
  //    }
  //    for (int i = 0; i < faSize; i++) {
  //      System.out.printf("\n%d. %s\n  - 국적 : %s, %d세, %dcm %dkg"
  //          , i+1, fa.defender[i].getName(), fa.defender[i].getNation(), fa.defender[i].getAge()
  //          ,fa.defender[i].getHeight(), fa.defender[i].getWeight());
  //    }
  //    System.out.printf("\n--------------------\n");
  //  }

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

  public void playLeague() {
    r = new Random();
    nums = new int[teamSize];

    for (int y = 0; y < nums.length; y++) {
      int temp = r.nextInt(teamSize);
      nums[y] = temp;

      for (int o = 0; o < y; o++) {
        if (nums[o] == temp) {
          y--;
          break;
        }
      }
    }

    System.out.printf("\n<<<<< %d라운드 경기 >>>>>\n", day);

    for (int o = 0; o < teamSize / 2; o++) {
      league = findByNo(nums[o]);
      System.out.printf("\n[ %s ]",league.getTeamName());
      league = findByNo(nums[o + 8]);
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

    int o = 0;
    while (o < (teamSize / 2)) {
      int homeTeam = 0, awayTeam = 0;

      for (int s = 0; s < 5; s++) {
        Random r2 = new Random();
        int home = r2.nextInt(2);

        Random r3 = new Random();
        int away = r3.nextInt(2);

        if (home == away) {
          continue;
        } else if(home > away) {
          league = findByNo(nums[o]);
          homeTeam += 1;

          int temp = r.nextInt(10);
          if(temp >= 0 && temp <= 4) {
            int st = r.nextInt(teamStriker);
            league.striker[st].setGoal(league.striker[st].getGoal() + 1);
            System.out.printf("\n[%s] - %s(%s) + 1"
                , league.getTeamName(), league.striker[st].getName(), league.striker[st].getPosition());
          } else if(temp >= 5 && temp <= 8) {
            int mid = r.nextInt(teamMidfielder);
            league.midfielder[mid].setGoal(league.midfielder[mid].getGoal() + 1);
            System.out.printf("\n[%s] - %s(%s) + 1"
                , league.getTeamName(), league.midfielder[mid].getName(), league.midfielder[mid].getPosition());
          } else {
            int def = r.nextInt(teamDefender);
            league.defender[def].setGoal(league.midfielder[def].getGoal() + 1);
            System.out.printf("\n[%s] - %s(%s) + 1"
                , league.getTeamName(), league.defender[def].getName(), league.defender[def].getPosition());
          }


        } else if(home < away) {
          league = findByNo(nums[o + 8]);
          awayTeam += 1;

          int temp = r.nextInt(10);
          if(temp >= 0 && temp <= 4) {
            int st = r.nextInt(teamStriker);
            league.striker[st].setGoal(league.striker[st].getGoal() + 1);
            System.out.printf("\n[%s] - %s(%s) + 1"
                , league.getTeamName(), league.striker[st].getName(), league.striker[st].getPosition());
          } else if(temp >= 5 && temp <= 8) {
            int mid = r.nextInt(teamMidfielder);
            league.midfielder[mid].setGoal(league.midfielder[mid].getGoal() + 1);
            System.out.printf("\n[%s] - %s(%s) + 1"
                , league.getTeamName(), league.midfielder[mid].getName(), league.midfielder[mid].getPosition());
          } else {
            int def = r.nextInt(teamDefender);
            league.defender[def].setGoal(league.midfielder[def].getGoal() + 1);
            System.out.printf("\n[%s] - %s(%s) + 1"
                , league.getTeamName(), league.defender[def].getName(), league.defender[def].getPosition());
          }

        }
      }

      if (homeTeam > awayTeam) {
        league = findByNo(nums[o]);
        league.setWin(league.getWin() + 1);

        league = findByNo(nums[o + 8]);
        league.setLoose(league.getLoose() + 1);

      } else if (homeTeam < awayTeam) {
        league = findByNo(nums[o]);
        league.setLoose(league.getLoose() + 1);

        league = findByNo(nums[o + 8]);
        league.setWin(league.getWin()+ 1);

      } else if (homeTeam == awayTeam) {
        league = findByNo(nums[o]);
        league.setDraw(league.getDraw()+ 1);

        league = findByNo(nums[o + 8]);
        league.setDraw(league.getDraw()+ 1);
      }

      league = findByNo(nums[o]);
      System.out.printf(String.format("\n[ %s ] %d : ", league.getTeamName(), homeTeam));
      league = findByNo(nums[o + 8]);
      System.out.printf(String.format("%d [ %s ]\n", awayTeam, league.getTeamName()));

      o++;
      System.out.println("=============================================");
    }
    System.out.printf("\n<<<<< 경기종료 >>>>>\n");
    day++;
  }


  public void ranking() {
    ArrayList<LeagueTeam> rank = new ArrayList<LeagueTeam>();
    for (int r = 0; r < teamSize; r++) {
      league = findByNo(r);
      rank.add(league);
    }

    TeamDecending team = new TeamDecending();


  }

}