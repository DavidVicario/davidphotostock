/*
Contiene información sobre las comunidades autónomas en España.
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Indicamos que la entidad debe ser mapeada a una tabla en una base de datos.
@Entity
//Indicamos que la entidad se mapea a una tabla.
@Table(name = "ccaa")
//Definimos las consultas estaticas para encontrar los atributos.
@NamedQueries({
    @NamedQuery(name = "Ccaa.findAll", query = "SELECT c FROM Ccaa c"),
    @NamedQuery(name = "Ccaa.findByIdCcaa", query = "SELECT c FROM Ccaa c WHERE c.idCcaa = :idCcaa"),
    @NamedQuery(name = "Ccaa.findByCcaa", query = "SELECT c FROM Ccaa c WHERE c.ccaa = :ccaa")})
/*
Se implementa serializable para que los objetos de la clase puedan convertirse en secuencias 
de bytes. Para poder enviar, guardar y almacenar objetos en la base de datos. 
 */
public class Ccaa implements Serializable {

    //Aseguramos que la clase guardada y la clase cargada sean compatibles entre sí.
    private static final long serialVersionUID = 1L;
    //Indicamos que es la clave primaria.
    @Id
    //Impedimos que el valor sea Null
    @Basic(optional = false)
    //Especificamos en que columna debe de mapearse.
    @Column(name = "id_ccaa")
    private Integer idCcaa;
    @Basic(optional = false)
    @Column(name = "ccaa")
    private String ccaa;
    //Especificamos que hay una relacion de uno a muchos con la entidad Province. 
    //Al ser cascade si se realiza un cambio se realizara a todos los objetos relacionados.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCcaa")
    //Almacenamos todos los objetos Province asociados con un objeto ccaa. Una ccaa puede tener varios Province.
    private Collection<Province> provinceCollection;

    //Constructores
    public Ccaa() {
    }

    public Ccaa(Integer idCcaa) {
        this.idCcaa = idCcaa;
    }

    public Ccaa(Integer idCcaa, String ccaa) {
        this.idCcaa = idCcaa;
        this.ccaa = ccaa;
    }

    //Getter and Setter
    public Integer getIdCcaa() {
        return idCcaa;
    }

    public void setIdCcaa(Integer idCcaa) {
        this.idCcaa = idCcaa;
    }

    public String getCcaa() {
        return ccaa;
    }

    public void setCcaa(String ccaa) {
        this.ccaa = ccaa;
    }

    public Collection<Province> getProvinceCollection() {
        return provinceCollection;
    }

    public void setProvinceCollection(Collection<Province> provinceCollection) {
        this.provinceCollection = provinceCollection;
    }

    //Metodos para verificar si son iguales dos objetos según el id
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCcaa != null ? idCcaa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Ccaa)) {
            return false;
        }
        Ccaa other = (Ccaa) object;
        if ((this.idCcaa == null && other.idCcaa != null) || (this.idCcaa != null && !this.idCcaa.equals(other.idCcaa))) {
            return false;
        }
        return true;
    }

    //Metodo toString para imprimir la clase.
    @Override
    public String toString() {
        return "Ccaa[ idCcaa=" + this.idCcaa
                + ", ccaa=" + this.ccaa + " ]";
    }

}
