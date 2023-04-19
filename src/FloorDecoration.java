public final class FloorDecoration {

    int z;

    int x;

    int y;

    public Renderable renderable;

    public long tag;

    int flags;

    static final int method1209(int var0, int var1) {
        var1 = (var0 & 127) * var1 >> 7;
        if (var1 < 2) {
            var1 = 2;
        } else if (var1 > 126) {
            var1 = 126;
        }

        return (var0 & 'ﾀ') + var1;
    }

    static void method1210(int var0, int var1, int var2, int var3, int var4, int var5, float var6, float var7,
            float var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16,
            int var17, int var18, int var19, int var20, int var21) {
        Rasterizer3D.field1999.vmethod1362(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11,
                var12, var13, var14, var15, var16, var17, var18, var19, var20, var21);
    }

    static void performPlayerAnimation(Player var0, int var1, int var2) {
        if (var0.sequence == var1 && var1 != -1) {
            int var3 = ItemContainer.SequenceDefinition_get(var1).replyMode;
            if (var3 == 1) {
                var0.sequenceFrame = 0;
                var0.sequenceFrameCycle = 0;
                var0.sequenceDelay = var2;
                var0.currentSequenceFrameIndex = 0;
            }

            if (var3 == 2) {
                var0.currentSequenceFrameIndex = 0;
            }
        } else if (var1 == -1 || var0.sequence == -1
                || ItemContainer.SequenceDefinition_get(var1).forcedPriority >= ItemContainer
                        .SequenceDefinition_get(var0.sequence).forcedPriority) {
            var0.sequence = var1;
            var0.sequenceFrame = 0;
            var0.sequenceFrameCycle = 0;
            var0.sequenceDelay = var2;
            var0.currentSequenceFrameIndex = 0;
            var0.field1006 = var0.pathLength;
        }

    }
}
