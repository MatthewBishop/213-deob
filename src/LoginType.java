public class LoginType {

    public static final LoginType oldscape = new LoginType(4, 0, "", "");

    static final LoginType field3991 = new LoginType(6, 1, "", "");

    static final LoginType field3993 = new LoginType(3, 2, "", "");

    static final LoginType field3994 = new LoginType(8, 3, "", "");

    static final LoginType field3990 = new LoginType(7, 4, "", "");

    static final LoginType field3995 = new LoginType(5, 5, "", "");

    static final LoginType field3996 = new LoginType(2, 6, "", "");

    static final LoginType field3997 = new LoginType(1, 7, "", "");

    public static final LoginType field3998;

    final int field3999;

    final String field4000;

    static {
        field3998 = new LoginType(0, -1, "", "", true,
                new LoginType[] { oldscape, field3991, field3993, field3990, field3994 });
    }

    LoginType(int var1, int var2, String var3, String var4) {
        this.field3999 = var1;
        this.field4000 = var4;
    }

    LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
        this.field3999 = var1;
        this.field4000 = var4;
    }

    public String toString() {
        return this.field4000;
    }
}
