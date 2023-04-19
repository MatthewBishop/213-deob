public class class283 {

    static int[] Tiles_lightness;

    static final int method1594(LoginType var0) {
        if (var0 == null) {
            return 12;
        } else {
            switch (var0.field3999) {
            case 5:
                return 20;
            default:
                return 12;
            }
        }
    }

    public static void method1593(int var0, int var1) {
        VarbitComposition var2 = class158.method894(var0);
        int var3 = var2.baseVar;
        int var4 = var2.startBit;
        int var5 = var2.endBit;
        int var6 = Varps.Varps_masks[var5 - var4];
        if (var1 < 0 || var1 > var6) {
            var1 = 0;
        }

        var6 <<= var4;
        Varps.Varps_main[var3] = Varps.Varps_main[var3] & ~var6 | var1 << var4 & var6;
    }
}
