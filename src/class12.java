import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.Certificate;

import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

import org.bouncycastle.crypto.tls.TlsClientProtocol;

class class12 extends SSLSocket {

    static boolean clearLoginScreen;

    Certificate[] field40;
    // $FF: synthetic field

    final class15 this$0;
    // $FF: synthetic field

    final TlsClientProtocol val$tlsClientProtocol;
    // $FF: synthetic field

    final String val$host;

    class12(class15 var1, TlsClientProtocol var2, String var3) {
        this.this$0 = var1;
        this.val$tlsClientProtocol = var2;
        this.val$host = var3;
    }

    public InputStream getInputStream() throws IOException {
        return this.val$tlsClientProtocol.getInputStream();
    }

    public synchronized void close() throws IOException {
        this.val$tlsClientProtocol.close();
    }

    public void addHandshakeCompletedListener(HandshakeCompletedListener var1) {
    }

    public String[] getEnabledCipherSuites() {
        return null;
    }

    public String[] getEnabledProtocols() {
        return null;
    }

    public boolean getNeedClientAuth() {
        return false;
    }

    public boolean getUseClientMode() {
        return false;
    }

    public boolean getWantClientAuth() {
        return false;
    }

    public void removeHandshakeCompletedListener(HandshakeCompletedListener var1) {
    }

    public void setEnableSessionCreation(boolean var1) {
    }

    public void setEnabledCipherSuites(String[] var1) {
    }

    public void setEnabledProtocols(String[] var1) {
    }

    public void setNeedClientAuth(boolean var1) {
    }

    public void startHandshake() throws IOException {
        this.val$tlsClientProtocol.connect(new class13(this));
    }

    public void setWantClientAuth(boolean var1) {
    }

    public boolean getEnableSessionCreation() {
        return false;
    }

    public void setUseClientMode(boolean var1) {
    }

    public SSLSession getSession() {
        return new class17(this);
    }

    public String[] getSupportedCipherSuites() {
        return null;
    }

    public OutputStream getOutputStream() throws IOException {
        return this.val$tlsClientProtocol.getOutputStream();
    }

    public String[] getSupportedProtocols() {
        return null;
    }

    static int getClipMidY() {
        return Rasterizer3D.clips.field2229;
    }

    static void runWidgetOnLoadListener(int var0) {
        if (var0 != -1) {
            if (SoundSystem.loadInterface(var0)) {
                Widget[] var1 = VerticalAlignment.Widget_interfaceComponents[var0];

                for (int var2 = 0; var2 < var1.length; ++var2) {
                    Widget var3 = var1[var2];
                    if (var3.onLoad != null) {
                        ScriptEvent var4 = new ScriptEvent();
                        var4.widget = var3;
                        var4.args = var3.onLoad;
                        PlayerType.runScript(var4, 5000000, 0);
                    }
                }

            }
        }
    }
}
