import java.util.Iterator;

class class472 implements Iterator {

    int field4017;
    // $FF: synthetic field

    final class473 this$0;

    class472(class473 var1) {
        this.this$0 = var1;
    }

    public boolean hasNext() {
        return this.field4017 < this.this$0.method2274();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public Object next() {
        int var1 = ++this.field4017 - 1;
        class431 var2 = (class431) this.this$0.field4018.get((long) var1);
        return var2 != null ? var2 : this.this$0.method2420(var1);
    }
}
