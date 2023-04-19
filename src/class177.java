import java.io.IOException;

public abstract class class177 {

    String field1468;
    // $FF: synthetic field

    final class166 this$0;

    class177(class166 var1, String var2) {
        this.this$0 = var1;
        this.field1468 = var2;
    }

    public abstract int vmethod3379();

    public String vmethod3380() {
        return null;
    }

    public int vmethod3378() {
        return -1;
    }

    public String method963() {
        return this.field1468;
    }

    public static void method967(boolean var0) {
        if (NetCache.NetCache_socket != null) {
            try {
                Buffer var1 = new Buffer(4);
                var1.writeByte(var0 ? 2 : 3);
                var1.writeMedium(0);
                NetCache.NetCache_socket.write(var1.array, 0, 4);
            } catch (IOException var4) {
                try {
                    NetCache.NetCache_socket.close();
                } catch (Exception var3) {
                    ;
                }

                ++NetCache.NetCache_ioExceptions;
                NetCache.NetCache_socket = null;
            }

        }
    }
}
