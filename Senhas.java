public class Senhas
{
    int qtd;
    String redes[] = new String[qtd]; 
    String senhas[] = new String[qtd]; 
    
    public Senhas(int qtd, String redes[], String senhas[])
    {
        this.qtd = qtd;
        this.redes = redes;
        this.senhas = senhas;
    }

    public void addSenha(String rede, String senha)
    {
        qtd++;
        String redesNova[] = new String[qtd];
        String senhasNova[] = new String[qtd];

        if (redes.length == 0)
        {
            redesNova[qtd-1] = rede;
            senhasNova[qtd-1] = senha;
    
            redes = redesNova;
            senhas = senhasNova;
        }
        else{
            for(int i = 0;i<qtd-1; i++)
            {   
                redesNova[i] = redes[i];
                senhasNova[i] = senhas[i];
            }
            redesNova[qtd-1] = rede.toLowerCase();
            senhasNova[qtd-1] = senha;

            redes = redesNova;
            senhas = senhasNova;
        }
    }

    public void altSenha(String rede, String senha) throws Exception
    {
        if (redes.length == 0)
            throw new Exception("Não há senhas para alterar");


        for(int i = 0;i<qtd; i++)
        {   
            if(rede.equals(redes[i]))
            {
                senhas[i] = senha;                    
            }
        }
        
    }

    public String returnSenha(String rede)
    {
        String ret = "";
        for(int i = 0;i<qtd; i++)
        {   
            if(rede.equals(redes[i]))              // TIRAR DUVIDA SOBRE toLowerCase()
            {
                ret = senhas[i];                   
            }
        }

        return ret;
    }

    public String toString()
    {
        String ret = "";
        int i;
        for(i = 0; i < qtd-1; i++)
        {
            ret += redes[i] + ":" + senhas[i] + "\n";
                
        }
        ret += redes[i] + ":" + senhas[i];

        return ret;
    }
}