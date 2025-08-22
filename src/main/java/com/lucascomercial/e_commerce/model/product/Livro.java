package com.lucascomercial.e_commerce.model.product;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name = "product_id")
public class Livro extends Product {

    private String author;
    private String genre;
    private int pages;


 public Livro(String author, String genre, int pages,double preco,Integer estoque,double desconto) {
    super(preco,estoque,desconto);
        this.author = author;
        this.genre = genre;
        this.pages = pages;
    }
    



    public Livro() {
}




    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }



    
    

}
