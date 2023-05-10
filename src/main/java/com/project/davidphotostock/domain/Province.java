/*
Contiene información sobre las provincias de España y la asociación a su 
respectiva comunidad autónoma.
 */
package com.project.davidphotostock.domain;

//Importaciones
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "province")
//Definimos las consultas estaticas para encontrar los atributos.
@NamedQueries({
    @NamedQuery(name = "Province.findAll", query = "SELECT p FROM Province p"),
    @NamedQuery(name = "Province.findByIdProvince", query = "SELECT p FROM Province p WHERE p.idProvince = :idProvince"),
    @NamedQuery(name = "Province.findByProvince", query = "SELECT p FROM Province p WHERE p.province = :province")})
/*
Se implementa serializable para que los objetos de la clase puedan convertirse en secuencias 
de bytes. Para poder enviar, guardar y almacenar objetos en la base de datos. 
 */
public class Province implements Serializable {

    //Aseguramos que la clase guardada y la clase cargada sean compatibles entre sí.
    private static final long serialVersionUID = 1L;
    //Indicamos que es la clave primaria.
    @Id
    //Impedimos que el valor sea Null
    @Basic(optional = false)
    //Especificamos en que columna debe de mapearse.
    @Column(name = "id_province")
    private Integer idProvince;
    @Column(name = "province")
    private String province;
    //Creamos un enlace entre los provincia y su ccaa.
    @JoinColumn(name = "id_ccaa", referencedColumnName = "id_ccaa")
    //Muchos a uno, varias provincias pueden tener una ccaa.
    @ManyToOne(optional = false)
    //Almacenamos la ccaa a la que pertenecen las provincias.
    private Ccaa idCcaa;
    //Especificamos que hay una relacion de uno a muchos con la entidad Municipality. 
    //Al ser cascade si se realiza un cambio se realizara a todos los objetos relacionados.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProvince")
    //Almacenamos todos los objetos Municipality asociados con un objeto province. Una province puede tener varios Municipality.
    private Collection<Municipality> municipalityCollection;

    //Constructores
    public Province() {
    }

    public Province(Integer idProvince) {
        this.idProvince = idProvince;
    }

    //Getter and Setter
    public Integer getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(Integer idProvince) {
        this.idProvince = idProvince;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Ccaa getIdCcaa() {
        return idCcaa;
    }

    public void setIdCcaa(Ccaa idCcaa) {
        this.idCcaa = idCcaa;
    }

    public Collection<Municipality> getMunicipalityCollection() {
        return municipalityCollection;
    }

    public void setMunicipalityCollection(Collection<Municipality> municipalityCollection) {
        this.municipalityCollection = municipalityCollection;
    }

    //Metodos para verificar si son iguales dos objetos según el id
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProvince != null ? idProvince.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Province)) {
            return false;
        }
        Province other = (Province) object;
        if ((this.idProvince == null && other.idProvince != null) || (this.idProvince != null && !this.idProvince.equals(other.idProvince))) {
            return false;
        }
        return true;
    }

    //Metodo toString para imprimir la clase.
    @Override
    public String toString() {
        return "Province[ idProvince=" + this.idProvince
                + ", province=" + this.province
                + ", idCcaa=" + this.idCcaa + " ]";
    }

}
