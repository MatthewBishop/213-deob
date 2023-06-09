import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import java.util.zip.CRC32;

public class NetCache {

    public static AbstractSocket NetCache_socket;

    public static int NetCache_loadTime = 0;

    public static long field3509;

    public static NodeHashTable NetCache_pendingPriorityWrites = new NodeHashTable(4096);

    public static int NetCache_pendingPriorityWritesCount = 0;

    public static NodeHashTable NetCache_pendingPriorityResponses = new NodeHashTable(32);

    public static int NetCache_pendingPriorityResponsesCount = 0;

    public static DualNodeDeque NetCache_pendingWritesQueue = new DualNodeDeque();

    public static NodeHashTable NetCache_pendingWrites = new NodeHashTable(4096);

    public static int NetCache_pendingWritesCount = 0;

    public static NodeHashTable NetCache_pendingResponses = new NodeHashTable(4096);

    public static int NetCache_pendingResponsesCount = 0;

    static boolean field3498;

    public static Buffer NetCache_responseHeaderBuffer = new Buffer(8);

    public static Buffer NetCache_responseArchiveBuffer;

    public static int field3504 = 0;

    static CRC32 NetCache_crc = new CRC32();

    static Archive[] NetCache_archives = new Archive[256];

    static int field3489 = -1;

    static int field3508 = 255;

    public static byte field3506 = 0;

    public static int NetCache_crcMismatches = 0;

    public static int NetCache_ioExceptions = 0;

    protected static int getGcDuration() {
        int var0 = 0;
        if (class291.garbageCollector == null || !class291.garbageCollector.isValid()) {
            try {
                Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                while (var1.hasNext()) {
                    GarbageCollectorMXBean var2 = (GarbageCollectorMXBean) var1.next();
                    if (var2.isValid()) {
                        class291.garbageCollector = var2;
                        GameEngine.garbageCollectorLastCheckTimeMs = -1L;
                        GameEngine.garbageCollectorLastCollectionTime = -1L;
                    }
                }
            } catch (Throwable var11) {
                ;
            }
        }

        if (class291.garbageCollector != null) {
            long var9 = class96.clockNow();
            long var3 = class291.garbageCollector.getCollectionTime();
            if (GameEngine.garbageCollectorLastCollectionTime != -1L) {
                long var5 = var3 - GameEngine.garbageCollectorLastCollectionTime;
                long var7 = var9 - GameEngine.garbageCollectorLastCheckTimeMs;
                if (var7 != 0L) {
                    var0 = (int) (var5 * 100L / var7);
                }
            }

            GameEngine.garbageCollectorLastCollectionTime = var3;
            GameEngine.garbageCollectorLastCheckTimeMs = var9;
        }

        return var0;
    }
}
