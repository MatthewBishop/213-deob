import java.io.IOException;
import java.net.Socket;

public class BufferedNetSocket extends AbstractSocket {

    Socket socket;

    BufferedSource source;

    BufferedSink sink;

    BufferedNetSocket(Socket var1, int var2, int var3) throws IOException {
        this.socket = var1;
        this.socket.setSoTimeout(30000);
        this.socket.setTcpNoDelay(true);
        this.socket.setReceiveBufferSize(65536);
        this.socket.setSendBufferSize(65536);
        this.source = new BufferedSource(this.socket.getInputStream(), var2);
        this.sink = new BufferedSink(this.socket.getOutputStream(), var3);
    }

    public boolean isAvailable(int var1) throws IOException {
        return this.source.isAvailable(var1);
    }

    public int available() throws IOException {
        return this.source.available();
    }

    public int readUnsignedByte() throws IOException {
        return this.source.readUnsignedByte();
    }

    public int read(byte[] var1, int var2, int var3) throws IOException {
        return this.source.read(var1, var2, var3);
    }

    public void write(byte[] var1, int var2, int var3) throws IOException {
        this.sink.write(var1, var2, var3);
    }

    public void close() {
        this.sink.close();

        try {
            this.socket.close();
        } catch (IOException var2) {
            ;
        }

        this.source.close();
    }

    protected void finalize() {
        this.close();
    }

    static int method2210(int var0, int var1) {
        ItemContainer var2 = (ItemContainer) ItemContainer.itemContainers.get((long) var0);
        if (var2 == null) {
            return 0;
        } else if (var1 == -1) {
            return 0;
        } else {
            int var3 = 0;

            for (int var4 = 0; var4 < var2.quantities.length; ++var4) {
                if (var2.ids[var4] == var1) {
                    var3 += var2.quantities[var4];
                }
            }

            return var3;
        }
    }

    public static Font method2212(AbstractArchive var0, AbstractArchive var1, String var2, String var3) {
        if (!var0.isValidFileName(var2, var3)) {
            return null;
        } else {
            int var4 = var0.getGroupId(var2);
            int var5 = var0.getFileId(var4, var3);
            byte[] var8 = var0.takeFile(var4, var5);
            boolean var7;
            if (var8 == null) {
                var7 = false;
            } else {
                class485.SpriteBuffer_decode(var8);
                var7 = true;
            }

            Font var6;
            if (!var7) {
                var6 = null;
            } else {
                byte[] var9 = var1.takeFile(var4, var5);
                Font var11;
                if (var9 == null) {
                    var11 = null;
                } else {
                    Font var10 = new Font(var9, class503.SpriteBuffer_xOffsets, class17.SpriteBuffer_yOffsets,
                            class97.SpriteBuffer_spriteWidths, class138.SpriteBuffer_spriteHeights,
                            class394.SpriteBuffer_spritePalette, VarbitComposition.SpriteBuffer_pixels);
                    class398.method2125();
                    var11 = var10;
                }

                var6 = var11;
            }

            return var6;
        }
    }
}
