import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Map;

public class class20 {

    static ClientPreferences clientPreferences;

    final int field64;

    final Map field63;

    final String field62;

    class20(String var1) {
        this.field64 = 400;
        this.field63 = null;
        this.field62 = "";
    }

    class20(HttpURLConnection var1) throws IOException {
        this.field64 = var1.getResponseCode();
        var1.getResponseMessage();
        this.field63 = var1.getHeaderFields();
        StringBuilder var2 = new StringBuilder();
        InputStream var3 = this.field64 >= 300 ? var1.getErrorStream() : var1.getInputStream();
        if (var3 != null) {
            InputStreamReader var4 = new InputStreamReader(var3);
            BufferedReader var5 = new BufferedReader(var4);

            String var6;
            while ((var6 = var5.readLine()) != null) {
                var2.append(var6);
            }

            var3.close();
        }

        this.field62 = var2.toString();
    }

    public int method79() {
        return this.field64;
    }

    public Map method80() {
        return this.field63;
    }

    public String method81() {
        return this.field62;
    }

    static int method83(int var0, int var1) {
        long var2 = (long) ((var0 << 16) + var1);
        return Script.NetCache_currentResponse != null && Script.NetCache_currentResponse.key == var2
                ? NetCache.NetCache_responseArchiveBuffer.offset * 99
                        / (NetCache.NetCache_responseArchiveBuffer.array.length
                                - Script.NetCache_currentResponse.padding)
                        + 1
                : 0;
    }

    public static int method82(int var0) {
        class133 var2 = (class133) SequenceDefinition.SequenceDefinition_cachedModel.get((long) var0);
        class133 var1;
        if (var2 != null) {
            var1 = var2;
        } else {
            var2 = class211.method1180(SequenceDefinition.SequenceDefinition_animationsArchive,
                    SequenceDefinition.SequenceDefinition_skeletonsArchive, var0, false);
            if (var2 != null) {
                SequenceDefinition.SequenceDefinition_cachedModel.put(var2, (long) var0);
            }

            var1 = var2;
        }

        if (var1 == null) {
            return 2;
        } else {
            return var1.method774() ? 0 : 1;
        }
    }
}
