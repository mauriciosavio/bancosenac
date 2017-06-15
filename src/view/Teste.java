package view;

import dao.ClienteDAO;
import dao.ContaDAO;
import java.util.Scanner;
import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

public class Teste {

    public static void main(String[] args) {
        
        ContaDAO dao = new ContaDAO();
        
        Scanner entrada = new Scanner(System.in);
        int opcao;
        int agencia;
        int conta;
        
        ContaCorrente cc = new ContaCorrente();
        ContaPoupanca cp = new ContaPoupanca();
        Cliente cliente = new Cliente();
        ContaDAO c1 = new ContaDAO() ;
        
        
        do {
        
            System.out.println("Digite uma opcao \n"
                    + " 0 Sair\n"
                    + "1 - Cadastrar Cliente\n"
                    + "2 - Cadastrar Conta\n"
                    + "3 - Depositar\n"
                    + "4 - Sacar\n"
                    + "5 - Transferir."
                    + "6 - Saldo");
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
                    System.out.println("Informe a agencia:");
                    agencia = entrada.nextInt();
                    System.out.println("Informe a conta:");
                    conta = entrada.nextInt();
                                        
                    if(cc.getAgencia() == agencia && cc.getConta() == conta ){
                        System.out.println("Informe o valor do deposito:");
                        cc.depositar(entrada.nextFloat());
                    }else{
                        System.out.println("Conta ou Agencia Invalidas!");
                    }
                    break;
                case 4:
                    System.out.println("Informe a agencia:");
                    agencia = entrada.nextInt();
                    System.out.println("Informe a conta:");
                    conta = entrada.nextInt();
                    Conta contc = c1.buscarPorAgenciaConta(agencia, conta);
                    if (contc != null){
                        System.out.println("Valor do saque:");
                        float vlrsaque = entrada.nextFloat();
                            if(cc.getSaldo() - vlrsaque > 0 ){
                                cc.sacar(vlrsaque);
                                System.out.println("Saque realizado com sucesso!");
                            }else{
                                System.out.println("Saldo Insuficiente!");
                            }
                    }else {
                        System.out.println("Dados Invalidos");
                    }
                    break;
                case 5:
                    System.out.println("Caso 4");
                    break;
                case 6 :
                    System.out.println("Informe a agencia:");
                    agencia = entrada.nextInt();
                    System.out.println("Informe a conta:");
                    conta = entrada.nextInt();
                    if(cc.equals(cp)){
                        System.out.println(cc.getSaldo());
                    }else{
                        System.out.println("Dados Invalidos");
                    }
                    
                    
//        cc.setAgencia(1);
//        cc.setConta(1);
//        cc.setSaldo(500);
//        
//        
//        cp.setAgencia(1);
//        cp.setConta(2);
//        cp.setSaldo(200);
//        
//        dao.inserir(cc);
//        dao.inserir(cp);
//        
//        dao.buscarPorAgenciaConta(1, 1).sacar(100);
//        
//        System.out.println(dao.buscarPorAgenciaConta(1, 1).toString());
//
//        System.out.println(dao.buscarTodas().toString());
        break;
                default :
                System.out.println("Opcao Invalida!");
            }
        }while (opcao != 0);
    }
    
}