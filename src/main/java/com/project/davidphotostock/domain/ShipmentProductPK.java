/*
Se utiliza como una clave primaria compuesta en la clase ShipmentProduct para 
representar la relación de muchos a muchos entre las entidades Shipment y Product. 
Esta relación permite que un envío contenga múltiples productos y que un producto 
pueda estar en varios envíos.
 */
package com.project.davidphotostock.domain;

//Importaciones
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/*
ShipmentProductPK no es una entidad completa. Si no que forma parte de ShipmentProduct.
ShipmentProductPK la utilizo para representar la clave primaria compuesta que esta presente
en ShipmentProduct. 
Por eso aquí no escribimos las anotaciones @Entity, @Table y @NamedQueries. Ya que estás
se llaman desde ShipmentProduct. 
 */
//Indicamos que es un objeto incrustable y es usado como parte de otra entidad.
@Embeddable
/*
Se implementa serializable para que los objetos de la clase puedan convertirse en secuencias 
de bytes. Para poder enviar, guardar y almacenar objetos en la base de datos. 
 */
public class ShipmentProductPK implements Serializable {

    //Impedimos que el valor sea Null
    @Basic(optional = false)
    //Especificamos en que columna debe de mapearse.
    @Column(name = "id_shipment_product")
    private int idShipmentProduct;
    @Basic(optional = false)
    @Column(name = "id_shipment")
    private int idShipment;

    //Constructores
    public ShipmentProductPK() {
    }

    public ShipmentProductPK(int idShipmentProduct, int idShipment) {
        this.idShipmentProduct = idShipmentProduct;
        this.idShipment = idShipment;
    }

    //Getter and Setter
    public int getIdShipmentProduct() {
        return idShipmentProduct;
    }

    public void setIdShipmentProduct(int idShipmentProduct) {
        this.idShipmentProduct = idShipmentProduct;
    }

    public int getIdShipment() {
        return idShipment;
    }

    public void setIdShipment(int idShipment) {
        this.idShipment = idShipment;
    }

    //Metodos para verificar si son iguales dos objetos según el id
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idShipmentProduct;
        hash += (int) idShipment;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ShipmentProductPK)) {
            return false;
        }
        ShipmentProductPK other = (ShipmentProductPK) object;
        if (this.idShipmentProduct != other.idShipmentProduct) {
            return false;
        }
        if (this.idShipment != other.idShipment) {
            return false;
        }
        return true;
    }

    //Metodo toString para imprimir la clase.
    @Override
    public String toString() {
        return "ShipmentProductPK[ idShipmentProduct=" + idShipmentProduct
                + ", idShipment=" + idShipment + " ]";
    }

}
