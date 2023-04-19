import java.io.File;

public class JagexCache {

    static File JagexCache_locationFile;

    public static int idxCount;

    public static BufferedFile JagexCache_randomDat = null;

    public static BufferedFile JagexCache_dat2File = null;

    public static BufferedFile JagexCache_idx255File = null;

    public static int cacheGamebuild;

    static final int method952(int var0, int var1, int var2, int var3) {
        int var4 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var2 * 1024 / var3] >> 1;
        return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
    }
}
