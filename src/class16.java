import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class class16 implements ThreadFactory {

    static int field54;

    static IndexedSprite[] worldSelectFlagSprites;

    final ThreadGroup field51;

    final AtomicInteger field52;
    // $FF: synthetic field

    final class14 this$0;

    class16(class14 var1) {
        this.this$0 = var1;
        this.field52 = new AtomicInteger(1);
        SecurityManager var2 = System.getSecurityManager();
        this.field51 = var2 != null ? var2.getThreadGroup() : Thread.currentThread().getThreadGroup();
    }

    public Thread newThread(Runnable var1) {
        Thread var2 = new Thread(this.field51, var1,
                this.this$0.field45 + "-rest-request-" + this.field52.getAndIncrement(), 0L);
        var2.setDaemon(true);
        var2.setPriority(5);
        return var2;
    }

    public static int compareStrings(CharSequence var0, CharSequence var1, Language var2) {
        int var3 = var0.length();
        int var4 = var1.length();
        int var5 = 0;
        int var6 = 0;
        byte var7 = 0;
        byte var8 = 0;

        while (var5 - var7 < var3 || var6 - var8 < var4) {
            if (var5 - var7 >= var3) {
                return -1;
            }

            if (var6 - var8 >= var4) {
                return 1;
            }

            char var9;
            if (var7 != 0) {
                var9 = (char) var7;
                boolean var14 = false;
            } else {
                var9 = var0.charAt(var5++);
            }

            char var10;
            if (var8 != 0) {
                var10 = (char) var8;
                boolean var15 = false;
            } else {
                var10 = var1.charAt(var6++);
            }

            byte var11;
            if (var9 == 198) {
                var11 = 69;
            } else if (var9 == 230) {
                var11 = 101;
            } else if (var9 == 223) {
                var11 = 115;
            } else if (var9 == 338) {
                var11 = 69;
            } else if (var9 == 339) {
                var11 = 101;
            } else {
                var11 = 0;
            }

            var7 = var11;
            byte var12;
            if (var10 == 198) {
                var12 = 69;
            } else if (var10 == 230) {
                var12 = 101;
            } else if (var10 == 223) {
                var12 = 115;
            } else if (var10 == 338) {
                var12 = 69;
            } else if (var10 == 339) {
                var12 = 101;
            } else {
                var12 = 0;
            }

            var8 = var12;
            var9 = AbstractArchive.standardizeChar(var9, var2);
            var10 = AbstractArchive.standardizeChar(var10, var2);
            if (var9 != var10 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
                var9 = Character.toLowerCase(var9);
                var10 = Character.toLowerCase(var10);
                if (var9 != var10) {
                    return Archive.lowercaseChar(var9, var2) - Archive.lowercaseChar(var10, var2);
                }
            }
        }

        int var16 = Math.min(var3, var4);

        int var17;
        char var20;
        for (var17 = 0; var17 < var16; ++var17) {
            if (var2 == Language.Language_FR) {
                var5 = var3 - 1 - var17;
                var6 = var4 - 1 - var17;
            } else {
                var6 = var17;
                var5 = var17;
            }

            char var18 = var0.charAt(var5);
            var20 = var1.charAt(var6);
            if (var18 != var20 && Character.toUpperCase(var18) != Character.toUpperCase(var20)) {
                var18 = Character.toLowerCase(var18);
                var20 = Character.toLowerCase(var20);
                if (var20 != var18) {
                    return Archive.lowercaseChar(var18, var2) - Archive.lowercaseChar(var20, var2);
                }
            }
        }

        var17 = var3 - var4;
        if (var17 != 0) {
            return var17;
        } else {
            for (int var19 = 0; var19 < var16; ++var19) {
                var20 = var0.charAt(var19);
                char var13 = var1.charAt(var19);
                if (var13 != var20) {
                    return Archive.lowercaseChar(var20, var2) - Archive.lowercaseChar(var13, var2);
                }
            }

            return 0;
        }
    }

    static int method60(int var0, Script var1, boolean var2) {
        return 2;
    }
}
