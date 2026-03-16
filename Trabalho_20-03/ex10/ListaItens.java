package ex10;

import java.util.ArrayList;

class ListaItens {
    ArrayList<Item> list = new ArrayList<>();

    boolean cadastrarItem(Item item) {
        try {
            list.add(item);
            return true;
        } catch (Exception err) {

            return false;
        }
    }

    void listarItens() {
        for (Item item : list) {
            System.out.println("-".repeat(15));
            item.mostrarItem();
            System.out.println("-".repeat(15));
        }

    }
}