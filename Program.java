import java.util.Scanner; // 1. importando a classe Scanner
import java.io.*;

public class Program 
{
    public static void main (String[] args) 
    {
        try 
        {
            boolean on = true;
            Scanner in = new Scanner(new FileReader("text.txt"));
            int i = 0;
            int qtd = Integer.parseInt(in.nextLine());
            String[] redesVector = new String[qtd];
            String[] senhasVector = new String[qtd];

            while (in.hasNextLine()) {    
                String[] line = in.nextLine().split(":");
                redesVector[i] = line[0];
                senhasVector[i] = line[1];
                i++; 
            }

            Senhas senhas = new Senhas(qtd,redesVector, senhasVector);

            while(on == true)
            {
                System.out.println("\n=============MENU============");
                System.out.println("Escolha uma opção:");
                System.out.println("1 - add uma nova senha");
                System.out.println("2 - mudar senha existente");
                System.out.println("3 - descobrir senha");
                System.out.println("4 - ver todas senhas");
                System.out.println("=============================");

                int choose = Teclado.getUmInt();

                if (choose == 0)
                {   
                    FileWriter arq = new FileWriter("text.txt");
                    PrintWriter gravarArq = new PrintWriter(arq);
                    System.out.println("\nAté logo!");
                    gravarArq.println(senhas.qtd);
                    gravarArq.println(senhas);
                    arq.close();
                    on = false;
                }
                switch (choose) {
                    case 1:
                        System.out.println("\n=============ADD============");
                        System.out.printf("Digite uma rede:");
                        String rede = Teclado.getUmString();                       
                        System.out.printf("Digite uma senha:");
                        String senha = Teclado.getUmString();
                        senhas.addSenha(rede, senha);
                        break;
        
                    case 2:
                        System.out.println("\n=============MUDAR============");
                        System.out.printf("Digite uma rede:");
                        String redeMudar = Teclado.getUmString();  
                        System.out.printf("Digite uma senha:");
                        String senhaMudar = Teclado.getUmString();
                        senhas.altSenha(redeMudar, senhaMudar);
                        break;
        
                    case 3:
                        System.out.println("\n=============PESQUISAR============");
                        System.out.printf("Digite uma rede:");
                        String redePesq = Teclado.getUmString();
                        System.out.println("\n============="+redePesq+"============");
                        System.out.println("SENHA:"+senhas.returnSenha(redePesq));
                        System.out.println("\n=====================================");
                        break;
        
                    case 4:
                        System.out.println("=============SENHAS============");
                        System.out.println(senhas);
                        System.out.println("===============================");
                        break;
                }

            }
        } 
        catch(final Exception erro)
        {
            System.err.println(erro.getMessage());
        }
    }


}