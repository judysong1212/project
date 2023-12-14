/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.utils.MSFEventType;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;

public class MSFManyTriggerField<M> extends TextField {
    //ATTRIBUTES
    public static final EventType[] triggerClickEvent = 
    {
        new MSFEventType("field-0", 30), 
        new MSFEventType("field-1", 31), 
        new MSFEventType("field-2", 32), 
        new MSFEventType("field-3", 33), 
        new MSFEventType("field-4", 34)
    }; //5 events for a possible of up to 10 triggers 
    public final static String INVALID_ARG_NUMERIC = "The numeric argument of this method has an invalid value"; 
    public final static String INVALID_STATE = "The algorithm has entered an invalid state: Check why"; 

    private final List<El> triggers;
    private final List<String> triggerStyles;
    private final List<String> triggerStylesOnMouseOver;

    private El spanAfterInput, spanBeforeInput;
    //private El input;
    private El wrap;

    private EventListener triggerListener;

    /**
     * This field is an internal delimiter that decides which of the triggers in the <b>trigger</b> list go before the input and which go after. <br>
     * This detail of the implementation is a small compromise for the sake of performance; a cleaner and more elegant design choice would 
     * have been to define separate lists for the triggers before and the triggers after, but that would have meant three more lists and a 
     * somewhat large performance hit 
     */
    private int delimiterAfterBefore = 0; 

    //CONSTRUCTOR(S)
    public MSFManyTriggerField(int numberOfTriggers){
        this.triggers = new ArrayList<El>(); 
        this.triggerStyles = new ArrayList<String>();
        this.triggerStylesOnMouseOver = new ArrayList<String>();

        this.addTriggers(numberOfTriggers); 
        
        //addListener(Events.Change, this);
    }

    //METHODS
    //trigger
    public El getTrigger( int index ){
        assert( index >= 0 && this.triggers.size() > index ); 
        return this.triggers.get(index);
    }
    public El getFirstTrigger(){
        assert( this.triggers.size() >= 0 );
        return this.triggers.get(0);
    }
    public El getSecondTrigger(){
        assert( this.triggers.size() >= 1 );
        return this.triggers.get(1);
    }
    public El getThirdTrigger(){
        assert( this.triggers.size() >= 2 );
        return this.triggers.get(2);
    }

    public void setTrigger( El triggerToSet, int index ){
        assert( index >= 0 && this.triggers.size() > index );
        this.triggers.set(index, triggerToSet);
    }
    public void setFirstTrigger( El triggerToSet ){
        assert( this.triggers.size() >= 0 );
        this.triggers.set(0, triggerToSet);
    }
    public void setSecondTrigger( El triggerToSet ){
        assert( this.triggers.size() >= 1 );
        this.triggers.set(1, triggerToSet);
    }
    public void setThirdTrigger( El triggerToSet ){
        assert( this.triggers.size() >= 2 );
        this.triggers.set(2, triggerToSet);
    }

    public int getNumberOfTriggers(){
        int retval = this.triggers!=null ? this.triggers.size() : 0;
        return retval; 
    }

    public void addTrigger(El triggerToAdd){
        this.triggers.add( triggerToAdd ); 
        this.triggerStyles.add(null);
        this.triggerStylesOnMouseOver.add(null); 
    }
    public void addTrigger(){
        this.addTrigger( new El(DOM.createImg()) ); 
    }
    public void addTriggers(int nrOfTriggersToAdd){
        for (int i = 0; i < nrOfTriggersToAdd; i++){
            this.addTrigger( new El(DOM.createImg()) );
        }
    }

    //trigger style
    public String getTriggerStyle( int index ){
        assert( index >= 0 && this.triggerStyles.size() >= index ); 
        return this.triggerStyles.get(index);
    }
    public String getFirstTriggerStyle(){
        assert( this.triggerStyles.size() >= 0 );
        return this.triggerStyles.get(0);
    }
    public String getSecondTriggerStyle(){
        assert( this.triggerStyles.size() >= 1 );
        return this.triggerStyles.get(1);
    }
    public String getThirdTriggerStyle(){
        assert( this.triggerStyles.size() >= 2 );
        return this.triggerStyles.get(2);
    }

    public void setTriggerStyle( String triggerStyleToSet, int index ){
        assert( index >= 0 && this.triggerStyles.size() >= index );
        this.triggerStyles.set(index, triggerStyleToSet);
    }
    public void setFirstTriggerStyle( String triggerStyleToSet ){
        assert( this.triggerStyles.size() >= 0 );
        this.triggerStyles.set(0, triggerStyleToSet);
    }
    public void setSecondTriggerStyle( String triggerStyleToSet ){
        assert( this.triggerStyles.size() >= 1 );
        this.triggerStyles.set(1, triggerStyleToSet);
    }
    public void setThirdTriggerStyle( String triggerStyleToSet ){
        assert( this.triggerStyles.size() >= 2 );
        this.triggerStyles.set(2, triggerStyleToSet);
    }

    //trigger style on mouse over
    public String getTriggerStyleOnMouseOver(int index) {
        return this.triggerStylesOnMouseOver.get(index);
    }
    public String getFirstTriggerStyleOnMouseOver(){
        assert( this.triggerStylesOnMouseOver.size() >= 0 );
        return this.triggerStylesOnMouseOver.get(0);
    }
    public String getSecondTriggerStyleOnMouseOver(){
        assert( this.triggerStylesOnMouseOver.size() >= 1 );
        return this.triggerStylesOnMouseOver.get(1);
    }
    public String getThirdTriggerStyleOnMouseOver(){
        assert( this.triggerStylesOnMouseOver.size() >= 2 );
        return this.triggerStylesOnMouseOver.get(2);
    }

    public void setTriggerStyleOnMouseOver( String triggerStyleOnMouseOverToSet, int index ){
        assert( index >= 0 && this.triggerStylesOnMouseOver.size() >= index );
        this.triggerStylesOnMouseOver.set(index, triggerStyleOnMouseOverToSet);
    }
    public void setFirstTriggerStyleOnMouseOver( String triggerStyleOnMouseOverToSet ){
        assert( this.triggerStylesOnMouseOver.size() >= 0 );
        this.triggerStylesOnMouseOver.set(0, triggerStyleOnMouseOverToSet);
    }
    public void setSecondTriggerStyleOnMouseOver( String triggerStyleOnMouseOverToSet ){
        assert( this.triggerStylesOnMouseOver.size() >= 1 );
        this.triggerStylesOnMouseOver.set(1, triggerStyleOnMouseOverToSet);
    }
    public void setThirdTriggerStyleOnMouseOver( String triggerStyleOnMouseOverToSet ){
        assert( this.triggerStylesOnMouseOver.size() >= 2 );
        this.triggerStylesOnMouseOver.set(2, triggerStyleOnMouseOverToSet);
    }

    //events
    final void onTriggerEvent(final ComponentEvent ce) {
        /*
0 - should be Remove
1 - should be Add
         */
        final El target = ce.getTargetEl();
        int counter = 0; 
        for( final El trigger : this.triggers ){
            if (target.dom == trigger.dom) {
                this.onNthTriggerEvent(ce, counter);
                return; 
            }
            counter++;
        }
    }
    private final void onNthTriggerEvent(ComponentEvent ce, int index) {
        final int type = ce.getType().getEventCode();
        switch (type) {
        case Event.ONMOUSEOVER:
            this.getTrigger(index).addStyleName( this.getTriggerStyleOnMouseOver(index) );
            return;
        case Event.ONMOUSEOUT:
            this.getTrigger(index).removeStyleName( this.getTriggerStyleOnMouseOver(index) );
            return;
        case Event.ONCLICK:
            this.fireEvent(triggerClickEvent[index], ce); 
            return;
        default: 
            //do not throw exception, as the following events may also occur: ONMOUSEMOVE(64), ...others
        }
    }

    public void setDelimiter(int delimiterValue){
        assert( delimiterValue >= 0 ): INVALID_ARG_NUMERIC; 
        this.delimiterAfterBefore = delimiterValue; 
    }

    //internal
    @Override
    public Element getElement() {
        if (this.wrap == null) {
            return super.getElement();
        }
        return this.wrap.dom;
    }

    @Override
    protected El getFocusEl(){
        return this.input;
    }
    @Override
    protected El getInputEl(){
        return this.input;
    }
    @Override
    protected El getStyleEl(){
        return this.input;
    }

    @Override
    protected void alignErrorIcon() {
        this.errorIcon.el().alignTo(this.wrap.dom, "tl-tr", new int[] {1, 1});
    }

    @Override
    protected void onFocus(ComponentEvent ce) {
        super.onFocus(ce);
        this.wrap.addStyleName("x-trigger-wrap-focus");
    }
    @Override
    protected void onBlur(ComponentEvent ce) {
        super.onBlur(ce);
        this.wrap.removeStyleName("x-trigger-wrap-focus");
    }
    @Override
    protected void onDisable() {
        super.onDisable();
        this.wrap.addStyleName("x-item-disabled");
    }
    @Override
    protected void onEnable() {
        super.onEnable();
        this.wrap.removeStyleName("x-item-disabled");
    }

    @Override
    protected void doAttachChildren(){
        super.doAttachChildren();

        for (El trigger : this.triggers){
            DOM.setEventListener( trigger.dom, this.triggerListener );
        }
    }
    @Override
    protected void doDetachChildren(){
        super.doDetachChildren();

        for (El trigger : this.triggers){
            DOM.setEventListener( trigger.dom, null );
        }
    }

    @Override
    protected void onRender(Element target, int index) {
        //input
        this.input = new El(DOM.createInputText());
        this.input.setStyleName("x-form-field"); 
        //wrap
        this.wrap = new El(DOM.createDiv());
        this.wrap.dom.setClassName("x-form-field-wrap");
        //triggers
        assert( this.triggers.size() == this.triggerStyles.size() ): INVALID_STATE;
        El triggerToConfig = null; 
        for(int i = 0; i < this.triggers.size(); i++){
            triggerToConfig = this.getTrigger(i);
            triggerToConfig.dom.setClassName( "x-form-trigger " + this.getTriggerStyle(i) ); 
            triggerToConfig.dom.setPropertyString( "src", GXT.BLANK_IMAGE_URL );
        }
        //spanAfterInput
        this.spanBeforeInput = new El( DOM.createSpan() );
        this.spanBeforeInput.dom.setClassName("x-form-twin-triggers");
        this.spanAfterInput = new El( DOM.createSpan() );
        this.spanAfterInput.dom.setClassName("x-form-twin-triggers");
        //additions
        //note: the triggers AFTER the delimiter are placed BEFORE the input
        assert( this.triggers.size() >= this.delimiterAfterBefore ): INVALID_STATE; 
        for(int i = 0; i < this.delimiterAfterBefore; i++){
            DOM.appendChild(this.spanAfterInput.dom, this.triggers.get(i).dom);
        }
        for(int i = this.delimiterAfterBefore; i < this.triggers.size(); i++){
            DOM.appendChild(this.spanBeforeInput.dom, this.triggers.get(i).dom);
        }

        DOM.appendChild(this.wrap.dom, this.spanBeforeInput.dom);
        DOM.appendChild(this.wrap.dom, this.input.dom);
        DOM.appendChild(this.wrap.dom, this.spanAfterInput.dom);
        this.setElement(this.wrap.dom, target, index);
        //others
        super.onRender(target, index);
        //events
        this.triggerListener = new EventListener() {
            public void onBrowserEvent(Event event) {
                FieldEvent ce = new FieldEvent(MSFManyTriggerField.this);
                ce.setEvent(event);
                ce.setType(new EventType(DOM.eventGetType(event)));
                ce.stopEvent();
                onTriggerEvent(ce);
            }
        };

        DOM.sinkEvents( this.wrap.dom, Event.FOCUSEVENTS );
        for (El trigger : this.triggers){
            DOM.sinkEvents( trigger.dom, Event.ONCLICK | Event.MOUSEEVENTS );
        }

    }
    @Override
    protected final void onResize(int width, int height) {
        if (width != Style.DEFAULT) {
            int tw = this.spanAfterInput.getWidth();
            //this.input.setWidth(adjustWidth("input", width - tw), true);
        }
    }
    //others
    public final boolean isMainField(){
        return (this.getNumberOfTriggers() == 3); 
    }
    //system
    @Override
    public String toString(){
        return "New(TF): " + this.getFieldLabel();
    }

}