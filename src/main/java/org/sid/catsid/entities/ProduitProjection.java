package org.sid.catsid.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "P1",types = Produit.class)
public interface ProduitProjection {

        public double setprice();
        public String getDesignation();

}