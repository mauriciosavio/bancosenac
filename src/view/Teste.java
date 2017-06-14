package view;

import dao.ClienteDAO;
import dao.ContaDAO;
import java.util.Scanner;
import model.Cliente;
import model.ContaCorrente;
import model.ContaPoupanca;

public class Teste {

    public static void main(String[] args) {
        
        ContaDAO dao = new ContaDAO();
        
        Scanner entrada = new Scanner(System.in);
        int opcao;
        
        
        ContaCorrente cc = new ContaCorrente();
        ContaPoupanca cp = new ContaPoupanca();
        Cliente cliente = new Cliente();
        do {
        
            System.out.println("Digite uma opcao \n"
                    + " 0 Sair\n"
                    + "1 - Cadastrar Cliente\n"
                    + "2 - Cadastrar Conta\n"
                    + "3 - Depositar\n"
                    + "4 - Sacar\n"
                    + "5 - Transferir.");
             opcao = entrada.nextInt();
            
            switch(opcao){
                case 0:
                    System.exit(0);
                    break;
                case 1 :
                    System.out.println("Digite o CPF do cliente:");
                    cliente.setCpf(entrada.next());
                    
                    System.out.println("Digite o Nome do Cliente:");
                    cliente.setNome(entrada.next());
                    break;
                case 2:
                    System.out.println("Digite o numero da agencia:");
                    cc.setAgencia(entrada.nextInt());
                    System.out.println("Digite o numero da conta:");
                    cc.setConta(entrada.nextInt());
                    System.out.println("Informe o saldo inicial da conta:");
                    cc.setSaldo(entrada.nextFloat());
                    break;
                case 3:
                    
        cc.setAgencia(1);
        cc.setConta(1);
        cc.setSaldo(500);
        
        
        cp.setAgencia(1);
        cp.setConta(2);
        cp.setSaldo(200);
        
        dao.inserir(cc);
        dao.inserir(cp);
        
        dao.buscarPorAgenciaConta(1, 1).sacar(100);
        
        System.out.println(dao.buscarPorAgenciaConta(1, 1).toString());

        System.out.println(dao.buscarTodas().toString());
        break;
                default :
                System.out.println("Opcao Invalida!");
            }
        }while (opcao != 0);
    }
    
}