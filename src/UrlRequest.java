import java.net.URL;

public class UrlRequest {

    static int field1151 = -1;

    static int field1150 = -2;

    public static int field1154;

    final URL field1152;

    volatile int field1149;

    volatile byte[] response0;

    UrlRequest(URL var1) {
        this.field1149 = field1151;
        this.field1152 = var1;
    }

    public boolean isDone() {
        return this.field1149 != field1151;
    }

    public byte[] getResponse() {
        return this.response0;
    }

    public String method679() {
        return this.field1152.toString();
    }

    static int Rasterizer3D_brighten(int var0, double var1) {
        double var3 = (double) (var0 >> 16) / 256.0D;
        double var5 = (double) (var0 >> 8 & 255) / 256.0D;
        double var7 = (double) (var0 & 255) / 256.0D;
        var3 = Math.pow(var3, var1);
        var5 = Math.pow(var5, var1);
        var7 = Math.pow(var7, var1);
        int var9 = (int) (var3 * 256.0D);
        int var10 = (int) (var5 * 256.0D);
        int var11 = (int) (var7 * 256.0D);
        return var11 + (var10 << 8) + (var9 << 16);
    }

    static void method680() {
        class129.method763(24);
        class205.setLoginResponseString("The game servers are currently being updated.",
                "Please wait a few minutes and try again.", "");
    }
}
