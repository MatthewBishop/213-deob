import java.util.Comparator;

final class GrandExchangeOfferUnitPriceComparator implements Comparator {

    static Archive archive18;

    int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
        return var1.grandExchangeOffer.unitPrice < var2.grandExchangeOffer.unitPrice ? -1
                : (var2.grandExchangeOffer.unitPrice == var1.grandExchangeOffer.unitPrice ? 0 : 1);
    }

    public int compare(Object var1, Object var2) {
        return this.compare_bridged((GrandExchangeEvent) var1, (GrandExchangeEvent) var2);
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }

    public static int method1933(int var0) {
        return var0 != 0 && var0 != 1 ? -1 : 0;
    }
}
