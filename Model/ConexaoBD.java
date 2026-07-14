/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author BERNARDOMACHADODEBOR
 */
public class ConexaoBD {
    
     private static final String url = "jdbc:mysql://localhost:3306/meu_crud_jogos";
    private static final String usuario = "root";
    private static final String senha = "root";

    public static Connection getConexao() {
        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
            
        }
    }
}

