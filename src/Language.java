import java.io.IOException;
import java.util.Locale;

public class Language implements class356 {

    public static final Language Language_EN;

    static final Language field3554;

    public static final Language Language_FR;

    static final Language field3547;

    static final Language field3548;

    public static final Language Language_ES;

    static final Language field3550;

    static final Language[] field3556;

    static Font fontPlain11;

    static MenuAction tempMenuAction;

    final String field3555;

    final String language;

    final int id;

    static {
        Language_EN = new Language("EN", "en", "English", ModeWhere.field3573, 0, "GB");
        field3554 = new Language("DE", "de", "German", ModeWhere.field3573, 1, "DE");
        Language_FR = new Language("FR", "fr", "French", ModeWhere.field3573, 2, "FR");
        field3547 = new Language("PT", "pt", "Portuguese", ModeWhere.field3573, 3, "BR");
        field3548 = new Language("NL", "nl", "Dutch", ModeWhere.field3568, 4, "NL");
        Language_ES = new Language("ES", "es", "Spanish", ModeWhere.field3568, 5, "ES");
        field3550 = new Language("ES_MX", "es-mx", "Spanish (Latin American)", ModeWhere.field3573, 6, "MX");
        Language[] var0 = method1947();
        field3556 = new Language[var0.length];
        Language[] var1 = var0;

        for (int var2 = 0; var2 < var1.length; ++var2) {
            Language var3 = var1[var2];
            if (field3556[var3.id] != null) {
                throw new IllegalStateException();
            }

            field3556[var3.id] = var3;
        }

    }

    Language(String var1, String var2, String var3, ModeWhere var4, int var5, String var6) {
        this.field3555 = var1;
        this.language = var2;
        this.id = var5;
        if (var6 != null) {
            new Locale(var2.substring(0, 2), var6);
        } else {
            new Locale(var2.substring(0, 2));
        }

    }

    public int rsOrdinal() {
        return this.id;
    }

    String getLanguage() {
        return this.language;
    }

    public String toString() {
        return this.getLanguage().toLowerCase(Locale.ENGLISH);
    }

    static Language[] method1947() {
        return new Language[] { Language_FR, field3548, field3554, field3550, field3547, Language_EN, Language_ES };
    }

    public static class337[] method1949() {
        return new class337[] { class337.field3421, class337.field3422, class337.field3423, class337.field3420 };
    }

    public static Language method1943(int var0) {
        return var0 >= 0 && var0 < field3556.length ? field3556[var0] : null;
    }

    static Object method1948(class478 var0) {
        if (var0 == null) {
            throw new IllegalStateException("popValueOfType() failure - null baseVarType");
        } else {
            switch (var0.field4029) {
            case 1:
                return Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            case 2:
                return Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
            default:
                throw new IllegalStateException("popValueOfType() failure - unsupported type");
            }
        }
    }

    static final void method1946(boolean var0) {
        class323.playPcmPlayers();
        ++Client.packetWriter.pendingWrites;
        if (Client.packetWriter.pendingWrites >= 50 || var0) {
            Client.packetWriter.pendingWrites = 0;
            if (!Client.hadNetworkError && Client.packetWriter.getSocket() != null) {
                PacketBufferNode var1 = class330.getPacketBufferNode(ClientPacket.field2554,
                        Client.packetWriter.isaacCipher);
                Client.packetWriter.addNode(var1);

                try {
                    Client.packetWriter.flush();
                } catch (IOException var3) {
                    Client.hadNetworkError = true;
                }
            }

        }
    }
}
