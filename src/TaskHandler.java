import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class TaskHandler implements Runnable {

    public static String javaVendor;

    public static String javaVersion;

    Task current = null;

    Task task = null;

    Thread thread;

    boolean isClosed = false;

    public TaskHandler() {
        javaVendor = "Unknown";
        javaVersion = "1.6";

        try {
            javaVendor = System.getProperty("java.vendor");
            javaVersion = System.getProperty("java.version");
        } catch (Exception var2) {
            ;
        }

        this.isClosed = false;
        this.thread = new Thread(this);
        this.thread.setPriority(10);
        this.thread.setDaemon(true);
        this.thread.start();
    }

    public final void close() {
        synchronized (this) {
            this.isClosed = true;
            this.notifyAll();
        }

        try {
            this.thread.join();
        } catch (InterruptedException var3) {
            ;
        }

    }

    final Task newTask(int var1, int var2, int var3, Object var4) {
        Task var5 = new Task();
        var5.type = var1;
        var5.intArgument = var2;
        var5.objectArgument = var4;
        synchronized (this) {
            if (this.task != null) {
                this.task.next = var5;
                this.task = var5;
            } else {
                this.task = this.current = var5;
            }

            this.notify();
            return var5;
        }
    }

    public final Task newSocketTask(String var1, int var2) {
        return this.newTask(1, var2, 0, var1);
    }

    public final Task newThreadTask(Runnable var1, int var2) {
        return this.newTask(2, var2, 0, var1);
    }

    public final void run() {
        while (true) {
            Task var1;
            synchronized (this) {
                while (true) {
                    if (this.isClosed) {
                        return;
                    }

                    if (this.current != null) {
                        var1 = this.current;
                        this.current = this.current.next;
                        if (this.current == null) {
                            this.task = null;
                        }
                        break;
                    }

                    try {
                        this.wait();
                    } catch (InterruptedException var8) {
                        ;
                    }
                }
            }

            try {
                int var5 = var1.type;
                if (var5 == 1) {
                    var1.result = new Socket(InetAddress.getByName((String) var1.objectArgument), var1.intArgument);
                } else if (var5 == 2) {
                    Thread var3 = new Thread((Runnable) var1.objectArgument);
                    var3.setDaemon(true);
                    var3.start();
                    var3.setPriority(var1.intArgument);
                    var1.result = var3;
                } else if (var5 == 4) {
                    var1.result = new DataInputStream(((URL) var1.objectArgument).openStream());
                }

                var1.status = 1;
            } catch (ThreadDeath var6) {
                throw var6;
            } catch (Throwable var7) {
                var1.status = 2;
            }
        }
    }

    static int getClipMidX() {
        return Rasterizer3D.clips.field2231;
    }

    public static StudioGame[] method951() {
        return new StudioGame[] { StudioGame.game3, StudioGame.game4, StudioGame.runescape, StudioGame.stellardawn,
                StudioGame.game5, StudioGame.oldscape };
    }

    static int method949(int var0, Script var1, boolean var2) {
        int var3;
        if (var0 == 5504) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            int var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            if (!Client.isCameraLocked) {
                Client.camAngleX = var3;
                Client.camAngleY = var4;
            }

            return 1;
        } else if (var0 == 5505) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.camAngleX;
            return 1;
        } else if (var0 == 5506) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.camAngleY;
            return 1;
        } else if (var0 == 5530) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            if (var3 < 0) {
                var3 = 0;
            }

            Client.camFollowHeight = var3;
            return 1;
        } else if (var0 == 5531) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.camFollowHeight;
            return 1;
        } else {
            return 2;
        }
    }
}
