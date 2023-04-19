public class ArchiveDiskActionHandler implements Runnable {

    public static NodeDeque ArchiveDiskActionHandler_requestQueue = new NodeDeque();

    public static NodeDeque ArchiveDiskActionHandler_responseQueue = new NodeDeque();

    static int field3453 = 0;

    static Object ArchiveDiskActionHandler_lock = new Object();

    public void run() {
        try {
            while (true) {
                NodeDeque var2 = ArchiveDiskActionHandler_requestQueue;
                ArchiveDiskAction var1;
                synchronized (ArchiveDiskActionHandler_requestQueue) {
                    var1 = (ArchiveDiskAction) ArchiveDiskActionHandler_requestQueue.last();
                }

                Object var14;
                if (var1 != null) {
                    if (var1.type == 0) {
                        var1.archiveDisk.write((int) var1.key, var1.data, var1.data.length);
                        var2 = ArchiveDiskActionHandler_requestQueue;
                        synchronized (ArchiveDiskActionHandler_requestQueue) {
                            var1.remove();
                        }
                    } else if (var1.type == 1) {
                        var1.data = var1.archiveDisk.read((int) var1.key);
                        var2 = ArchiveDiskActionHandler_requestQueue;
                        synchronized (ArchiveDiskActionHandler_requestQueue) {
                            ArchiveDiskActionHandler_responseQueue.addFirst(var1);
                        }
                    }

                    var14 = ArchiveDiskActionHandler_lock;
                    synchronized (ArchiveDiskActionHandler_lock) {
                        if (field3453 <= 1) {
                            field3453 = 0;
                            ArchiveDiskActionHandler_lock.notifyAll();
                            return;
                        }

                        field3453 = 600;
                    }
                } else {
                    PlayerComposition.method1704(100L);
                    var14 = ArchiveDiskActionHandler_lock;
                    synchronized (ArchiveDiskActionHandler_lock) {
                        if (field3453 <= 1) {
                            field3453 = 0;
                            ArchiveDiskActionHandler_lock.notifyAll();
                            return;
                        }

                        --field3453;
                    }
                }
            }
        } catch (Exception var13) {
            class387.RunException_sendStackTrace((String) null, var13);
        }
    }

    static String addImageTag(int var0) {
        return "<img=" + var0 + ">";
    }
}
