package view;

import model.Produto;
import dao.ProdutoDao;
import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ProdutoDao p1 = new ProdutoDao();
        int id;
        String descricao;
        float preco;
        LocalDate validade;

        int opcao;
        do {

            JOptionPane.showMessageDialog(null, "Escolha uma opção: \n" +
                    "1 - Cadastrar produtos.\n" +
                    "2 - Listar produtos.\n" +
                    "3 - Atualizar produtos.\n" +
                    "4 - Excluir produtos.\n" +
                    "5 - Sair do programa.");
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:", "1"));
            switch (opcao) {
                case 1:
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto:"));
                    descricao = JOptionPane.showInputDialog("Digite a descrição do produto:");
                    preco = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do produto:"));
                    validade = LocalDate.parse(JOptionPane.showInputDialog("Digite a data de validade do produto:"));

                    p1.adicionarProduto(new Produto(id, descricao, preco, validade));

                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Lista de produtos"+ p1.getProdutos());
                    break;
                case 3:
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto:"));
                    descricao = JOptionPane.showInputDialog("Digite a descrição do produto:");
                    preco = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do produto:"));
                    validade = LocalDate.parse(JOptionPane.showInputDialog("Digite a data de validade do produto:"));

                    p1.atualizar(new Produto(id, descricao, preco, validade));
                    break;
                case 4:
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto: "));
                    p1.removerProduto(new Produto(id,null,0,null));
                    System.out.println(p1.getProdutos());

                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);

            }
        }
        while (opcao != 5);

    }
}