public class class154 extends class139 {

    long field1387;

    String field1386;

    int field1385;
    // $FF: synthetic field

    final class142 this$0;

    class154(class142 var1) {
        this.this$0 = var1;
        this.field1387 = -1L;
        this.field1386 = null;
        this.field1385 = 0;
    }

    void vmethod3254(Buffer var1) {
        if (var1.readUnsignedByte() != 255) {
            --var1.offset;
            this.field1387 = var1.readLong();
        }

        this.field1386 = var1.readStringCp1252NullTerminatedOrNull();
        this.field1385 = var1.readUnsignedShort();
    }

    void vmethod3248(ClanSettings var1) {
        var1.method849(this.field1387, this.field1386, this.field1385);
    }

    public static void method883(Huffman var0) {
        class319.huffman = var0;
    }
}
