package entity;

public class Socio {
    private int id;
    private String nome;

    public Socio() {

    }

    public Socio( int id, String nome ){
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
