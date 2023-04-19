import java.util.Iterator;
import java.util.concurrent.Callable;

public class class124 implements Callable {

    public static Font ItemDefinition_fontPlain11;

    final class125 field1212;

    final class126 field1210;

    final class127 field1214;

    final int field1211;
    // $FF: synthetic field

    final class133 this$0;

    class124(class133 var1, class125 var2, class126 var3, class127 var4, int var5) {
        this.this$0 = var1;
        this.field1212 = var2;
        this.field1210 = var3;
        this.field1214 = var4;
        this.field1211 = var5;
    }

    public Object call() {
        this.field1212.method750();
        class125[][] var1;
        if (this.field1210 == class126.field1240) {
            var1 = this.this$0.field1279;
        } else {
            var1 = this.this$0.field1282;
        }

        var1[this.field1211][this.field1214.method756()] = this.field1212;
        return null;
    }

    static void method741() {
        Object var0 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock;
        synchronized (ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
            if (ArchiveDiskActionHandler.field3453 == 0) {
                GrandExchangeOfferNameComparator.ArchiveDiskActionHandler_thread = new Thread(
                        new ArchiveDiskActionHandler());
                GrandExchangeOfferNameComparator.ArchiveDiskActionHandler_thread.setDaemon(true);
                GrandExchangeOfferNameComparator.ArchiveDiskActionHandler_thread.start();
                GrandExchangeOfferNameComparator.ArchiveDiskActionHandler_thread.setPriority(5);
            }

            ArchiveDiskActionHandler.field3453 = 600;
        }
    }

    static void method742() {
        Iterator var0 = Messages.Messages_hashTable.iterator();

        while (var0.hasNext()) {
            Message var1 = (Message) var0.next();
            var1.clearIsFromIgnored();
        }

    }
}
