import java.util.Comparator;
import java.util.Map.Entry;

class class395 implements Comparator {
    // $FF: synthetic field

    final class394 this$0;

    class395(class394 var1) {
        this.this$0 = var1;
    }

    int method2118(Entry var1, Entry var2) {
        return ((Float) var2.getValue()).compareTo((Float) var1.getValue());
    }

    public int compare(Object var1, Object var2) {
        return this.method2118((Entry) var1, (Entry) var2);
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }
}
