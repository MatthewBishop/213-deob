import java.awt.Image;
import java.io.IOException;

public class PacketWriter {

    static Image field1141;

    AbstractSocket socket;

    IterableNodeDeque packetBufferNodes = new IterableNodeDeque();

    int bufferSize = 0;

    Buffer buffer = new Buffer(5000);

    public IsaacCipher isaacCipher;

    PacketBuffer packetBuffer = new PacketBuffer(40000);

    ServerPacket serverPacket = null;

    int serverPacketLength = 0;

    boolean field1135 = true;

    int field1136 = 0;

    int pendingWrites = 0;

    ServerPacket field1138;

    ServerPacket field1139;

    ServerPacket field1133;

    final void clearBuffer() {
        this.packetBufferNodes.rsClear();
        this.bufferSize = 0;
    }

    final void flush() throws IOException {
        if (this.socket != null && this.bufferSize > 0) {
            this.buffer.offset = 0;

            while (true) {
                PacketBufferNode var1 = (PacketBufferNode) this.packetBufferNodes.last();
                if (var1 == null || var1.index > this.buffer.array.length - this.buffer.offset) {
                    this.socket.write(this.buffer.array, 0, this.buffer.offset);
                    this.pendingWrites = 0;
                    break;
                }

                this.buffer.writeBytes(var1.packetBuffer.array, 0, var1.index);
                this.bufferSize -= var1.index;
                var1.remove();
                var1.packetBuffer.releaseArray();
                var1.release();
            }
        }

    }

    public final void addNode(PacketBufferNode var1) {
        this.packetBufferNodes.addFirst(var1);
        var1.index = var1.packetBuffer.offset;
        var1.packetBuffer.offset = 0;
        this.bufferSize += var1.index;
    }

    void setSocket(AbstractSocket var1) {
        this.socket = var1;
    }

    void close() {
        if (this.socket != null) {
            this.socket.close();
            this.socket = null;
        }

    }

    void removeSocket() {
        this.socket = null;
    }

    AbstractSocket getSocket() {
        return this.socket;
    }
}
