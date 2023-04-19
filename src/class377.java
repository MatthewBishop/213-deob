import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class class377 extends AbstractQueue {

    class375[] field3608;

    Map field3606;

    int field3610;

    final Comparator field3609;

    int field3607;

    public class377(int var1, Comparator var2) {
        this.field3607 = 0;
        this.field3608 = new class375[var1];
        this.field3606 = new HashMap();
        this.field3609 = var2;
    }

    public class377(int var1) {
        this(var1, (Comparator) null);
    }

    void method1997() {
        int var1 = (this.field3608.length << 1) + 1;
        this.field3608 = (class375[]) ((class375[]) Arrays.copyOf(this.field3608, var1));
    }

    void method1995(int var1) {
        class375 var2;
        int var3;
        for (var2 = this.field3608[var1]; var1 > 0; var1 = var3) {
            var3 = var1 - 1 >>> 1;
            class375 var4 = this.field3608[var3];
            if (this.field3609 != null) {
                if (this.field3609.compare(var2.field3600, var4.field3600) >= 0) {
                    break;
                }
            } else if (((Comparable) var2.field3600).compareTo(var4.field3600) >= 0) {
                break;
            }

            this.field3608[var1] = var4;
            this.field3608[var1].field3601 = var1;
        }

        this.field3608[var1] = var2;
        this.field3608[var1].field3601 = var1;
    }

    void method1996(int var1) {
        class375 var2 = this.field3608[var1];

        int var8;
        for (int var3 = this.field3610 >>> 1; var1 < var3; var1 = var8) {
            int var4 = (var1 << 1) + 1;
            class375 var5 = this.field3608[var4];
            int var6 = (var1 << 1) + 2;
            class375 var7 = this.field3608[var6];
            if (this.field3609 != null) {
                if (var6 < this.field3610 && this.field3609.compare(var5.field3600, var7.field3600) > 0) {
                    var8 = var6;
                } else {
                    var8 = var4;
                }
            } else if (var6 < this.field3610 && ((Comparable) var5.field3600).compareTo(var7.field3600) > 0) {
                var8 = var6;
            } else {
                var8 = var4;
            }

            if (this.field3609 != null) {
                if (this.field3609.compare(var2.field3600, this.field3608[var8].field3600) <= 0) {
                    break;
                }
            } else if (((Comparable) var2.field3600).compareTo(this.field3608[var8].field3600) <= 0) {
                break;
            }

            this.field3608[var1] = this.field3608[var8];
            this.field3608[var1].field3601 = var1;
        }

        this.field3608[var1] = var2;
        this.field3608[var1].field3601 = var1;
    }

    public boolean remove(Object var1) {
        class375 var2 = (class375) this.field3606.remove(var1);
        if (var2 == null) {
            return false;
        } else {
            ++this.field3607;
            --this.field3610;
            if (var2.field3601 == this.field3610) {
                this.field3608[this.field3610] = null;
                return true;
            } else {
                class375 var3 = this.field3608[this.field3610];
                this.field3608[this.field3610] = null;
                this.field3608[var2.field3601] = var3;
                this.field3608[var2.field3601].field3601 = var2.field3601;
                this.method1996(var2.field3601);
                if (var3 == this.field3608[var2.field3601]) {
                    this.method1995(var2.field3601);
                }

                return true;
            }
        }
    }

    public Object peek() {
        return this.field3610 == 0 ? null : this.field3608[0].field3600;
    }

    public int size() {
        return this.field3610;
    }

    public boolean offer(Object var1) {
        if (this.field3606.containsKey(var1)) {
            throw new IllegalArgumentException("");
        } else {
            ++this.field3607;
            int var2 = this.field3610;
            if (var2 >= this.field3608.length) {
                this.method1997();
            }

            ++this.field3610;
            if (var2 == 0) {
                this.field3608[0] = new class375(var1, 0);
                this.field3606.put(var1, this.field3608[0]);
            } else {
                this.field3608[var2] = new class375(var1, var2);
                this.field3606.put(var1, this.field3608[var2]);
                this.method1995(var2);
            }

            return true;
        }
    }

    public Object poll() {
        if (this.field3610 == 0) {
            return null;
        } else {
            ++this.field3607;
            Object var1 = this.field3608[0].field3600;
            this.field3606.remove(var1);
            --this.field3610;
            if (this.field3610 == 0) {
                this.field3608[this.field3610] = null;
            } else {
                this.field3608[0] = this.field3608[this.field3610];
                this.field3608[0].field3601 = 0;
                this.field3608[this.field3610] = null;
                this.method1996(0);
            }

            return var1;
        }
    }

    public boolean contains(Object var1) {
        return this.field3606.containsKey(var1);
    }

    public Iterator iterator() {
        return new class376(this);
    }

    public Object[] toArray() {
        Object[] var1 = super.toArray();
        if (this.field3609 != null) {
            Arrays.sort(var1, this.field3609);
        } else {
            Arrays.sort(var1);
        }

        return var1;
    }

    static Object[] method1998(Buffer var0, int[] var1) {
        int var2 = var0.readUShortSmart();
        Object[] var3 = new Object[var1.length * var2];

        for (int var4 = 0; var4 < var2; ++var4) {
            for (int var5 = 0; var5 < var1.length; ++var5) {
                int var6 = var1.length * var4 + var5;
                class478 var7 = class103.method639(var1[var5]);
                var3[var6] = var7.method2435(var0);
            }
        }

        return var3;
    }
}
