/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Dao;
import Model.Jogos;
import java.util.List;
import Model.JogosPlatina;
/**
 *
 * @author BERNARDOMACHADODEBOR
 */
public class GameController {

    private Dao dao = new Dao();

    public void adicionarJogo(String nome, String genero, double nota) {
        dao.adicionarJogo(nome, genero, nota);
    }

    public void atualizarJogo(String nome, String novoGenero, double novaNota) {
        dao.atualizarJogo(nome, novoGenero, novaNota);
    }

    public void deletarJogo(String nome) {
        dao.deletarJogo(nome);
    }

    public List<Jogos> listarJogo() {
        return dao.listarosJogos();

    }

    public void adicionarPlatinas(int id_jogo, double horas, String plataforma, String dificuldade) {
        dao.adicionarPlatina(id_jogo, horas, plataforma, dificuldade);
    }

    public List<JogosPlatina> listarPlatinas() {
        return dao.listarPlatina();
    }

}
