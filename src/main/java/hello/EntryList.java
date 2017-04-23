/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.SortedSet;

/**
 *
 * @author ilya
 */
public class EntryList {
    SortedSet<Entry> list;
    
    public SortedSet<Entry> getList() {
        return list;
    }
    
    public EntryList(SortedSet<Entry> list){
        this.list = list;
    }
}
