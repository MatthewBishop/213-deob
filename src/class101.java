final class class101 implements class308 {

    static int field1082;
    // $FF: synthetic field

    final Widget val$cc;

    class101(Widget var1) {
        this.val$cc = var1;
    }

    public void vmethod5708() {
        if (this.val$cc != null && this.val$cc.method1818().field2824 != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.method491(this.val$cc);
            var1.setArgs(this.val$cc.method1818().field2824);
            GrandExchangeOfferAgeComparator.getScriptEvents().addFirst(var1);
        }

    }

    static final String method633(int var0) {
        if (var0 < 100000) {
            return "<col=ffff00>" + var0 + "</col>";
        } else {
            return var0 < 10000000 ? "<col=ffffff>" + var0 / 1000 + "K" + "</col>"
                    : "<col=00ff80>" + var0 / 1000000 + "M" + "</col>";
        }
    }

    static final int method634(int var0, int var1, int var2) {
        int var3 = var0 / var2;
        int var4 = var0 & var2 - 1;
        int var5 = var1 / var2;
        int var6 = var1 & var2 - 1;
        int var7 = class383.method2085(var3, var5);
        int var8 = class383.method2085(var3 + 1, var5);
        int var9 = class383.method2085(var3, var5 + 1);
        int var10 = class383.method2085(var3 + 1, var5 + 1);
        int var11 = JagexCache.method952(var7, var8, var4, var2);
        int var12 = JagexCache.method952(var9, var10, var4, var2);
        return JagexCache.method952(var11, var12, var6, var2);
    }
}
