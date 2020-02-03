package com.optimised_buildings_ltd.OB_Niagara_Tools;

import com.honeywell.trend.driver.core.schedule.BTrendScheduleExport;
import com.honeywell.trend.driver.core.schedule.BTrendScheduleImport;
import com.tridium.history.rollup.BHistoryRollupRecord;

import javax.baja.collection.BITable;
import javax.baja.email.BEmail;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.schedule.*;
import javax.baja.status.BStatusBoolean;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(
        name = "enabled",
        type = "BBoolean",
        defaultValue = "BBoolean.make(false)"
)
@NiagaraProperty(
        name = "useEnableSchedule",
        type = "BBoolean",
        defaultValue = "BBoolean.make(false)"
)
@NiagaraProperty(
        name = "triadSchedule",
        type = "BBooleanSchedule",
        defaultValue = "new BBooleanSchedule()"
)
@NiagaraProperty(
        name = "enabledTimes",
        type = "BBooleanSchedule",
        defaultValue = "new BBooleanSchedule()"
)
@NiagaraProperty(
        name = "triadTag",
        type = "BString",
        defaultValue = "BString.make(\"\")"

)
@NiagaraProperty(
        name = "waitTimeBetweenReadAndWrite",
        type = "BRelTime",
        defaultValue = "BRelTime.make(60000)"
)
@NiagaraProperty(
        name = "scheduleWriterConsole",
        type = "BString",
        defaultValue = "BString.make(\"\")",
        flags = Flags.READONLY
)
@NiagaraProperty(
        name = "emailDecoderConsole",
        type = "BString",
        defaultValue = "BString.make(\"\")",
        flags = Flags.READONLY
)
@NiagaraAction(
        name = "decodeEmail",
        parameterType = "BEmail",
        defaultValue = "new BEmail()"
)
@NiagaraAction(
        name = "updateSchedules",
        flags = Flags.ASYNC
)
@NiagaraAction(
        name = "readSchedules",
        flags = Flags.ASYNC | Flags.HIDDEN
)
@NiagaraAction(
        name = "writeSchedules",
        flags = Flags.ASYNC | Flags.HIDDEN
)


public class BTriadEmailDecoder extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.OB_Niagara_Tools.BTriadEmailDecoder(361783847)1.0$ @*/
/* Generated Mon Nov 25 10:21:12 GMT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

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
// Property "useEnableSchedule"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code useEnableSchedule} property.
   * @see #getUseEnableSchedule
   * @see #setUseEnableSchedule
   */
  public static final Property useEnableSchedule = newProperty(0, ((BBoolean)(BBoolean.make(false))).getBoolean(), null);
  
  /**
   * Get the {@code useEnableSchedule} property.
   * @see #useEnableSchedule
   */
  public boolean getUseEnableSchedule() { return getBoolean(useEnableSchedule); }
  
  /**
   * Set the {@code useEnableSchedule} property.
   * @see #useEnableSchedule
   */
  public void setUseEnableSchedule(boolean v) { setBoolean(useEnableSchedule, v, null); }

////////////////////////////////////////////////////////////////
// Property "triadSchedule"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code triadSchedule} property.
   * @see #getTriadSchedule
   * @see #setTriadSchedule
   */
  public static final Property triadSchedule = newProperty(0, new BBooleanSchedule(), null);
  
  /**
   * Get the {@code triadSchedule} property.
   * @see #triadSchedule
   */
  public BBooleanSchedule getTriadSchedule() { return (BBooleanSchedule)get(triadSchedule); }
  
  /**
   * Set the {@code triadSchedule} property.
   * @see #triadSchedule
   */
  public void setTriadSchedule(BBooleanSchedule v) { set(triadSchedule, v, null); }

////////////////////////////////////////////////////////////////
// Property "enabledTimes"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code enabledTimes} property.
   * @see #getEnabledTimes
   * @see #setEnabledTimes
   */
  public static final Property enabledTimes = newProperty(0, new BBooleanSchedule(), null);
  
  /**
   * Get the {@code enabledTimes} property.
   * @see #enabledTimes
   */
  public BBooleanSchedule getEnabledTimes() { return (BBooleanSchedule)get(enabledTimes); }
  
  /**
   * Set the {@code enabledTimes} property.
   * @see #enabledTimes
   */
  public void setEnabledTimes(BBooleanSchedule v) { set(enabledTimes, v, null); }

////////////////////////////////////////////////////////////////
// Property "triadTag"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code triadTag} property.
   * @see #getTriadTag
   * @see #setTriadTag
   */
  public static final Property triadTag = newProperty(0, BString.make(""), null);
  
  /**
   * Get the {@code triadTag} property.
   * @see #triadTag
   */
  public String getTriadTag() { return getString(triadTag); }
  
  /**
   * Set the {@code triadTag} property.
   * @see #triadTag
   */
  public void setTriadTag(String v) { setString(triadTag, v, null); }

////////////////////////////////////////////////////////////////
// Property "waitTimeBetweenReadAndWrite"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code waitTimeBetweenReadAndWrite} property.
   * @see #getWaitTimeBetweenReadAndWrite
   * @see #setWaitTimeBetweenReadAndWrite
   */
  public static final Property waitTimeBetweenReadAndWrite = newProperty(0, BRelTime.make(60000), null);
  
  /**
   * Get the {@code waitTimeBetweenReadAndWrite} property.
   * @see #waitTimeBetweenReadAndWrite
   */
  public BRelTime getWaitTimeBetweenReadAndWrite() { return (BRelTime)get(waitTimeBetweenReadAndWrite); }
  
  /**
   * Set the {@code waitTimeBetweenReadAndWrite} property.
   * @see #waitTimeBetweenReadAndWrite
   */
  public void setWaitTimeBetweenReadAndWrite(BRelTime v) { set(waitTimeBetweenReadAndWrite, v, null); }

////////////////////////////////////////////////////////////////
// Property "scheduleWriterConsole"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code scheduleWriterConsole} property.
   * @see #getScheduleWriterConsole
   * @see #setScheduleWriterConsole
   */
  public static final Property scheduleWriterConsole = newProperty(Flags.READONLY, BString.make(""), null);
  
  /**
   * Get the {@code scheduleWriterConsole} property.
   * @see #scheduleWriterConsole
   */
  public String getScheduleWriterConsole() { return getString(scheduleWriterConsole); }
  
  /**
   * Set the {@code scheduleWriterConsole} property.
   * @see #scheduleWriterConsole
   */
  public void setScheduleWriterConsole(String v) { setString(scheduleWriterConsole, v, null); }

////////////////////////////////////////////////////////////////
// Property "emailDecoderConsole"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code emailDecoderConsole} property.
   * @see #getEmailDecoderConsole
   * @see #setEmailDecoderConsole
   */
  public static final Property emailDecoderConsole = newProperty(Flags.READONLY, BString.make(""), null);
  
  /**
   * Get the {@code emailDecoderConsole} property.
   * @see #emailDecoderConsole
   */
  public String getEmailDecoderConsole() { return getString(emailDecoderConsole); }
  
  /**
   * Set the {@code emailDecoderConsole} property.
   * @see #emailDecoderConsole
   */
  public void setEmailDecoderConsole(String v) { setString(emailDecoderConsole, v, null); }

////////////////////////////////////////////////////////////////
// Action "decodeEmail"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code decodeEmail} action.
   * @see #decodeEmail(BEmail parameter)
   */
  public static final Action decodeEmail = newAction(0, new BEmail(), null);
  
  /**
   * Invoke the {@code decodeEmail} action.
   * @see #decodeEmail
   */
  public void decodeEmail(BEmail parameter) { invoke(decodeEmail, parameter, null); }

////////////////////////////////////////////////////////////////
// Action "updateSchedules"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code updateSchedules} action.
   * @see #updateSchedules()
   */
  public static final Action updateSchedules = newAction(Flags.ASYNC, null);
  
  /**
   * Invoke the {@code updateSchedules} action.
   * @see #updateSchedules
   */
  public void updateSchedules() { invoke(updateSchedules, null, null); }

////////////////////////////////////////////////////////////////
// Action "readSchedules"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code readSchedules} action.
   * @see #readSchedules()
   */
  public static final Action readSchedules = newAction(Flags.ASYNC | Flags.HIDDEN, null);
  
  /**
   * Invoke the {@code readSchedules} action.
   * @see #readSchedules
   */
  public void readSchedules() { invoke(readSchedules, null, null); }

////////////////////////////////////////////////////////////////
// Action "writeSchedules"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code writeSchedules} action.
   * @see #writeSchedules()
   */
  public static final Action writeSchedules = newAction(Flags.ASYNC | Flags.HIDDEN, null);
  
  /**
   * Invoke the {@code writeSchedules} action.
   * @see #writeSchedules
   */
  public void writeSchedules() { invoke(writeSchedules, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTriadEmailDecoder.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


    public void doDecodeEmail(BEmail email){

      if(!this.getEnabled() || (this.getUseEnableSchedule() && !this.getEnabledTimes().getOut().getBoolean())){
        return;
      }

      try {
        //Make time for tomorrow and update console
        BAbsTime event = BAbsTime.now().add(BRelTime.makeDays(1));


        //Decode email subject into event start and end times
        String body = email.getBody().toString();
        if(body.contains("DO NOT")){
          this.setEmailDecoderConsole("Triad alert received for " + event.toDateString(null) + ". No Triad Predicted.");
          return;
        } else if (body.contains("DO")){
          this.setEmailDecoderConsole("Triad alert received for " + event.toDateString(null) + ". Triad Predicted.");
        } else {
          //There is no try
          return;
        }
        BHistoryRollupRecord dave = new BHistoryRollupRecord();
        String triadTimes = body.substring(body.indexOf("(") + 1, body.indexOf(")"));
        BTime start = BTime.make(Integer.parseInt(triadTimes.substring(0, triadTimes.indexOf(":"))), Integer.parseInt(triadTimes.substring(3, 5)), 0);
        triadTimes = triadTimes.substring(triadTimes.indexOf("-") + 1);
        BTime end = BTime.make(Integer.parseInt(triadTimes.substring(0, triadTimes.indexOf(":"))), Integer.parseInt(triadTimes.substring(3, 5)), 0);

        //Check times are sequential
        if(start.isAfter(end)){
          this.setEmailDecoderConsole("Error: Start time is after End time.");
          return;
        }

        //Add event to schedule
        BBooleanSchedule schedule = this.getTriadSchedule();
        BCompositeSchedule specialEvents = (BCompositeSchedule) schedule.getSchedule().get("specialEvents");
        //Make Time tomorrow

        //Name the event tomorrows date
        String eventName = "$3" + event.toDateString(null).replaceAll("-", "\\$2d");
        specialEvents.add(eventName, new BDailySchedule());
        BAbstractSchedule days = ((BDailySchedule) specialEvents.get(eventName)).getDays();
        //Set day, month and year
        ((BYearSchedule) days.get("yearSchedule")).setYear(event.getYear());
        ((BYearSchedule) days.get("yearSchedule")).setAlwaysEffective(false);
        ((BMonthSchedule) days.get("monthSchedule")).add(event.getMonth().getMonthOfYear() - 1);
        ((BDayOfMonthSchedule) days.get("daySchedule")).add(event.getDay());
        //Set Times
        BDaySchedule day = ((BDailySchedule) specialEvents.get(eventName)).getDay();
        day.add("time", new BTimeSchedule());
        BTimeSchedule time = (BTimeSchedule) day.get("time");
        time.add("effectiveValue", new BStatusBoolean(true));
        time.setStart(start);
        time.setFinish(end);

      } catch (Exception e){
        setEmailDecoderConsole(e.toString());
      }

    }

    public void doReadSchedules() throws  Exception{
      BITable import_result =
              (BITable) BOrd.make("station:|slot:/Drivers|neql:" + this.getTriadTag() + "|bql:select * where type = 'TrendN4:TrendScheduleImport'").resolve().get();
      Cursor import_c = import_result.cursor();
      this.setScheduleWriterConsole("Importing schedules...");
      while(import_c.next()){
        try{
          ((BTrendScheduleImport)import_c.get()).execute();
        } catch (Exception e){this.setScheduleWriterConsole(e.toString());}
      }
      this.setScheduleWriterConsole("Successfully updated schedules at " + BAbsTime.now().toDateString(null));
    }

    public void doWriteSchedules() throws Exception{
      this.setScheduleWriterConsole("Exporting schedules...");
      BITable export_result =
              (BITable) BOrd.make("station:|slot:/Drivers|neql:" + this.getTriadTag() + "|bql:select * where type = 'TrendN4:TrendScheduleExport'").resolve().get();
      Cursor export_c = export_result.cursor();

      while(export_c.next()){*
        try {
          ((BTrendScheduleExport)export_c.get()).execute();
        } catch (Exception e){this.setScheduleWriterConsole(e.toString());}
      }
      this.setScheduleWriterConsole("Idle");
    }

    public void doUpdateSchedules() throws Exception{
      doWriteSchedules();

      //Wait without stalling station
      this.setScheduleWriterConsole("Sleeping for " + this.getWaitTimeBetweenReadAndWrite().getSeconds() + " seconds...");
      Thread.sleep(this.getWaitTimeBetweenReadAndWrite().getMillis());

      doReadSchedules();
    }

  private static final BIcon icon = BIcon.std("desktop.png");
  public BIcon getIcon() {
    BValue dynamic = this.get("icon");
    return dynamic instanceof BIcon ? (BIcon)dynamic : icon;
  }

}
