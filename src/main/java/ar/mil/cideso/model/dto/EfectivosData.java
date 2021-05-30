package ar.mil.cideso.model.dto;

/**
 * Clase para enviar los datos de alta y baja de cada tipo de efectivo
 */
public class EfectivosData {

    private Integer oficialSuperior;
    private Integer oficialJefe;
    private Integer oficialSubalterno;
    private Integer suboficialSuperior;
    private Integer suboficialSubalterno;
    private Integer agenteCivil;
    private Integer soldadoVoluntario;

    public Integer getOficialSuperior() {
        return oficialSuperior;
    }

    public void setOficialSuperior(Integer oficialSuperior) {
        this.oficialSuperior = oficialSuperior;
    }

    public Integer getOficialJefe() {
        return oficialJefe;
    }

    public void setOficialJefe(Integer oficialJefe) {
        this.oficialJefe = oficialJefe;
    }

    public Integer getOficialSubalterno() {
        return oficialSubalterno;
    }

    public void setOficialSubalterno(Integer oficialSubalterno) {
        this.oficialSubalterno = oficialSubalterno;
    }

    public Integer getSuboficialSuperior() {
        return suboficialSuperior;
    }

    public void setSuboficialSuperior(Integer suboficialSuperior) {
        this.suboficialSuperior = suboficialSuperior;
    }

    public Integer getSuboficialSubalterno() {
        return suboficialSubalterno;
    }

    public void setSuboficialSubalterno(Integer suboficialSubalterno) {
        this.suboficialSubalterno = suboficialSubalterno;
    }

    public Integer getAgenteCivil() {
        return agenteCivil;
    }

    public void setAgenteCivil(Integer agenteCivil) {
        this.agenteCivil = agenteCivil;
    }

    public Integer getSoldadoVoluntario() {
        return soldadoVoluntario;
    }

    public void setSoldadoVoluntario(Integer soldadoVoluntario) {
        this.soldadoVoluntario = soldadoVoluntario;
    }

}
