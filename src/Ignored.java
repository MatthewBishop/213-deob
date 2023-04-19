import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;

public class Ignored extends User {

    int id;

    int compareTo_ignored(Ignored var1) {
        return this.id - var1.id;
    }

    public int compareTo_user(User var1) {
        return this.compareTo_ignored((Ignored) var1);
    }

    public int compareTo(Object var1) {
        return this.compareTo_ignored((Ignored) var1);
    }

    public static void openURL(String var0, boolean var1, boolean var2) {
        if (var1) {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                try {
                    Desktop.getDesktop().browse(new URI(var0));
                    return;
                } catch (Exception var4) {
                    ;
                }
            }

            if (class31.field91.startsWith("win")) {
                GrandExchangeOfferOwnWorldComparator.method366(var0, 0);
            } else if (class31.field91.startsWith("mac")) {
                RouteStrategy.method1177(var0, 1, "openjs");
            } else {
                RouteStrategy.method1177(var0, 2, "openjs");
            }
        } else {
            RouteStrategy.method1177(var0, 3, "openjs");
        }

    }
}
