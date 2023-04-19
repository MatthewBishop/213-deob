public class Bounds {

    public int lowX;

    public int lowY;

    public int highX;

    public int highY;

    public Bounds(int var1, int var2, int var3, int var4) {
        this.setLow(var1, var2);
        this.setHigh(var3, var4);
    }

    public Bounds(int var1, int var2) {
        this(0, 0, var1, var2);
    }

    public void setLow(int var1, int var2) {
        this.lowX = var1;
        this.lowY = var2;
    }

    public void setHigh(int var1, int var2) {
        this.highX = var1;
        this.highY = var2;
    }

    public boolean method2232(int var1, int var2) {
        return var1 >= this.lowX && var1 < this.highX + this.lowX && var2 >= this.lowY && var2 < this.lowY + this.highY;
    }

    public void method2236(Bounds var1, Bounds var2) {
        this.method2233(var1, var2);
        this.method2234(var1, var2);
    }

    void method2233(Bounds var1, Bounds var2) {
        var2.lowX = this.lowX;
        var2.highX = this.highX;
        if (this.lowX < var1.lowX) {
            var2.highX = (var2.highX * -1469434281 - (var1.lowX * -1469434281 - this.lowX * -1469434281)) * 944313703;
            var2.lowX = var1.lowX;
        }

        if (var2.method2235() > var1.method2235()) {
            var2.highX -= var2.method2235() - var1.method2235();
        }

        if (var2.highX < 0) {
            var2.highX = 0;
        }

    }

    void method2234(Bounds var1, Bounds var2) {
        var2.lowY = this.lowY;
        var2.highY = this.highY;
        if (this.lowY < var1.lowY) {
            var2.highY = (var2.highY * 149296003 - (var1.lowY * 149296003 - this.lowY * 149296003)) * -1376251093;
            var2.lowY = var1.lowY;
        }

        if (var2.method2237() > var1.method2237()) {
            var2.highY -= var2.method2237() - var1.method2237();
        }

        if (var2.highY < 0) {
            var2.highY = 0;
        }

    }

    int method2235() {
        return this.highX + this.lowX;
    }

    int method2237() {
        return this.highY + this.lowY;
    }

    public String toString() {
        return null;
    }
}
