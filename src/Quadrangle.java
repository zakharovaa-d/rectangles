public class Quadrangle {
    private Point leftBottom;
    private Point leftTop;
    private Point rightBottom;
    private Point rightTop;

    public Quadrangle(Point leftBottom, Point leftTop, Point rightBottom, Point rightTop) {
        this.leftBottom = leftBottom;
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
        this.rightTop = rightTop;
    }

    /**
     * If a quadrangle has two pairs of equal opposite sides and its diagonals are also equal, this is a rectangle.
     *
     * @return true if quadrangle is a rectangle
     */
    public boolean isRectangular() {
        final double THRESHOLD = 0.0001;

        final boolean isVerticalSidesEqual = Math.abs(getLength(leftBottom, leftTop) -
                getLength(rightBottom, rightTop)) < THRESHOLD;
        final boolean isHorizontalSidesEqual = Math.abs(getLength(leftBottom, rightBottom) -
                getLength(leftTop, rightTop)) < THRESHOLD;
        final boolean isDiagonalsEqual = Math.abs(getLength(leftBottom, rightTop) -
                getLength(leftTop, rightBottom)) < THRESHOLD;

        return isVerticalSidesEqual && isHorizontalSidesEqual && isDiagonalsEqual;
    }

    /**
     * Calculating the length of the line using the Pythagorean theorem
     *
     * @param startPoint start point
     * @param endPoint   end point
     * @return the length of the line
     */
    private double getLength(final Point startPoint, final Point endPoint) {
        return Math.sqrt(Math.pow(Math.abs(startPoint.getX() - endPoint.getX()), 2) +
                Math.pow(Math.abs(startPoint.getY() - endPoint.getY()), 2));
    }

    @Override
    public String toString() {
        return "{" + leftBottom.toString() + ", " + leftTop.toString() + ", " +
                rightTop.toString() + ", " + rightBottom.toString() + "}";
    }

    public void print() {
        System.out.println(this.toString());
    }
}
