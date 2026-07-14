/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Model.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author BERNARDOMACHADODEBOR
 */
public class BancoUtils {

    public static void AddUnique() {

        Connection conexao = ConexaoBD.getConexao();
        if (conexao != null) {
            String sq2 = "ALTER TABLE Jogos ADD CONSTRAINT uc_jogos UNIQUE (nome)";
            try (PreparedStatement pst = conexao.prepareStatement(sq2)) {
                pst.executeUpdate();
                System.out.println("Alteração feita com sucesso!!");
            } catch (SQLException e) {

            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }

    public static void AddUniquePlatina() {

        Connection conexao = ConexaoBD.getConexao();
        if (conexao != null) {
            String sq2 = "ALTER TABLE Platinas ADD CONSTRAINT uc_platina UNIQUE (id_jogo)";
            try (PreparedStatement pst = conexao.prepareStatement(sq2)) {
                pst.executeUpdate();
                System.out.println("Alteração feita com sucesso!!");
            } catch (SQLException e) {

            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }

    public static void CriarTabelaJogos() {
    Connection conexao = ConexaoBD.getConexao();
    if (conexao != null) {
        String sql = "create table if not exists Jogos("
                + "id int auto_increment primary key,"
                + "nome varchar(100),"
                + "genero varchar(50),"
                + "nota decimal(3,1)"
                + ")default charset utf8mb4;";
        try (PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.execute();
            System.out.println("Tabela 'Jogos' criada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela 'Jogos': " + e.getMessage());
        } finally {
            try { conexao.close(); } catch (SQLException e) {}
        }
    }
}

public static void CriarTabelaPlatina() {
    Connection conexao = ConexaoBD.getConexao();
    if (conexao != null) {
        String sql = "create table if not exists Platinas("
                + "id int auto_increment primary key,"
                + "id_jogo int,"
                + "horas double,"
                + "plataforma varchar(20),"
                + "dificuldade varchar(20),"
                + "foreign key (id_jogo) references Jogos(id)"
                + ")default charset utf8mb4;";
        try (PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.execute();
            System.out.println("Tabela 'Platinas' criada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela 'Platinas': " + e.getMessage());
        } finally {
            try { conexao.close(); } catch (SQLException e) {}
        }
    }
}
}
