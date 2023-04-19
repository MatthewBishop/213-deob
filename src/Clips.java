public class Clips {

    static int selectedSpellWidget;

    boolean field2234 = false;

    public boolean field2226 = true;

    int field2225 = 0;

    public int field2227 = 512;

    public TextureLoader Rasterizer3D_textureLoader;

    int field2231;

    int field2229;

    int field2233;

    int field2232;

    int clipNegativeMidX;

    int field2236;

    int clipNegativeMidY;

    int field2238;

    int[] Rasterizer3D_rowOffsets = new int[1024];

    void method1358() {
        this.field2231 = this.field2233 / 2;
        this.field2229 = this.field2232 / 2;
        this.clipNegativeMidX = -(this.field2231 * 1684654809) * -1346890391;
        this.field2236 = this.field2233 - this.field2231;
        this.clipNegativeMidY = -(this.field2229 * -2109856295) * 1380452969;
        this.field2238 = this.field2232 - this.field2229;
    }

    void method1359(int var1, int var2, int var3, int var4) {
        this.field2231 = var1 - var2;
        this.field2229 = var3 - var4;
        this.clipNegativeMidX = -(this.field2231 * 1684654809) * -1346890391;
        this.field2236 = this.field2233 - this.field2231;
        this.clipNegativeMidY = -(this.field2229 * -2109856295) * 1380452969;
        this.field2238 = this.field2232 - this.field2229;
    }

    void method1360(int var1, int var2, int var3) {
        this.field2234 = var1 < 0 || var1 > this.field2233 || var2 < 0 || var2 > this.field2233 || var3 < 0
                || var3 > this.field2233;
    }

    static void method1361(int var0, ArchiveDisk var1, Archive var2) {
        ArchiveDiskAction var3 = new ArchiveDiskAction();
        var3.type = 1;
        var3.key = (long) var0;
        var3.archiveDisk = var1;
        var3.archive = var2;
        NodeDeque var4 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
        synchronized (ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
            ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var3);
        }

        class124.method741();
    }
}
