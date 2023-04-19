import java.util.Comparator;

final class GrandExchangeOfferNameComparator implements Comparator {

    static Thread ArchiveDiskActionHandler_thread;

    int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
        return var1.getOfferName().compareTo(var2.getOfferName());
    }

    public int compare(Object var1, Object var2) {
        return this.compare_bridged((GrandExchangeEvent) var1, (GrandExchangeEvent) var2);
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }

    static int getWindowedMode() {
        return Client.isResizable ? 2 : 1;
    }
}
