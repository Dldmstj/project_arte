package project_arte.join;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Join {

   public static void main(String[] args) {
      // 회원가입 클래스
      
      // 변수 선언
      Scanner sc = new Scanner(System.in);
      String id; // 아이디 선언
      String id01 = "himan123";  // 중복이 될 아이디1 선언
      String id02 = "himan234";  // 중복이 될 아이디2 선언
      String psw; // 비밀번호 선언
      Pattern pswpattern = Pattern.compile
      ("^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&+=])(?=\\S+$).*$"); // 숫자,영어,특수문자를 포함 해야함 
      boolean tfpsw = false;
      String pswcheck; // 비밀번호 확인 선언
      String name; // 이름 선언
      int minLength = 2; // 입력가능한 이름의 최소숫자
      int maxLength = 8; // 입력가능한 이름의 최대숫자
      int year, month, day; // 생년월일
      String sex; // 성별
      String email; // email
      String phoneNum; // 핸드폰 전화번호
      int phoneLength = 11;
      String ranNum01; // 인증코드
      String yOn ; // YesOrNo
      
      
      // 아이디 입력
      System.out.print("아이디를 입력해주세요 :");
          id = sc.nextLine(); // 아이디 입력 : id
         if(id.equals(id01)) {
         System.out.println("이미 중복된 아이디 입니다.");
         System.exit(0);   // 중복 시 실행종료
         
      }else {
         System.out.println("사용 가능한 아이디입니다.");
      }
   
         
      // 비밀번호 입력
       
        
      do {
         System.out.print("비밀번호를 입력해주세요 :");
         psw = sc.nextLine(); // 비밀번호 입력 : psw 
         
         if(psw.length()>=10){
            System.out.println("10자 이하로 기입해주세요!");
             }else{
             Matcher pswmatcher = pswpattern.matcher(psw); // pattern의 문자가 psw에 있는지 확인
         if(pswmatcher.matches()) {
             tfpsw = true; // tfpsw가 true 일 때 while문을 벗어남
            }else{
              System.out.println("비밀번호는 특수문자, 숫자, 소문자가 반드시 포함되어야 합니다!");
            }
           }    
      } while(!tfpsw); // false로 설정된 tfpsw가 true가 될때 아래에 있는 출력문을 출력
      
       System.out.println("비밀번호 입력 완료!");
      
       
      // 비밀번호 확인
      while(true){
      System.out.print("비밀번호를 한번 더 입력해주세요 :");
      pswcheck = sc.nextLine(); // 비밀번호 입력 : pswcheck
      if(pswcheck.equals(psw)) {
         System.out.println("비밀번호 확인 완료!");
         break; // 비밀번호 같을 때 다음으로 넘어감
      }else {
         System.out.println("비밀번호가 같지 않습니다!");
         // 비밀번호가 같지 않을 시 다시 반복됨
      }
      }
      
      
      // 이름 입력
      do {
            System.out.print("이름을 입력해주세요 : ");
            name = sc.nextLine();

            if (name.length() < minLength || name.length() > maxLength) {
                System.out.println("이름은 " + minLength + "글자 이상, " + maxLength + "글자 이하여야 합니다.");
            }
        } while (name.length() < minLength || name.length() > maxLength);

        System.out.println("입력한 이름: " + name);

      
      // 생년월일 입력
        do {
            System.out.print("생년월일을 8자리로 입력해주세요 (예: 20020101): ");
            String birth = sc.nextLine();

            if (birth.length() != 8) {
                System.out.println("잘못된 형식입니다. 8자리로 입력해주세요");
                continue;
            }

            try {
                year = Integer.parseInt(birth.substring(0, 4)); // 문자열 추출
                month = Integer.parseInt(birth.substring(4, 6));
                day = Integer.parseInt(birth.substring(6, 8));

                break;
            } catch (NumberFormatException e) { // 숫자가 아닐 시 예외처리
                System.out.println("잘못된 형식입니다. 숫자로 입력해주세요.");
            }
        } while (true);

        System.out.println("입력한 생년월일: " + year + "년 " + month + "월 " + day + "일");
        
        
        // 성별 입력
        while(true) {
           System.out.print("성별을 입력해주세요 # 남자/여자 # :");
            sex = sc.nextLine();
            if(sex.equals("남자")) {
               System.out.println("남자를 입력하셨습니다.");
               break;
            }else if(sex.equals("여자")) {
               System.out.println("여자를 입력하셨습니다.");
               break;
            }else {
               System.out.println("잘못 입력하였습니다. 남자/여자 중 입력 해주세요.");
            }
        }
        // 이메일 입력
        do {
            System.out.print("이메일 주소를 입력해주세요: ");
            email = sc.nextLine();

            if (!email.contains("@") || !email.contains(".")) { // @와 . 을 반드시 포합해야함
                System.out.println("올바른 이메일 주소 형식이 아닙니다. '@' 기호와 '.' 기호를 포함해주세요.");
            }
        } while (!email.contains("@") || !email.contains("."));

        System.out.println("입력한 이메일 주소: " + email);
        
        
        // 전화번호 인증
        do {
            System.out.print("전화번호를 입력해주세요: ");
            phoneNum = sc.nextLine();

            if (!phoneNum.startsWith("010") || phoneNum.length()!= phoneLength) { // 010 을 반드시 포합해야함
                System.out.println("올바른 지역번호가 아닙니다. 010을 입력해주세요.");
               
            }
            
        } while (!phoneNum.startsWith("010") || phoneNum.length() != phoneLength);
           
        System.out.println("입력한 전화번호: " + phoneNum + "인증번호를 전송합니다.");
        
        
        char [] num01 = new char[4]; // num01에 4개의 문자를 배열로 받음

        for(int idx=0;idx<num01.length;idx++) {

        int ranNum = (int)(Math.random()*10+48);

        num01[idx] = (char)ranNum;

        }
        String num02 = new String(num01);
        System.out.println("인증 코드 : " +  num02 );
        
        // 인증코드 입력
        do {
           System.out.print("인증 코드를 입력해주세요: ");
            ranNum01 = sc.nextLine();
        if(!ranNum01.equals(num02)) {
           System.out.println("인증코드를 잘못 입력하셨습니다. 다시 입력 해주세요.");
        }
        }while(!ranNum01.equals(num02));
           System.out.println("인증 성공하셨습니다.");
       
       do {
       System.out.println("회원가입이 완료 되었습니다. 회원정보를 보시겠습니까? Y/N");
       yOn = sc.nextLine();
       if(yOn.equals("Y") || yOn.equals("y")) {
          System.out.println("아이디 :" + id);
          System.out.println("비밀번호 :" + psw);
          System.out.println("이름 :" + name);
          System.out.println("생년월일 :" + year + "년 " + month + "월 " + day + "일");
          System.out.println("성별 :" + sex);
          System.out.println("이메일 :"+ email);
          System.out.println("전화번호 :"+ phoneNum);
          
       }else if(yOn.equals("N") || yOn.equals("n")) {
          System.out.println("메인으로 이동.");
          break;
       }else {
        
          System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
       }
       }while(true);
   }

}