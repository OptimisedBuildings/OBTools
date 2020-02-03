package com.optimised_buildings_ltd.OB_Niagara_Tools.schmanager;

import javax.baja.nre.annotations.*;
import javax.baja.schedule.BDailySchedule;
import javax.baja.sys.*;

@NiagaraType
@NiagaraAction(
        name = "addMassEvent",
        parameterType = "BEventCreationInfo",
        defaultValue = "new BEventCreationInfo()"
)
@NiagaraAction(
        name = "addRegion",
        parameterType = "BString",
        defaultValue = "BString.make(\"\")"
)
@NiagaraAction(
        name = "removeMassEvent",
        parameterType = "BDate",
        defaultValue = "BDate.make()"
)

public class BScheduleManager extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.OB_Niagara_Tools.schmanager.BScheduleManager(2456133738)1.0$ @*/
/* Generated Wed Nov 27 10:27:45 GMT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Action "addMassEvent"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addMassEvent} action.
   * @see #addMassEvent(BEventCreationInfo parameter)
   */
  public static final Action addMassEvent = newAction(0, new BEventCreationInfo(), null);
  
  /**
   * Invoke the {@code addMassEvent} action.
   * @see #addMassEvent
   */
  public void addMassEvent(BEventCreationInfo parameter) { invoke(addMassEvent, parameter, null); }

////////////////////////////////////////////////////////////////
// Action "addRegion"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addRegion} action.
   * @see #addRegion(BString parameter)
   */
  public static final Action addRegion = newAction(0, BString.make(""), null);
  
  /**
   * Invoke the {@code addRegion} action.
   * @see #addRegion
   */
  public void addRegion(BString parameter) { invoke(addRegion, parameter, null); }

////////////////////////////////////////////////////////////////
// Action "removeMassEvent"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code removeMassEvent} action.
   * @see #removeMassEvent(BDate parameter)
   */
  public static final Action removeMassEvent = newAction(0, BDate.make(), null);
  
  /**
   * Invoke the {@code removeMassEvent} action.
   * @see #removeMassEvent
   */
  public void removeMassEvent(BDate parameter) { invoke(removeMassEvent, parameter, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BScheduleManager.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public BIcon getIcon() {
    BValue dynamic = this.get("icon");
    return dynamic instanceof BIcon ? (BIcon)dynamic : icon;
  }
  private static final BIcon icon = BIcon.std("deviceData.png");

    public void doAddMassEvent(BEventCreationInfo eventInfo){
        BComponent[] children = this.getChildComponents();
        for(BComponent child : children){
          if(child.getType().toString().contains("ScheduleRegion")){
            ((BScheduleRegion)child).addMassEvent(eventInfo);

          }
        }
    }

    public void doRemoveMassEvent(BDate date){
      BComponent[] children = this.getChildComponents();
      for(BComponent child : children){
        if(child.getType().toString().contains("ScheduleRegion")){
          ((BScheduleRegion)child).removeMassEvent(date);
        }
      }
    }

    public void doAddRegion(BString regionName){
      this.add(regionName.getString(), new BScheduleRegion());
    }

}
