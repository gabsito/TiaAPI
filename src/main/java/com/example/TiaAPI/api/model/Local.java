package com.example.TiaAPI.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_local")
    private int idLocal;

    @NotEmpty(message = "El codigo del local es requerido")
    @Column(name = "codigo_local", unique = true)
    private String codigoLocal;

    @NotEmpty(message = "La direccion del local es requerida")
    @Column(name = "direccion")
    private String direccion;
    
    public Local() {
    }

    public Local(String codigoLocal, String direccion) {
        this.codigoLocal = codigoLocal;
        this.direccion = direccion;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public String getCodigoLocal() {
        return codigoLocal;
    }

    public void setCodigoLocal(String codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
}
