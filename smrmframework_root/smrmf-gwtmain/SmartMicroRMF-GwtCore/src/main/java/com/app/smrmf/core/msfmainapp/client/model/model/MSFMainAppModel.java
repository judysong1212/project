/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.model.model;

import java.util.Iterator;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.form.NoticePage;
import com.app.smrmf.core.msfmainapp.client.form.WindowFactory;
 

public class MSFMainAppModel extends BaseAppModel {
 

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Entry entryMenu;
//TODO 확인필요  -정리
    public MSFMainAppModel() {
        entryMenu = new Entry(
                String.valueOf(MSFMainApp.ENTRY_MENU_NAME), 
               // "<font size=2>" + MSFMainApp.ADMINCONSTANTS.Menu() +  "</font>", MSFMainApp.ADMINCONSTANTS.Categoria(),
                 MSFMainApp.ADMINCONSTANTS.Menu() , MSFMainApp.ADMINCONSTANTS.Categoria(),
             //   WindowFactory.get(MenuPage.class.getName()), 
                WindowFactory.get(NoticePage.class.getName()), 
                null, 
                null, 
                true, 
                false);
        //set("menu", new Entry(MSFMainApp.ADMINCONSTANTS.Menu(), new MenuPage(), null, true, false));
        set("menu", entryMenu);
        List<Category> categories = MSFMainApp.get().getAppMenu();
        Iterator<Category> iter = categories.iterator();
        while (iter.hasNext()) {
            add(iter.next());
        }
//        loadEntries(this);
    }

//    public Entry findEntry(String name) {
//        if (get(name) != null) {
//            return (Entry) get(name);
//        }
//        for (Entry entry : getEntries()) {
//            if (name.equals(entry.getId())) {
//                return entry;
//            }
//        }
//        return null;
//    }

//    private void loadEntries(TreeModel model) {
//        for (ModelData child : model.getChildren()) {
//            if (child instanceof Entry) {
//                entries.add((Entry) child);
//            } else if (child instanceof Category) {
//                loadEntries((Category) child);
//            } else if (child instanceof Folder) {
//                loadEntries((Folder) child);
//            }
//        }
//    }
    
    public Entry getEntryMenu(){
        return entryMenu;
    }
}
