import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class class264 {

    static int foundItemIdCount;

    public static boolean[] Widget_loadedInterfaces;

    static long method1531() {
        try {
            URL var0 = new URL(InvDefinition.method977("services", false) + "m=accountappeal/login.ws");
            URLConnection var1 = var0.openConnection();
            var1.setRequestProperty("connection", "close");
            var1.setDoInput(true);
            var1.setDoOutput(true);
            var1.setConnectTimeout(5000);
            OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
            var2.write("data1=req");
            var2.flush();
            InputStream var3 = var1.getInputStream();
            Buffer var4 = new Buffer(new byte[1000]);

            do {
                int var5 = var3.read(var4.array, var4.offset, 1000 - var4.offset);
                if (var5 == -1) {
                    var4.offset = 0;
                    long var7 = var4.readLong();
                    return var7;
                }

                var4.offset += var5;
            } while (var4.offset < 1000);

            return 0L;
        } catch (Exception var9) {
            return 0L;
        }
    }

    static int getClipMidX2() {
        return Rasterizer3D.clips.field2236;
    }
}
