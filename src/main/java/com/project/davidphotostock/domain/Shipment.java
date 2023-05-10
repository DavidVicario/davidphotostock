/*
Contiene información sobre envíos de pedidos realizados por los usuarios. 
Donde sale la dirección de envío y la fecha de envío. Los envios están asociados
al usuario y al municipio que se indique.
 */
package com.project.davidphotostock.domain;

//Importaciones
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Indicamos que la entidad debe ser mapeada a una tabla en una base de datos.
@Entity
//Indicamos que la entidad se mapea a una tabla.
@Table(name = "shipment")
//Definimos las consultas estaticas para encontrar los atributos.
@NamedQueries({
    @NamedQuery(name = "Shipment.findAll", query = "SELECT s FROM Shipment s"),
    @NamedQuery(name = "Shipment.findByIdShipment", query = "SELECT s FROM Shipment s WHERE s.idShipment = :idShipment"),
    @NamedQuery(name = "Shipment.findByFinished", query = "SELECT s FROM Shipment s WHERE s.finished = :finished"),
    @NamedQuery(name = "Shipment.findByAddress", query = "SELECT s FROM Shipment s WHERE s.address = :address")})
/*
Se implementa serializable para que los objetos de la clase puedan convertirse en secuencias 
de bytes. Para poder enviar, guardar y almacenar objetos en la base de datos. 
 */
public class Shipment implements Serializable {

    //Aseguramos que la clase guardada y la clase cargada sean compatibles entre sí.
    private static final long serialVersionUID = 1L;
    //Indicamos que es la clave primaria.
    @Id
    //Especificamos que se genere un valor de clave primaria cada vez que se agrega una fila nueva.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Impedimos que el valor sea Null
    @Basic(optional = false)
    //Especificamos en que columna debe de mapearse.
    @Column(name = "id_shipment")
    private Integer idShipment;
    @Basic(optional = false)
    @Column(name = "finished")
    private boolean finished;
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "shipment_date")
    //Indicamos como se mapea el atributo Date, aquí almacena la fecha y la hora.
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipmentDate = new Date();
    //Creamos un enlace entre los envios y sus municipios.
    @JoinColumn(name = "id_municipality", referencedColumnName = "id_municipality")
    //Muchos a uno, varios envios pueden tener un municipio.
    @ManyToOne
    //Almacenamos el municipio al que pertenece el envio. 
    private Municipality idMunicipality;
    //Creamos un enlace entre los envios y sus usuarios.
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    //Muchos a uno, varios envios pueden tener un usuario.
    @ManyToOne
    //Almacenamos el municipio al que pertenece el usuario.
    private Users idUser;
    //Especificamos que hay una relacion de uno a muchos con la entidad ShipmentProduct. 
    //Al ser cascade si se realiza un cambio se realizara a todos los objetos relacionados.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipment")
    //Almacenamos todos los objetos Shipment asociados con un objeto ShipmentProduct. Un ShipmentProduct puede tener varios Shipment.
    private Collection<ShipmentProduct> shipmentProductCollection;

    //Constructores
    public Shipment() {
    }

    public Shipment(Integer idShipment) {
        this.idShipment = idShipment;
    }

    //Getter and Setter
    public Integer getIdShipment() {
        return idShipment;
    }

    public void setIdShipment(Integer idShipment) {
        this.idShipment = idShipment;
    }

    public boolean getFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Municipality getIdMunicipality() {
        return idMunicipality;
    }

    public void setIdMunicipality(Municipality idMunicipality) {
        this.idMunicipality = idMunicipality;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
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
        hash += (idShipment != null ? idShipment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Shipment)) {
            return false;
        }
        Shipment other = (Shipment) object;
        if ((this.idShipment == null && other.idShipment != null) || (this.idShipment != null && !this.idShipment.equals(other.idShipment))) {
            return false;
        }
        return true;
    }

    //Metodo toString para imprimir la clase.
    @Override
    public String toString() {
        return "Shipment[ idShipment=" + this.idShipment
                + ", finished=" + this.finished
                + ", address=" + this.address
                + ", idMunicipality=" + this.idMunicipality
                + ", idUser=" + this.idUser + " ]";
    }

}
