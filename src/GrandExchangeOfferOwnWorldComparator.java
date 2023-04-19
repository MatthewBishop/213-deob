import java.util.Comparator;

public class GrandExchangeOfferOwnWorldComparator implements Comparator {

    boolean filterWorlds;

    int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
        if (var2.world == var1.world) {
            return 0;
        } else {
            if (this.filterWorlds) {
                if (Client.worldId == var1.world) {
                    return -1;
                }

                if (var2.world == Client.worldId) {
                    return 1;
                }
            }

            return var1.world < var2.world ? -1 : 1;
        }
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }

    public int compare(Object var1, Object var2) {
        return this.compare_bridged((GrandExchangeEvent) var1, (GrandExchangeEvent) var2);
    }

    static int method367(AbstractArchive var0) {
        int var1 = Login.field761.length + Login.field760.length;
        String[] var2 = Login.field762;

        for (int var3 = 0; var3 < var2.length; ++var3) {
            String var4 = var2[var3];
            if (var0.getGroupId(var4) != -1) {
                ++var1;
            }
        }

        return var1;
    }

    static boolean method366(String var0, int var1) {
        return RouteStrategy.method1177(var0, var1, "openjs");
    }

    static final void method364() {
        VerticalAlignment.method1036("You can't add yourself to your own ignore list");
    }

    static void method365(boolean var0) {
        Client.leftClickOpensMenu = var0;
    }
}
