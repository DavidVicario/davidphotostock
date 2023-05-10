/*
Contiene información sobre los productos que se venden en la web. Su nombre, stock, 
precio y la subcategoría a la que esta asociada.
 */
package com.project.davidphotostock.domain;

//Importaciones
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "product")
//Definimos las consultas estaticas para encontrar los atributos.
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByIdProduct", query = "SELECT p FROM Product p WHERE p.idProduct = :idProduct"),
    @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName = :productName"),
    @NamedQuery(name = "Product.findByStock", query = "SELECT p FROM Product p WHERE p.stock = :stock"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price")})
/*
Se implementa serializable para que los objetos de la clase puedan convertirse en secuencias 
de bytes. Para poder enviar, guardar y almacenar objetos en la base de datos. 
 */
public class Product implements Serializable {

    //Aseguramos que la clase guardada y la clase cargada sean compatibles entre sí.
    private static final long serialVersionUID = 1L;
    //Indicamos que es la clave primaria.
    @Id
    //Especificamos que se genere un valor de clave primaria cada vez que se agrega una fila nueva.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Impedimos que el valor sea Null
    @Basic(optional = false)
    //Especificamos en que columna debe de mapearse.
    @Column(name = "id_product")
    private Integer idProduct;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "stock")
    private Integer stock;
    // @Max(value=?)  @Min(value=?) Incluir¿?
    @Column(name = "price")
    //BigDecimal es una clase de Java para representar decimales con altra precision y controlar el redondeo.
    private BigDecimal price;
    //Creamos un enlace entre los productos y sus subcategorias.
    @JoinColumn(name = "id_subcategory", referencedColumnName = "id_subcategory")
    //Muchos a uno, varios productos pueden tener una subcategoria.
    @ManyToOne
    //Almacenamos la subcategoria a la que pertenecen los productos.
    private Subcategory idSubcategory;
    //Especificamos que hay una relacion de uno a muchos con la entidad ShipmentProduct
    @OneToMany(mappedBy = "idProduct")
    //Almacenamos todos los objetos ShipmentProduct asociados con un objeto Producto. Un producto puede tener varios. 
    private Collection<ShipmentProduct> shipmentProductCollection;

    //Constructor
    public Product() {
    }

    public Product(Integer idProduct) {
        this.idProduct = idProduct;
    }

    //Getter and Setter
    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Subcategory getIdSubcategory() {
        return idSubcategory;
    }

    public void setIdSubcategory(Subcategory idSubcategory) {
        this.idSubcategory = idSubcategory;
    }

    public Collection<ShipmentProduct> getShipmentProductCollection() {
        return shipmentProductCollection;
    }

    public void setShipmentProductCollection(Collection<ShipmentProduct> shipmentProductCollection) {
        this.shipmentProductCollection = shipmentProductCollection;
    }

    //Metodos para verificar si son iguales dos objetos según el id
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduct != null ? idProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    //Metodo toString para imprimir la clase. 
    @Override
    public String toString() {
        return "Product[ idProduct=" + this.idProduct
                + ", productName=" + this.productName
                + ", stock=" + this.stock
                + ", price" + this.price
                + ", idSubcategory=" + this.idSubcategory + " ]";
    }

}
