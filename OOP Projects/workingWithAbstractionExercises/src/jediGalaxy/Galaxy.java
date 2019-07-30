package jediGalaxy;

public class Galaxy {
    private Star[][] stars;

    public Galaxy(int rows, int cols) {
        this.stars = new Star[rows][cols];
        this.fillStars();
    }

    private void fillStars() {
        int filler = 0;
        for (int i = 0; i < this.stars.length; i++) {
            for (int j = 0; j < this.stars[i].length; j++) {
                this.stars[i][j] = new Star(filler++);
            }
        }
    }

    public int getRows () {
        return this.stars.length;
    }

    public int getCols() {
        return this.stars[0].length;
    }

    public void setStar(int row, int col, Star star) {
        this.stars[row][col] = star;
    }

    public long collectStar(int row, int col) {
        return this.stars[row][col].getValue();
    }
}
