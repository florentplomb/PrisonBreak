package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.item.BananaPeel;
import model.item.Item;
import model.item.Transportable;

/**
 * This class represents players in the game. Each player has a current location
 * and also a list contains which rooms he where in before.
 */
public class Player {

    private int point;
    private int move;
    private String name;
    private Room currentRoom;
    private ArrayList<Room> previousRooms;
    private HashMap<String, Transportable> items;

    //This is Constructor.
    /**
     * Create a simple player to display in the scoreView
     *
     * @param name of the player
     * @param point of the player
     * @param move number of move
     */
    public Player(String name, Integer point, Integer move) {
        this.name = name;
        this.point = point;
        this.move = move;
    }

    /**
     * Construcor
     *
     * @param name the player's name
     */
    public Player(String name) {
        this.name = name;
        currentRoom = null;
        previousRooms = new ArrayList<Room>();
        items = new HashMap<String, Transportable>();
        this.addItem(new BananaPeel("BananaPeel", "BananaPeel", 1, false, "/images/banana.jpg"));
        this.point = 0;
    }

    /**
     * Return the current room for this player.
     *
     * @return the room
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Set the current room for this player.
     */
    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    /**
     * Returns the list of previous room that this player where in before.
     *
     * @return arraylist of room
     */
    public ArrayList getPreviousRooms() {
        return previousRooms;
    }

    /**
     * Adds the list of previously visited rooms.
     */
    public void addPreviousRoom(Room room) {
        previousRooms.add(room);
    }

    /**
     * add a item to the player
     *
     * @param t the new item
     */
    public void addItem(Transportable t) {
        items.put(t.getNAME().toLowerCase(), t);
    }

    /**
     * Remove item to the player
     *
     * @param itemName the item removed
     */
    public void removeItem(String itemName) {

        items.remove(itemName);
    }

    /**
     * Return item with name
     */
    public Item getItem(String itemName) {
        return items.get(itemName);
    }

    /**
     * Return all items
     *
     * @return
     */
    public ArrayList<Transportable> getAllItems() {
        return new ArrayList<Transportable>(items.values());
    }

    /**
     * Return the weight of player's items
     *
     * @return
     */

    public Integer getWeightItems() {
        int weight = 0;

        for (Map.Entry element : items.entrySet()) {
            Transportable item = (Transportable) element.getValue();
            weight += item.getWEIGHT();
        }
        return weight;
    }

    /**
     * Add point of quizz
     *
     * @param point point added
     */

    public void addPoint(Integer point) {
        this.point = this.point + point;
    }

    /**
     * @return the point
     */
    public int getPoint() {
        return point;
    }

    /**
     * @return the move
     */
    public int getMove() {
        return move;
    }

    /**
     * @param move the move to set
     */
    public void setMove(int move) {
        this.move += move;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
