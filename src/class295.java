public class class295 {

    static int[] field2716;

    static {
        new Object();
        field2716 = new int[33];
        field2716[0] = 0;
        int var0 = 2;

        for (int var1 = 1; var1 < 33; ++var1) {
            field2716[var1] = var0 - 1;
            var0 += var0;
        }

    }

    public static void method1608() {
        if (NetCache.NetCache_socket != null) {
            NetCache.NetCache_socket.close();
        }

    }
}
