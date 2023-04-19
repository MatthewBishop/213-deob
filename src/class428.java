public enum class428 implements class356 {

    field3815(1, 1),

    field3817(2, 2),

    field3816(0, 3),

    field3814(3, 10);

    final int field3818;

    final int field3819;

    class428(int var3, int var4) {
        this.field3818 = var3;
        this.field3819 = var4;
    }

    public int rsOrdinal() {
        return this.field3819;
    }

    static final boolean method2272(Model var0, int var1, int var2, int var3, int var4) {
        boolean var5 = ViewportMouse.ViewportMouse_isInViewport;
        if (!var5) {
            return false;
        } else {
            class122.method737();
            AABB var6 = (AABB) var0.aabb.get(var1);
            int var7 = var2 + var6.xMid;
            int var8 = var3 + var6.yMid;
            int var9 = var4 + var6.zMid;
            int var10 = var6.xMidOffset;
            int var11 = var6.yMidOffset;
            int var12 = var6.zMidOffset;
            int var13 = ViewportMouse.field2207 - var7;
            int var14 = class294.field2715 - var8;
            int var15 = ViewportMouse.field2208 - var9;
            if (Math.abs(var13) > var10 + EnumComposition.field1536) {
                return false;
            } else if (Math.abs(var14) > var11 + ViewportMouse.field2211) {
                return false;
            } else if (Math.abs(var15) > var12 + class9.field29) {
                return false;
            } else if (Math.abs(var15 * UserComparator8.field1157 - var14 * ReflectionCheck.field166) > var11
                    * class9.field29 + var12 * ViewportMouse.field2211) {
                return false;
            } else if (Math.abs(var13 * ReflectionCheck.field166 - var15 * ViewportMouse.field2209) > var12
                    * EnumComposition.field1536 + var10 * class9.field29) {
                return false;
            } else {
                return Math.abs(var14 * ViewportMouse.field2209 - var13 * UserComparator8.field1157) <= var11
                        * EnumComposition.field1536 + var10 * ViewportMouse.field2211;
            }
        }
    }
}
