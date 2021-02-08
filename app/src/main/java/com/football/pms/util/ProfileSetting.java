package com.football.pms.util;

import java.util.Random;

public class ProfileSetting {

  public static String makeRanName() {

    String[] secoundNames = { "아드리안", "오스틴", "이안", "에런", "알렉스", "케빈", "저스틴"
        ,"안드레스", "벤자민", "브랜던", "베넷", "브룩스", "브루노", "크리스토퍼", "조나단"
        , "그레고리", "조지", "헨리", "헤이든", "헨드릭스", "해리", "휴고", "해리슨", "하비"
        , "허드슨", "이반", "이즈라엘", "아이작", "제이든", "제임스", "제이콥", "잭슨", "막시"
        , "제레미", "제이스", "맥스웰"};

    String[] firstNames = { "스미스", "밀러", "윌슨", "테일러", "앤더슨", "홀", "미첼", "베넷"
        , "알렉산더", "아놀드", "맥도널드", "제주스", "다니엘즈", "로버트슨", "로즈", "딕슨"
        , "앤드류스", "하퍼", "던컨", "쇼", "고든", "더글라스", " 윌리엄슨", "하디", "램지"
        , "바우어", "카슨", "비어드", "매클린", "핸더슨", "게빈", "게일", "파브로", "가브리엘"
        , "커너", "찰스", "켈럽", "쿠퍼", "콜린", "코비", "죠지", "데니얼", "딜런", "데미안", "데클렌"
        , "데릭", "단테", "도미닉", "딜런", "듀르", "에반", "에릭", "프렌시스코", "필릭스"
        , "퍼렌도" , "파비안", "핀", "프랭키", "프레드릭"};

    Random randomNum = new Random();

    int random1 = randomNum.nextInt(secoundNames.length);
    String a = secoundNames[random1];

    int random2 = randomNum.nextInt(firstNames.length);
    String b = firstNames[random2];

    return a + " " + b;
  }

  public static String makeTeamName(int i) {

    Random randomNum = new Random();

    String[] firstTeamName = { "진격의", "동네근처", "할렐루야", "소심", "동네북", "바라심경"
        , "청양고추", "타코야끼", "콩나물", "설레발", "끼리끼리", "오합지졸", "쌈바"
        , "전국시대", "종합병원"};
    String[] SecondTeamName = { "마드리드", "유나이티드", "FC"};

    int r = randomNum.nextInt(SecondTeamName.length);


    String n = firstTeamName[i] + " " + SecondTeamName[r];

    return  n;
  }

  public static int age() {
    Random age = new Random();
    int i = age.nextInt(26)+18;
    return i;
  }

  public static int height() {
    Random tall = new Random();
    int t = tall.nextInt(35)+165;

    return t;
  }

  public static int weight() {
    Random kg = new Random();
    int k;
    if (height() > 164 || height()< 175) {
      k = kg.nextInt(15)+60;
    } else if (height() > 175 || height()< 185) {
      k = kg.nextInt(15)+70;
    } else {
      k = kg.nextInt(15)+80;
    }

    return k;
  }

  public static String coachName(int i) {
    String[] name = { "김감독", "호센 모리뉴", "우르겜 칼롭", "낙엘스안", "앙토니오 쿤텐"
        , "아드리안 파롤루", "체사테 푸론달리", "졸지 알루미론", "디엑 시오네메", "하아호 헬리히"
        , "안디 후터", "스팁 부룩스", "칼롭 안젤로트", "로날도 쿠안", "미칸 아테르타"};

    return name[i];
  }

  public static String nationality () {
    Random n = new Random();
    String[] nationality = { "잉글랜드", "이탈리아", "미국", "벨기에", " 스페인", "독일"
        , "오스트리아", "포르투갈", "아이슬란드", "캐나다", "스위스" };
    int i = n.nextInt(nationality.length);

    return nationality[i];
  }

}
