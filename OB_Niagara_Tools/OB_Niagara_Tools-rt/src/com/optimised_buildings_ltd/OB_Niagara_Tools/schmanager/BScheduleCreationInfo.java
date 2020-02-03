package com.optimised_buildings_ltd.OB_Niagara_Tools.schmanager;


import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.util.BTimeRange;


@NiagaraType
@NiagaraProperty(
        name = "scheduleName",
        type = "BString",
        defaultValue = "BString.make(\"\")"
)
@NiagaraProperty(
        name = "monToFriTimes",
        type = "BTimeRange",
        defaultValue = "new BTimeRange(BTime.make(9,0,0),BTime.make(17,0,0))"
)
@NiagaraProperty(
        name = "satTimes",
        type = "BTimeRange",
        defaultValue = "new BTimeRange(BTime.make(9,0,0),BTime.make(17,0,0))"
)
@NiagaraProperty(
        name = "sunTimes",
        type = "BTimeRange",
        defaultValue = "new BTimeRange(BTime.make(9,0,0),BTime.make(17,0,0))"
)

public class BScheduleCreationInfo extends BComponent{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.OB_Niagara_Tools.schmanager.BScheduleCreationInfo(1566870122)1.0$ @*/
/* Generated Wed Nov 27 10:27:24 GMT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "scheduleName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code scheduleName} property.
   * @see #getScheduleName
   * @see #setScheduleName
   */
  public static final Property scheduleName = newProperty(0, BString.make(""), null);
  
  /**
   * Get the {@code scheduleName} property.
   * @see #scheduleName
   */
  public String getScheduleName() { return getString(scheduleName); }
  
  /**
   * Set the {@code scheduleName} property.
   * @see #scheduleName
   */
  public void setScheduleName(String v) { setString(scheduleName, v, null); }

////////////////////////////////////////////////////////////////
// Property "monToFriTimes"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code monToFriTimes} property.
   * @see #getMonToFriTimes
   * @see #setMonToFriTimes
   */
  public static final Property monToFriTimes = newProperty(0, new BTimeRange(BTime.make(9,0,0),BTime.make(17,0,0)), null);
  
  /**
   * Get the {@code monToFriTimes} property.
   * @see #monToFriTimes
   */
  public BTimeRange getMonToFriTimes() { return (BTimeRange)get(monToFriTimes); }
  
  /**
   * Set the {@code monToFriTimes} property.
   * @see #monToFriTimes
   */
  public void setMonToFriTimes(BTimeRange v) { set(monToFriTimes, v, null); }

////////////////////////////////////////////////////////////////
// Property "satTimes"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code satTimes} property.
   * @see #getSatTimes
   * @see #setSatTimes
   */
  public static final Property satTimes = newProperty(0, new BTimeRange(BTime.make(9,0,0),BTime.make(17,0,0)), null);
  
  /**
   * Get the {@code satTimes} property.
   * @see #satTimes
   */
  public BTimeRange getSatTimes() { return (BTimeRange)get(satTimes); }
  
  /**
   * Set the {@code satTimes} property.
   * @see #satTimes
   */
  public void setSatTimes(BTimeRange v) { set(satTimes, v, null); }

////////////////////////////////////////////////////////////////
// Property "sunTimes"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code sunTimes} property.
   * @see #getSunTimes
   * @see #setSunTimes
   */
  public static final Property sunTimes = newProperty(0, new BTimeRange(BTime.make(9,0,0),BTime.make(17,0,0)), null);
  
  /**
   * Get the {@code sunTimes} property.
   * @see #sunTimes
   */
  public BTimeRange getSunTimes() { return (BTimeRange)get(sunTimes); }
  
  /**
   * Set the {@code sunTimes} property.
   * @see #sunTimes
   */
  public void setSunTimes(BTimeRange v) { set(sunTimes, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BScheduleCreationInfo.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

}
