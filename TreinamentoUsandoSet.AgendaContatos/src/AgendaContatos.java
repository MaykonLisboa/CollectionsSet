import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    
    private Set<Contato> contatoSet;

    public AgendaContatos(){
        this.contatoSet = new HashSet<>();
    } 
    public void adicionarContato(String nome, int numero){
        contatoSet.add(new Contato(nome, numero));
    }
    public void exibirContato(){
        System.out.println(contatoSet);
    }
    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatoPorNome = new HashSet<>();
        for (Contato c : contatoSet){
            if(c.getNome().startsWith(nome)){
                contatoPorNome.add(c);
            }
        }
        return contatoPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero){
        Contato contatoAtualizado = null;
        for (Contato c: contatoSet){
            if (c.getNome().equalsIgnoreCase(nome)){
                c.setNumero(novoNumero); 
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }
    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();
        agendaContatos.adicionarContato("Carmine Souza", 111);
        agendaContatos.adicionarContato("Carmine Cabral", 134);
        agendaContatos.adicionarContato("Carmine Fernandes", 155);
        agendaContatos.adicionarContato("Carmine Pinto", 166);
        agendaContatos.adicionarContato("Jorginho", 555);
        agendaContatos.exibirContato();

        System.out.println("Contato Atualizado "+agendaContatos.atualizarNumeroContato("Jorginho", 455));
        agendaContatos.exibirContato();
    }
}
