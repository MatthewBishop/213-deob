public class class158 extends class139 {

    static IndexedSprite options_buttons_2Sprite;

    int field1394;
    // $FF: synthetic field

    final class142 this$0;

    class158(class142 var1) {
        this.this$0 = var1;
        this.field1394 = -1;
    }

    void vmethod3254(Buffer var1) {
        this.field1394 = var1.readUnsignedShort();
    }

    void vmethod3248(ClanSettings var1) {
        var1.method850(this.field1394);
    }

    static void method896() {
        if (TaskHandler.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
            class28.KeyHandler_keyCodes[186] = 57;
            class28.KeyHandler_keyCodes[187] = 27;
            class28.KeyHandler_keyCodes[188] = 71;
            class28.KeyHandler_keyCodes[189] = 26;
            class28.KeyHandler_keyCodes[190] = 72;
            class28.KeyHandler_keyCodes[191] = 73;
            class28.KeyHandler_keyCodes[192] = 58;
            class28.KeyHandler_keyCodes[219] = 42;
            class28.KeyHandler_keyCodes[220] = 74;
            class28.KeyHandler_keyCodes[221] = 43;
            class28.KeyHandler_keyCodes[222] = 59;
            class28.KeyHandler_keyCodes[223] = 28;
        } else {
            class28.KeyHandler_keyCodes[44] = 71;
            class28.KeyHandler_keyCodes[45] = 26;
            class28.KeyHandler_keyCodes[46] = 72;
            class28.KeyHandler_keyCodes[47] = 73;
            class28.KeyHandler_keyCodes[59] = 57;
            class28.KeyHandler_keyCodes[61] = 27;
            class28.KeyHandler_keyCodes[91] = 42;
            class28.KeyHandler_keyCodes[92] = 74;
            class28.KeyHandler_keyCodes[93] = 43;
            class28.KeyHandler_keyCodes[192] = 28;
            class28.KeyHandler_keyCodes[222] = 58;
            class28.KeyHandler_keyCodes[520] = 59;
        }

    }

    public static VarbitComposition method894(int var0) {
        VarbitComposition var1 = (VarbitComposition) VarbitComposition.VarbitDefinition_cached.get((long) var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = VarbitComposition.VarbitDefinition_archive.takeFile(14, var0);
            var1 = new VarbitComposition();
            if (var2 != null) {
                var1.decode(new Buffer(var2));
            }

            VarbitComposition.VarbitDefinition_cached.put(var1, (long) var0);
            return var1;
        }
    }

    static void alignWidgetSize(Widget var0, int var1, int var2, boolean var3) {
        int var4 = var0.width;
        int var5 = var0.height;
        if (var0.widthAlignment == 0) {
            var0.width = var0.rawWidth;
        } else if (var0.widthAlignment == 1) {
            var0.width = var1 - var0.rawWidth;
        } else if (var0.widthAlignment == 2) {
            var0.width = var0.rawWidth * var1 >> 14;
        }

        if (var0.heightAlignment == 0) {
            var0.height = var0.rawHeight;
        } else if (var0.heightAlignment == 1) {
            var0.height = var2 - var0.rawHeight;
        } else if (var0.heightAlignment == 2) {
            var0.height = var2 * var0.rawHeight >> 14;
        }

        if (var0.widthAlignment == 4) {
            var0.width = var0.field2896 * var0.height / var0.field2897;
        }

        if (var0.heightAlignment == 4) {
            var0.height = var0.field2897 * var0.width / var0.field2896;
        }

        if (var0.contentType == 1337) {
            Client.viewportWidget = var0;
        }

        if (var0.type == 12) {
            var0.method1815().method1710(var0.width, var0.height);
        }

        if (var3 && var0.onResize != null && (var4 != var0.width || var5 != var0.height)) {
            ScriptEvent var6 = new ScriptEvent();
            var6.widget = var0;
            var6.args = var0.onResize;
            Client.scriptEvents.addFirst(var6);
        }

    }
}
