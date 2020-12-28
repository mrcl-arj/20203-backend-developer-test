package com.marcelo.ZSSN.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "item")
public class Item {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
    @ManyToOne
    @JoinColumn(name = "survivor_id")
    private Survivor survivor;

	@ManyToOne
    @JoinColumn(name = "itemType_id")
    private ItemType itemType;
    
    private int amount;
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
    public Survivor getSurvivor() {
		return survivor;
	}

	public void setSurvivor(Survivor survivor) {
		this.survivor = survivor;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

}
