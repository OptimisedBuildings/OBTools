package com.optimised_buildings_ltd.OB_Niagara_Tools.metering;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(
        name = "hourlyMeter",
        type = "BMeterPeriod",
        defaultValue = "BMeterPeriod.make(BMeterPeriod.hourlyMode, 1, 0)",
        flags = Flags.HIDDEN
)
@NiagaraProperty(
        name = "dailyMeter",
        type = "BMeterPeriod",
        defaultValue = "BMeterPeriod.make(BMeterPeriod.dailyMode, 1, 0)",
        flags = Flags.HIDDEN
)
@NiagaraProperty(
        name = "weeklyMeter",
        type = "BMeterPeriod",
        defaultValue = "BMeterPeriod.make(BMeterPeriod.weeklyMode, 1, 1)",
        flags = Flags.HIDDEN
)
@NiagaraProperty(
        name = "monthlyMeter",
        type = "BMeterPeriod",
        defaultValue = "BMeterPeriod.make(BMeterPeriod.monthlyMode, 1, 0)",
        flags = Flags.HIDDEN
)
@NiagaraProperty(
        name = "yearlyMeter",
        type = "BMeterPeriod",
        defaultValue = "BMeterPeriod.make(BMeterPeriod.yearlyMode, 1, 0)",
        flags = Flags.HIDDEN
)
@NiagaraAction(
        name = "pulse"
)
@NiagaraAction(
        name = "resetAll"
)



public class BOptimisedMeter extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.OB_Niagara_Tools.metering.BOptimisedMeter(3452409606)1.0$ @*/
/* Generated Mon Nov 11 14:08:11 GMT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "hourlyMeter"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code hourlyMeter} property.
   * @see #getHourlyMeter
   * @see #setHourlyMeter
   */
  public static final Property hourlyMeter = newProperty(Flags.HIDDEN, BMeterPeriod.make(BMeterPeriod.hourlyMode, 1, 0), null);
  
  /**
   * Get the {@code hourlyMeter} property.
   * @see #hourlyMeter
   */
  public BMeterPeriod getHourlyMeter() { return (BMeterPeriod)get(hourlyMeter); }
  
  /**
   * Set the {@code hourlyMeter} property.
   * @see #hourlyMeter
   */
  public void setHourlyMeter(BMeterPeriod v) { set(hourlyMeter, v, null); }

////////////////////////////////////////////////////////////////
// Property "dailyMeter"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code dailyMeter} property.
   * @see #getDailyMeter
   * @see #setDailyMeter
   */
  public static final Property dailyMeter = newProperty(Flags.HIDDEN, BMeterPeriod.make(BMeterPeriod.dailyMode, 1, 0), null);
  
  /**
   * Get the {@code dailyMeter} property.
   * @see #dailyMeter
   */
  public BMeterPeriod getDailyMeter() { return (BMeterPeriod)get(dailyMeter); }
  
  /**
   * Set the {@code dailyMeter} property.
   * @see #dailyMeter
   */
  public void setDailyMeter(BMeterPeriod v) { set(dailyMeter, v, null); }

////////////////////////////////////////////////////////////////
// Property "weeklyMeter"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code weeklyMeter} property.
   * @see #getWeeklyMeter
   * @see #setWeeklyMeter
   */
  public static final Property weeklyMeter = newProperty(Flags.HIDDEN, BMeterPeriod.make(BMeterPeriod.weeklyMode, 1, 1), null);
  
  /**
   * Get the {@code weeklyMeter} property.
   * @see #weeklyMeter
   */
  public BMeterPeriod getWeeklyMeter() { return (BMeterPeriod)get(weeklyMeter); }
  
  /**
   * Set the {@code weeklyMeter} property.
   * @see #weeklyMeter
   */
  public void setWeeklyMeter(BMeterPeriod v) { set(weeklyMeter, v, null); }

////////////////////////////////////////////////////////////////
// Property "monthlyMeter"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code monthlyMeter} property.
   * @see #getMonthlyMeter
   * @see #setMonthlyMeter
   */
  public static final Property monthlyMeter = newProperty(Flags.HIDDEN, BMeterPeriod.make(BMeterPeriod.monthlyMode, 1, 0), null);
  
  /**
   * Get the {@code monthlyMeter} property.
   * @see #monthlyMeter
   */
  public BMeterPeriod getMonthlyMeter() { return (BMeterPeriod)get(monthlyMeter); }
  
  /**
   * Set the {@code monthlyMeter} property.
   * @see #monthlyMeter
   */
  public void setMonthlyMeter(BMeterPeriod v) { set(monthlyMeter, v, null); }

////////////////////////////////////////////////////////////////
// Property "yearlyMeter"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code yearlyMeter} property.
   * @see #getYearlyMeter
   * @see #setYearlyMeter
   */
  public static final Property yearlyMeter = newProperty(Flags.HIDDEN, BMeterPeriod.make(BMeterPeriod.yearlyMode, 1, 0), null);
  
  /**
   * Get the {@code yearlyMeter} property.
   * @see #yearlyMeter
   */
  public BMeterPeriod getYearlyMeter() { return (BMeterPeriod)get(yearlyMeter); }
  
  /**
   * Set the {@code yearlyMeter} property.
   * @see #yearlyMeter
   */
  public void setYearlyMeter(BMeterPeriod v) { set(yearlyMeter, v, null); }

////////////////////////////////////////////////////////////////
// Action "pulse"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code pulse} action.
   * @see #pulse()
   */
  public static final Action pulse = newAction(0, null);
  
  /**
   * Invoke the {@code pulse} action.
   * @see #pulse
   */
  public void pulse() { invoke(pulse, null, null); }

////////////////////////////////////////////////////////////////
// Action "resetAll"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code resetAll} action.
   * @see #resetAll()
   */
  public static final Action resetAll = newAction(0, null);
  
  /**
   * Invoke the {@code resetAll} action.
   * @see #resetAll
   */
  public void resetAll() { invoke(resetAll, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BOptimisedMeter.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public void started(){
        for(BComponent child : this.getChildComponents()){
                if (child.getType() == BMeterPeriod.TYPE) {
                    String childName = child.getName().substring(0, child.getName().length() - 5);
                    this.add(childName, BInteger.make(0), Flags.READONLY | Flags.SUMMARY);
                    this.add(childName + "_link", this.makeLink(child, child.getSlot("count"), this.getSlot(childName), null));
                }
        }
    }

    public void doPulse(){
        for(BComponent child : this.getChildComponents()){
            if(child.getType() == BMeterPeriod.TYPE){
                ((BMeterPeriod)child).increment();
            }
        }
    }

    public void doResetAll(){
        for(BComponent child : this.getChildComponents()){
            if(child.getType() == BMeterPeriod.TYPE){
                ((BMeterPeriod)child).reset();
            }
        }
    }

    private static final BIcon icon = BIcon.std("calculator.png");
    public BIcon getIcon() {
        BValue dynamic = this.get("icon");
        return dynamic instanceof BIcon ? (BIcon)dynamic : icon;
    }


}
