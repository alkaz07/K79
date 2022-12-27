public class Robot {
    private int x,y, direction;
    int[][] matrix;

    public Robot(){//конструктор без праметров, т.е. default constructor
        x = 50;
        y = 50;
        direction = 0;
        matrix = null;
    }

    public Robot(int x0, int y0, int direction, int[][] matrix) {
       setXY(x0, y0);
       this.direction = direction;
       this.matrix = matrix;
    }

    public int getDirection(){
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setXY(int newX, int newY) {
        if(matrix == null ||
            x>=0 && y>=0 && y < matrix.length && x < matrix[0].length){
            x = newX;
            y = newY;
        }
    }

    public void setDirection(int direction) {
        if (direction == 0   ||
            direction == 90  ||
            direction == 180 ||
            direction == 270)
                this.direction = direction;
    }
}
