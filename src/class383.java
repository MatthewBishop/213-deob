import java.io.IOException;

public class class383 {

    class379 field3650;

    int field3648 = 0;

    int field3649 = 0;

    class383(class379 var1, int var2, int var3) {
        this.field3650 = var1;
        this.field3648 = var2;
        this.field3649 = var3;
    }

    public String method2083() {
        if (this.method2078()) {
            return "";
        } else {
            StringBuilder var1 = new StringBuilder(this.method2079());

            for (int var2 = this.field3648; var2 < this.field3649; ++var2) {
                class381 var3 = this.field3650.method2002(var2);
                var1.append(var3.field3624);
            }

            return var1.toString();
        }
    }

    boolean method2081(int var1) {
        return this.field3650.method2024() == 2
                || this.field3650.method2024() == 1 && (!this.field3650.field3618 || this.field3649 - 1 != var1);
    }

    public boolean method2078() {
        return this.field3649 == this.field3648;
    }

    public int method2079() {
        return this.field3649 - this.field3648;
    }

    boolean method2082(class381 var1) {
        if (this.field3650.field3621 == 2) {
            return true;
        } else if (this.field3650.field3621 == 0) {
            return false;
        } else {
            return this.field3650.method2023() != var1;
        }
    }

    int method2084() {
        if (this.method2078()) {
            return 0;
        } else {
            class381 var1 = this.field3650.method2002(this.field3649 - 1);
            if (var1.field3624 == '\n') {
                return 0;
            } else if (this.method2082(var1)) {
                return this.field3650.field3612.advances[42];
            } else {
                int var2 = this.field3650.field3612.advances[var1.field3624];
                if (var2 == 0) {
                    return var1.field3624 == '\t' ? this.field3650.field3612.advances[32] * 3
                            : this.field3650.field3612.advances[32];
                } else {
                    return var2;
                }
            }
        }
    }

    public class461 method2077() {
        if (this.method2078()) {
            return new class461(0, 0);
        } else {
            class381 var1 = this.field3650.method2002(this.field3649 - 1);
            return new class461(var1.field3623 + this.method2084(), var1.field3625);
        }
    }

    public class381 method2080(int var1) {
        return var1 >= 0 && var1 < this.method2079() ? this.field3650.method2002(this.field3648 + var1) : null;
    }

    static String colorStartTag(int var0) {
        return "<col=" + Integer.toHexString(var0) + ">";
    }

    public static void method2087() {
        DbTableType.DBTableType_cache.clear();
    }

    static final int method2085(int var0, int var1) {
        int var2 = Actor.method537(var0 - 1, var1 - 1) + Actor.method537(var0 + 1, var1 - 1)
                + Actor.method537(var0 - 1, var1 + 1) + Actor.method537(var0 + 1, var1 + 1);
        int var3 = Actor.method537(var0 - 1, var1) + Actor.method537(var0 + 1, var1) + Actor.method537(var0, var1 - 1)
                + Actor.method537(var0, var1 + 1);
        int var4 = Actor.method537(var0, var1);
        return var2 / 16 + var3 / 8 + var4 / 4;
    }

    static void method2086(Buffer var0) {
        if (Client.randomDatData != null) {
            var0.writeBytes(Client.randomDatData, 0, Client.randomDatData.length);
        } else {
            byte[] var2 = new byte[24];

            try {
                JagexCache.JagexCache_randomDat.seek(0L);
                JagexCache.JagexCache_randomDat.readFully(var2);

                int var3;
                for (var3 = 0; var3 < 24 && var2[var3] == 0; ++var3) {
                    ;
                }

                if (var3 >= 24) {
                    throw new IOException();
                }
            } catch (Exception var6) {
                for (int var4 = 0; var4 < 24; ++var4) {
                    var2[var4] = -1;
                }
            }

            var0.writeBytes(var2, 0, var2.length);
        }
    }
}
