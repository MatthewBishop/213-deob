import java.util.Date;

public class class136 extends class139 {

    static int[] ByteArrayPool_altSizeArrayCounts;

    int field1310;

    int field1308;

    int field1306;

    int field1309;
    // $FF: synthetic field

    final class142 this$0;

    class136(class142 var1) {
        this.this$0 = var1;
        this.field1310 = -1;
    }

    void vmethod3254(Buffer var1) {
        this.field1310 = var1.readUnsignedShort();
        this.field1308 = var1.readInt();
        this.field1306 = var1.readUnsignedByte();
        this.field1309 = var1.readUnsignedByte();
    }

    void vmethod3248(ClanSettings var1) {
        var1.method865(this.field1310, this.field1308, this.field1306, this.field1309);
    }

    public static String method789(long var0) {
        Calendar.Calendar_calendar.setTime(new Date(var0));
        int var2 = Calendar.Calendar_calendar.get(7);
        int var3 = Calendar.Calendar_calendar.get(5);
        int var4 = Calendar.Calendar_calendar.get(2);
        int var5 = Calendar.Calendar_calendar.get(1);
        int var6 = Calendar.Calendar_calendar.get(11);
        int var7 = Calendar.Calendar_calendar.get(12);
        int var8 = Calendar.Calendar_calendar.get(13);
        return Calendar.DAYS_OF_THE_WEEK[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-"
                + Calendar.MONTH_NAMES_ENGLISH_GERMAN[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":"
                + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
    }

    static void addChatMessage(int var0, String var1, String var2, String var3) {
        ChatChannel var4 = (ChatChannel) Messages.Messages_channels.get(var0);
        if (var4 == null) {
            var4 = new ChatChannel();
            Messages.Messages_channels.put(var0, var4);
        }

        Message var5 = var4.addMessage(var0, var1, var2, var3);
        Messages.Messages_hashTable.put(var5, (long) var5.count);
        Messages.Messages_queue.add(var5);
        Client.chatCycle = Client.cycleCntr;
    }
}
