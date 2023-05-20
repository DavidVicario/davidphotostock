/*
Contiene información sobre los usuarios registrados en la web. Estarían sus datos 
personales, dirección, nombre de usuario, mail y si tienen privilegios de administrador.
Se asocia con municipio, aunque luego se pueda modificar en el envio.
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
@Table(name = "users")
//Definimos las consultas estaticas para encontrar los atributos.
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByIdUser", query = "SELECT u FROM Users u WHERE u.idUser = :idUser"),
    @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name"),
    @NamedQuery(name = "Users.findByFirstSurname", query = "SELECT u FROM Users u WHERE u.firstSurname = :firstSurname"),
    @NamedQuery(name = "Users.findBySecondSurname", query = "SELECT u FROM Users u WHERE u.secondSurname = :secondSurname"),
    @NamedQuery(name = "Users.findByMail", query = "SELECT u FROM Users u WHERE u.mail = :mail"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")})
/*
Se implementa serializable para que los objetos de la clase puedan convertirse en secuencias 
de bytes. Para poder enviar, guardar y almacenar objetos en la base de datos. 
 */
public class Users implements Serializable {

    //Aseguramos que la clase guardada y la clase cargada sean compatibles entre sí.
    private static final long serialVersionUID = 1L;
    //Indicamos que es la clave primaria.
    @Id
    //Especificamos que se genere un valor de clave primaria cada vez que se agrega una fila nueva.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Impedimos que el valor sea Null
    @Basic(optional = false)
    //Especificamos en que columna debe de mapearse.
    @Column(name = "id_user")
    private Integer idUser;
    @Column(name = "name")
    private String name;
    @Column(name = "first_surname")
    private String firstSurname;
    @Column(name = "second_surname")
    private String secondSurname;
    @Column(name = "mail")
    private String mail;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    //Especificamos que hay una relacion de uno a muchos con la entidad Shipment
    @OneToMany(mappedBy = "idUser")
    //Almacenamos todos los objetos Shipment asociados con un objeto Users. Un usuario puede tener varios envios.
    private Collection<Shipment> shipmentCollection;
    @Basic(optional = false)
    @Column(name = "admin")
    private boolean admin;

    //Constructores
    public Users() {
    }    

    public Users(Integer idUser) {
        this.idUser = idUser;
    }
    
    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users(String name, String firstSurname, String secondSurname, String mail, String username, String password) {
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.mail = mail;
        this.username = username;
        this.password = password;
    }
    
    //Getter and Setter
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Collection<Shipment> getShipmentCollection() {
        return shipmentCollection;
    }

    public void setShipmentCollection(Collection<Shipment> shipmentCollection) {
        this.shipmentCollection = shipmentCollection;
    }

    //Metodos para verificar si son iguales dos objetos según el id
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    //Metodo toString para imprimir la clase.
    @Override
    public String toString() {
        return "Users[ idUser=" + this.idUser
                + ", name=" + this.name
                + ", firstSurname=" + this.firstSurname
                + ", secondSurname=" + this.secondSurname
                + ", mail=" + this.mail
                + ", username=" + this.username
                + ", password=" + this.password + " ]";
    }

}
