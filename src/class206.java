public class class206 extends Node {

    static int[] BZip2Decompressor_block;

    public int field1855;

    public int field1852;

    public int field1853;

    public Widget field1854;

    public class206(int var1, int var2, int var3, Widget var4) {
        this.field1853 = var1;
        this.field1855 = var2;
        this.field1852 = var3;
        this.field1854 = var4;
    }

    static class482 method1147(int var0) {
        class482 var1 = (class482) Client.Widget_cachedModels.get((long) var0);
        if (var1 == null) {
            var1 = new class482(PcmPlayer.field211, class373.method1992(var0), BufferedSink.method2222(var0));
            Client.Widget_cachedModels.put(var1, (long) var0);
        }

        return var1;
    }
}
