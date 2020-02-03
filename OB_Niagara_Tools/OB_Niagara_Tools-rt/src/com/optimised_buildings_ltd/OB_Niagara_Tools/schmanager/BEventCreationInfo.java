package com.optimised_buildings_ltd.OB_Niagara_Tools.schmanager;

import javax.baja.nre.annotations.*;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(
        name = "eventName",
        type = "BString",
        defaultValue = "BString.make(\"Event\")"
)
@NiagaraProperty(
        name = "eventState",
        type = "BBoolean",
        defaultValue = "BBoolean.make(false)"
)
@NiagaraProperty(
        name = "addInvertedPeriods",
        type = "BBoolean",
        defaultValue = "BBoolean.make(false)"
)
@NiagaraProperty(
        name = "day",
        type = "BInteger",
        defaultValue = "BInteger.make(1)"
)
@NiagaraProperty(
        name = "month",
        type = "BInteger",
        defaultValue = "BInteger.make(1)"
)
@NiagaraProperty(
        name = "year",
        type = "BInteger",
        defaultValue = "BInteger.make(1970)"
)
@NiagaraProperty(
        name = "startTime",
        type = "BTime",
        defaultValue = "BTime.make(9,0,0)"
)
@NiagaraProperty(
        name = "endTime",
        type = "BTime",
        defaultValue = "BTime.make(17,0,0)"
)

public class BEventCreationInfo extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.OB_Niagara_Tools.schmanager.BEventCreationInfo(3422295740)1.0$ @*/
/* Generated Wed Nov 27 10:27:24 GMT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "eventName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code eventName} property.
   * @see #getEventName
   * @see #setEventName
   */
  public static final Property eventName = newProperty(0, BString.make("Event"), null);
  
  /**
   * Get the {@code eventName} property.
   * @see #eventName
   */
  public String getEventName() { return getString(eventName); }
  
  /**
   * Set the {@code eventName} property.
   * @see #eventName
   */
  public void setEventName(String v) { setString(eventName, v, null); }

////////////////////////////////////////////////////////////////
// Property "eventState"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code eventState} property.
   * @see #getEventState
   * @see #setEventState
   */
  public static final Property eventState = newProperty(0, ((BBoolean)(BBoolean.make(false))).getBoolean(), null);
  
  /**
   * Get the {@code eventState} property.
   * @see #eventState
   */
  public boolean getEventState() { return getBoolean(eventState); }
  
  /**
   * Set the {@code eventState} property.
   * @see #eventState
   */
  public void setEventState(boolean v) { setBoolean(eventState, v, null); }

////////////////////////////////////////////////////////////////
// Property "addInvertedPeriods"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addInvertedPeriods} property.
   * @see #getAddInvertedPeriods
   * @see #setAddInvertedPeriods
   */
  public static final Property addInvertedPeriods = newProperty(0, ((BBoolean)(BBoolean.make(false))).getBoolean(), null);
  
  /**
   * Get the {@code addInvertedPeriods} property.
   * @see #addInvertedPeriods
   */
  public boolean getAddInvertedPeriods() { return getBoolean(addInvertedPeriods); }
  
  /**
   * Set the {@code addInvertedPeriods} property.
   * @see #addInvertedPeriods
   */
  public void setAddInvertedPeriods(boolean v) { setBoolean(addInvertedPeriods, v, null); }

////////////////////////////////////////////////////////////////
// Property "day"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code day} property.
   * @see #getDay
   * @see #setDay
   */
  public static final Property day = newProperty(0, ((BInteger)(BInteger.make(1))).getInt(), null);
  
  /**
   * Get the {@code day} property.
   * @see #day
   */
  public int getDay() { return getInt(day); }
  
  /**
   * Set the {@code day} property.
   * @see #day
   */
  public void setDay(int v) { setInt(day, v, null); }

////////////////////////////////////////////////////////////////
// Property "month"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code month} property.
   * @see #getMonth
   * @see #setMonth
   */
  public static final Property month = newProperty(0, ((BInteger)(BInteger.make(1))).getInt(), null);
  
  /**
   * Get the {@code month} property.
   * @see #month
   */
  public int getMonth() { return getInt(month); }
  
  /**
   * Set the {@code month} property.
   * @see #month
   */
  public void setMonth(int v) { setInt(month, v, null); }

////////////////////////////////////////////////////////////////
// Property "year"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code year} property.
   * @see #getYear
   * @see #setYear
   */
  public static final Property year = newProperty(0, ((BInteger)(BInteger.make(1970))).getInt(), null);
  
  /**
   * Get the {@code year} property.
   * @see #year
   */
  public int getYear() { return getInt(year); }
  
  /**
   * Set the {@code year} property.
   * @see #year
   */
  public void setYear(int v) { setInt(year, v, null); }

////////////////////////////////////////////////////////////////
// Property "startTime"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code startTime} property.
   * @see #getStartTime
   * @see #setStartTime
   */
  public static final Property startTime = newProperty(0, BTime.make(9,0,0), null);
  
  /**
   * Get the {@code startTime} property.
   * @see #startTime
   */
  public BTime getStartTime() { return (BTime)get(startTime); }
  
  /**
   * Set the {@code startTime} property.
   * @see #startTime
   */
  public void setStartTime(BTime v) { set(startTime, v, null); }

////////////////////////////////////////////////////////////////
// Property "endTime"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code endTime} property.
   * @see #getEndTime
   * @see #setEndTime
   */
  public static final Property endTime = newProperty(0, BTime.make(17,0,0), null);
  
  /**
   * Get the {@code endTime} property.
   * @see #endTime
   */
  public BTime getEndTime() { return (BTime)get(endTime); }
  
  /**
   * Set the {@code endTime} property.
   * @see #endTime
   */
  public void setEndTime(BTime v) { set(endTime, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BEventCreationInfo.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
