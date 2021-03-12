package org.sid.catsid.dao;
import java.util.*;
import org.sid.catsid.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import sun.security.pkcs11.P11Util;

import java.awt.*;
import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    //Lorsque on returne une liste de produit on cherchons par le designiation  on utilise
    @RestResource(path = "/byDesignation")
    public List<Produit> findByDesignationContains(@Param("mc") String des);
    //Lorsque on returne une liste de produit on cherchons par le designiation
    @RestResource(path = "/byDesignationPage")
    public Page<Produit> findByDesignationContains(@Param("mc") String des, Pageable pageable );
    @RestResource(path = "/price")
    public List<Produit> findByPrice(@Param("mc") Double des);



}
