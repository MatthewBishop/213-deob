import java.util.Iterator;

public class class473 extends class430 implements class275 {

    static boolean mouseCam;

    final AbstractArchive field4019;

    final DemotingHashTable field4018 = new DemotingHashTable(64);

    final int field4020;

    public class473(StudioGame var1, int var2, Language var3, AbstractArchive var4) {
        super(var1, var3, var4 != null ? var4.getGroupFileCount(var2) : 0);
        this.field4019 = var4;
        this.field4020 = var2;
    }

    protected class432 vmethod8207(int var1) {
        DemotingHashTable var3 = this.field4018;
        synchronized (this.field4018) {
            class431 var2 = (class431) this.field4018.get((long) var1);
            if (var2 == null) {
                var2 = this.method2420(var1);
                this.field4018.method1577(var2, (long) var1);
            }

            return var2;
        }
    }

    class431 method2420(int var1) {
        byte[] var2 = this.field4019.takeFile(this.field4020, var1);
        class431 var3 = new class431(var1);
        if (var2 != null) {
            var3.method2281(new Buffer(var2));
        }

        return var3;
    }

    public void method2418() {
        DemotingHashTable var1 = this.field4018;
        synchronized (this.field4018) {
            this.field4018.clear();
        }
    }

    public Iterator iterator() {
        return new class472(this);
    }

    static HorizontalAlignment[] method2421() {
        return new HorizontalAlignment[] { HorizontalAlignment.field1547, HorizontalAlignment.field1549,
                HorizontalAlignment.HorizontalAlignment_centered };
    }
}
