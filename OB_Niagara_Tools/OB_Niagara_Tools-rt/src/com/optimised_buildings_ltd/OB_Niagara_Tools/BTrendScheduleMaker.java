package com.optimised_buildings_ltd.OB_Niagara_Tools;




import com.honeywell.trend.driver.core.schedule.BTrendScheduleExport;
import com.honeywell.trend.driver.core.schedule.BTrendScheduleImport;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.schedule.BBooleanSchedule;
import javax.baja.sys.*;
import javax.baja.util.BFormat;

@NiagaraType
@NiagaraProperty(
        name = "targetFolder",
        type = "BOrd",
        defaultValue = "BOrd.make(\"\")"
)
@NiagaraProperty(
        name = "console",
        type = "BString",
        defaultValue = "BString.make(\"\")"
)
@NiagaraAction(
        name = "createSchedule"
)
@NiagaraProperty(
        name = "itemNumber",
        type = "BInteger",
        defaultValue = "BInteger.make(1)"
)
@NiagaraProperty(
        name = "desiredDisplayName",
        type = "BString",
        defaultValue = "BString.make(\"\")"
)

public class BTrendScheduleMaker extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.OB_Niagara_Tools.BTrendScheduleMaker(3427222128)1.0$ @*/
/* Generated Tue Nov 05 10:25:19 GMT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "targetFolder"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code targetFolder} property.
   * @see #getTargetFolder
   * @see #setTargetFolder
   */
  public static final Property targetFolder = newProperty(0, BOrd.make(""), null);
  
  /**
   * Get the {@code targetFolder} property.
   * @see #targetFolder
   */
  public BOrd getTargetFolder() { return (BOrd)get(targetFolder); }
  
  /**
   * Set the {@code targetFolder} property.
   * @see #targetFolder
   */
  public void setTargetFolder(BOrd v) { set(targetFolder, v, null); }

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
// Property "itemNumber"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code itemNumber} property.
   * @see #getItemNumber
   * @see #setItemNumber
   */
  public static final Property itemNumber = newProperty(0, ((BInteger)(BInteger.make(1))).getInt(), null);
  
  /**
   * Get the {@code itemNumber} property.
   * @see #itemNumber
   */
  public int getItemNumber() { return getInt(itemNumber); }
  
  /**
   * Set the {@code itemNumber} property.
   * @see #itemNumber
   */
  public void setItemNumber(int v) { setInt(itemNumber, v, null); }

////////////////////////////////////////////////////////////////
// Property "desiredDisplayName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code desiredDisplayName} property.
   * @see #getDesiredDisplayName
   * @see #setDesiredDisplayName
   */
  public static final Property desiredDisplayName = newProperty(0, BString.make(""), null);
  
  /**
   * Get the {@code desiredDisplayName} property.
   * @see #desiredDisplayName
   */
  public String getDesiredDisplayName() { return getString(desiredDisplayName); }
  
  /**
   * Set the {@code desiredDisplayName} property.
   * @see #desiredDisplayName
   */
  public void setDesiredDisplayName(String v) { setString(desiredDisplayName, v, null); }

////////////////////////////////////////////////////////////////
// Action "createSchedule"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code createSchedule} action.
   * @see #createSchedule()
   */
  public static final Action createSchedule = newAction(0, null);
  
  /**
   * Invoke the {@code createSchedule} action.
   * @see #createSchedule
   */
  public void createSchedule() { invoke(createSchedule, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrendScheduleMaker.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public void doCreateSchedule(){
        setConsole("");
        BComponent scheduleFolder = (BComponent)getTargetFolder().resolve().get();

        //Check inputs are valid
        if(!scheduleFolder.getDisplayName(null).contains("Schedules")){
            setConsole("Target Invalid");
            return;
        }
        try{
            //Add Import Schedule, it's extension and set the item number
            //TODO Test whether the extra bits need adding to the extension
            String importName = "Z000" + this.getItemNumber() + "_IMP";
            scheduleFolder.add(importName, new BBooleanSchedule());
            scheduleFolder.setDisplayName(scheduleFolder.getProperty(importName), BFormat.make(this.getDesiredDisplayName()),null);
            BBooleanSchedule importSchedule = (BBooleanSchedule)scheduleFolder.get(importName);
            importSchedule.add("ext", new BTrendScheduleImport());
            BTrendScheduleImport ext = (BTrendScheduleImport)importSchedule.get("ext");
            ext.setItemNumber(this.getItemNumber());

            //Add Export schedule and set the item number
            String exportName = "Z000" + this.getItemNumber() + "_EXP";
            scheduleFolder.add(exportName, new BTrendScheduleExport());
            scheduleFolder.setDisplayName(scheduleFolder.getProperty(exportName), BFormat.make(this.getDesiredDisplayName()),null);
            BTrendScheduleExport scheduleExport = (BTrendScheduleExport)scheduleFolder.get(exportName);
            scheduleExport.setItemNumber(this.getItemNumber());

        } catch (Exception e){setConsole(e.toString());}

    }

    private static final BIcon icon = BIcon.std("schedule.png");
    public BIcon getIcon() {
        BValue dynamic = this.get("icon");
        return dynamic instanceof BIcon ? (BIcon)dynamic : icon;
    }
}
