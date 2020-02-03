package com.optimised_buildings_ltd.OB_Niagara_Tools;

import javax.baja.collection.BITable;
import javax.baja.control.BBooleanWritable;
import javax.baja.control.BEnumWritable;
import javax.baja.control.BNumericWritable;
import javax.baja.control.BStringWritable;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.schedule.BBooleanSchedule;
import javax.baja.sys.*;
import java.util.HashMap;

@NiagaraType
@NiagaraProperty(
        name = "targetType",
        type = "BTagTargetType",
        defaultValue = "BTagTargetType.make(3)"
)
@NiagaraProperty(
        name = "value",
        type = "BString",
        defaultValue = "BString.make(\"\")"
)
@NiagaraProperty(
        name = "tag",
        type = "BString",
        defaultValue = "BString.make(\"\")"
)
@NiagaraProperty(
        name = "console",
        type = "BString",
        defaultValue = "BString.make(\"\")"
)
@NiagaraAction(
        name = "write"
)


public class BTagSetter extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.OB_Niagara_Tools.BTagSetter(2613417168)1.0$ @*/
/* Generated Fri Nov 22 15:21:11 GMT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "targetType"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code targetType} property.
   * @see #getTargetType
   * @see #setTargetType
   */
  public static final Property targetType = newProperty(0, BTagTargetType.make(3), null);
  
  /**
   * Get the {@code targetType} property.
   * @see #targetType
   */
  public BTagTargetType getTargetType() { return (BTagTargetType)get(targetType); }
  
  /**
   * Set the {@code targetType} property.
   * @see #targetType
   */
  public void setTargetType(BTagTargetType v) { set(targetType, v, null); }

////////////////////////////////////////////////////////////////
// Property "value"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code value} property.
   * @see #getValue
   * @see #setValue
   */
  public static final Property value = newProperty(0, BString.make(""), null);
  
  /**
   * Get the {@code value} property.
   * @see #value
   */
  public String getValue() { return getString(value); }
  
  /**
   * Set the {@code value} property.
   * @see #value
   */
  public void setValue(String v) { setString(value, v, null); }

////////////////////////////////////////////////////////////////
// Property "tag"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code tag} property.
   * @see #getTag
   * @see #setTag
   */
  public static final Property tag = newProperty(0, BString.make(""), null);
  
  /**
   * Get the {@code tag} property.
   * @see #tag
   */
  public String getTag() { return getString(tag); }
  
  /**
   * Set the {@code tag} property.
   * @see #tag
   */
  public void setTag(String v) { setString(tag, v, null); }

////////////////////////////////////////////////////////////////
// Property "console"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code console} property.
   * @see #getConsole
   * @see #setConsole
   */
  public static final Property console = newProperty(0, BString.make(""), null);
  
  /**
   * Get the {@code console} property.
   * @see #console
   */
  public String getConsole() { return getString(console); }
  
  /**
   * Set the {@code console} property.
   * @see #console
   */
  public void setConsole(String v) { setString(console, v, null); }

////////////////////////////////////////////////////////////////
// Action "write"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code write} action.
   * @see #write()
   */
  public static final Action write = newAction(0, null);
  
  /**
   * Invoke the {@code write} action.
   * @see #write
   */
  public void write() { invoke(write, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTagSetter.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
public BIcon getIcon() {
    BValue dynamic = this.get("icon");
    return dynamic instanceof BIcon ? (BIcon)dynamic : icon;
}
private static final BIcon icon = BIcon.std("tag.png");

public void doWrite(){
    try {
        int targetType = this.getTargetType().getEnum().getOrdinal();
        String neqlExt = "";
        String value = this.getValue().toLowerCase();
        int pointCount = 0;
        switch(targetType) {
            case 0:
                neqlExt = "BooleanWritable";
                break;
            case 1:
                neqlExt = "NumericWritable";
                break;
            case 2:
                neqlExt = "EnumWritable";
                break;
            case 3:
                neqlExt = "StringWritable";
                break;
            default:
                this.setConsole("Invalid Type");
                return;
        }

        String neql = "station:|slot:/Drivers|neql:" + this.getTag() + "|bql:select * where type like '*" + neqlExt + "*'";
        BITable result = (BITable) BOrd.make(neql).resolve().get();
        Cursor c = result.cursor();
        switch(targetType) {
            case 0:
                while(c.next()){
                    BBooleanWritable point = (BBooleanWritable)c.get();
                    point.set(BBoolean.make(value));
                    pointCount++;
                }
                break;
            case 1:
                while(c.next()){
                    BNumericWritable point = (BNumericWritable)c.get();
                    point.set(BDouble.make(value));
                    pointCount++;
                }
                break;
            case 2:
                while(c.next()){
                    BEnumWritable point = (BEnumWritable)c.get();
                    point.set(BDynamicEnum.make(Integer.parseInt(value)));
                    point.set(BDynamicEnum.make(0));
                    pointCount++;
                }
                break;
            case 3:
                while(c.next()){
                    BStringWritable point = (BStringWritable)c.get();
                    point.set(BString.make(value));
                    pointCount++;
                }
                break;
            default:
                this.setConsole("Invalid Type");
                return;

        }

        this.setConsole("Wrote " + pointCount + " points.");
    } catch (Exception e){
        this.setConsole(e.toString());
    }

}


}
