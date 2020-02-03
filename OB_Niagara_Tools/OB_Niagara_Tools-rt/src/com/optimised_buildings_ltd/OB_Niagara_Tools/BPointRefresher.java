package com.optimised_buildings_ltd.OB_Niagara_Tools;

import javax.baja.collection.BITable;
import javax.baja.control.BControlPoint;
import javax.baja.control.trigger.BTimeTrigger;
import javax.baja.driver.point.BProxyExt;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(
        name = "enabled",
        type = "BBoolean",
        defaultValue = "BBoolean.make(false)"
)
@NiagaraProperty(
        name = "bql",
        type = "BOrd",
        defaultValue = "BOrd.make(\"station:|slot:/|bql:select * from baja:Component where parent.displayName = 'Points'\")"
)
@NiagaraAction(
        name = "refreshPoints"
)
@NiagaraProperty(
        name = "schedule",
        type = "BTimeTrigger",
        defaultValue = "new BTimeTrigger()"
)
@NiagaraProperty(
        name = "console",
        type = "BString",
        defaultValue = "BString.make(\"\")",
        flags = Flags.READONLY
)

public class BPointRefresher extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.OB_Niagara_Tools.BPointRefresher(1717787689)1.0$ @*/
/* Generated Thu Dec 05 15:17:49 GMT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "enabled"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code enabled} property.
   * @see #getEnabled
   * @see #setEnabled
   */
  public static final Property enabled = newProperty(0, ((BBoolean)(BBoolean.make(false))).getBoolean(), null);
  
  /**
   * Get the {@code enabled} property.
   * @see #enabled
   */
  public boolean getEnabled() { return getBoolean(enabled); }
  
  /**
   * Set the {@code enabled} property.
   * @see #enabled
   */
  public void setEnabled(boolean v) { setBoolean(enabled, v, null); }

////////////////////////////////////////////////////////////////
// Property "bql"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code bql} property.
   * @see #getBql
   * @see #setBql
   */
  public static final Property bql = newProperty(0, BOrd.make("station:|slot:/|bql:select * from baja:Component where parent.displayName = 'Points'"), null);
  
  /**
   * Get the {@code bql} property.
   * @see #bql
   */
  public BOrd getBql() { return (BOrd)get(bql); }
  
  /**
   * Set the {@code bql} property.
   * @see #bql
   */
  public void setBql(BOrd v) { set(bql, v, null); }

////////////////////////////////////////////////////////////////
// Property "schedule"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code schedule} property.
   * @see #getSchedule
   * @see #setSchedule
   */
  public static final Property schedule = newProperty(0, new BTimeTrigger(), null);
  
  /**
   * Get the {@code schedule} property.
   * @see #schedule
   */
  public BTimeTrigger getSchedule() { return (BTimeTrigger)get(schedule); }
  
  /**
   * Set the {@code schedule} property.
   * @see #schedule
   */
  public void setSchedule(BTimeTrigger v) { set(schedule, v, null); }

////////////////////////////////////////////////////////////////
// Property "console"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code console} property.
   * @see #getConsole
   * @see #setConsole
   */
  public static final Property console = newProperty(Flags.READONLY, BString.make(""), null);
  
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
// Action "refreshPoints"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code refreshPoints} action.
   * @see #refreshPoints()
   */
  public static final Action refreshPoints = newAction(0, null);
  
  /**
   * Invoke the {@code refreshPoints} action.
   * @see #refreshPoints
   */
  public void refreshPoints() { invoke(refreshPoints, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BPointRefresher.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    private boolean isLogEnabled(){
        String bql = "station:|slot:/Services/OptimisedServices";
        BOptimisedServices os = (BOptimisedServices)BOrd.make(bql).resolve().get();
        return os.getLog();
    }

public void doRefreshPoints(){
    if(isLogEnabled()){System.out.println("[Reeves-Tech][PointRefresh] Beginning points refresh....");}
    this.setConsole("Beginning points refresh...");
    int pointCount = 0;
    BITable result = (BITable)getBql().resolve().get();
    Cursor c = result.cursor();
    while(c.next()){
        try{
            //Based on false inheritance. Might break in the future
            BControlPoint point = (BControlPoint)c.get();
            BProxyExt ext = (BProxyExt)point.get("proxyExt");
            ext.readSubscribed(null);
            pointCount++;
        } catch (Exception e){
            this.setConsole(e.toString());
        }
    }
    if(isLogEnabled()){System.out.println("[Reeves-Tech][PointRefresh] Point refresh complete. " + pointCount + " points refreshed");}
    this.setConsole("Point refresh complete. " + pointCount + " points refreshed");
}
    public BIcon getIcon() {
        BValue dynamic = this.get("icon");
        return dynamic instanceof BIcon ? (BIcon)dynamic : icon;
    }

    private static final BIcon icon = BIcon.std("refresh.png");

    public void started() throws Exception {
        BTimeTrigger schedule = getSchedule();
        this.add("link",this.makeLink(schedule,schedule.getSlot("fireTrigger"),this.getSlot("refreshPoints"),null),null);
    }

}
