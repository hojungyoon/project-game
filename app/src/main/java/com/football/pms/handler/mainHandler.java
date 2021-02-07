package com.football.pms.handler;

import java.util.Random;
import com.football.pms.domain.LeagueTeam;
import com.football.pms.domain.fieldplay.Defender;
import com.football.pms.domain.fieldplay.Kipper;
import com.football.pms.domain.fieldplay.Midfielder;
import com.football.pms.domain.fieldplay.Striker;
import com.football.pms.util.List;
import com.football.pms.util.ProfileSetting;
import com.football.pms.util.Prompt;

public class mainHandler {
  LeagueTeam league; 

  private int i = 0;
  private int i2 = 0;

  private int teamSize = 15;

  private int teamStriker = 4;
  private int teamMidfielder = 7;
  private int teamDefender = 6;
  private int teamKipper = 2;

  private List list = new List();

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
        league = findByNo(0);
        league.setTeamName(tName);
        league.setCoach(cName);
        while(true) {
          int c2 = Prompt.inputInt("\n1.내 팀정보"
              + "\n2.팀 선수정보"
              + "\n> ");
          switch (c2) {
            case 1:
              teamInfo();
              continue;
            case 2:
              privacy();
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

        league.setStriker(st);
      }

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

        league.setMidfielder(md);
      }

      for (int i = 0; i < teamDefender; i++) {
        Defender df = new Defender();
        df.setName(ProfileSetting.makeRanName());
        df.setAge(ProfileSetting.age());
        if(ProfileSetting.height() < 185) { 
          continue;
        } else {
          df.setHeight(ProfileSetting.height());
        }
        df.setWeight(ProfileSetting.weight());
        df.setPosition("Defender"); 
        df.setNation(ProfileSetting.nationality());
        df.setDismissal(0);
        df.setGoal(0);

        league.setDefender(df);
      }

      for (int i = 0; i < teamKipper; i++) {
        Kipper df = new Kipper();
        df.setName(ProfileSetting.makeRanName());
        df.setAge(ProfileSetting.age());
        df.setHeight(ProfileSetting.height());
        df.setWeight(ProfileSetting.weight());
        df.setPosition("Kipper"); 
        df.setNation(ProfileSetting.nationality());

        league.setKipper(df);
      }
      list.add(league);
      i++;
    }

  }

  public void teamInfo() {
    System.out.printf("\n[  내 팀 정보  ]\n");
    league = findByNo(0);

    System.out.printf("팀 이름 : %s\n", league.getTeamName());
    System.out.printf("팀 감독 : %s\n", league.getCoach());
    System.out.printf("<<<<< 선수목록 >>>>>\n");
    System.out.printf("1. 공격수\n");
    for (int i = 0; i < teamStriker; i++) {
      league = findByNo(i);
      System.out.printf("- %s (%d)\n", league.striker.getName(), league.striker.getAge());
    }
    System.out.printf("2. 미드필더\n");
    for (int i = 0; i < teamMidfielder; i++) {
      league = findByNo(i);
      System.out.printf("- %s (%d)\n", league.midfielder.getName(), league.midfielder.getAge());
    }
    System.out.printf("3. 수비수\n");
    for (int i = 0; i < teamDefender; i++) {
      league = findByNo(i);
      System.out.printf("- %s (%d)\n", league.defender.getName(), league.defender.getAge());
    }
    System.out.printf("4. 골키퍼\n");
    for (int i = 0; i < teamKipper; i++) {
      league = findByNo(i);
      System.out.printf("- %s (%d)\n", league.kipper.getName(), league.kipper.getAge());
    }
    return;
  }

  public void privacy() {
    System.out.printf("\n[  선수 정보  ]\n");
    int i = Prompt.inputInt(" - 선수군 선택\n"
        + "1. 공격수\n"
        + "2. 미드필더\n"
        + "3. 수비수\n"
        + "4. 골키퍼\n> ");
    switch (i) {
      case 1:
        for (int j = 0; j < teamStriker; j++) {
          league = findByNo(j);
          System.out.printf("\n이름 : %s"
              + "\n국적 : %s"
              + "\n나이 : %d세"
              + "\n신장 : %dcm"
              + "\n몸무게 : %dkg"
              + "\n퇴장 : %d번"
              + "\n골 : %d골"
              + "\n--------------------\n"
              , league.striker.getName(), league.striker.getNation()
              , league.striker.getAge(), league.striker.getHeight()
              , league.striker.getWeight(), league.striker.getDismissal()
              , league.striker.getGoal());
        }
      case 2:
        for (int j = 0; j < teamMidfielder; j++) {
          league = findByNo(j);
          System.out.printf("\n이름 : %s"
              + "\n국적 : %s"
              + "\n나이 : %d세"
              + "\n신장 : %dcm"
              + "\n몸무게 : %dkg"
              + "\n퇴장 : %d번"
              + "\n골 : %d골"
              + "\n--------------------\n"
              , league.midfielder.getName(), league.midfielder.getNation()
              , league.midfielder.getAge(), league.midfielder.getHeight()
              , league.midfielder.getWeight(), league.midfielder.getDismissal()
              , league.midfielder.getGoal());
        }
      case 3:
        for (int j = 0; j < teamDefender; j++) {
          league = findByNo(j);
          System.out.printf("\n이름 : %s"
              + "\n국적 : %s"
              + "\n나이 : %d세"
              + "\n신장 : %dcm"
              + "\n몸무게 : %dkg"
              + "\n퇴장 : %d번"
              + "\n골 : %d골"
              + "\n--------------------\n"
              , league.defender.getName(), league.defender.getNation()
              , league.defender.getAge(), league.defender.getHeight()
              , league.defender.getWeight(), league.defender.getDismissal()
              , league.defender.getGoal());
        }
      case 4:
        for (int j = 0; j < teamKipper; j++) {
          league = findByNo(j);
          System.out.printf("\n이름 : %s"
              + "\n국적 : %s"
              + "\n나이 : %d세"
              + "\n신장 : %dcm"
              + "\n몸무게 : %dkg"
              + "\n--------------------\n"
              , league.kipper.getName(), league.kipper.getNation()
              , league.kipper.getAge(), league.kipper.getHeight()
              , league.kipper.getWeight());
        }
    }
    return;
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
