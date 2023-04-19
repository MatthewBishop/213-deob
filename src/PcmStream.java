public abstract class PcmStream extends Node {

    PcmStream after;

    int field255;

    AbstractSound sound;

    volatile boolean active = true;

    protected abstract PcmStream firstSubStream();

    protected abstract PcmStream nextSubStream();

    protected abstract int vmethod5648();

    protected abstract void fill(int[] var1, int var2, int var3);

    protected abstract void skip(int var1);

    int vmethod1019() {
        return 255;
    }

    final void update(int[] var1, int var2, int var3) {
        if (this.active) {
            this.fill(var1, var2, var3);
        } else {
            this.skip(var3);
        }

    }
}
