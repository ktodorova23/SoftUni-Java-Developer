import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class articles2 {

    static class Article {
        String title;
        String content;
        String author;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rows = Integer.parseInt(console.nextLine());

        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            String[] line = console.nextLine().split(", ");

            String title = line[0];
            String content = line[1];
            String auhor = line[2];

            Article article = new Article(title, content, auhor);

            articles.add(article);
        }

        String cmd = console.nextLine();

        if (cmd.equals("title")) {
            articles.stream().sorted((a1, a2) -> a1.getTitle().compareTo(a2.getTitle())).forEach(e -> System.out.printf("%s - %s: %s%n", e.getTitle(), e.getContent(), e.getAuthor()));
        } else if (cmd.equals("content")) {
            articles.stream().sorted((a1, a2) -> a1.getContent().compareTo(a2.getContent())).forEach(e -> System.out.printf("%s - %s: %s%n", e.getTitle(), e.getContent(), e.getAuthor()));
        } else if (cmd.equals("author")) {
            articles.stream().sorted((a1, a2) -> a1.getAuthor().compareTo(a2.getAuthor())).forEach(e -> System.out.printf("%s - %s: %s%n", e.getTitle(), e.getContent(), e.getAuthor()));
        }
    }
}
