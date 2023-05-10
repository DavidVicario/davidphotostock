/*
Contiene información sobre las categorías de productos disponibles en la web.
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Indicamos que la entidad debe ser mapeada a una tabla en una base de datos.
@Entity
//Indicamos que la entidad se mapea a una tabla.
@Table(name = "category")
//Definimos las consultas estaticas para encontrar los atributos.
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByIdCategory", query = "SELECT c FROM Category c WHERE c.idCategory = :idCategory"),
    @NamedQuery(name = "Category.findByCategoryName", query = "SELECT c FROM Category c WHERE c.categoryName = :categoryName")})
/*
Se implementa serializable para que los objetos de la clase puedan convertirse en secuencias 
de bytes. Para poder enviar, guardar y almacenar objetos en la base de datos. 
 */
public class Category implements Serializable {

    //Aseguramos que la clase guardada y la clase cargada sean compatibles entre sí.
    private static final long serialVersionUID = 1L;
    //Indicamos que es la clave primaria.
    @Id
    //Especificamos que se genere un valor de clave primaria cada vez que se agrega una fila nueva. 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Impedimos que el valor sea Null
    @Basic(optional = false)
    //Especificamos en que columna debe de mapearse.
    @Column(name = "id_category")
    private Integer idCategory;
    @Column(name = "category_name")
    private String categoryName;
    //Especificamos que hay una relacion de uno a muchos con la entidad Subcategory
    @OneToMany(mappedBy = "idCategory")
    //Almacenamos todos los objetos Subcategory asociados con un objeto Category. Una Category puede tener varios Subcategory. 
    private Collection<Subcategory> subcategoryCollection;

    //Constructores 
    public Category() {
    }

    public Category(Integer idCategory) {
        this.idCategory = idCategory;
    }

    //Getter and Setter
    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Collection<Subcategory> getSubcategoryCollection() {
        return subcategoryCollection;
    }

    public void setSubcategoryCollection(Collection<Subcategory> subcategoryCollection) {
        this.subcategoryCollection = subcategoryCollection;
    }

    //Metodos para verificar si son iguales dos objetos según el id
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategory != null ? idCategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.idCategory == null && other.idCategory != null) || (this.idCategory != null && !this.idCategory.equals(other.idCategory))) {
            return false;
        }
        return true;
    }

    //Metodo toString para imprimir la clase. 
    @Override
    public String toString() {
        return "Category[ idCategory=" + this.idCategory
                + ", categoryName=" + this.categoryName + " ]";
    }

}
