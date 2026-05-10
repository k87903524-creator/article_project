import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 프로그램 실행 확인
    System.out.println(" == 프로그램 시작 ==");
    //
    Scanner sc = new Scanner(System.in);

    // 게시글 저장소 만들기
    List<Article> articles = new ArrayList<>();

    // 게시글 순서 확인(변수 선언)
    int lastArticle = 0;

    // 명령어를 계속 입력 받는 무한루프 구조 만들기
    while (true) {
      // 명령어 입력 받기
      System.out.print("명령어) ");
      // nextLine()으로 입력 후 다음줄로 이동, trim() 좌우 공백 제거
      String cmd = sc.nextLine().trim();
      // 무한루프 탈출 => 시스템 종료
      if (cmd.equals("exit")) {
        break;
      }
      // 입력값 0(없으면)이면 명령어 입력 요청 및 continue
      else if (cmd.length() == 0) {
        System.out.println("명령어를 입력해주세요");
        continue;
      }
      // article write 입력시 게시글 작성
      else if (cmd.equals("article write")) {
        System.out.println("== 게시글 작성 ==");
        // 게시글마다 새 번호 부여
        int id = lastArticle + 1;

        //제목 및 내용 입력받기
        System.out.print("제목 : ");
        String title = sc.nextLine().trim();
        System.out.print("내용 : ");
        String body = sc.nextLine().trim();

        // 객체 생성
        Article article = new Article(id,Util.getNowStr(), Util.getNowStr(), title, body);
        // 리스트에 저장
        articles.add(article);
        System.out.println(id + "번 글 작성 완료");

        // 마지막 번호 갱신
        lastArticle++;
      }
      // 게시글 목록
      else if (cmd.equals("article list")) {
        System.out.println("==게시글 목록==");
        if (articles.size() == 0) {
          System.out.println("게시글이 존재하지 않습니다.");
        } else {
          System.out.println("  번호  /  제목  /  내용  ");
          // 게시글 출력, i--로 최신글이 위로 오게 함
          for (int i = articles.size() - 1; i >= 0; i--) {
            Article article = articles.get(i);
            System.out.printf("  %d  /  %s  /  %s  \n", article.getId(), article.getTitle(), article.getBody());
          }
        }
      }
      // 게시글 상세보기
      else if (cmd.startsWith("article detail ")) {
        // 명령어 뒤의 문자타입의 숫자를 정수로 변환하여 id 지정
        int id = Integer.parseInt(cmd.split(" ")[2]);

        // 게시글 찾기
        Article foundArticle = null;
        for (Article article : articles) {
          if (article.getId() == id) {
            foundArticle = article;
            break;
          }
        }
        if (foundArticle == null) {
          System.out.println("해당 게시글은 없습니다.");
          continue;
        }
        System.out.println("번호 : " + foundArticle.getId());
        System.out.println("작성일시 : " + foundArticle.getRegDate());
        System.out.println("수정일시 : " + foundArticle.getUpdateDate());
        System.out.println("제목 : " + foundArticle.getTitle());
        System.out.println("내용 : " + foundArticle.getBody());
      }
      // 게시글 삭제
      else if (cmd.startsWith("article delete ")) {
        int id = Integer.parseInt(cmd.split(" ")[2]);

        Article foundArticle = null;

        for (Article article : articles) {
          if (article.getId() == id) {
            foundArticle = article;
            break;
          }
        }
        if (foundArticle == null) {
          System.out.println("해당 게시글은 없습니다.");
          continue;
        }
        // 게시글 삭제
        articles.remove(foundArticle);
        System.out.println(id + "번 글이 삭제되었습니다.");
      }
      // 게시글 수정
      else if (cmd.startsWith("article modify ")) {
        int id = Integer.parseInt(cmd.split(" ")[2]);

        Article foundArticle = null;

        for (Article article : articles) {
          if (article.getId() == id) {
            foundArticle = article;
            break;
          }
        }
        if (foundArticle == null) {
          System.out.println("해당 게시글은 없습니다.");
        }

        System.out.println("기존 제목 : " + foundArticle.getTitle());
        System.out.println("기존 내용 : " + foundArticle.getBody());

        //수정할 데이터 생성
        System.out.print("수정할 제목 : ");
        String newTitle = sc.nextLine().trim();
        System.out.print("수정할 내용 : ");
        String newBody = sc.nextLine().trim();

        //수정 데이터 저장
        foundArticle.setTitle(newTitle);
        foundArticle.setBody(newBody);
        foundArticle.setUpdateDate(Util.getNowStr());
        System.out.println(id + "번 게시글이 수정되었습니다.");
      }
    }
    System.out.println(" == 프로그램 종료 ==");
    sc.close();
  }
}