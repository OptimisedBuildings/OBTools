package com.optimised_buildings_ltd.OB_Niagara_Tools;

import com.optimised_buildings_ltd.OB_Niagara_Tools.metering.BOptimisedMeter;
import com.optimised_buildings_ltd.OB_Niagara_Tools.schmanager.BScheduleManager;
import com.tridium.history.BHistory;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.util.BFolder;

@NiagaraType
@NiagaraProperty(
        name = "log",
        type = "BBoolean",
        defaultValue = "BBoolean.make(true)"
)
@NiagaraAction(
        name = "addHistoryIdSetter",
        parameterType = "BString",
        defaultValue = "BString.make(\"\")"
)
@NiagaraAction(
        name = "addOptimisedMeter",
        parameterType = "BString",
        defaultValue = "BString.make(\"\")"
)
@NiagaraAction(
        name = "addPointRefresher",
        parameterType = "BString",
        defaultValue = "BString.make(\"\")"
)
@NiagaraAction(
        name = "addScheduleManager",
        parameterType = "BString",
        defaultValue = "BString.make(\"\")"
)
@NiagaraAction(
        name = "addTagSetter",
        parameterType = "BString",
        defaultValue = "BString.make(\"\")"
)
@NiagaraAction(
        name = "addTimeSyncManager",
        parameterType = "BString",
        defaultValue = "BString.make(\"\")"
)
@NiagaraAction(
        name = "addTrendScheduleMaker",
        parameterType = "BString",
        defaultValue = "BString.make(\"\")"
)
@NiagaraAction(
        name = "addTriadEmailDecoder",
        parameterType = "BString",
        defaultValue = "BString.make(\"\")"
)



public class BOptimisedServices extends BComponent {
    private static final BIcon icon = BIcon.std("alignBottom.png");

/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.OB_Niagara_Tools.BOptimisedServices(841723741)1.0$ @*/
/* Generated Mon Nov 25 14:09:39 GMT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "log"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code log} property.
   * @see #getLog
   * @see #setLog
   */
  public static final Property log = newProperty(0, ((BBoolean)(BBoolean.make(true))).getBoolean(), null);
  
  /**
   * Get the {@code log} property.
   * @see #log
   */
  public boolean getLog() { return getBoolean(log); }
  
  /**
   * Set the {@code log} property.
   * @see #log
   */
  public void setLog(boolean v) { setBoolean(log, v, null); }

////////////////////////////////////////////////////////////////
// Action "addHistoryIdSetter"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addHistoryIdSetter} action.
   * @see #addHistoryIdSetter(BString parameter)
   */
  public static final Action addHistoryIdSetter = newAction(0, BString.make(""), null);
  
  /**
   * Invoke the {@code addHistoryIdSetter} action.
   * @see #addHistoryIdSetter
   */
  public void addHistoryIdSetter(BString parameter) { invoke(addHistoryIdSetter, parameter, null); }

////////////////////////////////////////////////////////////////
// Action "addOptimisedMeter"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addOptimisedMeter} action.
   * @see #addOptimisedMeter(BString parameter)
   */
  public static final Action addOptimisedMeter = newAction(0, BString.make(""), null);
  
  /**
   * Invoke the {@code addOptimisedMeter} action.
   * @see #addOptimisedMeter
   */
  public void addOptimisedMeter(BString parameter) { invoke(addOptimisedMeter, parameter, null); }

////////////////////////////////////////////////////////////////
// Action "addPointRefresher"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addPointRefresher} action.
   * @see #addPointRefresher(BString parameter)
   */
  public static final Action addPointRefresher = newAction(0, BString.make(""), null);
  
  /**
   * Invoke the {@code addPointRefresher} action.
   * @see #addPointRefresher
   */
  public void addPointRefresher(BString parameter) { invoke(addPointRefresher, parameter, null); }

////////////////////////////////////////////////////////////////
// Action "addScheduleManager"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addScheduleManager} action.
   * @see #addScheduleManager(BString parameter)
   */
  public static final Action addScheduleManager = newAction(0, BString.make(""), null);
  
  /**
   * Invoke the {@code addScheduleManager} action.
   * @see #addScheduleManager
   */
  public void addScheduleManager(BString parameter) { invoke(addScheduleManager, parameter, null); }

////////////////////////////////////////////////////////////////
// Action "addTagSetter"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addTagSetter} action.
   * @see #addTagSetter(BString parameter)
   */
  public static final Action addTagSetter = newAction(0, BString.make(""), null);
  
  /**
   * Invoke the {@code addTagSetter} action.
   * @see #addTagSetter
   */
  public void addTagSetter(BString parameter) { invoke(addTagSetter, parameter, null); }

////////////////////////////////////////////////////////////////
// Action "addTimeSyncManager"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addTimeSyncManager} action.
   * @see #addTimeSyncManager(BString parameter)
   */
  public static final Action addTimeSyncManager = newAction(0, BString.make(""), null);
  
  /**
   * Invoke the {@code addTimeSyncManager} action.
   * @see #addTimeSyncManager
   */
  public void addTimeSyncManager(BString parameter) { invoke(addTimeSyncManager, parameter, null); }

////////////////////////////////////////////////////////////////
// Action "addTrendScheduleMaker"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addTrendScheduleMaker} action.
   * @see #addTrendScheduleMaker(BString parameter)
   */
  public static final Action addTrendScheduleMaker = newAction(0, BString.make(""), null);
  
  /**
   * Invoke the {@code addTrendScheduleMaker} action.
   * @see #addTrendScheduleMaker
   */
  public void addTrendScheduleMaker(BString parameter) { invoke(addTrendScheduleMaker, parameter, null); }

////////////////////////////////////////////////////////////////
// Action "addTriadEmailDecoder"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addTriadEmailDecoder} action.
   * @see #addTriadEmailDecoder(BString parameter)
   */
  public static final Action addTriadEmailDecoder = newAction(0, BString.make(""), null);
  
  /**
   * Invoke the {@code addTriadEmailDecoder} action.
   * @see #addTriadEmailDecoder
   */
  public void addTriadEmailDecoder(BString parameter) { invoke(addTriadEmailDecoder, parameter, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BOptimisedServices.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
public BIcon getIcon() {
    BValue dynamic = this.get("icon");
    return dynamic instanceof BIcon ? (BIcon)dynamic : icon;
}
    public void doAddHistoryIdSetter(BString itemName){
        this.add(itemName.getString(), new BHistoryIDSetter());
    }

    public void doAddOptimisedMeter(BString itemName){
        this.add(itemName.getString(), new BOptimisedMeter());
    }

    public void doAddPointRefresher(BString itemName){
        this.add(itemName.getString(), new BPointRefresher());
    }

    public void doAddScheduleManager(BString itemName){
        this.add(itemName.getString(), new BScheduleManager());
    }

    public void doAddTagSetter(BString itemName){
        this.add(itemName.getString(), new BTagSetter());
    }

    public void doAddTimeSyncManager(BString itemName){
        this.add(itemName.getString(), new BTimeSyncManager());
    }

    public void doAddTrendScheduleMaker(BString itemName){
        this.add(itemName.getString(), new BTrendScheduleMaker());
    }

    public void doAddTriadEmailDecoder(BString itemName){
        this.add(itemName.getString(), new BTriadEmailDecoder());
    }

}
