package jediGalaxy;

public class StarsManipulator {
    private Galaxy galaxy;

    public StarsManipulator(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public void destroyStars(int enemyRow, int enemyCol) {
        while (enemyRow >= 0 && enemyCol >= 0) {
            if (isInRange(enemyRow, enemyCol)) {
                this.galaxy.setStar(enemyRow, enemyCol, new Star(0));
            }
            enemyRow--;
            enemyCol--;
        }
    }

    private boolean isInRange(int row, int col) {
        return row >= 0 && row < this.galaxy.getRows() && col >= 0 && col < this.galaxy.getCols();
    }

    public long collectStars(int playerRow, int playerCol) {
        long collectedStars = 0;

        while (playerRow >= 0 && playerCol < this.galaxy.getCols()) {
            if (isInRange(playerRow, playerCol)) {
                collectedStars += this.galaxy.collectStar(playerRow, playerCol);
            }
            playerRow--;
            playerCol++;
        }
        return collectedStars;
    }
}
