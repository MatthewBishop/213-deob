public class class8 {

    final int field18;

    final int field17;

    final String field19;

    class8(Buffer var1) {
        this(var1.readUnsignedByte(), var1.readUnsignedByte(), var1.readStringCp1252NullTerminated());
    }

    class8(int var1, int var2, String var3) {
        this.field18 = var1;
        this.field17 = var2;
        this.field19 = var3;
    }

    String method29() {
        return Integer.toHexString(this.field18) + Integer.toHexString(this.field17) + this.field19;
    }

    int method28() {
        return this.field17;
    }
}
