public final class Projectile extends Renderable {

    int id;

    int plane;

    int sourceX;

    int sourceY;

    int sourceZ;

    int endHeight;

    int cycleStart;

    int cycleEnd;

    int slope;

    int startHeight;

    int targetIndex;

    boolean isMoving = false;

    double x;

    double y;

    double z;

    double speedX;

    double speedY;

    double speed;

    double speedZ;

    double accelerationZ;

    int yaw;

    int pitch;

    SequenceDefinition sequenceDefinition;

    int frame = 0;

    int frameCycle = 0;

    Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10,
            int var11) {
        this.id = var1;
        this.plane = var2;
        this.sourceX = var3;
        this.sourceY = var4;
        this.sourceZ = var5;
        this.cycleStart = var6;
        this.cycleEnd = var7;
        this.slope = var8;
        this.startHeight = var9;
        this.targetIndex = var10;
        this.endHeight = var11;
        this.isMoving = false;
        int var12 = ItemContainer.SpotAnimationDefinition_get(this.id).sequence;
        if (var12 != -1) {
            this.sequenceDefinition = ItemContainer.SequenceDefinition_get(var12);
        } else {
            this.sequenceDefinition = null;
        }

    }

    final void setDestination(int var1, int var2, int var3, int var4) {
        double var5;
        if (!this.isMoving) {
            var5 = (double) (var1 - this.sourceX);
            double var7 = (double) (var2 - this.sourceY);
            double var9 = Math.sqrt(var7 * var7 + var5 * var5);
            this.x = (double) this.sourceX + (double) this.startHeight * var5 / var9;
            this.y = (double) this.startHeight * var7 / var9 + (double) this.sourceY;
            this.z = (double) this.sourceZ;
        }

        var5 = (double) (this.cycleEnd + 1 - var4);
        this.speedX = ((double) var1 - this.x) / var5;
        this.speedY = ((double) var2 - this.y) / var5;
        this.speed = Math.sqrt(this.speedY * this.speedY + this.speedX * this.speedX);
        if (!this.isMoving) {
            this.speedZ = -this.speed * Math.tan(0.02454369D * (double) this.slope);
        }

        this.accelerationZ = 2.0D * ((double) var3 - this.z - this.speedZ * var5) / (var5 * var5);
    }

    protected final Model getModel() {
        SpotAnimationDefinition var1 = ItemContainer.SpotAnimationDefinition_get(this.id);
        Model var2 = var1.getModel(this.frame);
        if (var2 == null) {
            return null;
        } else {
            var2.rotateZ(this.pitch);
            return var2;
        }
    }

    final void advance(int var1) {
        this.isMoving = true;
        this.x += this.speedX * (double) var1;
        this.y += this.speedY * (double) var1;
        this.z += this.speedZ * (double) var1 + (double) var1 * this.accelerationZ * 0.5D * (double) var1;
        this.speedZ += this.accelerationZ * (double) var1;
        this.yaw = (int) (Math.atan2(this.speedX, this.speedY) * 325.949D) + 1024 & 2047;
        this.pitch = (int) (Math.atan2(this.speedZ, this.speed) * 325.949D) & 2047;
        if (this.sequenceDefinition != null) {
            if (!this.sequenceDefinition.isCachedModelIdSet()) {
                this.frameCycle += var1;

                while (true) {
                    do {
                        do {
                            if (this.frameCycle <= this.sequenceDefinition.frameLengths[this.frame]) {
                                return;
                            }

                            this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame];
                            ++this.frame;
                        } while (this.frame < this.sequenceDefinition.frameIds.length);

                        this.frame -= this.sequenceDefinition.frameCount;
                    } while (this.frame >= 0 && this.frame < this.sequenceDefinition.frameIds.length);

                    this.frame = 0;
                }
            } else {
                this.frame += var1;
                int var2 = this.sequenceDefinition.method1128();
                if (this.frame >= var2) {
                    this.frame = var2 - this.sequenceDefinition.frameCount;
                }
            }
        }

    }

    public static ObjTypeCustomisation method451(int var0, Buffer var1) {
        int var2 = var1.readUnsignedByte();
        boolean var3 = (var2 & 1) != 0;
        boolean var4 = (var2 & 2) != 0;
        ObjTypeCustomisation var5 = new ObjTypeCustomisation(var0);
        int var6;
        int[] var7;
        boolean var8;
        int var9;
        short var10;
        if (var3) {
            var6 = var1.readUnsignedByte();
            var7 = new int[] { var6 & 15, var6 >> 4 & 15 };
            var8 = var5.recol != null && var7.length == var5.recol.length;

            for (var9 = 0; var9 < 2; ++var9) {
                if (var7[var9] != 15) {
                    var10 = (short) var1.readUnsignedShort();
                    if (var8) {
                        var5.recol[var7[var9]] = var10;
                    }
                }
            }
        }

        if (var4) {
            var6 = var1.readUnsignedByte();
            var7 = new int[] { var6 & 15, var6 >> 4 & 15 };
            var8 = var5.retex != null && var7.length == var5.retex.length;

            for (var9 = 0; var9 < 2; ++var9) {
                if (var7[var9] != 15) {
                    var10 = (short) var1.readUnsignedShort();
                    if (var8) {
                        var5.retex[var7[var9]] = var10;
                    }
                }
            }
        }

        return var5;
    }

    static final int method452() {
        return ViewportMouse.ViewportMouse_x;
    }

    static long method450() {
        return Client.playerUUID;
    }
}
