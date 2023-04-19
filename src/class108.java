import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class class108 extends UrlRequester {

    static String param9;

    final boolean field1147;

    public class108(boolean var1, int var2) {
        super(var2);
        this.field1147 = var1;
    }

    void vmethod2700(UrlRequest var1) throws IOException {
        URLConnection var2 = null;
        boolean var9 = false;

        HttpURLConnection var12;
        label139: {
            label131: {
                try {
                    label134: {
                        var9 = true;
                        String var3 = var1.field1152.getProtocol();
                        if (var3.equals("http")) {
                            var2 = this.method673(var1);
                        } else {
                            if (!var3.equals("https")) {
                                var1.field1149 = UrlRequest.field1150;
                                var9 = false;
                                break label134;
                            }

                            var2 = this.method674(var1);
                        }

                        this.method669(var2, var1);
                        var9 = false;
                        break label139;
                    }
                } catch (IOException var10) {
                    var1.field1149 = UrlRequest.field1150;
                    var9 = false;
                    break label131;
                } finally {
                    if (var9) {
                        if (var2 != null && var2 instanceof HttpURLConnection) {
                            HttpURLConnection var6 = (HttpURLConnection) var2;
                            var6.disconnect();
                        }

                    }
                }

                if (var2 != null && var2 instanceof HttpURLConnection) {
                    HttpURLConnection var4 = (HttpURLConnection) var2;
                    var4.disconnect();
                }

                return;
            }

            if (var2 != null && var2 instanceof HttpURLConnection) {
                var12 = (HttpURLConnection) var2;
                var12.disconnect();
            }

            return;
        }

        if (var2 != null && var2 instanceof HttpURLConnection) {
            var12 = (HttpURLConnection) var2;
            var12.disconnect();
        }

    }

    URLConnection method673(UrlRequest var1) throws IOException {
        URLConnection var2 = var1.field1152.openConnection();
        this.method668(var2);
        return var2;
    }

    URLConnection method674(UrlRequest var1) throws IOException {
        HttpsURLConnection var2 = (HttpsURLConnection) var1.field1152.openConnection();
        if (!this.field1147) {
            if (class15.field50 == null) {
                class15.field50 = new class15();
            }

            class15 var4 = class15.field50;
            var2.setSSLSocketFactory(var4);
        }

        this.method668(var2);
        return var2;
    }

    public static Object method675(byte[] var0, boolean var1) {
        if (var0 == null) {
            return null;
        } else if (var0.length > 136) {
            DirectByteArrayCopier var2 = new DirectByteArrayCopier();
            var2.set(var0);
            return var2;
        } else {
            return var0;
        }
    }
}
