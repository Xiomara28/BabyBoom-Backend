package com.babyboomproyect.babyboom.DTO;

public class TipoEnfermedadDTO {

    private Long idEnfermedad;
    private String nombreEnfermedad;
    private String tipoTipoEnfermedad;

    // Getters y Setters

    public Long getIdEnfermedad() {
        return idEnfermedad;
    }

    public void setIdEnfermedad(Long idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }

    public String getNombreEnfermedad() {
        return nombreEnfermedad;
    }

    public void setNombreEnfermedad(String nombreEnfermedad) {
        this.nombreEnfermedad = nombreEnfermedad;
    }

    public String getTipoTipoEnfermedad() {
        return tipoTipoEnfermedad;
    }

    public void setTipoTipoEnfermedad(String tipoTipoEnfermedad) {
        this.tipoTipoEnfermedad = tipoTipoEnfermedad;
    }
}
