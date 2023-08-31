import java.util.HashSet;
import java.util.Set;

public class ListaTarefa {
    
    private Set<Tarefa> tarefas;

    public ListaTarefa() {
        tarefas = new HashSet<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaRemover = null;
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equals(descricao)) {
                tarefaRemover = tarefa;
                break;
            }
        }
        if (tarefaRemover != null) {
            tarefas.remove(tarefaRemover);
        }
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for (Tarefa tarefa : tarefas) {
            if (tarefa.isConcluida()) {
                tarefasConcluidas.add(tarefa);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        for (Tarefa tarefa : tarefas) {
            if (!tarefa.isConcluida()) {
                tarefasPendentes.add(tarefa);
            }
        }
        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equals(descricao)) {
                tarefa.marcarConcluida(true);
                break;
            }
        }
    }

    public void marcarTarefaPendente(String descricao) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equals(descricao)) {
                tarefa.marcarConcluida(false);
                break;
            }
        }
    }

    public void limparListaTarefas() {
        tarefas.clear();
    }

    public void exibirTarefas() {
        for (Tarefa tarefa : tarefas) {
            System.out.println("Descrição: " + tarefa.getDescricao() + ", Concluída: " + tarefa.isConcluida());
        }
    }

    public int contarTarefas() {
        return tarefas.size();
    }


    public static void main(String[] args) {
        ListaTarefa lista = new ListaTarefa();

        Tarefa tarefa1 = new Tarefa("Comprar leite");
        Tarefa tarefa2 = new Tarefa("Fazer exercícios");
        Tarefa tarefa3 = new Tarefa("Ler um livro");

        lista.adicionarTarefa(tarefa1);
        lista.adicionarTarefa(tarefa2);
        lista.adicionarTarefa(tarefa3);

        lista.marcarTarefaConcluida("Comprar leite");
        lista.marcarTarefaConcluida("Fazer exercícios");

        System.out.println("Tarefas pendentes:");
        Set<Tarefa> tarefasPendentes = lista.obterTarefasPendentes();
        for (Tarefa tarefa : tarefasPendentes) {
            System.out.println("Descrição: " + tarefa.getDescricao() + ", Concluída: " + tarefa.isConcluida());
        }

        System.out.println("\nTarefas concluídas:");
        Set<Tarefa> tarefasConcluidas = lista.obterTarefasConcluidas();
        for (Tarefa tarefa : tarefasConcluidas) {
            System.out.println("Descrição: " + tarefa.getDescricao() + ", Concluída: " + tarefa.isConcluida());
        }

        System.out.println("\nTotal de tarefas: " + lista.contarTarefas());

        System.out.println("\nRemovendo tarefa...");
        lista.removerTarefa("Fazer exercícios");

        System.out.println("\nLista de tarefas após remoção:");
        lista.exibirTarefas();
    }
}

