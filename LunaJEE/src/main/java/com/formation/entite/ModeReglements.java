package com.formation.entite;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class ModeReglements implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
    private Long code;
	
	@Basic
    private String type;
    
    @Transient
    private transient boolean ignor�;
    
    /*
     * Constructeur 1.
     * Utilis� par JPA.
     */
    public ModeReglements(){
    	super();
    }
    
    /*
     * Constructeur 2
     * Pour la gestion des commandes
     */
    public ModeReglements(String type){
    	this();
    	this.type = type;
    }

    /*
     * Accesseurs
     */
    public Long getCode() {
        return code;
    }
    public String getType() {
        return type;
    }
    
    /*
     * Mutateur
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * D�crit le mode de r�glement
     * de mani�re textuelle.
     */
    @Override
    public String toString() {
    	return type;
    }
}