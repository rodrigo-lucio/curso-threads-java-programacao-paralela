package br.com.lucio.listas.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;


public class Principal {
    public static void main(String[] args) throws InterruptedException {
        
        // Se passarmos apenas uma lista, os 1000 elementos não sao populados, pois executa tudo em sequencia       
        // List<String> lista = new ArrayList<>();
        // Se utilizar o vector, dai sim, ele é Thread safe        
        // List<String> lista = new Vector<>(); 

        //Utilizando uma lista sincronizada, ela garante que todos os elementos sejam adicionados
        List<String> lista = Collections.synchronizedList(new ArrayList<>());
        
        //Para os mapas podemos usar:
        Map mapaThreadSafe = new Hashtable();
        //Ou
        Map mapaThreadSafe2 = new ConcurrentHashMap();
        
        //E para sets
        Set conjunto = Collections.synchronizedSet(new HashSet());
        
        for (int i = 0; i < 10; i++) {
            new Thread(new TarefaAdicionarElemento(lista, "Thread " + i)).start();
        }
        
        Thread.sleep(200);
        
        //Temos que ter um size de 1000, mas se nao usar o Vector ou o synchronizedList, o array
        //não é totalmente preenchido e
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + " - " + lista.get(i));
        }
    }
}
