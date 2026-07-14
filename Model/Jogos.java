/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author BERNARDOMACHADODEBOR
 */
public class Jogos {
        private int id;
    private String nome, genero;
    private double nota;
    
    public Jogos(){}

    public Jogos(int id, String nome, String genero, double nota) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Jogos{" + "id=" + id + ", nome=" + nome + ", genero=" + genero + ", nota=" + nota + '}';
    }
    
    
}
