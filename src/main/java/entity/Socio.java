package entity;

public class Socio {

    private Long id;
    private String nomeSocio;
    private String matricula;
    private String cpf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeSocio() {
        return nomeSocio;
    }

    public void setNomeSocio(String nomeSocio) {
        this.nomeSocio = nomeSocio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Socio{" + "id=" + id + ", nomeSocio='" + nomeSocio + '\'' + ", matricula='" + matricula + '\'' + ", cpf='" + cpf + '\'' + '}';
    }
}