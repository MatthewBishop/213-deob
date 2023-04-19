import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Widget extends Node {

    static EvictingDualNodeHashTable Widget_cachedSprites = new EvictingDualNodeHashTable(200);

    static EvictingDualNodeHashTable Widget_cachedModels = new EvictingDualNodeHashTable(50);

    static EvictingDualNodeHashTable Widget_cachedFonts = new EvictingDualNodeHashTable(20);

    static EvictingDualNodeHashTable Widget_cachedSpriteMasks = new EvictingDualNodeHashTable(8);

    static class398 field2878;

    static class398 field2867;

    public static boolean field2877;

    public boolean isIf3 = false;

    public int id = -1;

    public int childIndex = -1;

    public int type;

    public int buttonType = 0;

    public int contentType = 0;

    public int xAlignment = 0;

    public int yAlignment = 0;

    public int widthAlignment = 0;

    public int heightAlignment = 0;

    public int rawX = 0;

    public int rawY = 0;

    public int rawWidth = 0;

    public int rawHeight = 0;

    public int x = 0;

    public int y = 0;

    public int width = 0;

    public int height = 0;

    public int field2896 = 1;

    public int field2897 = 1;

    public int parentId = -1;

    public boolean isHidden = false;

    public int scrollX = 0;

    public int scrollY = 0;

    public int scrollWidth = 0;

    public int scrollHeight = 0;

    public int color = 0;

    public int color2 = 0;

    public int mouseOverColor = 0;

    public int mouseOverColor2 = 0;

    public boolean fill = false;

    public FillMode fillMode;

    public int transparencyTop;

    public int transparencyBot;

    public int lineWid;

    public boolean field2913;

    public int spriteId2;

    public int spriteId;

    public String field2916;

    public int spriteAngle;

    public boolean spriteTiling;

    public int outline;

    public int spriteShadow;

    public boolean spriteFlipV;

    public boolean spriteFlipH;

    public int modelType;

    public int modelId;

    int modelType2;

    int modelId2;

    public int sequenceId;

    public int sequenceId2;

    public int modelOffsetX;

    public int modelOffsetY;

    public int modelAngleX;

    public int modelAngleY;

    public int modelAngleZ;

    public int modelZoom;

    public int modelRotation;

    public int rotationKey;

    public PlayerComposition field2894;

    public boolean modelOrthog;

    public boolean modelTransparency;

    public int itemQuantityMode;

    public int fontId;

    public String text;

    public String text2;

    public int textLineHeight;

    public int textXAlignment;

    public int textYAlignment;

    public boolean textShadowed;

    class166 field2868;

    int field2948;

    HashMap field2949;

    HashMap field2950;

    class312 field2951;

    public int flags;

    public boolean field2891;

    public byte[][] field2954;

    public byte[][] field2955;

    public int[] field2936;

    public int[] field2977;

    public String dataText;

    public String[] actions;

    public Widget parent;

    public int dragZoneSize;

    public int dragThreshold;

    public boolean isScrollBar;

    public String spellActionName;

    public boolean hasListener;

    public Object[] onLoad;

    public Object[] onClick;

    public Object[] onClickRepeat;

    public Object[] onRelease;

    public Object[] onHold;

    public Object[] onMouseOver;

    public Object[] onMouseRepeat;

    public Object[] onMouseLeave;

    public Object[] onDrag;

    public Object[] onDragComplete;

    public Object[] onTargetEnter;

    public Object[] onTargetLeave;

    public Object[] onVarTransmit;

    public int[] varTransmitTriggers;

    public Object[] onInvTransmit;

    public int[] invTransmitTriggers;

    public Object[] onStatTransmit;

    public int[] statTransmitTriggers;

    public Object[] onTimer;

    public Object[] onOp;

    public Object[] field2984;

    public Object[] onScroll;

    public Object[] onChatTransmit;

    public Object[] onKey;

    public Object[] field2988;

    public Object[] field2892;

    public Object[] onFriendTransmit;

    public Object[] onClanTransmit;

    public Object[] field2946;

    public Object[] field2876;

    public Object[] onMiscTransmit;

    public Object[] onDialogAbort;

    public Object[] onSubChange;

    public Object[] onResize;

    public Object[] onStockTransmit;

    public Object[] field2998;

    public Object[] field2961;

    public int[][] cs1Instructions;

    public int[] cs1Comparisons;

    public int[] cs1ComparisonValues;

    public int mouseOverRedirect;

    public String field3004;

    public String buttonText;

    public int[] itemIds;

    public int[] field3007;

    public int itemId;

    public int itemQuantity;

    public int modelFrame;

    public int modelFrameCycle;

    public Widget[] children;

    public boolean field2978;

    public boolean field2969;

    public int field3015;

    public int field2870;

    public int field3017;

    public int field3006;

    public int rootIndex;

    public int cycle;

    public int[] field2952;

    public boolean noClickThrough;

    public boolean noScrollThrough;

    public boolean prioritizeMenuEntry;

    static {
        field2878 = new class398(10, class396.field3689);
        field2867 = new class398(10, class396.field3689);
        field2877 = false;
    }

    public Widget() {
        this.fillMode = FillMode.SOLID;
        this.transparencyTop = 0;
        this.transparencyBot = 0;
        this.lineWid = 1;
        this.field2913 = false;
        this.spriteId2 = -1;
        this.spriteId = -1;
        this.spriteAngle = 0;
        this.spriteTiling = false;
        this.outline = 0;
        this.spriteShadow = 0;
        this.modelType = 1;
        this.modelId = -1;
        this.modelType2 = 1;
        this.modelId2 = -1;
        this.sequenceId = -1;
        this.sequenceId2 = -1;
        this.modelOffsetX = 0;
        this.modelOffsetY = 0;
        this.modelAngleX = 0;
        this.modelAngleY = 0;
        this.modelAngleZ = 0;
        this.modelZoom = 100;
        this.modelRotation = 0;
        this.rotationKey = 0;
        this.modelOrthog = false;
        this.modelTransparency = false;
        this.itemQuantityMode = 2;
        this.fontId = -1;
        this.text = "";
        this.text2 = "";
        this.textLineHeight = 0;
        this.textXAlignment = 0;
        this.textYAlignment = 0;
        this.textShadowed = false;
        this.field2948 = -1;
        this.flags = 0;
        this.field2891 = false;
        this.dataText = "";
        this.parent = null;
        this.dragZoneSize = 0;
        this.dragThreshold = 0;
        this.isScrollBar = false;
        this.spellActionName = "";
        this.hasListener = false;
        this.mouseOverRedirect = -1;
        this.field3004 = "";
        this.buttonText = "Ok";
        this.itemId = -1;
        this.itemQuantity = 0;
        this.modelFrame = 0;
        this.modelFrameCycle = 0;
        this.field2978 = false;
        this.field2969 = false;
        this.field3015 = -1;
        this.field2870 = 0;
        this.field3017 = 0;
        this.field3006 = 0;
        this.rootIndex = -1;
        this.cycle = -1;
        this.noClickThrough = false;
        this.noScrollThrough = false;
        this.prioritizeMenuEntry = false;
    }

    void decodeLegacy(Buffer var1) {
        this.isIf3 = false;
        this.type = var1.readUnsignedByte();
        this.buttonType = var1.readUnsignedByte();
        this.contentType = var1.readUnsignedShort();
        this.rawX = var1.readShort();
        this.rawY = var1.readShort();
        this.rawWidth = var1.readUnsignedShort();
        this.rawHeight = var1.readUnsignedShort();
        this.transparencyTop = var1.readUnsignedByte();
        this.parentId = var1.readUnsignedShort();
        if (this.parentId == 65535) {
            this.parentId = -1;
        } else {
            this.parentId += this.id & -65536;
        }

        this.mouseOverRedirect = var1.readUnsignedShort();
        if (this.mouseOverRedirect == 65535) {
            this.mouseOverRedirect = -1;
        }

        int var2 = var1.readUnsignedByte();
        int var3;
        if (var2 > 0) {
            this.cs1Comparisons = new int[var2];
            this.cs1ComparisonValues = new int[var2];

            for (var3 = 0; var3 < var2; ++var3) {
                this.cs1Comparisons[var3] = var1.readUnsignedByte();
                this.cs1ComparisonValues[var3] = var1.readUnsignedShort();
            }
        }

        var3 = var1.readUnsignedByte();
        int var4;
        if (var3 > 0) {
            this.cs1Instructions = new int[var3][];

            for (var4 = 0; var4 < var3; ++var4) {
                int var5 = var1.readUnsignedShort();
                this.cs1Instructions[var4] = new int[var5];

                for (int var6 = 0; var6 < var5; ++var6) {
                    this.cs1Instructions[var4][var6] = var1.readUnsignedShort();
                    if (this.cs1Instructions[var4][var6] == 65535) {
                        this.cs1Instructions[var4][var6] = -1;
                    }
                }
            }
        }

        if (this.type == 0) {
            this.scrollHeight = var1.readUnsignedShort();
            this.isHidden = var1.readUnsignedByte() == 1;
        }

        if (this.type == 1) {
            var1.readUnsignedShort();
            var1.readUnsignedByte();
        }

        if (this.type == 3) {
            this.fill = var1.readUnsignedByte() == 1;
        }

        if (this.type == 4 || this.type == 1) {
            this.textXAlignment = var1.readUnsignedByte();
            this.textYAlignment = var1.readUnsignedByte();
            this.textLineHeight = var1.readUnsignedByte();
            this.fontId = var1.readUnsignedShort();
            if (this.fontId == 65535) {
                this.fontId = -1;
            }

            this.textShadowed = var1.readUnsignedByte() == 1;
        }

        if (this.type == 4) {
            this.text = var1.readStringCp1252NullTerminated();
            this.text2 = var1.readStringCp1252NullTerminated();
        }

        if (this.type == 1 || this.type == 3 || this.type == 4) {
            this.color = var1.readInt();
        }

        if (this.type == 3 || this.type == 4) {
            this.color2 = var1.readInt();
            this.mouseOverColor = var1.readInt();
            this.mouseOverColor2 = var1.readInt();
        }

        if (this.type == 5) {
            this.spriteId2 = var1.readInt();
            this.spriteId = var1.readInt();
        }

        if (this.type == 6) {
            this.modelType = 1;
            this.modelId = var1.readUnsignedShort();
            if (this.modelId == 65535) {
                this.modelId = -1;
            }

            this.modelType2 = 1;
            this.modelId2 = var1.readUnsignedShort();
            if (this.modelId2 == 65535) {
                this.modelId2 = -1;
            }

            this.sequenceId = var1.readUnsignedShort();
            if (this.sequenceId == 65535) {
                this.sequenceId = -1;
            }

            this.sequenceId2 = var1.readUnsignedShort();
            if (this.sequenceId2 == 65535) {
                this.sequenceId2 = -1;
            }

            this.modelZoom = var1.readUnsignedShort();
            this.modelAngleX = var1.readUnsignedShort();
            this.modelAngleY = var1.readUnsignedShort();
        }

        if (this.type == 8) {
            this.text = var1.readStringCp1252NullTerminated();
        }

        if (this.buttonType == 2) {
            this.spellActionName = var1.readStringCp1252NullTerminated();
            this.field3004 = var1.readStringCp1252NullTerminated();
            var4 = var1.readUnsignedShort() & 63;
            this.flags |= var4 << 11;
        }

        if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5 || this.buttonType == 6) {
            this.buttonText = var1.readStringCp1252NullTerminated();
            if (this.buttonText.length() == 0) {
                if (this.buttonType == 1) {
                    this.buttonText = "Ok";
                }

                if (this.buttonType == 4) {
                    this.buttonText = "Select";
                }

                if (this.buttonType == 5) {
                    this.buttonText = "Select";
                }

                if (this.buttonType == 6) {
                    this.buttonText = "Continue";
                }
            }
        }

        if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5) {
            this.flags |= 4194304;
        }

        if (this.buttonType == 6) {
            this.flags |= 1;
        }

    }

    void decode(Buffer var1) {
        var1.readUnsignedByte();
        this.isIf3 = true;
        this.type = var1.readUnsignedByte();
        this.contentType = var1.readUnsignedShort();
        this.rawX = var1.readShort();
        this.rawY = var1.readShort();
        this.rawWidth = var1.readUnsignedShort();
        if (this.type == 9) {
            this.rawHeight = var1.readShort();
        } else {
            this.rawHeight = var1.readUnsignedShort();
        }

        this.widthAlignment = var1.readByte();
        this.heightAlignment = var1.readByte();
        this.xAlignment = var1.readByte();
        this.yAlignment = var1.readByte();
        this.parentId = var1.readUnsignedShort();
        if (this.parentId == 65535) {
            this.parentId = -1;
        } else {
            this.parentId += this.id & -65536;
        }

        this.isHidden = var1.readUnsignedByte() == 1;
        if (this.type == 0) {
            this.scrollWidth = var1.readUnsignedShort();
            this.scrollHeight = var1.readUnsignedShort();
            this.noClickThrough = var1.readUnsignedByte() == 1;
        }

        if (this.type == 5) {
            this.spriteId2 = var1.readInt();
            this.spriteAngle = var1.readUnsignedShort();
            this.spriteTiling = var1.readUnsignedByte() == 1;
            this.transparencyTop = var1.readUnsignedByte();
            this.outline = var1.readUnsignedByte();
            this.spriteShadow = var1.readInt();
            this.spriteFlipV = var1.readUnsignedByte() == 1;
            this.spriteFlipH = var1.readUnsignedByte() == 1;
        }

        if (this.type == 6) {
            this.modelType = 1;
            this.modelId = var1.readUnsignedShort();
            if (this.modelId == 65535) {
                this.modelId = -1;
            }

            this.modelOffsetX = var1.readShort();
            this.modelOffsetY = var1.readShort();
            this.modelAngleX = var1.readUnsignedShort();
            this.modelAngleY = var1.readUnsignedShort();
            this.modelAngleZ = var1.readUnsignedShort();
            this.modelZoom = var1.readUnsignedShort();
            this.sequenceId = var1.readUnsignedShort();
            if (this.sequenceId == 65535) {
                this.sequenceId = -1;
            }

            this.modelOrthog = var1.readUnsignedByte() == 1;
            var1.readUnsignedShort();
            if (this.widthAlignment != 0) {
                this.modelRotation = var1.readUnsignedShort();
            }

            if (this.heightAlignment != 0) {
                var1.readUnsignedShort();
            }
        }

        if (this.type == 4) {
            this.fontId = var1.readUnsignedShort();
            if (this.fontId == 65535) {
                this.fontId = -1;
            }

            this.text = var1.readStringCp1252NullTerminated();
            this.textLineHeight = var1.readUnsignedByte();
            this.textXAlignment = var1.readUnsignedByte();
            this.textYAlignment = var1.readUnsignedByte();
            this.textShadowed = var1.readUnsignedByte() == 1;
            this.color = var1.readInt();
        }

        if (this.type == 3) {
            this.color = var1.readInt();
            this.fill = var1.readUnsignedByte() == 1;
            this.transparencyTop = var1.readUnsignedByte();
        }

        if (this.type == 9) {
            this.lineWid = var1.readUnsignedByte();
            this.color = var1.readInt();
            this.field2913 = var1.readUnsignedByte() == 1;
        }

        this.flags = var1.readMedium();
        this.dataText = var1.readStringCp1252NullTerminated();
        int var2 = var1.readUnsignedByte();
        if (var2 > 0) {
            this.actions = new String[var2];

            for (int var3 = 0; var3 < var2; ++var3) {
                this.actions[var3] = var1.readStringCp1252NullTerminated();
            }
        }

        this.dragZoneSize = var1.readUnsignedByte();
        this.dragThreshold = var1.readUnsignedByte();
        this.isScrollBar = var1.readUnsignedByte() == 1;
        this.spellActionName = var1.readStringCp1252NullTerminated();
        this.onLoad = this.readListener(var1);
        this.onMouseOver = this.readListener(var1);
        this.onMouseLeave = this.readListener(var1);
        this.onTargetLeave = this.readListener(var1);
        this.onTargetEnter = this.readListener(var1);
        this.onVarTransmit = this.readListener(var1);
        this.onInvTransmit = this.readListener(var1);
        this.onStatTransmit = this.readListener(var1);
        this.onTimer = this.readListener(var1);
        this.onOp = this.readListener(var1);
        this.onMouseRepeat = this.readListener(var1);
        this.onClick = this.readListener(var1);
        this.onClickRepeat = this.readListener(var1);
        this.onRelease = this.readListener(var1);
        this.onHold = this.readListener(var1);
        this.onDrag = this.readListener(var1);
        this.onDragComplete = this.readListener(var1);
        this.onScroll = this.readListener(var1);
        this.varTransmitTriggers = this.readListenerTriggers(var1);
        this.invTransmitTriggers = this.readListenerTriggers(var1);
        this.statTransmitTriggers = this.readListenerTriggers(var1);
    }

    Object[] readListener(Buffer var1) {
        int var2 = var1.readUnsignedByte();
        if (var2 == 0) {
            return null;
        } else {
            Object[] var3 = new Object[var2];

            for (int var4 = 0; var4 < var2; ++var4) {
                int var5 = var1.readUnsignedByte();
                if (var5 == 0) {
                    var3[var4] = new Integer(var1.readInt());
                } else if (var5 == 1) {
                    var3[var4] = var1.readStringCp1252NullTerminated();
                }
            }

            this.hasListener = true;
            return var3;
        }
    }

    int[] readListenerTriggers(Buffer var1) {
        int var2 = var1.readUnsignedByte();
        if (var2 == 0) {
            return null;
        } else {
            int[] var3 = new int[var2];

            for (int var4 = 0; var4 < var2; ++var4) {
                var3[var4] = var1.readInt();
            }

            return var3;
        }
    }

    public SpritePixels getSprite(boolean var1, UrlRequester var2) {
        field2877 = false;
        if (this.field2916 != null) {
            SpritePixels var3 = this.method1826(var2);
            if (var3 != null) {
                return var3;
            }
        }

        int var7;
        if (var1) {
            var7 = this.spriteId;
        } else {
            var7 = this.spriteId2;
        }

        if (var7 == -1) {
            return null;
        } else {
            long var4 = ((long) this.spriteShadow << 40) + ((this.spriteFlipV ? 1L : 0L) << 38)
                    + ((long) this.outline << 36) + (long) var7 + ((this.spriteFlipH ? 1L : 0L) << 39);
            SpritePixels var6 = (SpritePixels) Widget_cachedSprites.get(var4);
            if (var6 != null) {
                return var6;
            } else {
                var6 = class484.SpriteBuffer_getSprite(ScriptEvent.Widget_spritesArchive, var7, 0);
                if (var6 == null) {
                    field2877 = true;
                    return null;
                } else {
                    this.method1797(var6);
                    Widget_cachedSprites.put(var6, var4);
                    return var6;
                }
            }
        }
    }

    SpritePixels method1826(UrlRequester var1) {
        if (!this.method1796()) {
            return this.method1825(var1);
        } else {
            String var2 = this.field2916 + (this.spriteFlipV ? 1 : 0) + (this.spriteFlipH ? 1 : 0) + this.outline
                    + this.spriteShadow;
            SpritePixels var3 = (SpritePixels) field2867.method2126(var2);
            if (var3 == null) {
                SpritePixels var4 = this.method1825(var1);
                if (var4 != null) {
                    var3 = var4.method2602();
                    this.method1797(var3);
                    field2867.method2122(var2, var3);
                }
            }

            return var3;
        }
    }

    SpritePixels method1825(UrlRequester var1) {
        if (this.field2916 != null && var1 != null) {
            class311 var2 = (class311) field2878.method2126(this.field2916);
            if (var2 == null) {
                var2 = new class311(this.field2916, var1);
                field2878.method2122(this.field2916, var2);
            }

            return var2.method1690();
        } else {
            return null;
        }
    }

    boolean method1796() {
        return this.spriteFlipV || this.spriteFlipH || this.outline != 0 || this.spriteShadow != 0;
    }

    void method1797(SpritePixels var1) {
        if (this.spriteFlipV) {
            var1.flipVertically();
        }

        if (this.spriteFlipH) {
            var1.flipHorizontally();
        }

        if (this.outline > 0) {
            var1.pad(this.outline);
        }

        if (this.outline >= 1) {
            var1.outline(1);
        }

        if (this.outline >= 2) {
            var1.outline(16777215);
        }

        if (this.spriteShadow != 0) {
            var1.shadow(this.spriteShadow);
        }

    }

    public Font getFont() {
        field2877 = false;
        if (this.fontId == -1) {
            return null;
        } else {
            Font var1 = (Font) Widget_cachedFonts.get((long) this.fontId);
            if (var1 != null) {
                return var1;
            } else {
                AbstractArchive var3 = ScriptEvent.Widget_spritesArchive;
                AbstractArchive var4 = class146.Widget_fontsArchive;
                int var5 = this.fontId;
                byte[] var7 = var3.takeFile(var5, 0);
                boolean var6;
                if (var7 == null) {
                    var6 = false;
                } else {
                    class485.SpriteBuffer_decode(var7);
                    var6 = true;
                }

                Font var2;
                if (!var6) {
                    var2 = null;
                } else {
                    byte[] var8 = var4.takeFile(var5, 0);
                    Font var10;
                    if (var8 == null) {
                        var10 = null;
                    } else {
                        Font var9 = new Font(var8, class503.SpriteBuffer_xOffsets, class17.SpriteBuffer_yOffsets,
                                class97.SpriteBuffer_spriteWidths, class138.SpriteBuffer_spriteHeights,
                                class394.SpriteBuffer_spritePalette, VarbitComposition.SpriteBuffer_pixels);
                        class398.method2125();
                        var10 = var9;
                    }

                    var2 = var10;
                }

                if (var2 != null) {
                    Widget_cachedFonts.put(var2, (long) this.fontId);
                } else {
                    field2877 = true;
                }

                return var2;
            }
        }
    }

    public Model getModel(SequenceDefinition var1, int var2, boolean var3, PlayerComposition var4, NPCComposition var5,
            NewShit var6) {
        field2877 = false;
        int var7;
        int var8;
        if (var3) {
            var7 = this.modelType2;
            var8 = this.modelId2;
        } else {
            var7 = this.modelType;
            var8 = this.modelId;
        }

        if (var7 == 6) {
            if (var5 == null) {
                return null;
            }

            var8 = var5.id;
        }

        if (var7 == 0) {
            return null;
        } else if (var7 == 1 && var8 == -1) {
            return null;
        } else {
            if (var6 != null && var6.field1558 && var7 == 6) {
                var7 = 3;
            }

            long var9 = (long) (var8 + (var7 << 16));
            if (var6 != null) {
                var9 |= var6.field1556 << 20;
            }

            Model var11 = (Model) Widget_cachedModels.get(var9);
            if (var11 == null) {
                ModelData var12 = null;
                int var13 = 64;
                int var14 = 768;
                switch (var7) {
                case 1:
                    var12 = ModelData.ModelData_get(DynamicObject.field813, var8, 0);
                    break;
                case 2:
                    var12 = AbstractArchive.getNpcDefinition(var8).method1022((NewShit) null);
                    break;
                case 3:
                    var12 = var4 != null ? var4.getModelData() : null;
                    break;
                case 4:
                    ItemComposition var15 = HealthBarUpdate.ItemDefinition_get(var8);
                    var12 = var15.getModelData(10);
                    var13 += var15.field1780;
                    var14 += var15.field1781;
                case 5:
                default:
                    break;
                case 6:
                    var12 = AbstractArchive.getNpcDefinition(var8).method1022(var6);
                }

                if (var12 == null) {
                    field2877 = true;
                    return null;
                }

                var11 = var12.toModel(var13, var14, -50, -10, -50);
                Widget_cachedModels.put(var11, var9);
            }

            if (var1 != null) {
                var11 = var1.transformWidgetModel(var11, var2);
            }

            return var11;
        }
    }

    public SpriteMask getSpriteMask(boolean var1) {
        if (this.spriteId == -1) {
            var1 = false;
        }

        int var2 = var1 ? this.spriteId * 1679014525 * -1352724779 : this.spriteId2 * -363627527 * -504605111;
        if (var2 == -1) {
            return null;
        } else {
            long var3 = ((this.spriteFlipH ? 1L : 0L) << 39) + ((this.spriteFlipV ? 1L : 0L) << 38)
                    + ((long) this.outline << 36) + (long) var2 + ((long) this.spriteShadow << 40);
            SpriteMask var5 = (SpriteMask) Widget_cachedSpriteMasks.get(var3);
            if (var5 != null) {
                return var5;
            } else {
                SpritePixels var6 = this.getSprite(var1, (UrlRequester) null);
                if (var6 == null) {
                    return null;
                } else {
                    SpritePixels var7 = var6.copyNormalized();
                    int[] var8 = new int[var7.subHeight];
                    int[] var9 = new int[var7.subHeight];

                    for (int var10 = 0; var10 < var7.subHeight; ++var10) {
                        int var11 = 0;
                        int var12 = var7.subWidth;

                        int var13;
                        for (var13 = 0; var13 < var7.subWidth; ++var13) {
                            if (var7.pixels[var13 + var10 * var7.subWidth] == 0) {
                                var11 = var13;
                                break;
                            }
                        }

                        for (var13 = var7.subWidth - 1; var13 >= var11; --var13) {
                            if (var7.pixels[var13 + var10 * var7.subWidth] == 0) {
                                var12 = var13 + 1;
                                break;
                            }
                        }

                        var8[var10] = var11;
                        var9[var10] = var12 - var11;
                    }

                    var5 = new SpriteMask(var7.subWidth, var7.subHeight, var9, var8, var2);
                    Widget_cachedSpriteMasks.put(var5, var3);
                    return var5;
                }
            }
        }
    }

    public void setAction(int var1, String var2) {
        if (this.actions == null || this.actions.length <= var1) {
            String[] var3 = new String[var1 + 1];
            if (this.actions != null) {
                for (int var4 = 0; var4 < this.actions.length; ++var4) {
                    var3[var4] = this.actions[var4];
                }
            }

            this.actions = var3;
        }

        this.actions[var1] = var2;
    }

    public boolean method1801() {
        return !this.isIf3 || this.type == 0 || this.type == 11 || this.hasListener || this.contentType == 1338
                || this.type == 12;
    }

    public boolean method1808() {
        return this.type == 11 || this.type == 12;
    }

    public void method1803(String var1, UrlRequester var2, long var3) {
        if (this.type == 11 && -1L != var3) {
            var1 = var1.replaceAll("%userid%", Long.toString(var3));
            this.field2868 = new class166();
            if (!this.field2868.method924(var1, var2)) {
                this.field2868 = null;
            } else {
                if (this.field2949 == null || this.field2950 == null) {
                    this.method1823();
                }

            }
        }
    }

    public void method1802(String var1, UrlRequester var2) {
        if (this.type == 11 && var1 != null) {
            this.field2868 = new class166();
            this.field2868.method938(var1, var2);
        }
    }

    void method1823() {
        this.field2949 = new HashMap();
        this.field2950 = new HashMap();
    }

    public void method1824(int var1, int var2) {
        if (this.type == 11) {
            if (this.field2949 == null) {
                this.method1823();
            }

            this.field2949.put(var1, var2);
        }
    }

    public void method1805(String var1, int var2) {
        if (this.type == 11) {
            if (this.field2950 == null) {
                this.method1823();
            }

            this.field2950.put(var1, var2);
        }
    }

    public boolean method1806(int var1, int var2, int var3, int var4) {
        if (this.type == 11 && this.field2868 != null && this.method1807()) {
            var1 -= var3;
            var2 -= var4;
            int var5 = (int) (this.field2868.method930()[0] * (float) this.width);
            int var6 = (int) (this.field2868.method930()[1] * (float) this.height);
            int var7 = var5 + (int) (this.field2868.method930()[2] * (float) this.width);
            int var8 = var6 + (int) (this.field2868.method930()[3] * (float) this.height);
            return var1 >= var5 && var2 >= var6 && var1 < var7 && var2 < var8;
        } else {
            return false;
        }
    }

    public boolean method1807() {
        return this.field2948 == 2;
    }

    public int method1804(String var1) {
        return this.type == 11 && this.field2868 != null && this.method1807() ? this.field2868.method933(var1) : -1;
    }

    public String method1809(String var1) {
        return this.type == 11 && this.field2868 != null && this.method1807() ? this.field2868.method927(var1) : null;
    }

    public int method1810() {
        return this.field2950 != null && this.field2950.size() > 0 ? 1 : 0;
    }

    public int method1811() {
        if (this.type == 11 && this.field2868 != null && this.field2950 != null && !this.field2950.isEmpty()) {
            String var1 = this.field2868.method940();
            return var1 != null && this.field2950.containsKey(this.field2868.method940())
                    ? (Integer) this.field2950.get(var1)
                    : -1;
        } else {
            return -1;
        }
    }

    public String method1827() {
        if (this.type == 11 && this.field2868 != null) {
            String var1 = this.field2868.method940();
            Iterator var2 = this.field2868.method931().iterator();

            while (var2.hasNext()) {
                class177 var3 = (class177) var2.next();
                String var4 = String.format("%%%S%%", var3.method963());
                if (var3.vmethod3379() == 0) {
                    var1.replaceAll(var4, Integer.toString(var3.vmethod3378()));
                } else {
                    var1.replaceAll(var4, var3.vmethod3380());
                }
            }

            return var1;
        } else {
            return null;
        }
    }

    public int[] method1812() {
        if (this.type == 11 && this.field2868 != null) {
            int[] var1 = new int[3];
            int var2 = 0;
            Iterator var3 = this.field2868.method931().iterator();

            while (var3.hasNext()) {
                class177 var4 = (class177) var3.next();
                if (!var4.method963().equals("user_id")) {
                    if (var4.vmethod3379() != 0) {
                        return null;
                    }

                    var1[var2++] = var4.vmethod3378();
                    if (var2 > 3) {
                        return null;
                    }
                }
            }

            return var1;
        } else {
            return null;
        }
    }

    public boolean method1820(UrlRequester var1) {
        if (this.type == 11 && this.field2868 != null) {
            this.field2868.method925(var1);
            if (this.field2868.method926() != this.field2948) {
                this.field2948 = this.field2868.method926();
                if (this.field2948 >= 100) {
                    return true;
                }

                if (this.field2948 == 2) {
                    this.method1813();
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    void method1813() {
        this.noClickThrough = true;
        ArrayList var1 = this.field2868.method929();
        ArrayList var2 = this.field2868.method942();
        int var3 = var1.size() + var2.size();
        this.children = new Widget[var3];
        int var4 = 0;

        Iterator var5;
        Widget var7;
        for (var5 = var1.iterator(); var5.hasNext(); this.children[var4++] = var7) {
            class172 var6 = (class172) var5.next();
            var7 = class314.method1789(5, this, var4, 0, 0, 0, 0, var6.field1444);
            var7.field2916 = var6.field1445.method679();
            class311 var8 = new class311(var6.field1445);
            field2878.method2122(var7.field2916, var8);
        }

        for (var5 = var2.iterator(); var5.hasNext(); this.children[var4++] = var7) {
            class173 var9 = (class173) var5.next();
            var7 = class314.method1789(4, this, var4, 0, 0, 0, 0, var9.field1448);
            var7.text = var9.field1447;
            var7.fontId = (Integer) this.field2949.get(var9.field1446);
            var7.textXAlignment = var9.field1449;
            var7.textYAlignment = var9.field1450;
        }

    }

    public void method1814() {
        this.field2951 = new class312();

        for (int var1 = 1; var1 <= 12; ++var1) {
            this.field2951.field2827.method114(var1, 0);
        }

        for (char var2 = 0; var2 < ' '; ++var2) {
            this.field2951.field2827.method115(var2, 0);
        }

        this.field2951.field2827.method115('\u0080', 0);
        this.field2951.field2827.method114(82, 2);
        this.field2951.field2827.method114(81, 2);
        this.field2951.field2827.method114(86, 2);
    }

    public class314 method1815() {
        return this.field2951 != null ? this.field2951.field2823 : null;
    }

    public class309 method1817() {
        return this.field2951 != null ? this.field2951.field2822 : null;
    }

    public class27 method1795() {
        return this.field2951 != null ? this.field2951.field2827 : null;
    }

    public class312 method1818() {
        return this.field2951;
    }

    boolean method1816(class314 var1) {
        boolean var2 = false;
        String var5;
        String var6;
        StringBuilder var7;
        int var8;
        int var9;
        int var10;
        char var11;
        String var12;
        if (this.text != null && !this.text.isEmpty()) {
            var6 = this.text;
            var7 = new StringBuilder(var6.length());
            var8 = 0;
            var9 = -1;

            for (var10 = 0; var10 < var6.length(); ++var10) {
                var11 = var6.charAt(var10);
                if (var11 == '<') {
                    var7.append(var6.substring(var8, var10));
                    var9 = var10;
                } else if (var11 == '>' && var9 != -1) {
                    var12 = var6.substring(var9 + 1, var10);
                    var9 = -1;
                    if (var12.equals("lt")) {
                        var7.append("<");
                    } else if (var12.equals("gt")) {
                        var7.append(">");
                    } else if (var12.equals("br")) {
                        var7.append("\n");
                    }

                    var8 = var10 + 1;
                }
            }

            if (var8 < var6.length()) {
                var7.append(var6.substring(var8, var6.length()));
            }

            var5 = var7.toString();
            var2 |= var1.method1708(var5);
            this.text = "";
        }

        if (this.text2 != null && !this.text2.isEmpty()) {
            var6 = this.text2;
            var7 = new StringBuilder(var6.length());
            var8 = 0;
            var9 = -1;

            for (var10 = 0; var10 < var6.length(); ++var10) {
                var11 = var6.charAt(var10);
                if (var11 == '<') {
                    var7.append(var6.substring(var8, var10));
                    var9 = var10;
                } else if (var11 == '>' && var9 != -1) {
                    var12 = var6.substring(var9 + 1, var10);
                    var9 = -1;
                    if (var12.equals("lt")) {
                        var7.append("<");
                    } else if (var12.equals("gt")) {
                        var7.append(">");
                    } else if (var12.equals("br")) {
                        var7.append("\n");
                    }

                    var8 = var10 + 1;
                }
            }

            if (var8 < var6.length()) {
                var7.append(var6.substring(var8, var6.length()));
            }

            var5 = var7.toString();
            var2 |= var1.method1709(var5);
            this.text2 = "";
        }

        return var2;
    }

    public boolean method1822() {
        class314 var1 = this.method1815();
        if (var1 == null) {
            return false;
        } else {
            boolean var2 = false;
            if (!var1.method1748() && this.fontId != -1) {
                int var3 = var1.method1769();
                int var4 = var1.method1781();
                int var5 = var1.method1747();
                int var6 = var1.method1746();
                Font var7 = this.getFont();
                if (var7 != null) {
                    var2 |= var1.method1737(var7);
                    var2 |= this.method1816(var1);
                    var2 |= var1.method1713(var3, var4);
                    var2 |= var1.method1725(var5, var6);
                }
            } else if (var1.method1748()) {
                var2 |= this.method1816(var1);
            }

            var1.method1779();
            return var2;
        }
    }
}
