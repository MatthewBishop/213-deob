public class MilliClock extends Clock {

    static int field1455;

    long[] field1461 = new long[10];

    int field1456 = 256;

    int field1457 = 1;

    long field1458 = class96.clockNow();

    int field1460 = 0;

    int field1459;

    MilliClock() {
        for (int var1 = 0; var1 < 10; ++var1) {
            this.field1461[var1] = this.field1458;
        }

    }

    public void mark() {
        for (int var1 = 0; var1 < 10; ++var1) {
            this.field1461[var1] = 0L;
        }

    }

    public int wait(int var1, int var2) {
        int var3 = this.field1456;
        int var4 = this.field1457;
        this.field1456 = 300;
        this.field1457 = 1;
        this.field1458 = class96.clockNow();
        if (0L == this.field1461[this.field1459]) {
            this.field1456 = var3;
            this.field1457 = var4;
        } else if (this.field1458 > this.field1461[this.field1459]) {
            this.field1456 = (int) ((long) (var1 * 2560) / (this.field1458 - this.field1461[this.field1459]));
        }

        if (this.field1456 < 25) {
            this.field1456 = 25;
        }

        if (this.field1456 > 256) {
            this.field1456 = 256;
            this.field1457 = (int) ((long) var1 - (this.field1458 - this.field1461[this.field1459]) / 10L);
        }

        if (this.field1457 > var1) {
            this.field1457 = var1;
        }

        this.field1461[this.field1459] = this.field1458;
        this.field1459 = (this.field1459 + 1) % 10;
        int var5;
        if (this.field1457 > 1) {
            for (var5 = 0; var5 < 10; ++var5) {
                if (0L != this.field1461[var5]) {
                    this.field1461[var5] += (long) this.field1457;
                }
            }
        }

        if (this.field1457 < var2) {
            this.field1457 = var2;
        }

        PlayerComposition.method1704((long) this.field1457);

        for (var5 = 0; this.field1460 < 256; this.field1460 += this.field1456) {
            ++var5;
        }

        this.field1460 &= 255;
        return var5;
    }
}
