public class LoginPacket implements class285 {

    public static final LoginPacket field2705 = new LoginPacket(14, 0);

    static final LoginPacket field2701 = new LoginPacket(15, 4);

    public static final LoginPacket NEW_LOGIN_CONNECTION = new LoginPacket(16, -2);

    public static final LoginPacket RECONNECT_LOGIN_CONNECTION = new LoginPacket(18, -2);

    public static final LoginPacket field2700 = new LoginPacket(19, -2);

    static final LoginPacket field2704 = new LoginPacket(27, 0);

    static final LoginPacket[] field2706 = new LoginPacket[32];

    public final int id;

    static {
        LoginPacket[] var0 = class33.method145();

        for (int var1 = 0; var1 < var0.length; ++var1) {
            field2706[var0[var1].id] = var0[var1];
        }

    }

    LoginPacket(int var1, int var2) {
        this.id = var1;
    }

    public static int iLog(int var0) {
        int var1 = 0;
        if (var0 < 0 || var0 >= 65536) {
            var0 >>>= 16;
            var1 += 16;
        }

        if (var0 >= 256) {
            var0 >>>= 8;
            var1 += 8;
        }

        if (var0 >= 16) {
            var0 >>>= 4;
            var1 += 4;
        }

        if (var0 >= 4) {
            var0 >>>= 2;
            var1 += 2;
        }

        if (var0 >= 1) {
            var0 >>>= 1;
            ++var1;
        }

        return var0 + var1;
    }
}
