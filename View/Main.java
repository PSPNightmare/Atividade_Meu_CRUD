/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.Scanner;
import java.util.List;
import Controller.GameController;
import Util.BancoUtils;
import Model.Jogos;
import Model.JogosPlatina;

/**
 *
 * @author BERNARDOMACHADODEBOR
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc2 = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        GameController controller = new GameController();

        BancoUtils.CriarTabelaJogos();
        BancoUtils.CriarTabelaPlatina();
        BancoUtils.AddUnique();
        BancoUtils.AddUniquePlatina();

        int op = -1;
        while (op != 0) {
            System.out.println(" # MENU CRUD DE JOGOS # ");
            System.out.println("1. Inserir Jogo");
            System.out.println("2. Atualizar Jogo");
            System.out.println("3. Deletar Jogo");
            System.out.println("4. Consultar Jogos");
            System.out.println("5. Adicionar jogo a platina");
            System.out.println("6. Listar jogos platinados");
            System.out.println("0. Sair\n ");
            System.out.print("Escolha uma opção: ");
            op = sc2.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Nome: ");
                    String nomeInserir = sc.nextLine();
                    System.out.print("Gênero: ");
                    String generoInserir = sc.nextLine();
                    System.out.println("Nota: ");
                    double notaInserir = sc2.nextDouble();

                    controller.adicionarJogo(nomeInserir, generoInserir, notaInserir);

                    break;
                case 2:
                    System.out.println("Nome do Jogo para atualizar: ");
                    String nomeAtualizar = sc.nextLine();
                    System.out.println("Novo Gênero: ");
                    String novoGenero = sc.nextLine();
                    System.out.println("Nova Nota: ");
                    double novaNota = sc.nextDouble();
                    controller.atualizarJogo(nomeAtualizar, novoGenero, novaNota);
                    break;
                case 3:
                    System.out.println("Nome do jogo para deletar: ");
                    String nomeDeletar = sc.nextLine();
                    controller.deletarJogo(nomeDeletar);
                    break;
                case 4:
                    System.out.println("");
                    List<Jogos> jogo = controller.listarJogo();
                    if (jogo.isEmpty()) { // a lista de usuarios está vazia
                        System.out.println("Nenhum Jogo cadastrado!");
                    } else {
                        System.out.println(" - Lista de Jogos - \n\n");
                        for (Jogos j : jogo) {
                            System.out.println(j);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Digite o id do jogo para adicionar a tabela");
                    int id_jogo = sc.nextInt();
                    sc.nextLine(); // limpa o buffer
                    System.out.println("Quantas horas de jogo: ");
                    double horas = sc.nextDouble();
                    sc.nextLine(); // limpa o buffer
                    System.out.println("Qual a plataforma: ");
                    String plataforma = sc.nextLine();
                    System.out.println("Qual a dificuldade da platina?  ");
                    String dificuldade = sc.nextLine();

                    controller.adicionarPlatinas(id_jogo, horas, plataforma, dificuldade);
                    break;


                case 6:
                    List<JogosPlatina> platinas = controller.listarPlatinas();
                    if (platinas.isEmpty()) {
                        System.out.println("Nenhum jogo platinado!");
                    } else {
                        System.out.println(" - Jogos Platinados - \n");
                        for (JogosPlatina p : platinas) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa . . .");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            System.out.println("\n\n");

        }
    }

    public static void Escolha(String resp) {

    }
}
