public class class147 extends class155 {

    static ClanChannel field1346;

    static int menuHeight;

    int field1345;
    // $FF: synthetic field

    final class156 this$0;

    class147(class156 var1) {
        this.this$0 = var1;
        this.field1345 = -1;
    }

    void vmethod3238(Buffer var1) {
        this.field1345 = var1.readUnsignedShort();
        var1.readUnsignedByte();
        if (var1.readUnsignedByte() != 255) {
            --var1.offset;
            var1.readLong();
        }

    }

    void vmethod3239(ClanChannel var1) {
        var1.removeMember(this.field1345);
    }

    static final void method837(byte[] var0, int var1, int var2, Scene var3, CollisionMap[] var4) {
        Buffer var5 = new Buffer(var0);
        int var6 = -1;

        while (true) {
            int var7 = var5.method2529();
            if (var7 == 0) {
                return;
            }

            var6 += var7;
            int var8 = 0;

            while (true) {
                int var9 = var5.readUShortSmart();
                if (var9 == 0) {
                    break;
                }

                var8 += var9 - 1;
                int var10 = var8 & 63;
                int var11 = var8 >> 6 & 63;
                int var12 = var8 >> 12;
                int var13 = var5.readUnsignedByte();
                int var14 = var13 >> 2;
                int var15 = var13 & 3;
                int var16 = var11 + var1;
                int var17 = var10 + var2;
                if (var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
                    int var18 = var12;
                    if ((Tiles.Tiles_renderFlags[1][var16][var17] & 2) == 2) {
                        var18 = var12 - 1;
                    }

                    CollisionMap var19 = null;
                    if (var18 >= 0) {
                        var19 = var4[var18];
                    }

                    class207.addObjects(var12, var16, var17, var6, var15, var14, var3, var19);
                }
            }
        }
    }

    static final int getTileHeight(int var0, int var1, int var2) {
        int var3 = var0 >> 7;
        int var4 = var1 >> 7;
        if (var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
            int var5 = var2;
            if (var2 < 3 && (Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
                var5 = var2 + 1;
            }

            int var6 = var0 & 127;
            int var7 = var1 & 127;
            int var8 = (128 - var6) * Tiles.Tiles_heights[var5][var3][var4]
                    + Tiles.Tiles_heights[var5][var3 + 1][var4] * var6 >> 7;
            int var9 = var6 * Tiles.Tiles_heights[var5][var3 + 1][var4 + 1]
                    + Tiles.Tiles_heights[var5][var3][var4 + 1] * (128 - var6) >> 7;
            return var8 * (128 - var7) + var7 * var9 >> 7;
        } else {
            return 0;
        }
    }
}
