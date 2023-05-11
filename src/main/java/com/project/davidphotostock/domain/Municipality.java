/*
Contiene información sobre los municipios de España y la asociación a su 
respectiva provincia.
 */
package com.project.davidphotostock.domain;

//Importaciones
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Indicamos que la entidad debe ser mapeada a una tabla en una base de datos.
@Entity
//Indicamos que la entidad se mapea a una tabla.
@Table(name = "municipality")
//Definimos las consultas estaticas para encontrar los atributos.
@NamedQueries({
    @NamedQuery(name = "Municipality.findAll", query = "SELECT m FROM Municipality m"),
    @NamedQuery(name = "Municipality.findByIdMunicipality", query = "SELECT m FROM Municipality m WHERE m.idMunicipality = :idMunicipality"),
    @NamedQuery(name = "Municipality.findByCodMunicipality", query = "SELECT m FROM Municipality m WHERE m.codMunicipality = :codMunicipality"),
    @NamedQuery(name = "Municipality.findByDc", query = "SELECT m FROM Municipality m WHERE m.dc = :dc"),
    @NamedQuery(name = "Municipality.findByMunicipality", query = "SELECT m FROM Municipality m WHERE m.municipality = :municipality")})
/*
Se implementa serializable para que los objetos de la clase puedan convertirse en secuencias 
de bytes. Para poder enviar, guardar y almacenar objetos en la base de datos. 
 */
public class Municipality implements Serializable {

    //Aseguramos que la clase guardada y la clase cargada sean compatibles entre sí.
    private static final long serialVersionUID = 1L;
    //Indicamos que es la clave primaria.
    @Id
    //Especificamos que se genere un valor de clave primaria cada vez que se agrega una fila nueva.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Impedimos que el valor sea Null
    @Basic(optional = false)
    //Especificamos en que columna debe de mapearse.
    @Column(name = "id_municipality")
    private Integer idMunicipality;
    @Basic(optional = false)
    @Column(name = "cod_municipality")
    private int codMunicipality;
    @Basic(optional = false)
    @Column(name = "dc")
    private int dc;
    @Basic(optional = false)
    @Column(name = "municipality")
    private String municipality;
    //Especificamos que hay una relacion de uno a muchos con la entidad Shipment. 
    @OneToMany(mappedBy = "idMunicipality")
    //Almacenamos todos los objetos Shipment asociados con un objeto municipality. Una municipality puede tener varios Shipment.
    private Collection<Shipment> shipmentCollection;
    //Creamos un enlace entre los municipios y su provincia.
    @JoinColumn(name = "id_province", referencedColumnName = "id_province")
    //Muchos a uno, varios municipios pueden tener una provincia.
    @ManyToOne(optional = false)
    //Almacenamos la provincia a la que pertenecen los municipios. 
    private Province idProvince;

    //Constructores
    public Municipality() {
    }

    public Municipality(Integer idMunicipality) {
        this.idMunicipality = idMunicipality;
    }

    public Municipality(Integer idMunicipality, int codMunicipality, int dc, String municipality) {
        this.idMunicipality = idMunicipality;
        this.codMunicipality = codMunicipality;
        this.dc = dc;
        this.municipality = municipality;
    }

    //Getter and Setter
    public Integer getIdMunicipality() {
        return idMunicipality;
    }

    public void setIdMunicipality(Integer idMunicipality) {
        this.idMunicipality = idMunicipality;
    }

    public int getCodMunicipality() {
        return codMunicipality;
    }

    public void setCodMunicipality(int codMunicipality) {
        this.codMunicipality = codMunicipality;
    }

    public int getDc() {
        return dc;
    }

    public void setDc(int dc) {
        this.dc = dc;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public Collection<Shipment> getShipmentCollection() {
        return shipmentCollection;
    }

    public void setShipmentCollection(Collection<Shipment> shipmentCollection) {
        this.shipmentCollection = shipmentCollection;
    }

    public Province getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(Province idProvince) {
        this.idProvince = idProvince;
    }

    //Metodos para verificar si son iguales dos objetos según el id
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicipality != null ? idMunicipality.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Municipality)) {
            return false;
        }
        Municipality other = (Municipality) object;
        if ((this.idMunicipality == null && other.idMunicipality != null) || (this.idMunicipality != null && !this.idMunicipality.equals(other.idMunicipality))) {
            return false;
        }
        return true;
    }

    //Metodo toString para imprimir la clase.
    @Override
    public String toString() {
        return "Municipality[ idMunicipality=" + this.idMunicipality
                + ", codMunicipality=" + this.codMunicipality
                + ", dc=" + this.dc
                + ", municipality " + this.municipality
                + ", idProvince=" + this.idProvince + " ]";
    }

}
