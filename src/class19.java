import java.io.IOException;
import java.util.concurrent.Callable;

public class class19 implements Callable {

    static Bounds field60;

    final class10 field61;
    // $FF: synthetic field

    final class14 this$0;

    class19(class14 var1, class10 var2) {
        this.this$0 = var1;
        this.field61 = var2;
    }

    public Object call() throws Exception {
        try {
            while (this.field61.method37()) {
                PlayerComposition.method1704(10L);
            }
        } catch (IOException var2) {
            return new class20("Error servicing REST query: " + var2.getMessage());
        }

        return this.field61.method35();
    }

    static final void method78(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7,
            int var8, int var9, CollisionMap[] var10) {
        int var12;
        for (int var11 = 0; var11 < 8; ++var11) {
            for (var12 = 0; var12 < 8; ++var12) {
                if (var11 + var2 > 0 && var11 + var2 < 103 && var3 + var12 > 0 && var3 + var12 < 103) {
                    var10[var1].flags[var11 + var2][var12 + var3] &= -16777217;
                }
            }
        }

        Buffer var24 = new Buffer(var0);

        for (var12 = 0; var12 < 4; ++var12) {
            for (int var13 = 0; var13 < 64; ++var13) {
                for (int var14 = 0; var14 < 64; ++var14) {
                    if (var12 == var4 && var13 >= var5 && var13 < var5 + 8 && var14 >= var6 && var14 < var6 + 8) {
                        int var15 = var2 + SpriteMask.method1682(var13 & 7, var14 & 7, var7);
                        int var18 = var13 & 7;
                        int var19 = var14 & 7;
                        int var20 = var7 & 3;
                        int var17;
                        if (var20 == 0) {
                            var17 = var19;
                        } else if (var20 == 1) {
                            var17 = 7 - var18;
                        } else if (var20 == 2) {
                            var17 = 7 - var19;
                        } else {
                            var17 = var18;
                        }

                        int var21 = var3 + var17;
                        int var22 = (var13 & 7) + var8 + var2;
                        int var23 = var3 + (var14 & 7) + var9;
                        class372.loadTerrain(var24, var1, var15, var21, var22, var23, var7);
                    } else {
                        class372.loadTerrain(var24, 0, -1, -1, 0, 0, 0);
                    }
                }
            }
        }

    }
}
