import java.net.MalformedURLException;
import java.net.URL;

public class class311 {

    UrlRequest field2819;

    SpritePixels field2820;

    class311(String var1, UrlRequester var2) {
        try {
            this.field2819 = var2.request(new URL(var1));
        } catch (MalformedURLException var4) {
            this.field2819 = null;
        }

    }

    class311(UrlRequest var1) {
        this.field2819 = var1;
    }

    SpritePixels method1690() {
        if (this.field2820 == null && this.field2819 != null && this.field2819.isDone()) {
            if (this.field2819.getResponse() != null) {
                this.field2820 = Strings.method1853(this.field2819.getResponse());
            }

            this.field2819 = null;
        }

        return this.field2820;
    }
}
