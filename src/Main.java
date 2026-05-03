import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println(" == 프로그램 시작 ==");
    Scanner sc = new Scanner(System.in);

    List<Article> articles = new ArrayList<>();

    int lastArticle = 0;

    while (true) {
      System.out.print("명령어) ");
      String cmd = sc.nextLine().trim();

      if (cmd.equals("exit")) {
        break;
      } else if (cmd.length() == 0) {
        System.out.println("명령어를 입력해주세요");
        continue;
      } else if (cmd.equals("article write")) {

        int id = lastArticle +1;

        System.out.print("제목 : ");
        String title = sc.nextLine().trim();
        System.out.print("내용 : ");
        String body = sc.nextLine().trim();

        Article article = new Article(id, title, body);
        articles.add(article);
        System.out.println(id +"번 글 작성 완료");

        lastArticle++;

      }
    }
    System.out.println(" == 프로그램 종료 ==");
    sc.close();
  }
}

class Article{
  private int id;
  private String title;
  private String body;
  public Article (int id, String title, String body){
    this.id = id;
    this.title = title;
    this.body = body;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }
}