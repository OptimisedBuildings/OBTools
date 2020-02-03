package com.optimised_buildings_ltd.OB_Niagara_Tools;

import com.tridium.history.db.BLocalDbHistory;
import com.tridium.history.rollup.BHistoryRollup;
import com.tridium.history.rollup.BHistoryRollupRecord;

import javax.baja.collection.BITable;
import javax.baja.control.BBooleanWritable;
import javax.baja.control.BControlPoint;
import javax.baja.control.BNumericWritable;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatusBoolean;
import javax.baja.status.BStatusNumeric;
import javax.baja.status.BStatusValue;
import javax.baja.sys.*;
import javax.baja.tag.Tag;
import java.util.ArrayList;
import java.util.Arrays;

@NiagaraType
@NiagaraProperty(
       name = "pointTag",
       type = "BString",
       defaultValue = "BString.make(\"n:point\")"
)
@NiagaraProperty(
        name = "siteTag",
        type = "BString",
        defaultValue = "BString.make(\"n:type = 'TrendN4:TrendSystem'\")"
)
@NiagaraProperty(
        name = "results",
        type = "BString",
        defaultValue = "BString.make(\"\")",
        facets = @Facet("BFacets.make(\"multiLine\",BBoolean.TRUE)")
)
@NiagaraAction(
        name = "scan"
)
@NiagaraAction(
        name = "set"
)
@NiagaraAction(
        name = "reset"
)
@NiagaraProperty(
        name = "query",
        type = "BString",
        defaultValue = "BString.make(\"\")"
)
@NiagaraProperty(
        name = "value",
        type = "BString",
        defaultValue = "BString.make(\"\")"
)
@NiagaraProperty(
        name = "totalResults",
        type = "BInteger",
        defaultValue = "BInteger.make(0)"
)
@NiagaraProperty(
        name = "matchingResults",
        type = "BInteger",
        defaultValue = "BInteger.make(0)"
)
@NiagaraProperty(
        name = "nonMatchingResults",
        type = "BInteger",
        defaultValue = "BInteger.make(0)"
)


public class BPointSetter extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.optimised_buildings_ltd.OB_Niagara_Tools.BPointSetter(1830133748)1.0$ @*/
/* Generated Tue Dec 10 17:03:22 GMT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "pointTag"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code pointTag} property.
   * @see #getPointTag
   * @see #setPointTag
   */
  public static final Property pointTag = newProperty(0, BString.make("n:point"), null);
  
  /**
   * Get the {@code pointTag} property.
   * @see #pointTag
   */
  public String getPointTag() { return getString(pointTag); }
  
  /**
   * Set the {@code pointTag} property.
   * @see #pointTag
   */
  public void setPointTag(String v) { setString(pointTag, v, null); }

////////////////////////////////////////////////////////////////
// Property "siteTag"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code siteTag} property.
   * @see #getSiteTag
   * @see #setSiteTag
   */
  public static final Property siteTag = newProperty(0, BString.make("n:type = 'TrendN4:TrendSystem'"), null);
  
  /**
   * Get the {@code siteTag} property.
   * @see #siteTag
   */
  public String getSiteTag() { return getString(siteTag); }
  
  /**
   * Set the {@code siteTag} property.
   * @see #siteTag
   */
  public void setSiteTag(String v) { setString(siteTag, v, null); }

////////////////////////////////////////////////////////////////
// Property "results"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code results} property.
   * @see #getResults
   * @see #setResults
   */
  public static final Property results = newProperty(0, BString.make(""), BFacets.make("multiLine",BBoolean.TRUE));
  
  /**
   * Get the {@code results} property.
   * @see #results
   */
  public String getResults() { return getString(results); }
  
  /**
   * Set the {@code results} property.
   * @see #results
   */
  public void setResults(String v) { setString(results, v, null); }

////////////////////////////////////////////////////////////////
// Property "query"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code query} property.
   * @see #getQuery
   * @see #setQuery
   */
  public static final Property query = newProperty(0, BString.make(""), null);
  
  /**
   * Get the {@code query} property.
   * @see #query
   */
  public String getQuery() { return getString(query); }
  
  /**
   * Set the {@code query} property.
   * @see #query
   */
  public void setQuery(String v) { setString(query, v, null); }

////////////////////////////////////////////////////////////////
// Property "value"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code value} property.
   * @see #getValue
   * @see #setValue
   */
  public static final Property value = newProperty(0, BString.make(""), null);
  
  /**
   * Get the {@code value} property.
   * @see #value
   */
  public String getValue() { return getString(value); }
  
  /**
   * Set the {@code value} property.
   * @see #value
   */
  public void setValue(String v) { setString(value, v, null); }

////////////////////////////////////////////////////////////////
// Property "totalResults"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code totalResults} property.
   * @see #getTotalResults
   * @see #setTotalResults
   */
  public static final Property totalResults = newProperty(0, ((BInteger)(BInteger.make(0))).getInt(), null);
  
  /**
   * Get the {@code totalResults} property.
   * @see #totalResults
   */
  public int getTotalResults() { return getInt(totalResults); }
  
  /**
   * Set the {@code totalResults} property.
   * @see #totalResults
   */
  public void setTotalResults(int v) { setInt(totalResults, v, null); }

////////////////////////////////////////////////////////////////
// Property "matchingResults"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code matchingResults} property.
   * @see #getMatchingResults
   * @see #setMatchingResults
   */
  public static final Property matchingResults = newProperty(0, ((BInteger)(BInteger.make(0))).getInt(), null);
  
  /**
   * Get the {@code matchingResults} property.
   * @see #matchingResults
   */
  public int getMatchingResults() { return getInt(matchingResults); }
  
  /**
   * Set the {@code matchingResults} property.
   * @see #matchingResults
   */
  public void setMatchingResults(int v) { setInt(matchingResults, v, null); }

////////////////////////////////////////////////////////////////
// Property "nonMatchingResults"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code nonMatchingResults} property.
   * @see #getNonMatchingResults
   * @see #setNonMatchingResults
   */
  public static final Property nonMatchingResults = newProperty(0, ((BInteger)(BInteger.make(0))).getInt(), null);
  
  /**
   * Get the {@code nonMatchingResults} property.
   * @see #nonMatchingResults
   */
  public int getNonMatchingResults() { return getInt(nonMatchingResults); }
  
  /**
   * Set the {@code nonMatchingResults} property.
   * @see #nonMatchingResults
   */
  public void setNonMatchingResults(int v) { setInt(nonMatchingResults, v, null); }

////////////////////////////////////////////////////////////////
// Action "scan"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code scan} action.
   * @see #scan()
   */
  public static final Action scan = newAction(0, null);
  
  /**
   * Invoke the {@code scan} action.
   * @see #scan
   */
  public void scan() { invoke(scan, null, null); }

////////////////////////////////////////////////////////////////
// Action "set"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code set} action.
   * @see #set()
   */
  public static final Action set = newAction(0, null);
  
  /**
   * Invoke the {@code set} action.
   * @see #set
   */
  public void set() { invoke(set, null, null); }

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
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BPointSetter.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public void doSet(){
        this.doScan();
        BITable result = (BITable)BOrd.make(this.getQuery()).resolve().get();
        Cursor c = result.cursor();
        while(c.next()){
            try{
                BControlPoint point = (BControlPoint)c.get();
                try{
                    ((BNumericWritable)point).doSet(BDouble.make(Double.parseDouble(this.getValue())));
                } catch (Exception f){
                    try {
                        ((BBooleanWritable)point).doSet(BBoolean.make(Boolean.parseBoolean(this.getValue())));
                    } catch (Exception g){
                        System.out.println(f);
                        System.out.println(g);
                    }
                }
            } catch (Exception e){
                System.out.println(e.toString());
            }
        }
        this.doScan();
    }

    public void doReset(){
        this.doScan();
        BITable result = (BITable)BOrd.make(this.getQuery()).resolve().get();
        Cursor c = result.cursor();
        while(c.next()){
            try{
                BControlPoint point = (BControlPoint)c.get();
                try{
                    ((BNumericWritable)point).doSet(BDouble.make(null));
                } catch (Exception f){
                    try {
                        ((BBooleanWritable)point).doSet(BBoolean.make(null));
                    } catch (Exception g){
                        System.out.println(f);
                        System.out.println(g);
                    }
                }
            } catch (Exception e){
                System.out.println(e.toString());
            }
        }
        this.doScan();
    }

    public void doScan(){
        String hexTag = Integer.toHexString(Tag.newTag(this.getSiteTag()).hashCode());
        String neql =     "station:|slot:|neql:"
                        + this.getPointTag()
                        + "|bql:select * where parent.parent.parent.parent.tags.all like '*javax.baja.tag.Tag@"
                        + hexTag
                        + "*'";
        this.setQuery(neql);
        BITable result = (BITable) BOrd.make(neql).resolve().get();
        Cursor c = result.cursor();
        ArrayList<BComponent> targetPoints = new ArrayList<>();
        int total = 0; int match = 0; int nonMatch = 0;
        while(c.next()){
            targetPoints.add((BComponent)c.get());
            total++;
            try {
                BComponent point = (BComponent) c.get();
                BStatusValue fallback = (BStatusValue) point.get("fallback");
                BStatusValue out = (BStatusValue)point.get("out");
                if (fallback.getValueValue().equals(out.getValueValue())){
                    match++;
                } else {
                    nonMatch++;
                }
            } catch (Exception e){
                System.out.println(e.toString());

            }
        }

        this.setTotalResults(total);
        this.setMatchingResults(match);
        this.setNonMatchingResults(nonMatch);

        StringBuilder output = new StringBuilder("Display Name\tFallback\tOut\n");
        for(BComponent target : targetPoints){
            output.append(target.getDisplayName(null)).append("\t").append(target.get("fallback")).append("\t").append(target.get("out")).append("\n");
        }
        this.setResults(output.toString());


    }

}
