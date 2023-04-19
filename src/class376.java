import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class class376 implements Iterator {

    static IndexedSprite field3605;

    class377 field3602;

    int field3604 = 0;

    int field3603;

    class376(class377 var1) {
        this.field3603 = this.field3602.field3607;
        this.field3602 = var1;
    }

    public boolean hasNext() {
        return this.field3604 < this.field3602.field3610;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public Object next() {
        if (this.field3602.field3607 != this.field3603) {
            throw new ConcurrentModificationException();
        } else if (this.field3604 < this.field3602.field3610) {
            Object var1 = this.field3602.field3608[this.field3604].field3600;
            ++this.field3604;
            return var1;
        } else {
            throw new NoSuchElementException();
        }
    }
}
