package org.sid.catsid.controller;

import org.sid.catsid.dao.ProduitRepository;
import org.sid.catsid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.persistence.Id;
import java.util.List;
//API REST
@RestController
public class ProduitRestService {
        @Autowired
      private ProduitRepository produitRepository;
      @GetMapping(value = "/listeProduits")
     public List<Produit> listProduits(){
          return produitRepository.findAll();
      }
    @GetMapping(value = "/listeProduits/{id}")
    public Produit listProduits(@PathVariable(name = "id") Long id){
        return produitRepository.findById(id).get();
      }
    @PutMapping(value = "/listeProduitsUpdate/{id}")
    public Produit update(@PathVariable(name = "id") Long id, @RequestBody Produit produit){
          produit.setId(id);
        return produitRepository.save(produit);
    }
        //How to save
    @PostMapping(value = "/listeProduitsSave")
    public Produit save(@RequestBody Produit produit){
        return produitRepository.save(produit);
    }
    @DeleteMapping(value = "/listeProduitsDelete/{id}")
    public void delete(@PathVariable(name = "id") Long id ){
        produitRepository.deleteById(id);
    }

}
