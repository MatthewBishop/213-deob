import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

public enum MoveSpeed implements class356 {

    STATIONARY((byte) -1),

    CRAWL((byte) 0),

    WALK((byte) 1),

    RUN((byte) 2);

    public byte speed;

    MoveSpeed(byte var3) {
        this.speed = var3;
    }

    public int rsOrdinal() {
        return this.speed;
    }

    static String method1179(Throwable var0) throws IOException {
        String var1;
        if (var0 instanceof RunException) {
            RunException var2 = (RunException) var0;
            var1 = var2.field4179 + " | ";
            var0 = var2.field4177;
        } else {
            var1 = "";
        }

        StringWriter var12 = new StringWriter();
        PrintWriter var3 = new PrintWriter(var12);
        var0.printStackTrace(var3);
        var3.close();
        String var4 = var12.toString();
        BufferedReader var5 = new BufferedReader(new StringReader(var4));
        String var6 = var5.readLine();

        while (true) {
            while (true) {
                String var7 = var5.readLine();
                if (var7 == null) {
                    var1 = var1 + "| " + var6;
                    return var1;
                }

                int var8 = var7.indexOf(40);
                int var9 = var7.indexOf(41, var8 + 1);
                if (var8 >= 0 && var9 >= 0) {
                    String var10 = var7.substring(var8 + 1, var9);
                    int var11 = var10.indexOf(".java:");
                    if (var11 >= 0) {
                        var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
                        var1 = var1 + var10 + ' ';
                        continue;
                    }

                    var7 = var7.substring(0, var8);
                }

                var7 = var7.trim();
                var7 = var7.substring(var7.lastIndexOf(32) + 1);
                var7 = var7.substring(var7.lastIndexOf(9) + 1);
                var1 = var1 + var7 + ' ';
            }
        }
    }
}
