public enum class135 implements class356 {

    field1302(2, 0),

    field1299(1, 1),

    field1305(0, 2),

    field1301(3, 3),

    field1303(4, 4);

    public final int field1304;

    final int id;

    class135(int var3, int var4) {
        this.field1304 = var3;
        this.id = var4;
    }

    public int rsOrdinal() {
        return this.id;
    }

    static void resizeInterface(Widget[] var0, int var1, int var2, int var3, boolean var4) {
        for (int var5 = 0; var5 < var0.length; ++var5) {
            Widget var6 = var0[var5];
            if (var6 != null && var6.parentId == var1) {
                class158.alignWidgetSize(var6, var2, var3, var4);
                class192.alignWidgetPosition(var6, var2, var3);
                if (var6.scrollX > var6.scrollWidth - var6.width) {
                    var6.scrollX = var6.scrollWidth - var6.width;
                }

                if (var6.scrollX < 0) {
                    var6.scrollX = 0;
                }

                if (var6.scrollY > var6.scrollHeight - var6.height) {
                    var6.scrollY = var6.scrollHeight - var6.height;
                }

                if (var6.scrollY < 0) {
                    var6.scrollY = 0;
                }

                if (var6.type == 0) {
                    WallDecoration.revalidateWidgetScroll(var0, var6, var4);
                }
            }
        }

    }

    static final void method783(int var0) {
        var0 = Math.min(Math.max(var0, 0), 127);
        class20.clientPreferences.setAreaSoundEffectsVolume(var0);
    }
}
