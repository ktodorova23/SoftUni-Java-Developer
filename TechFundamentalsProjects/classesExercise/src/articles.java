import java.util.Scanner;

public class articles {

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

        private String edit (String newContent) {
            return this.content = newContent;
        }

        private String changeAuthor (String newAuthor) {
            return this.author = newAuthor;
        }

        private String rename (String newTitle) {
            return this.title = newTitle;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine().split(", ");

        String title = input[0];
        String content = input[1];
        String author = input[2];

        Article book = new Article(title, content, author);

        int rows = Integer.parseInt(console.nextLine());

        for (int i = 0; i < rows; i++) {
            String[] line = console.nextLine().split(": ");

            String cmd = line[0];
            if (cmd.equals("Edit")) {
                String newContent = line[1];
                book.edit(newContent);
            } else if (cmd.equals("ChangeAuthor")) {
                String newAuthor = line[1];
                book.changeAuthor(newAuthor);
            } else {
                String newTitle = line[1];
                book.rename(newTitle);
            }
        }

        System.out.printf("%s - %s: %s%n", book.getTitle(), book.getContent(), book.getAuthor());
    }
}
