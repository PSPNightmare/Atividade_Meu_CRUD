/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.ConexaoBD;
import Model.Jogos;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.JogosPlatina;

/**
 *
 * @author BERNARDOMACHADODEBOR
 */
public class Dao {

    //Inserir Jogo
    public void adicionarJogo(String nome, String genero, Double nota) {
        Connection conexao = ConexaoBD.getConexao();
        if (conexao != null) {
            String sql = "insert into Jogos (nome, genero, nota) values (?,?,?)";

            try (PreparedStatement pst = conexao.prepareStatement(sql)) {
                pst.setString(1, nome);
                pst.setString(2, genero);
                pst.setDouble(3, nota);
                pst.executeUpdate();
                System.out.println("Jogo inserido com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao inserir o Jogo: " + e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }

    // Atualizar Jogo
    public void atualizarJogo(String nome, String novoGenero, Double novaNota) {
        Connection conexao = ConexaoBD.getConexao();
        if (conexao != null) {
            String sql = "update Jogos set genero = ?, nota = ? where nome = ?";
            try (PreparedStatement pst = conexao.prepareStatement(sql)) {
                pst.setString(1, novoGenero);
                pst.setString(2, nome);
                pst.setDouble(3, novaNota);
                pst.executeUpdate();
                System.out.println("Jogo atualizado na lista com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao atualizar o usuário: " + e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }

    //Deletar Jogo
    public void deletarJogo(String nome) {
        Connection conexao = ConexaoBD.getConexao();
        if (conexao != null) {
            String sql = "delete from Jogos where nome = ?";
            try (PreparedStatement pst = conexao.prepareStatement(sql)) {
                pst.setString(1, nome);
                pst.executeUpdate();
                System.out.println("Jogo deletado da lista com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao deletar o Jogo: " + e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }

    //Listar Jogo
    public List<Jogos> listarosJogos() {
        List<Jogos> Jogo = new ArrayList<>();
        Connection conexao = ConexaoBD.getConexao();
        if (conexao != null) {
            String sql = "select * from Jogos";
            try (PreparedStatement pst = conexao.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Jogos jogo = new Jogos();
                    jogo.setId(rs.getInt("id"));
                    jogo.setNome(rs.getString("nome"));
                    jogo.setGenero(rs.getString("genero"));
                    jogo.setNota(rs.getDouble("nota"));
                    Jogo.add(jogo);
                }
            } catch (SQLException e) {
                System.out.println("Erro ao listar os Jogos: " + e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }

        return Jogo;

    }

    public void adicionarPlatina(int id_jogo, double horas, String plataforma, String dificuldade) {
        Connection conexao = ConexaoBD.getConexao();
        if (conexao != null) {
            String sql = "insert into Platinas (id_jogo ,horas, plataforma, dificuldade) values (?,?,?,?)";

            try (PreparedStatement pst = conexao.prepareStatement(sql)) {
                pst.setInt(1, id_jogo);
                pst.setDouble(2, horas);
                pst.setString(3, plataforma);
                pst.setString(4, dificuldade);
                
                pst.executeUpdate();
                System.out.println("Jogo inserido com sucesso a tabela platinas!");
            } catch (SQLException e) {
                System.out.println("Erro ao inserir o Jogo nas platinas: " + e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }
    
public List<JogosPlatina> listarPlatina() {
    List<JogosPlatina> lista = new ArrayList<>();
    Connection conexao = ConexaoBD.getConexao();
    if (conexao != null) {
        String sql = "select j.nome, p.horas, p.plataforma, p.dificuldade "
                + "from Platinas as p "
                + "inner join Jogos as j on j.id = p.id_jogo";
        try (PreparedStatement pst = conexao.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                JogosPlatina jp = new JogosPlatina();
                jp.setNome(rs.getString("nome"));
                jp.setHoras(rs.getDouble("horas"));
                jp.setPlataforma(rs.getString("plataforma"));
                jp.setDificuldade(rs.getString("dificuldade"));
                lista.add(jp);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar tabela platina: " + e.getMessage());
        } finally {
            try { conexao.close(); } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
    return lista;
}
}