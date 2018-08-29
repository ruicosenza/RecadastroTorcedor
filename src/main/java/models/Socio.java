package models;

public class Socio {

    private Long id;
    private String nome;
    private String matricula;
    private String cpf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        return "Socio{" + "id=" + id + ", nome='" + nome + '\'' + ", matricula='" + matricula + '\'' + ", cpf='" + cpf + '\'' + '}';
    }
}