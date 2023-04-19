import java.util.concurrent.Callable;

class class128 implements Callable {

    static Archive archive13;
    // $FF: synthetic field

    final class133 this$0;
    // $FF: synthetic field

    final int val$workStart;
    // $FF: synthetic field

    final int val$workEnd;
    // $FF: synthetic field

    final class124[] val$curveLoadJobs;

    class128(class133 var1, int var2, int var3, class124[] var4) {
        this.this$0 = var1;
        this.val$workStart = var2;
        this.val$workEnd = var3;
        this.val$curveLoadJobs = var4;
    }

    public Object call() {
        for (int var1 = this.val$workStart; var1 < this.val$workEnd; ++var1) {
            this.val$curveLoadJobs[var1].call();
        }

        return null;
    }
}
