package com.optimised_buildings_ltd.OB_Niagara_Tools;

import javax.baja.sys.BFrozenEnum;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

public final class BTagTargetType extends BFrozenEnum {
    public static final int BOOL = 0;
    public static final int NUMERIC = 1;
    public static final int ENUMERIC = 2;
    public static final int STRING = 3;
    public static final BTagTargetType bool = new BTagTargetType(0);
    public static final BTagTargetType numeric = new BTagTargetType(1);
    public static final BTagTargetType enumeric = new BTagTargetType(2);
    public static final BTagTargetType string = new BTagTargetType(3);
    public static final Type TYPE = Sys.loadType(BTagTargetType.class);
    public static final BTagTargetType DEFAULT;

    public Type getType() {
        return TYPE;
    }

    public static BTagTargetType make(int ordinal) {
        return (BTagTargetType)bool.getRange().get(ordinal, false);
    }

    public static BTagTargetType make(String tag) {
        return (BTagTargetType)bool.getRange().get(tag);
    }

    private BTagTargetType(int ordinal) {
        super(ordinal);
    }

    static {
        DEFAULT = bool;
    }
}