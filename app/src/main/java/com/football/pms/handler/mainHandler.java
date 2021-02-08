package com.football.pms.handler;

import java.util.Random;
import com.football.pms.domain.LeagueTeam;
import com.football.pms.domain.fieldplay.Defender;
import com.football.pms.domain.fieldplay.FA;
import com.football.pms.domain.fieldplay.Kipper;
import com.football.pms.domain.fieldplay.Midfielder;
import com.football.pms.domain.fieldplay.Striker;
import com.football.pms.util.List;
import com.football.pms.util.ProfileSetting;
import com.football.pms.util.Prompt;

public class mainHandler {
  LeagueTeam league;
  FA fa = new FA(); ;

  private int i = 0;

  private int teamSize = 15;

  private int teamStriker = 4;
  private int teamMidfielder = 7;
  private int teamDefender = 6;
  private int teamKipper = 2;

  private List list = new List();
  private List FAlist = new List();

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
        makeTeam();
        makeFAplayer();
        league = findByNo(0);
        league.setTeamName(tName);
        league.setCoach(cName);
        while(true) {
          int c2 = Prompt.inputInt("\n1.내 팀정보"
              + "\n2.팀 선수정보"
              + "\n3.타팀 정보"
              + "\n4.FA 리스트"
              + "\n> ");
          switch (c2) {
            case 1:
              teamInfo();
              continue;
            case 2:
              privacy();
              continue;
            case 3:
              otherTeam();
              continue;
            case 4:
              FAplayerList();
              continue;
          }
          break;
        }
      } else if (c.equalsIgnoreCase("n")) {
        continue;
      }
      break;
    }
  }

  public void makeTeam() {

    Random r = new Random();
    int[] nums = new int[15];
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
      league.setCoach(ProfileSetting.coachName(i));


      Striker[] sta = new Striker[teamStriker];

      for (int i = 0; i < teamStriker; i++) {
        Striker st = new Striker();
        st.setName(ProfileSetting.makeRanName()); 
        st.setAge(ProfileSetting.age()); 
        st.setHeight(ProfileSetting.height()); 
        st.setWeight(ProfileSetting.weight()); 
        st.setPosition("Striker");
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
        md.setPosition("Midfielder");
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
        df.setPosition("Defender");
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
        kp.setPosition("Kipper");
        kp.setNation(ProfileSetting.nationality());

        kpa[i] = kp;

        league.setKipper(kpa);
      }

      list.add(league);
      i++;
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
    System.out.printf("팀 감독 : %s\n", league.getCoach());
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
    for (int i = 1; i < teamSize; i++) {
      league = findByNo(i);
      System.out.printf("\n%d. %s\n", i, league.getTeamName());
    }
  }

  public void makeFAplayer() {
    Striker[] faSta = new Striker[teamStriker];

    for (int i = 0; i < teamStriker; i++) {
      Striker fast = new Striker();
      fast.setName(ProfileSetting.makeRanName()); 
      fast.setAge(ProfileSetting.age()); 
      fast.setHeight(ProfileSetting.height()); 
      fast.setWeight(ProfileSetting.weight()); 
      fast.setPosition("Striker");
      fast.setNation(ProfileSetting.nationality());
      fast.setDismissal(0);
      fast.setGoal(0);

      faSta[i] = fast;

      fa.setStriker(faSta);
    }

    Midfielder[] faMda = new Midfielder[teamMidfielder];

    for (int i = 0; i < teamMidfielder; i++) {
      Midfielder md = new Midfielder();
      md.setName(ProfileSetting.makeRanName()); 
      md.setAge(ProfileSetting.age()); 
      md.setHeight(ProfileSetting.height()); 
      md.setWeight(ProfileSetting.weight()); 
      md.setPosition("Midfielder");
      md.setNation(ProfileSetting.nationality());
      md.setDismissal(0);
      md.setGoal(0);

      faMda[i] = md;

      fa.setMidfielder(faMda);
    }

    Defender[] faDfa = new Defender[teamDefender];

    for (int i = 0; i < teamDefender; i++) {
      Defender df = new Defender();
      df.setName(ProfileSetting.makeRanName()); 
      df.setAge(ProfileSetting.age()); 
      df.setHeight(ProfileSetting.height()); 
      df.setWeight(ProfileSetting.weight()); 
      df.setPosition("Defender");
      df.setNation(ProfileSetting.nationality());
      df.setDismissal(0);
      df.setGoal(0);

      faDfa[i] = df;

      fa.setDefender(faDfa);
    }

    Kipper[] faKpa = new Kipper[teamKipper];

    for (int i = 0; i < teamKipper; i++) {
      Kipper kp = new Kipper();
      kp.setName(ProfileSetting.makeRanName()); 
      kp.setAge(ProfileSetting.age()); 
      kp.setHeight(kipperHei()); 
      kp.setWeight(ProfileSetting.weight()); 
      kp.setPosition("Kipper");
      kp.setNation(ProfileSetting.nationality());

      faKpa[i] = kp;

      fa.setKipper(faKpa);
    }

    FAlist.add(fa);
  }

  public void FAplayerList() {

    System.out.printf("\n<<<<< FA선수 >>>>>\n");
    for (int i = 0; i < teamStriker; i++) {
      System.out.printf("\n%d. %s\n  - 국적 : %s, %d세, %dcm %dkg"
          , i+1, fa.striker[i].getName(), fa.striker[i].getNation(), fa.striker[i].getAge()
          ,fa.striker[i].getHeight(), fa.striker[i].getWeight());
    }
    System.out.printf("\n--------------------\n");
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
