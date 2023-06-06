/*
Contiene información sobre las subcategorías de productos y que están asociadas 
a las categorías principales.
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
@Table(name = "subcategory")
//Definimos las consultas estaticas para encontrar los atributos.
@NamedQueries({
    @NamedQuery(name = "Subcategory.findAll", query = "SELECT s FROM Subcategory s"),
    @NamedQuery(name = "Subcategory.findByIdSubcategory", query = "SELECT s FROM Subcategory s WHERE s.idSubcategory = :idSubcategory"),
    @NamedQuery(name = "Subcategory.findBySubcategoryName", query = "SELECT s FROM Subcategory s WHERE s.subcategoryName = :subcategoryName")})
/*
Se implementa serializable para que los objetos de la clase puedan convertirse en secuencias 
de bytes. Para poder enviar, guardar y almacenar objetos en la base de datos. 
 */
public class Subcategory implements Serializable {

    //Aseguramos que la clase guardada y la clase cargada sean compatibles entre sí.
    private static final long serialVersionUID = 1L;
    //Indicamos que es la clave primaria.
    @Id
    //Especificamos que se genere un valor de clave primaria cada vez que se agrega una fila nueva.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Impedimos que el valor sea Null
    @Basic(optional = false)
    //Especificamos en que columna debe de mapearse.
    @Column(name = "id_subcategory")
    private Integer idSubcategory;
    @Column(name = "subcategory_name")
    private String subcategoryName;
    //Especificamos que hay una relacion de uno a muchos con la entidad Product
    @OneToMany(mappedBy = "idSubcategory")
    //Almacenamos todos los objetos Product asociados con un objeto Subcategory. Un Subcategory puede tener varios Product.
    private Collection<Product> productCollection;
    //Creamos un enlace entre las subcategorias y sus categorias.
    @JoinColumn(name = "id_category", referencedColumnName = "id_category")
    //Muchos a uno, varias subcategorias pueden tener una categoria.
    @ManyToOne
    //Almacenamos la subcategoria a la que pertenece la categoria. 
    private Category idCategory;

    //Constructores
    public Subcategory() {
    }

    public Subcategory(Integer idSubcategory) {
        this.idSubcategory = idSubcategory;
    }
    
    public Subcategory(String subcategoryName, Category idCategory) {
        this.subcategoryName = subcategoryName;
        this.idCategory = idCategory;
    }

    //Getter and Setter
    public Integer getIdSubcategory() {
        return idSubcategory;
    }

    public void setIdSubcategory(Integer idSubcategory) {
        this.idSubcategory = idSubcategory;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    //Metodos para verificar si son iguales dos objetos según el id
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubcategory != null ? idSubcategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Subcategory)) {
            return false;
        }
        Subcategory other = (Subcategory) object;
        if ((this.idSubcategory == null && other.idSubcategory != null) || (this.idSubcategory != null && !this.idSubcategory.equals(other.idSubcategory))) {
            return false;
        }
        return true;
    }

    //Metodo toString para imprimir la clase.
    @Override
    public String toString() {
        return "Subcategory[ idSubcategory=" + this.idSubcategory
                + ", subcategoryName=" + this.subcategoryName
                + ", idCategory=" + this.idCategory + " ]";
    }

}
