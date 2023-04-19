import java.awt.datatransfer.Clipboard;

public class class143 extends class139 {

    static int loginBoxCenter;

    int field1325;

    byte field1326;
    // $FF: synthetic field

    final class142 this$0;

    class143(class142 var1) {
        this.this$0 = var1;
        this.field1325 = -1;
    }

    void vmethod3254(Buffer var1) {
        this.field1325 = var1.readUnsignedShort();
        this.field1326 = var1.readByte();
    }

    void vmethod3248(ClanSettings var1) {
        var1.method866(this.field1325, this.field1326);
    }

    static final int method812(int var0, int var1, int var2, int var3) {
        return var0 * var2 + var3 * var1 >> 16;
    }

    static final void runComponentCloseListeners(Widget[] var0, int var1) {
        for (int var2 = 0; var2 < var0.length; ++var2) {
            Widget var3 = var0[var2];
            if (var3 != null) {
                if (var3.type == 0) {
                    if (var3.children != null) {
                        runComponentCloseListeners(var3.children, var1);
                    }

                    InterfaceParent var4 = (InterfaceParent) Client.interfaceParents.get((long) var3.id);
                    if (var4 != null) {
                        class127.runIntfCloseListeners(var4.group, var1);
                    }
                }

                ScriptEvent var5;
                if (var1 == 0 && var3.onDialogAbort != null) {
                    var5 = new ScriptEvent();
                    var5.widget = var3;
                    var5.args = var3.onDialogAbort;
                    HealthBarUpdate.runScriptEvent(var5);
                }

                if (var1 == 1 && var3.onSubChange != null) {
                    if (var3.childIndex >= 0) {
                        Widget var6 = class165.getWidget(var3.id);
                        if (var6 == null || var6.children == null || var3.childIndex >= var6.children.length
                                || var3 != var6.children[var3.childIndex]) {
                            continue;
                        }
                    }

                    var5 = new ScriptEvent();
                    var5.widget = var3;
                    var5.args = var3.onSubChange;
                    HealthBarUpdate.runScriptEvent(var5);
                }
            }
        }

    }

    public static Clipboard method815() {
        return ScriptFrame.client.getClipboard();
    }
}
