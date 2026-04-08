package singleton;

import java.util.ArrayList;

import classi.Ordine;
import observers.Observer;
import service.OrderDAO;

public class GestoreOrdini {

    private static GestoreOrdini instance;

    private ArrayList<Ordine> ordini;
    private ArrayList<Observer> observers;

    private GestoreOrdini() {
        ordini = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static GestoreOrdini getInstance() {
        if (instance == null) {
            instance = new GestoreOrdini();
        }
        return instance;
    }

    public void aggiungiOrdine(Ordine ordine) {
        ordini.add(ordine);
    }

    public ArrayList<Ordine> getOrdini() {
        return ordini;
    }

    public Ordine getOrdineById(int id) {
        for (Ordine o : ordini) {
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void notifyObservers(Ordine ordine) {
        for(Observer o : observers) {
            o.aggiorna(ordine);
        }
    }

    // Aggiorna stato ordine e notifica osservatori
    public void aggiornaStatoOrdine(int id, String nuovoStato) throws Exception {
        OrderDAO orderDAO = new OrderDAO();

        Ordine ordine = orderDAO.getOrdine(id);
        if(ordine != null) {
            ordine.setStato(nuovoStato);
            orderDAO.aggiornaStato(id, nuovoStato);
            notifyObservers(ordine);
        }
    }
}