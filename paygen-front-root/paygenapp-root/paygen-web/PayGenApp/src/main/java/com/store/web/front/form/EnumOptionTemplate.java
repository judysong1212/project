package com.store.web.front.form;


import java.util.EnumSet;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;

import com.web.smrmf.core.command.ControlCommand;
import com.web.smrmf.sysm.type.Bolean;
import com.web.smrmf.sysm.type.Sex;
import com.web.smrmf.sysm.type.State;
import com.web.smrmf.sysm.type.Switch;
import com.web.smrmf.sysm.type.YesNo;
import com.web.smrmf.sysm.web.form.AbstractOptionTemplate;
import com.web.smrmf.user.type.Role;


public class EnumOptionTemplate extends AbstractOptionTemplate implements InitializingBean{


   private EnumSet<State> state;
   private EnumSet<Switch> switche;
   private EnumSet<Sex> sex;
   private EnumSet<Bolean> bolean;
   private EnumSet<YesNo> yesNo;
   private EnumSet<Role> role;
   private EnumSet<ControlCommand> command;

   
   public void afterPropertiesSet(){
      state = EnumSet.allOf(State.class);
      sex = EnumSet.allOf(Sex.class);
      switche = EnumSet.allOf(Switch.class);
      bolean = EnumSet.allOf(Bolean.class);
      yesNo = EnumSet.allOf(YesNo.class);
      role = EnumSet.allOf(Role.class);
      command = EnumSet.allOf(ControlCommand.class);
    }

   public EnumSet<State> getState() {
      return state;
   }

   public EnumSet<Sex> getSex() {
      return sex;
   }

   public EnumSet<Switch> getSwitch() {
      return switche;
   }

   public Set<Bolean> getBolean() {
      return bolean;
   }

   public EnumSet<YesNo> getYesNo() {
      return yesNo;
   }

   public EnumSet<Role> getRole() {
      return role;
   }

   public EnumSet<ControlCommand> getCommand() {
      return command;
   }
}