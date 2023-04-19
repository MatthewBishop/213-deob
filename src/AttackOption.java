import java.net.MalformedURLException;
import java.net.URL;

public enum AttackOption implements class356 {

    AttackOption_dependsOnCombatLevels(0),

    AttackOption_alwaysRightClick(1),

    field1070(2),

    AttackOption_hidden(3),

    field1073(4);

    final int id;

    AttackOption(int var3) {
        this.id = var3;
    }

    public int rsOrdinal() {
        return this.id;
    }

    static boolean method619(String var0) {
        if (var0 == null) {
            return false;
        } else {
            try {
                new URL(var0);
                return true;
            } catch (MalformedURLException var2) {
                return false;
            }
        }
    }

    public static int method621(int var0) {
        return class439.field3829[var0 & 16383];
    }

    static final InterfaceParent ifOpenSub(int var0, int var1, int var2) {
        InterfaceParent var3 = new InterfaceParent();
        var3.group = var1;
        var3.type = var2;
        Client.interfaceParents.put(var3, (long) var0);
        ZoneOperation.Widget_resetModelFrames(var1);
        Widget var4 = class165.getWidget(var0);
        class144.invalidateWidget(var4);
        if (Client.meslayerContinueWidget != null) {
            class144.invalidateWidget(Client.meslayerContinueWidget);
            Client.meslayerContinueWidget = null;
        }

        WallDecoration.revalidateWidgetScroll(VerticalAlignment.Widget_interfaceComponents[var0 >> 16], var4, false);
        class12.runWidgetOnLoadListener(var1);
        if (Client.rootInterface != -1) {
            class127.runIntfCloseListeners(Client.rootInterface, 1);
        }

        return var3;
    }
}
