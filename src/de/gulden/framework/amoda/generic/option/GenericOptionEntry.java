/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.option.GenericOptionEntry
 * Version: 0.1
 *
 * Date:    2002-10-24
 *
 * Note:    Contains auto-generated Javadoc comments
 *          created by BeautyJ (http://beautyj.berlios.de).
 *  
 * This is licensed under the GNU Lesser General Public License (LGPL)
 * and comes with NO WARRANTY. See file license.txt for details.
 *
 * Author:  Jens Gulden
 * Email:   amoda@jensgulden.de
 */

package de.gulden.framework.amoda.generic.option;

import de.gulden.framework.amoda.generic.data.*;
import de.gulden.framework.amoda.model.behaviour.Condition;
import de.gulden.framework.amoda.model.core.ApplicationEnvironment;
import de.gulden.framework.amoda.model.data.Value;
import de.gulden.framework.amoda.model.option.OptionEntry;
import de.gulden.util.xml.XMLHandler;
import java.util.*;

/**
 * Class GenericOptionEntry.
 */
public class GenericOptionEntry extends GenericOption implements OptionEntry {

    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The generic value.
     */
    public Collection genericValue=new Vector();

    /**
     * The validity condition.
     */
    protected Condition validityCondition;

    /**
     * The value array.
     */
    protected Value[] value;


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of GenericOptionEntry.
     */
    public GenericOptionEntry() {
        super();
        value = new Value[STATE_EDIT+1];
        for (int i=0;i<value.length;i++) {
            value[i]=new de.gulden.framework.amoda.generic.data.GenericValue();
        }

    }

    /**
     * Creates a new instance of GenericOptionEntry.
     *  
     * @param environment The environment.
     */
    public GenericOptionEntry(ApplicationEnvironment environment) {
        this();
        setEnvironment(environment);

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the validity condition.
     *  
     * @return  The validity condition.
     */
    public Condition getValidityCondition() {
        return validityCondition;

    }

    /**
     * Sets the validity condition.
     *  
     * @param _validityCondition The validity condition.
     */
    public void setValidityCondition(Condition _validityCondition) {
        validityCondition = _validityCondition;

    }

    /**
     * Returns the values.
     *  
     * @return  The values array.
     */
    public Value[] getValues() {
        return value;

    }

    /**
     * Sets the values.
     *  
     * @param _value The values array.
     */
    public void setValues(Value[] _value) {
        value = _value;

    }

    /**
     * Sets the value.
     *  
     * @param idx The value.
     * @param _value The value.
     */
    public void setValue(int idx, Value _value) throws ArrayIndexOutOfBoundsException {
        value[idx] = _value;

    }

    /**
     * Returns the value.
     *  
     * @param idx The idx.
     * @return  The value.
     */
    public Value getValue(int idx) throws ArrayIndexOutOfBoundsException {
        return value[idx];

    }

    /**
     * Returns the generic values.
     *  
     * @return  The generic values.
     */
    public Collection getGenericValues() {
        return genericValue;

    }

    /**
     * Adds a generic value.
     *  
     * @param genericValue The generic value.
     */
    public void addGenericValue(GenericValue genericValue) {
        if (! this.genericValue.contains(genericValue)) this.genericValue.add(genericValue);

    }

    /**
     * Removes a generic value.
     *  
     * @param genericValue The generic value.
     */
    public void removeGenericValue(GenericValue genericValue) {
        this.genericValue.remove(genericValue);

    }

    /**
     * Returns the value.
     *  
     * @return  The value.
     */
    public Value getValue() {
        // get most current value which is set, or null if no value is set
        for (int i=STATE_CURRENT;i>=0;i--) {
            Value v=getValue(i);
            if (v.getObject()!=null) {
                return v;
            }
        }
        return null;

    }

    /**
     * Sets the value.
     *  
     * @param value The value.
     */
    public void setValue(Value value) {
        setValue(STATE_CURRENT,value);

    }

    /**
     *  
     * @return  The boolean.
     */
    public boolean isValid() {
        Condition c=getValidityCondition();
        if (c!=null) {
            return c.test();
        } else {
            return (getValue()!=null); // default semantics for validity is "non-null"
        }

    }

    /**
     * Returns the type.
     *  
     * @return  The type.
     */
    public Class getType() {
        return ((de.gulden.framework.amoda.generic.data.GenericValue)getValue(0)).getType();

    }

    /**
     * Sets the type.
     *  
     * @param type The type.
     */
    public void setType(Class type) {
        for (int i=0;i<value.length;i++) {
            ((de.gulden.framework.amoda.generic.data.GenericValue)value[i]).setType(type);
        }

    }

    /**
     * Creates the x m l handler.
     *  
     * @return  The x m l handler.
     */
    protected XMLHandler createXMLHandler() {
        // your code here
        return null;

    }

} // end GenericOptionEntry
