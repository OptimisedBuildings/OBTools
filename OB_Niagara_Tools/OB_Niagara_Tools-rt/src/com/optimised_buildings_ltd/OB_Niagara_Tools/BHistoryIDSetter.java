package com.optimised_buildings_ltd.OB_Niagara_Tools;

import javax.baja.agent.BPxView;
import javax.baja.collection.BITable;
import javax.baja.history.BHistoryId;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.util.BFormat;

import static javax.baja.naming.BOrd.*;

@NiagaraType
@NiagaraProperty(
        name = "console",
        type = "BString",
        defaultValue = "BString.make(\"\")"
)
@NiagaraAction(
        name = "fixHistories"
)
@NiagaraAction(
        name = "fixLans"
)

public class BHistoryIDSetter extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.OB_Niagara_Tools.BHistoryIDSetter(1497590394)1.0$ @*/
/* Generated Fri Nov 01 14:00:47 GMT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

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
// Action "fixHistories"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code fixHistories} action.
   * @see #fixHistories()
   */
  public static final Action fixHistories = newAction(0, null);
  
  /**
   * Invoke the {@code fixHistories} action.
   * @see #fixHistories
   */
  public void fixHistories() { invoke(fixHistories, null, null); }

////////////////////////////////////////////////////////////////
// Action "fixLans"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code fixLans} action.
   * @see #fixLans()
   */
  public static final Action fixLans = newAction(0, null);
  
  /**
   * Invoke the {@code fixLans} action.
   * @see #fixLans
   */
  public void fixLans() { invoke(fixLans, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BHistoryIDSetter.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public void doFixLans(){
        this.setConsole("Beginning Lan scan...");
        Cursor c = ((BITable)BOrd.make("station:|slot:/Drivers|bql:select * from TrendN4:TrendLan").resolve().get()).cursor();
        int lansFound = 0; int lansFixed = 0;
        while(c.next()){
            try{
                lansFound++;
                BComponent lan = (BComponent)c.get();
                int oldLan = ((BInteger)lan.get("lanAddress")).getInt();
                lan.set("lanAddress",BInteger.make(Integer.parseInt(lan.getDisplayName(null).substring(1,4))));
                int newLan = ((BInteger)lan.get("lanAddress")).getInt();
                if(oldLan != newLan){lansFixed++;}
            } catch (Exception e){}
        }
        setConsole("Finished. Found " + lansFound + " lans. Fixed " + lansFixed + ".");
    }

    public void doFixHistories(){
        this.setConsole("Beginning history scan...");
        int historiesFound = 0; int historiesFixed = 0;
        Cursor c = ((BITable)BOrd.make("station:|slot:/Drivers|bql:select * from TrendN4:TrendHistoryImport").resolve().get()).cursor();
        while(c.next()){


            historiesFound++;
            BComponent trendHistory = (BComponent)c.get();
            BComponent network = (BComponent)trendHistory.getParent().getParent().getParent().getParent();
            String deviceName = "ERROR";
            try{
                deviceName = trendHistory.getParent().getParent().getDisplayName(null).replaceAll("[^a-zA-Z0-9_]","");
                deviceName = deviceName.substring(3);
                String importName = trendHistory.getDisplayName(null).replaceAll(" ","").split("\\]\\[")[1];
                String shortImportName = importName.replaceAll("[^$a-zA-Z0-9_]","");
                BHistoryId historyId = (BHistoryId)trendHistory.get("historyId");
                if(historyId.getHistoryName().contains("P0")){
                    String networkName = network.getDisplayName(null)
                            .replaceAll("\\$20","")
                            .replaceAll("\\$3","")
                            .replaceAll(" ","");
                    trendHistory.set("historyId", BHistoryId.make(networkName + "_" + deviceName,shortImportName));
                    historiesFixed++;
                }

            } catch (Exception e){System.out.println(e.toString());}
        }
        this.setConsole("Finished. Found " + historiesFound + " histories. Fixed " + historiesFixed + ".");
    }

    private static final BIcon icon = BIcon.std("build.png");
    public BIcon getIcon() {
        BValue dynamic = this.get("icon");
        return dynamic instanceof BIcon ? (BIcon)dynamic : icon;
    }

}
