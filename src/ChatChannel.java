public class ChatChannel {

    static int field817;

    static SpritePixels compass;

    Message[] messages = new Message[100];

    int count;

    Message addMessage(int var1, String var2, String var3, String var4) {
        Message var5 = this.messages[99];

        for (int var6 = this.count; var6 > 0; --var6) {
            if (var6 != 100) {
                this.messages[var6] = this.messages[var6 - 1];
            }
        }

        if (var5 == null) {
            var5 = new Message(var1, var2, var4, var3);
        } else {
            var5.remove();
            var5.removeDual();
            var5.set(var1, var2, var4, var3);
        }

        this.messages[0] = var5;
        if (this.count < 100) {
            ++this.count;
        }

        return var5;
    }

    Message getMessage(int var1) {
        return var1 >= 0 && var1 < this.count ? this.messages[var1] : null;
    }

    int size() {
        return this.count;
    }

    static final IterableNodeHashTable readStringIntParameters(Buffer var0, IterableNodeHashTable var1) {
        int var2 = var0.readUnsignedByte();
        int var3;
        if (var1 == null) {
            var3 = class70.method442(var2);
            var1 = new IterableNodeHashTable(var3);
        }

        for (var3 = 0; var3 < var2; ++var3) {
            boolean var4 = var0.readUnsignedByte() == 1;
            int var5 = var0.readMedium();
            Object var6;
            if (var4) {
                var6 = new ObjectNode(var0.readStringCp1252NullTerminated());
            } else {
                var6 = new IntegerNode(var0.readInt());
            }

            var1.put((Node) var6, (long) var5);
        }

        return var1;
    }

    public static void method470(Widget var0, int var1, int var2) {
        var0.field2894.bodyColors[var1] = var2;
        var0.field2894.method1702();
    }
}
