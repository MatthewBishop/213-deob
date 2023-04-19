public class class140 extends class139 {

    int field1318;

    boolean field1317;
    // $FF: synthetic field

    final class142 this$0;

    class140(class142 var1) {
        this.this$0 = var1;
        this.field1318 = -1;
    }

    void vmethod3254(Buffer var1) {
        this.field1318 = var1.readUnsignedShort();
        this.field1317 = var1.readUnsignedByte() == 1;
    }

    void vmethod3248(ClanSettings var1) {
        var1.method860(this.field1318, this.field1317);
    }

    public static int method806(int var0) {
        return class295.field2716[var0];
    }
}
