import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Strings {

    public static String field3226 = "Please visit the support page for assistance.";

    public static String field3267 = "";

    public static String field3291 = "Page has opened in the browser.";

    public static String field3376 = "";

    public static final SpritePixels method1853(byte[] var0) {
        BufferedImage var1 = null;

        try {
            Class var2 = ImageIO.class;
            synchronized (ImageIO.class) {
                var1 = ImageIO.read(new ByteArrayInputStream(var0));
            }

            int var6 = var1.getWidth();
            int var7 = var1.getHeight();
            int[] var4 = new int[var6 * var7];
            PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var6, var7, var4, 0, var6);
            var5.grabPixels();
            return new SpritePixels(var4, var6, var7);
        } catch (IOException var9) {
            ;
        } catch (InterruptedException var10) {
            ;
        }

        return new SpritePixels(0, 0);
    }

    static IndexedSprite method1852() {
        IndexedSprite var0 = new IndexedSprite();
        var0.width = class503.SpriteBuffer_spriteWidth;
        var0.height = class503.SpriteBuffer_spriteHeight;
        var0.xOffset = class503.SpriteBuffer_xOffsets[0];
        var0.yOffset = class17.SpriteBuffer_yOffsets[0];
        var0.subWidth = class97.SpriteBuffer_spriteWidths[0];
        var0.subHeight = class138.SpriteBuffer_spriteHeights[0];
        var0.palette = class394.SpriteBuffer_spritePalette;
        var0.pixels = VarbitComposition.SpriteBuffer_pixels[0];
        class398.method2125();
        return var0;
    }

    public static void method1854() {
        WorldMapElement.WorldMapElement_cachedSprites.clear();
    }
}
