import java.util.Comparator;

final class GrandExchangeOfferTotalQuantityComparator implements Comparator {

    static Archive archive9;

    int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
        return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity ? -1
                : (var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity ? 0 : 1);
    }

    public int compare(Object var1, Object var2) {
        return this.compare_bridged((GrandExchangeEvent) var1, (GrandExchangeEvent) var2);
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }

    public static void method1913() {
        PlayerComposition.PlayerAppearance_cachedModels.clear();
    }
}
