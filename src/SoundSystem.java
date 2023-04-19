import java.util.concurrent.ScheduledExecutorService;

public class SoundSystem implements Runnable {

    static ScheduledExecutorService soundSystemExecutor;

    static Widget scriptDotWidget;

    volatile PcmPlayer[] players = new PcmPlayer[2];

    public void run() {
        try {
            for (int var1 = 0; var1 < 2; ++var1) {
                PcmPlayer var2 = this.players[var1];
                if (var2 != null) {
                    var2.run();
                }
            }
        } catch (Exception var4) {
            class387.RunException_sendStackTrace((String) null, var4);
        }

    }

    public static Widget getWidgetChild(int var0, int var1) {
        Widget var2 = class165.getWidget(var0);
        if (var1 == -1) {
            return var2;
        } else {
            return var2 != null && var2.children != null && var1 < var2.children.length ? var2.children[var1] : null;
        }
    }

    public static boolean loadInterface(int var0) {
        if (class264.Widget_loadedInterfaces[var0]) {
            return true;
        } else if (!UserComparator3.Widget_archive.tryLoadGroup(var0)) {
            return false;
        } else {
            int var1 = UserComparator3.Widget_archive.getGroupFileCount(var0);
            if (var1 == 0) {
                class264.Widget_loadedInterfaces[var0] = true;
                return true;
            } else {
                if (VerticalAlignment.Widget_interfaceComponents[var0] == null) {
                    VerticalAlignment.Widget_interfaceComponents[var0] = new Widget[var1];
                }

                for (int var2 = 0; var2 < var1; ++var2) {
                    if (VerticalAlignment.Widget_interfaceComponents[var0][var2] == null) {
                        byte[] var3 = UserComparator3.Widget_archive.takeFile(var0, var2);
                        if (var3 != null) {
                            VerticalAlignment.Widget_interfaceComponents[var0][var2] = new Widget();
                            VerticalAlignment.Widget_interfaceComponents[var0][var2].id = var2 + (var0 << 16);
                            if (var3[0] == -1) {
                                VerticalAlignment.Widget_interfaceComponents[var0][var2].decode(new Buffer(var3));
                            } else {
                                VerticalAlignment.Widget_interfaceComponents[var0][var2].decodeLegacy(new Buffer(var3));
                            }
                        }
                    }
                }

                class264.Widget_loadedInterfaces[var0] = true;
                return true;
            }
        }
    }

    static int method246(int var0) {
        return (int) ((Math.log((double) var0) / Interpreter.field702 - 7.0D) * 256.0D);
    }

    static int method247(int var0, Script var1, boolean var2) {
        return 2;
    }
}
