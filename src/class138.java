import java.io.File;
import java.io.RandomAccessFile;

public class class138 extends class139 {

    static int field1314;

    public static int[] SpriteBuffer_spriteHeights;

    int field1315;
    // $FF: synthetic field

    final class142 this$0;

    class138(class142 var1) {
        this.this$0 = var1;
        this.field1315 = -1;
    }

    void vmethod3254(Buffer var1) {
        this.field1315 = var1.readUnsignedShort();
    }

    void vmethod3248(ClanSettings var1) {
        var1.method855(this.field1315);
    }

    static double method793(double var0) {
        return Math.exp(var0 * -var0 / 2.0D) / Math.sqrt(6.283185307179586D);
    }

    public static File getFile(String var0) {
        if (!FileSystem.FileSystem_hasPermissions) {
            throw new RuntimeException("");
        } else {
            File var1 = (File) FileSystem.FileSystem_cacheFiles.get(var0);
            if (var1 != null) {
                return var1;
            } else {
                File var2 = new File(class513.FileSystem_cacheDir, var0);
                RandomAccessFile var3 = null;

                try {
                    File var4 = new File(var2.getParent());
                    if (!var4.exists()) {
                        throw new RuntimeException("");
                    } else {
                        var3 = new RandomAccessFile(var2, "rw");
                        int var5 = var3.read();
                        var3.seek(0L);
                        var3.write(var5);
                        var3.seek(0L);
                        var3.close();
                        FileSystem.FileSystem_cacheFiles.put(var0, var2);
                        return var2;
                    }
                } catch (Exception var8) {
                    try {
                        if (var3 != null) {
                            var3.close();
                            var3 = null;
                        }
                    } catch (Exception var7) {
                        ;
                    }

                    throw new RuntimeException();
                }
            }
        }
    }

    public static void method801(String[] var0, int[] var1, int var2, int var3) {
        if (var2 < var3) {
            int var4 = (var3 + var2) / 2;
            int var5 = var2;
            String var6 = var0[var4];
            var0[var4] = var0[var3];
            var0[var3] = var6;
            int var7 = var1[var4];
            var1[var4] = var1[var3];
            var1[var3] = var7;

            for (int var8 = var2; var8 < var3; ++var8) {
                if (var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
                    String var9 = var0[var8];
                    var0[var8] = var0[var5];
                    var0[var5] = var9;
                    int var10 = var1[var8];
                    var1[var8] = var1[var5];
                    var1[var5++] = var10;
                }
            }

            var0[var3] = var0[var5];
            var0[var5] = var6;
            var1[var3] = var1[var5];
            var1[var5] = var7;
            method801(var0, var1, var2, var5 - 1);
            method801(var0, var1, var5 + 1, var3);
        }

    }

    static void method800() {
        Login.worldSelectOpen = false;
        class123.leftTitleSprite.drawAt(Login.xPadding, 0);
        ParamComposition.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
        Canvas.logoSprite.drawAt(Login.xPadding + 382 - Canvas.logoSprite.subWidth / 2, 18);
    }

    static void updateGameState(int var0) {
        if (var0 != Client.gameState) {
            if (Client.gameState == 30) {
                Client.field590.method1138();
            }

            if (Client.gameState == 0) {
                ScriptFrame.client.method185();
            }

            if (var0 == 20 || var0 == 40 || var0 == 45 || var0 == 50) {
                class284.method1595(0);
                Client.field391 = 0;
                Client.field392 = 0;
                Client.timer.method2096(var0);
                if (var0 != 20) {
                    class14.method53(false);
                }
            }

            if (var0 != 20 && var0 != 40 && class333.field3090 != null) {
                class333.field3090.close();
                class333.field3090 = null;
            }

            if (Client.gameState == 25) {
                Client.field489 = 0;
                Client.field427 = 0;
                Client.field593 = 1;
                Client.field425 = 0;
                Client.field426 = 1;
            }

            int var1;
            if (var0 != 5 && var0 != 10) {
                if (var0 == 20) {
                    var1 = Client.gameState == 11 ? 4 : 0;
                    KeyHandler.method105(NetFileRequest.archive10, class452.archive8, false, var1);
                } else if (var0 == 11) {
                    KeyHandler.method105(NetFileRequest.archive10, class452.archive8, false, 4);
                } else if (var0 == 50) {
                    class205.setLoginResponseString("", "Updating date of birth...", "");
                    KeyHandler.method105(NetFileRequest.archive10, class452.archive8, false, 7);
                } else {
                    Player.method519();
                }
            } else {
                var1 = class134.method779() ? 0 : 12;
                KeyHandler.method105(NetFileRequest.archive10, class452.archive8, true, var1);
            }

            Client.gameState = var0;
        }
    }

    static final void method797(MenuAction var0, int var1, int var2) {
        if (var0 != null) {
            class17.menuAction(var0.param0, var0.param1, var0.opcode, var0.identifier, var0.itemId, var0.action,
                    var0.target, var1, var2);
        }

    }

    static final void method796(String var0, String var1, int var2, int var3, int var4, int var5, int var6) {
        SceneTilePaint.insertMenuItem(var0, var1, var2, var3, var4, var5, var6, false);
    }
}
