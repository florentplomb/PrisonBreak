/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.item;

/**
 *
 * @author Florent Plomb <plombf at gmail.com>
 */
public abstract class Item {

    private final String NAME;
    private final String DESCRIPTION;

    public Item (String name,String description) {
        this.NAME = name;
        this.DESCRIPTION = description;
    }
    
    public abstract void action();
}