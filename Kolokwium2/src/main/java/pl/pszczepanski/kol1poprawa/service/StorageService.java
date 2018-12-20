package pl.pszczepanski.kol1poprawa.service;

import java.util.ArrayList;
import java.util.List;

import pl.pszczepanski.kol1poprawa.domain.Bookmark;

public class StorageService {

    private int id = 0;
    private List<Bookmark> db = new ArrayList<Bookmark>();
    private List<Bookmark> cart = new ArrayList<Bookmark>();

    public void add(Bookmark bookmark) {
        Bookmark newBookmark = new Bookmark(bookmark.getId(), bookmark.getName(), bookmark.getDate(), bookmark.getColor(), bookmark.getExtras(), bookmark.getPrice(), bookmark.getQuantity());
        db.add(newBookmark);
    }

    public int getId() {
        id++;

        return this.id;
    }

    public List<Bookmark> getAllBookmarks() {
        return db;
    }

    public void addToCart(Bookmark bookmark) {
        cart.add(bookmark);
    }

    public List<Bookmark> getCart() {
        return cart;
    }

}
