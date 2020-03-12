public class Quadrangle {
    private Point leftBottom;
    private Point leftTop;
    private Point rightBottom;
    private Point rightTop;

    Quadrangle(Point leftBottom, Point leftTop, Point rightBottom, Point rightTop) {
        this.leftBottom = leftBottom;
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
        this.rightTop = rightTop;
    }

    boolean isRectangular() {
        double THRESHOLD = 0.0001;

        boolean isVerticalSidesEqual = Math.abs(getLength(leftBottom, leftTop) -
                getLength(rightBottom, rightTop)) < THRESHOLD;
        boolean isHorizontalSidesEqual = Math.abs(getLength(leftBottom, rightBottom) -
                getLength(leftTop, rightTop)) < THRESHOLD;
        boolean isDiagonalsEqual = Math.abs(getLength(leftBottom, rightTop) -
                getLength(leftTop, rightBottom)) < THRESHOLD;

        return isVerticalSidesEqual && isHorizontalSidesEqual && isDiagonalsEqual;
    }

    private double getLength(Point startPoint, Point endPoint) {
        return Math.sqrt(Math.pow(Math.abs(startPoint.getX() - endPoint.getX()), 2) +
                Math.pow(Math.abs(startPoint.getY() - endPoint.getY()), 2));
    }

    @Override
    public String toString() {
        return "{" + leftBottom.toString() + ", " + leftTop.toString() + ", " +
                rightTop.toString() + ", " + rightBottom.toString() + "}";
    }

    void print() {
        System.out.println(this.toString());
    }
}
