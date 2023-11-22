package View;

import Controller.Operador;
import Model.PrecoData;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Operador operador;
    private Scanner scanner;

    public Main() {
        this.operador = new Operador();
        this.scanner = new Scanner(System.in);
    }
 // Consumir a quebra de linha

    public void iniciar() {
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar preço a um produto");
            System.out.println("2. Exibir menor preço de um produto");
            System.out.println("3. Exibir histórico de preços de um produto");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    adicionarPreco();
                    break;
                case 2:
                    exibirMenorPreco();
                    break;
                case 3:
                    exibirHistoricoPrecos();
                    break;
                case 4:
                    System.out.println("Encerrando o programa.");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void adicionarPreco() {
        System.out.print("Nome do Produto: ");
        String nomeProduto = scanner.nextLine();

        System.out.print("Nome do Site: ");
        String nomeSite = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Data (dd/MM/yyyy): ");
        String data = scanner.nextLine();

        operador.addProduto(nomeProduto, nomeSite, preco, data);
        System.out.println("Preço adicionado com sucesso.");
    }

    private void exibirMenorPreco() {
        System.out.print("Nome do Produto: ");
        String nomeProduto = scanner.nextLine();

        PrecoData menorPreco = operador.menorPrecoProduto(nomeProduto);
        if (menorPreco != null) {
            System.out.println("Menor preço para " + nomeProduto + ": " + menorPreco.getPreco() + " em " + menorPreco.getData());
        } else {
            System.out.println("Preço não encontrado para o produto.");
        }
    }


    private void exibirHistoricoPrecos() {
        System.out.print("Nome do Produto: ");
        String nomeProduto = scanner.nextLine();

        List<PrecoData> historicoPrecos = operador.historicoPrecoProduto(nomeProduto);
        if (historicoPrecos != null && !historicoPrecos.isEmpty()) {
            System.out.println("Histórico de preços:");
            for (PrecoData pd : historicoPrecos) {
                System.out.println(pd.getData() + ": " + pd.getPreco());
            }
        } else {
            System.out.println("Nenhum preço encontrado para o produto.");
        }
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.iniciar();
    }
}
