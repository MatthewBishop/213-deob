public class SpriteMask extends DualNode {

    static String field2808;

    public final int width;

    public final int height;

    public final int[] xWidths;

    public final int[] xStarts;

    SpriteMask(int var1, int var2, int[] var3, int[] var4, int var5) {
        this.width = var1;
        this.height = var2;
        this.xWidths = var3;
        this.xStarts = var4;
    }

    public boolean contains(int var1, int var2) {
        if (var2 >= 0 && var2 < this.xStarts.length) {
            int var3 = this.xStarts[var2];
            if (var1 >= var3 && var1 <= var3 + this.xWidths[var2]) {
                return true;
            }
        }

        return false;
    }

    public static int method1682(int var0, int var1, int var2) {
        var2 &= 3;
        if (var2 == 0) {
            return var0;
        } else if (var2 == 1) {
            return var1;
        } else {
            return var2 == 2 ? 7 - var0 : 7 - var1;
        }
    }
}
