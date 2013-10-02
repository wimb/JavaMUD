/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.entities;
    
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 01-10-2013 (tmtvl): Complete version.
 *          0.1: 30-09-2013 (tmtvl): Initial version.
 */
@Entity
@Table(name = "item")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private long id;
    
    /*
     *  Dit wordt dus een ManyToOne naar IHeeftItems (wat een Karakter of een Locatie kan zijn
     */    
    @ManyToOne
    @JoinColumn(name = "EigenaarId")
    private Karakter eigenaar;
    
    @ManyToOne
    @JoinColumn(name = "PositieId")
    private Lokatie positie;
    
    public Item(){
        eigenaar = null;
        positie = null;
    }
    
    public Item(Lokatie positie){
        this();
        setPositie(positie);
    }
    
    public Item(Karakter eigenaar){
        this();
        setEigenaar(eigenaar);
    }
    
    /*
     *  Dit wordt dus Item( ..., IHeeftItems) 
     *  
     *  Maar zowiso, indien je niet met een gemeenschappelijke basiklasse werkt, 
     *  Maak je beter 2 constructors
     *     Item( ..., Karakter k)
     *     Item( ..., Lokatie k)
     *  Nu reken je erop dat de gebruiker van je klasse 1 van beide leeg laat, maar je dwingt dit neit af!
     */
    public Item(long id, Karakter eigenaar, Lokatie positie){
        setId(id);
        setEigenaar(eigenaar);
        setPositie(positie);
    }
    
    public void setId(long id){
        this.id = id;
    }
    
    public void setEigenaar(Karakter eigenaar){
        if(this.eigenaar != null && this.eigenaar.hasItem(this)){
            this.eigenaar.removeItem(this);
        }
        this.eigenaar = eigenaar;
        if(eigenaar != null && !eigenaar.hasItem(this)){
            eigenaar.addItem(this);
            setPositie(null);
        }
    }
    
    public void setPositie(Lokatie positie){
        if(this.positie != null && this.positie.hasItem(this)){
            this.positie.removeItem(this);
        }
        this.positie = positie;
        if(positie != null && !positie.hasItem(this)){
            positie.addItem(this);
            setEigenaar(null);
        }
    }
    
    public long getId(){
        return id;
    }
    
    public Karakter getEigenaar(){
        return eigenaar;
    }
    
    public Lokatie getPositie(){
        return positie;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Item){
            Item item = (Item) obj;
            if(this.id != 0){
                return item.getId() == this.id;
            }
            else {
                if(this.eigenaar != null){
                    return this.eigenaar.equals(item.getEigenaar());
                }
                else if(this.positie != null){
                    return this.positie.equals(item.getPositie());
                }
                else {
                    return item.getEigenaar() == null && item.getPositie() == null;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 83 * hash + Objects.hashCode(this.eigenaar);
        hash = 83 * hash + Objects.hashCode(this.positie);
        return hash;
    }
    
}
