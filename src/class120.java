public class class120 {

    public static boolean musicTrackBoolean;

    int field1175;

    float field1178;

    float field1174 = Float.MAX_VALUE;

    float field1172 = Float.MAX_VALUE;

    float field1176 = Float.MAX_VALUE;

    float field1173 = Float.MAX_VALUE;

    class120 field1177;

    void method717(Buffer var1, int var2) {
        this.field1175 = var1.readShort();
        this.field1178 = var1.method2487();
        this.field1174 = var1.method2487();
        this.field1172 = var1.method2487();
        this.field1176 = var1.method2487();
        this.field1173 = var1.method2487();
    }

    static void setTapToDrop(boolean var0) {
        Client.tapToDrop = var0;
    }
}
