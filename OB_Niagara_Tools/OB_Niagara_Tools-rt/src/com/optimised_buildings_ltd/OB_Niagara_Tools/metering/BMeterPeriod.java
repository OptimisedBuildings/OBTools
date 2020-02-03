package com.optimised_buildings_ltd.OB_Niagara_Tools.metering;

import javax.baja.control.trigger.BIntervalTriggerMode;
import javax.baja.control.trigger.BTimeTrigger;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.schedule.BCalendarSchedule;
import javax.baja.schedule.BDateSchedule;
import javax.baja.schedule.BTriggerSchedule;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(
        name = "count",
        type = "BInteger",
        defaultValue = "BInteger.make(0)"
)
@NiagaraProperty(
        name = "lastCount",
        type = "BInteger",
        defaultValue = "BInteger.make(0)"
)
@NiagaraAction(
        name = "reset"
)
@NiagaraAction(
        name = "increment"
)

public class BMeterPeriod extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.OB_Niagara_Tools.metering.BMeterPeriod(1308696551)1.0$ @*/
/* Generated Mon Nov 11 15:48:06 GMT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "count"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code count} property.
   * @see #getCount
   * @see #setCount
   */
  public static final Property count = newProperty(0, ((BInteger)(BInteger.make(0))).getInt(), null);
  
  /**
   * Get the {@code count} property.
   * @see #count
   */
  public int getCount() { return getInt(count); }
  
  /**
   * Set the {@code count} property.
   * @see #count
   */
  public void setCount(int v) { setInt(count, v, null); }

////////////////////////////////////////////////////////////////
// Property "lastCount"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code lastCount} property.
   * @see #getLastCount
   * @see #setLastCount
   */
  public static final Property lastCount = newProperty(0, ((BInteger)(BInteger.make(0))).getInt(), null);
  
  /**
   * Get the {@code lastCount} property.
   * @see #lastCount
   */
  public int getLastCount() { return getInt(lastCount); }
  
  /**
   * Set the {@code lastCount} property.
   * @see #lastCount
   */
  public void setLastCount(int v) { setInt(lastCount, v, null); }

////////////////////////////////////////////////////////////////
// Action "reset"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code reset} action.
   * @see #reset()
   */
  public static final Action reset = newAction(0, null);
  
  /**
   * Invoke the {@code reset} action.
   * @see #reset
   */
  public void reset() { invoke(reset, null, null); }

////////////////////////////////////////////////////////////////
// Action "increment"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code increment} action.
   * @see #increment()
   */
  public static final Action increment = newAction(0, null);
  
  /**
   * Invoke the {@code increment} action.
   * @see #increment
   */
  public void increment() { invoke(increment, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BMeterPeriod.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    public static int intervalMode = 0;
    public static int hourlyMode = 1;
    public static int dailyMode = 2;
    public static int weeklyMode = 3;
    public static int monthlyMode = 4;
    public static int yearlyMode = 5;

    public static BMeterPeriod make(BRelTime interval){
        return new BMeterPeriod(interval, intervalMode, 0, 0);
    }

    public static BMeterPeriod make(int mode, int day, int weekday){
        return new BMeterPeriod(null, mode, day, weekday);
    }

    public BMeterPeriod(){

    }

    public BMeterPeriod(BRelTime interval, int mode, int day, int weekday) {
        if(mode == 0){
            this.add("interval", new BTimeTrigger(BIntervalTriggerMode.make(interval)) );
            BTimeTrigger tt = (BTimeTrigger)this.get("interval");
            //this.add("link",this.makeLink(tt,tt.getSlot("fireTrigger"),this.getSlot("reset"),null));
        } else {
            this.add("interval", new BTriggerSchedule());
            BTriggerSchedule ts = (BTriggerSchedule) this.get("interval");
            BCalendarSchedule schedule = (BCalendarSchedule) ts.get("dates");
            schedule.add("Event", new BDateSchedule());
            BDateSchedule event = (BDateSchedule) schedule.get("Event");
            switch (mode) {
                case 1:
                    //Hourly
                    for(int i = 0; i < 24; i++) {
                        ts.addTime(i, 0);
                    }
                    break;
                case 2:
                    //Daily
                    ts.addTime(0,0);
                    break;
                case 3:
                    //Weekly
                    event.setWeekday(weekday);
                    ts.addTime(0,0);
                    break;
                case 4:
                    //Monthly
                    event.setDay(day);
                    ts.addTime(0, 0);
                    break;
                case 5:
                    //Yearly
                    event.setDay(1);
                    event.setMonth(BMonth.make(0));
                    ts.addTime(0,0);
                default:
            }
            //this.add("link", this.makeLink(ts, ts.getSlot("trigger"), this.getSlot("reset"), null));
        }
    }

    public void started(){
        //TODO CHECK NEEDED TO SEE IF LINK IS NEEDED TO BE MADE
            BComponent interval = (BComponent)this.get("interval");
            try {
                this.add("link", this.makeLink(interval, interval.getSlot("trigger"), this.getSlot("reset"), null));
            } catch (Exception e){}
    }

    public void doIncrement(){
        this.setCount(this.getCount() + 1);
    }

    public void doReset () {
        this.setLastCount(this.getCount());
        this.setCount(0);
    }


}
