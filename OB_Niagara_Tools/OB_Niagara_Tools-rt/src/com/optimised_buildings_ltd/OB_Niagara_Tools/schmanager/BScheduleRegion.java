package com.optimised_buildings_ltd.OB_Niagara_Tools.schmanager;

import com.honeywell.trend.driver.core.device.configuration.BTrendDeviceIdentity;

import javax.baja.control.BBooleanWritable;
import javax.baja.nre.annotations.*;
import javax.baja.schedule.*;
import javax.baja.status.BStatusBoolean;
import javax.baja.sys.*;
import javax.baja.util.BEnumSet;

@NiagaraType
@NiagaraAction(
        name = "addMassEvent",
        parameterType = "BEventCreationInfo",
        defaultValue = "new BEventCreationInfo()"

)
@NiagaraAction(
        name = "addSchedule",
        parameterType = "BScheduleCreationInfo",
        defaultValue = "new BScheduleCreationInfo()"
)
@NiagaraAction(
        name = "removeMassEvent",
        parameterType = "BDate",
        defaultValue = "BDate.make()"
)

public class BScheduleRegion extends BComponent{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.OB_Niagara_Tools.schmanager.BScheduleRegion(3868157955)1.0$ @*/
/* Generated Wed Nov 27 10:27:24 GMT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

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
// Action "addSchedule"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addSchedule} action.
   * @see #addSchedule(BScheduleCreationInfo parameter)
   */
  public static final Action addSchedule = newAction(0, new BScheduleCreationInfo(), null);
  
  /**
   * Invoke the {@code addSchedule} action.
   * @see #addSchedule
   */
  public void addSchedule(BScheduleCreationInfo parameter) { invoke(addSchedule, parameter, null); }

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
  public static final Type TYPE = Sys.loadType(BScheduleRegion.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


    public void doAddMassEvent(BEventCreationInfo eventInfo){
        BComponent[] children = this.getChildComponents();
        for(BComponent child : children){
          if(child.getType().toString().contains("BooleanSchedule")){
            BCompositeSchedule specialEvents = (BCompositeSchedule)((BBooleanSchedule)child).getSchedule().get("specialEvents");
            //Make Time
            BAbsTime date = BAbsTime.make(eventInfo.getYear(),BMonth.make(eventInfo.getMonth()-1), eventInfo.getDay());
            specialEvents.add(eventInfo.getEventName(), new BDailySchedule());
            BAbstractSchedule days = ((BDailySchedule) specialEvents.get(eventInfo.getEventName())).getDays();
            //Set day, month and year
            ((BYearSchedule) days.get("yearSchedule")).setYear(eventInfo.getYear());
            ((BYearSchedule) days.get("yearSchedule")).setAlwaysEffective(false);
            ((BMonthSchedule) days.get("monthSchedule")).add(date.getMonth().getMonthOfYear() - 1);
            ((BDayOfMonthSchedule) days.get("daySchedule")).add(eventInfo.getDay());
            //Set Times
            BDaySchedule day = ((BDailySchedule) specialEvents.get(eventInfo.getEventName())).getDay();
            day.add("time", new BTimeSchedule());
            BTimeSchedule time = (BTimeSchedule) day.get("time");
            time.add("effectiveValue", new BStatusBoolean(eventInfo.getEventState()));
            time.setStart(eventInfo.getStartTime());
            time.setFinish(eventInfo.getEndTime());

            if(eventInfo.getAddInvertedPeriods()){
              day.add("time1", new BTimeSchedule());
              BTimeSchedule time1 = (BTimeSchedule)day.get("time1");
              time1.add("effectiveValue", new BStatusBoolean(!eventInfo.getEventState()));
              time1.setStart(BTime.make(0,0,0));
              time1.setFinish(eventInfo.getStartTime());

              day.add("time2", new BTimeSchedule());
              BTimeSchedule time2 = (BTimeSchedule)day.get("time2");
              time2.add("effectiveValue", new BStatusBoolean(!eventInfo.getEventState()));
              time2.setStart(eventInfo.getEndTime());
              time2.setFinish(BTime.make(0,0,0));
            }
          }
        }
    }

  public BIcon getIcon() {
    BValue dynamic = this.get("icon");
    return dynamic instanceof BIcon ? (BIcon)dynamic : icon;
  }
  private static final BIcon icon = BIcon.std("deviceLocal.png");

    public BScheduleRegion(){}

    public void doRemoveMassEvent(BDate date){
      BComponent[] children = this.getChildComponents();
      for(BComponent child : children){
        if(child.getType().toString().contains("BooleanSchedule")){
          BComponent[] specialEvents = ((BComponent)((BComponent)child.get("schedule")).get("specialEvents")).getChildComponents();
          for(BComponent event : specialEvents){
            BDailySchedule dailySchedule = (BDailySchedule)event;
            String monthString = ((BEnumSet)((BComponent)dailySchedule.getDays().get("monthSchedule")).get("set")).toString();
            int month = monthString.equals("") ? 13 : Integer.parseInt(monthString);
            String dayString = ((BEnumSet)((BComponent)dailySchedule.getDays().get("daySchedule")).get("set")).toString();
            int day = dayString.equals("") ? 13 : Integer.parseInt(dayString);
            int year = ((BInteger)((BComponent)dailySchedule.getDays().get("yearSchedule")).get("year")).getInt();


            System.out.println(year + "-" + month + "-" + day);
            if(date.getYear() == year && date.getMonth().getOrdinal() == month && date.getDay() == day){
              BComponent parent = (BComponent)dailySchedule.getParent();
              parent.remove(dailySchedule);
            }
          }
        }
      }
    }

    public void doAddSchedule(BScheduleCreationInfo scheduleCreationInfo){
      String scheduleName = scheduleCreationInfo.getScheduleName();
      if(scheduleName == null || scheduleName == ""){
        scheduleName =
                "MTF" +
                String.format("%02d",scheduleCreationInfo.getMonToFriTimes().getStartTime().getHour()) +
                String.format("%02d",scheduleCreationInfo.getMonToFriTimes().getEndTime().getHour()) +
                "_SAT" +
                String.format("%02d",scheduleCreationInfo.getSatTimes().getStartTime().getHour()) +
                String.format("%02d",scheduleCreationInfo.getSatTimes().getEndTime().getHour()) +
                "_SUN" +
                String.format("%02d",scheduleCreationInfo.getSunTimes().getStartTime().getHour()) +
                String.format("%02d",scheduleCreationInfo.getSunTimes().getEndTime().getHour());
      }

      this.add(scheduleName, new BBooleanSchedule());
      BBooleanSchedule newSchedule = (BBooleanSchedule)this.get(scheduleName);
      BCompositeSchedule compSchedule = (BCompositeSchedule)newSchedule.get("schedule");
      BWeekSchedule weekSchedule = (BWeekSchedule)compSchedule.get("week");

      BDailySchedule sunday = (BDailySchedule)weekSchedule.get("sunday");
      sunday.getDay().add("time", new BTimeSchedule(scheduleCreationInfo.getSunTimes().getStartTime(),
              scheduleCreationInfo.getSunTimes().getEndTime(), new BStatusBoolean(true)));
      BDailySchedule monday = (BDailySchedule)weekSchedule.get("monday");
      monday.getDay().add("time", new BTimeSchedule(scheduleCreationInfo.getMonToFriTimes().getStartTime(),
              scheduleCreationInfo.getMonToFriTimes().getEndTime(), new BStatusBoolean(true)));
      BDailySchedule tuesday = (BDailySchedule)weekSchedule.get("tuesday");
      tuesday.getDay().add("time", new BTimeSchedule(scheduleCreationInfo.getMonToFriTimes().getStartTime(),
              scheduleCreationInfo.getMonToFriTimes().getEndTime(), new BStatusBoolean(true)));
      BDailySchedule wednesday = (BDailySchedule)weekSchedule.get("wednesday");
      wednesday.getDay().add("time", new BTimeSchedule(scheduleCreationInfo.getMonToFriTimes().getStartTime(),
              scheduleCreationInfo.getMonToFriTimes().getEndTime(), new BStatusBoolean(true)));
      BDailySchedule thursday = (BDailySchedule)weekSchedule.get("thursday");
      thursday.getDay().add("time", new BTimeSchedule(scheduleCreationInfo.getMonToFriTimes().getStartTime(),
              scheduleCreationInfo.getMonToFriTimes().getEndTime(), new BStatusBoolean(true)));
      BDailySchedule friday = (BDailySchedule)weekSchedule.get("friday");
      friday.getDay().add("time", new BTimeSchedule(scheduleCreationInfo.getMonToFriTimes().getStartTime(),
              scheduleCreationInfo.getMonToFriTimes().getEndTime(), new BStatusBoolean(true)));
      BDailySchedule saturday = (BDailySchedule)weekSchedule.get("saturday");
      saturday.getDay().add("time", new BTimeSchedule(scheduleCreationInfo.getSatTimes().getStartTime(),
              scheduleCreationInfo.getSatTimes().getEndTime(), new BStatusBoolean(true)));

    }
}
