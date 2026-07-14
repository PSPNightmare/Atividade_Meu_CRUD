/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author BERNARDOMACHADODEBOR
 */
public class JogosPlatina {

    private String nome;
    private double horas;
    private String plataforma, dificuldade;

    public JogosPlatina() {
    }

    public JogosPlatina(String nome, double horas, String plataforma, String dificuldade) {
        this.nome = nome;
        this.horas = horas;
        this.plataforma = plataforma;
        this.dificuldade = dificuldade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    @Override
    public String toString() {
        return "Jogo: " + nome + " | Horas: " + horas + " | Plataforma: " + plataforma + " | Dificuldade: " + dificuldade;
    }
}
