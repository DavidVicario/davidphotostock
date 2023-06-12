/*
Contiene información sobre qué productos están incluidos en un envío específico 
y la cantidad de cada producto.
 */
package com.project.davidphotostock.domain;

//Importaciones
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//Indicamos que la entidad debe ser mapeada a una tabla en una base de datos.
@Entity
//Indicamos que la entidad se mapea a una tabla.
@Table(name = "shipment_product")
//Definimos las consultas estaticas para encontrar los atributos.
@NamedQueries({
    @NamedQuery(name = "ShipmentProduct.findAll", query = "SELECT s FROM ShipmentProduct s"),
    @NamedQuery(name = "ShipmentProduct.findByIdShipmentProduct", query = "SELECT s FROM ShipmentProduct s WHERE s.shipmentProductPK.idShipmentProduct = :idShipmentProduct"),
    @NamedQuery(name = "ShipmentProduct.findByAmount", query = "SELECT s FROM ShipmentProduct s WHERE s.amount = :amount"),
    @NamedQuery(name = "ShipmentProduct.findByIdShipment", query = "SELECT s FROM ShipmentProduct s WHERE s.shipmentProductPK.idShipment = :idShipment")})
/*
Se implementa serializable para que los objetos de la clase puedan convertirse en secuencias 
de bytes. Para poder enviar, guardar y almacenar objetos en la base de datos. 
 */
public class ShipmentProduct implements Serializable {

    //Aseguramos que la clase guardada y la clase cargada sean compatibles entre sí.
    private static final long serialVersionUID = 1L;
    /*
    Indicamos que ShipmentProductPK es una clave primaria compuesta incrustada. A la 
    hora de llamar al id de ShipmentProduct se llamaria a ShipmentProductPK.
     */
    @EmbeddedId
    protected ShipmentProductPK shipmentProductPK;
    //Impedimos que el valor sea Null
    @Basic(optional = false)
    //Especificamos en que columna debe de mapearse.
    @Column(name = "amount")
    private int amount;
    //Creamos un enlace entre ShipmentProduct y su Product.
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    //Muchos a uno, varios ShipmentProduct pueden tener un Product.
    @ManyToOne
    //Almacenamos el Product al que pertenecen los ShipmentProduct.
    private Product idProduct;
    //Creamos un enlace entre ShipmentProduct y su Shipment.
    @JoinColumn(name = "id_shipment", referencedColumnName = "id_shipment", insertable = false, updatable = false)
    //Muchos a uno, varios ShipmentProduct pueden tener un Shipment.
    @ManyToOne(optional = false)
    //Almacenamos el Shipment al que pertenecen los ShipmentProduct.
    private Shipment shipment;

    //Constructores
    public ShipmentProduct() {
    }

    public ShipmentProduct(ShipmentProductPK shipmentProductPK) {
        this.shipmentProductPK = shipmentProductPK;
    }

    public ShipmentProduct(ShipmentProductPK shipmentProductPK, int amount) {
        this.shipmentProductPK = shipmentProductPK;
        this.amount = amount;
    }

    public ShipmentProduct(int idShipmentProduct, int idShipment) {
        this.shipmentProductPK = new ShipmentProductPK(idShipmentProduct, idShipment);
    }

    public ShipmentProduct(int amount, Product idProduct, Shipment shipment) {
        this.amount = amount;
        this.idProduct = idProduct;
        this.shipment = shipment;
    }

    //Getter and Setter
    public ShipmentProductPK getShipmentProductPK() {
        return shipmentProductPK;
    }

    public void setShipmentProductPK(ShipmentProductPK shipmentProductPK) {
        this.shipmentProductPK = shipmentProductPK;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    //Metodos para verificar si son iguales dos objetos según el id
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shipmentProductPK != null ? shipmentProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShipmentProduct)) {
            return false;
        }
        ShipmentProduct other = (ShipmentProduct) object;
        if ((this.shipmentProductPK == null && other.shipmentProductPK != null) || (this.shipmentProductPK != null && !this.shipmentProductPK.equals(other.shipmentProductPK))) {
            return false;
        }
        return true;
    }

    //Metodo toString para imprimir la clase.
    @Override
    public String toString() {
        return "ShipmentProduct[ shipmentProductPK=" + shipmentProductPK
                + ", amount=" + this.amount
                + ", idProduct=" + this.idProduct + " ]";
    }

}
