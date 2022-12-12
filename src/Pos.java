public class Pos {
    public int x;
    public int y;
    public int t;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
        t = 0;
    }

    public double weight() {
        // min: -1, max: 1
        t++;
        return (t + 100) % 200 / 100.0 - 1;
    }
}
