package com.optimised_buildings_ltd.OB_Niagara_Tools;


import javax.baja.collection.BITable;
import javax.baja.control.BNumericPoint;
import javax.baja.control.ext.BAbstractProxyExt;
import javax.baja.driver.point.BProxyExt;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.control.trigger.BTimeTrigger;
import java.util.HashMap;

@NiagaraType
@NiagaraProperty(
        name = "enabled",
        type = "BBoolean",
        defaultValue = "BBoolean.make(false)"
)
@NiagaraProperty(
        name = "errorMargin",
        type = "BRelTime",
        defaultValue = "BRelTime.make(5)"
)
@NiagaraProperty(
        name = "retryAttempts",
        type = "BInteger",
        defaultValue = "BInteger.make(3)"
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
        facets = @Facet("BFacets.make(\"multiLine\",BBoolean.TRUE)")
)
@NiagaraProperty(
        name = "tag",
        type = "BString",
        defaultValue = "BString.make(\"\")"
)
@NiagaraProperty(
        name = "badStoresList",
        type = "BString",
        defaultValue = "BString.make(\"\")",
        facets = @Facet("BFacets.make(\"multiLine\",BBoolean.TRUE)")
)
@NiagaraAction(
        name = "findIncorrectTimes"
)
@NiagaraAction(
        name = "clearBadStores"
)



public class BTimeSyncManager extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.OB_Niagara_Tools.BTimeSyncManager(4209333724)1.0$ @*/
/* Generated Fri Nov 01 10:44:54 GMT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

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
// Property "errorMargin"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code errorMargin} property.
   * @see #getErrorMargin
   * @see #setErrorMargin
   */
  public static final Property errorMargin = newProperty(0, BRelTime.make(5), null);
  
  /**
   * Get the {@code errorMargin} property.
   * @see #errorMargin
   */
  public BRelTime getErrorMargin() { return (BRelTime)get(errorMargin); }
  
  /**
   * Set the {@code errorMargin} property.
   * @see #errorMargin
   */
  public void setErrorMargin(BRelTime v) { set(errorMargin, v, null); }

////////////////////////////////////////////////////////////////
// Property "retryAttempts"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code retryAttempts} property.
   * @see #getRetryAttempts
   * @see #setRetryAttempts
   */
  public static final Property retryAttempts = newProperty(0, ((BInteger)(BInteger.make(3))).getInt(), null);
  
  /**
   * Get the {@code retryAttempts} property.
   * @see #retryAttempts
   */
  public int getRetryAttempts() { return getInt(retryAttempts); }
  
  /**
   * Set the {@code retryAttempts} property.
   * @see #retryAttempts
   */
  public void setRetryAttempts(int v) { setInt(retryAttempts, v, null); }

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
  public static final Property console = newProperty(0, BString.make(""), BFacets.make("multiLine",BBoolean.TRUE));
  
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
// Property "badStoresList"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code badStoresList} property.
   * @see #getBadStoresList
   * @see #setBadStoresList
   */
  public static final Property badStoresList = newProperty(0, BString.make(""), BFacets.make("multiLine",BBoolean.TRUE));
  
  /**
   * Get the {@code badStoresList} property.
   * @see #badStoresList
   */
  public String getBadStoresList() { return getString(badStoresList); }
  
  /**
   * Set the {@code badStoresList} property.
   * @see #badStoresList
   */
  public void setBadStoresList(String v) { setString(badStoresList, v, null); }

////////////////////////////////////////////////////////////////
// Action "findIncorrectTimes"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code findIncorrectTimes} action.
   * @see #findIncorrectTimes()
   */
  public static final Action findIncorrectTimes = newAction(0, null);
  
  /**
   * Invoke the {@code findIncorrectTimes} action.
   * @see #findIncorrectTimes
   */
  public void findIncorrectTimes() { invoke(findIncorrectTimes, null, null); }

////////////////////////////////////////////////////////////////
// Action "clearBadStores"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code clearBadStores} action.
   * @see #clearBadStores()
   */
  public static final Action clearBadStores = newAction(0, null);
  
  /**
   * Invoke the {@code clearBadStores} action.
   * @see #clearBadStores
   */
  public void clearBadStores() { invoke(clearBadStores, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTimeSyncManager.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/



    private static final BIcon icon = BIcon.std("clock.png");
    private static HashMap<String, BRelTime> badTimeStores;
  private static HashMap<String, Integer> badStoresAttempts = new HashMap<>();
  private static HashMap<String, BAbsTime> badStores = new HashMap<>();

  private boolean isLogEnabled(){
    String bql = "station:|slot:/Services/OptimisedServices";
    BOptimisedServices os = (BOptimisedServices)BOrd.make(bql).resolve().get();
    return os.getLog();
  }

    public BIcon getIcon() {
        BValue dynamic = this.get("icon");
        return dynamic instanceof BIcon ? (BIcon)dynamic : icon;
    }

    public void doClearBadStores(){
      badStores = new HashMap<>();
    }

    public void doFindIncorrectTimes(){
      if(this.getEnabled()) {
        if(isLogEnabled()){System.out.println("[Reeves-Tech][TimeSyncManager] Beginning Time Sync...");}
        //Clear Hashmap
        badTimeStores = new HashMap<>();

        //select time masters, that are connected, and are not on failure list
        String bql = "station:|slot:/Drivers|bql:select * from TrendN4:TrendDevice where configuration.timeManagement" +
                ".enableTimeSynchronisation = true and configuration.timeManagement.timeMaster = true and parent.parent.vCncConnectionManager" +
                ".PrimarySetupVCnc.connectionState like 'Connected'";
        BITable bql_result = (BITable) BOrd.make(bql).resolve().get();
        Cursor c = bql_result.cursor();

        //Iterate through list giving time to update point values
        while (c.next()) {
          BComponent timeMaster = (BComponent) c.get();
          String neql = "station:|" + timeMaster.getSlotPath().toString() + "|neql:" + this.getTag() + "|bql:select *";
          BITable neql_result = (BITable) BOrd.make(neql).resolve().get();
          Cursor neql_c = neql_result.cursor();
          while (neql_c.next()) {
            BComponent time = (BComponent) neql_c.get();
            try {
              BProxyExt ext = (BProxyExt) time.get("proxyExt");
              //Update point
              ext.readSubscribed(null);
              //TODO THIS NEEDS TESTING
            } catch (Exception getProxyExtException) {
              setConsole(getProxyExtException.toString());
            }
          }
        }
        try {

          //This loop, update time if necessary
          Cursor d = bql_result.cursor();
          while (d.next()) {
            BComponent timeMaster = (BComponent) d.get();
            String storeName = timeMaster.getParent().getParent().getDisplayName(null);

            //Skip if store is on badStoreList
            if (badStores.containsKey(storeName)) {
              continue;
            }

            //Find time point
            String neql = "station:|" + timeMaster.getSlotPath().toString() + "|neql:" + this.getTag() + "|bql:select *";
            BITable neql_result = (BITable) BOrd.make(neql).resolve().get();
            Cursor neql_c = neql_result.cursor();
            while (neql_c.next()) {
              BNumericPoint controllerTimePoint = (BNumericPoint) neql_c.get();
              double controllerTimeValue = controllerTimePoint.getOut().getValue();
              BAbsTime now = BAbsTime.now();
              BAbsTime controllerTime = BAbsTime.make(
                      now.getYear(),
                      BMonth.make(now.getMonth().getMonthOfYear() - 1),
                      now.getDay(),
                      (int) Math.floor(controllerTimeValue),
                      (int) Math.floor(100 * (controllerTimeValue - Math.floor(controllerTimeValue)))
              );
              BRelTime timeDiff = now.delta(controllerTime);

              setConsole(storeName + "\nnow: " + now.toString() + "\ncontroller: " + controllerTime + "\ndiff: " + timeDiff + "\n");
              int minDiff = Math.abs(timeDiff.getMinutes());
              int errorMargin = getErrorMargin().getMinutes();
              int minInDay = 1440;
              boolean dayRolloverCheck = minDiff < minInDay && minDiff > (minInDay - errorMargin);
              boolean insideErrorMarginCheck = minDiff < errorMargin;
              if (!(insideErrorMarginCheck || dayRolloverCheck)){
                badTimeStores.put(storeName, timeDiff);
                if (badStoresAttempts.containsKey(storeName)) {
                  badStoresAttempts.put(storeName, badStoresAttempts.get(storeName) + 1);
                  if (badStoresAttempts.get(storeName) >= getRetryAttempts()) {
                    badStores.put(storeName, BAbsTime.now());
                    badStoresAttempts.remove(storeName);
                  }
                } else {
                  badStoresAttempts.put(storeName, 1);
                }

                BComponent timeManagement = (BComponent) ((BComponent) timeMaster.get("configuration")).get("timeManagement");
                timeManagement.invoke(timeManagement.getAction("synchroniseClock"), null);
              } else {
                if(badStoresAttempts.containsKey(storeName)){
                  badStoresAttempts.remove(storeName);
                }
              }
            }
          }
        } catch (Exception e) {
          setConsole(e.toString());
        }

        setBadStoresList(badStores.toString().replaceAll("\\{", "").replaceAll("}", "").replaceAll(", ", "\n"));
        //setConsole(getConsole() + badTimeStores.toString() + badStoresAttempts.toString());

      }
      if(isLogEnabled()){System.out.println("[Reeves-Tech][TimeSyncManager] Time Sync Complete.");}
    }

  public void started() throws Exception {
    BTimeTrigger schedule = getSchedule();
    this.add("link",this.makeLink(schedule,schedule.getSlot("fireTrigger"),this.getSlot("refreshPoints"),null),null);
  }

}
