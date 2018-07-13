package org.engim.tss2018.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.engim.tss2018.PM;
import org.engim.tss2018.db.CostoMezzoTrasporto;
import org.engim.tss2018.db.MerceSpedizione;
import org.engim.tss2018.db.Spedizione;

public class DAOSpedizioni
{
  
  public static Float pesoTotale(Spedizione s)
  {
    EntityManager db = PM.db();
    
    try
    {
      Spedizione reloaded = db.find(Spedizione.class, s.getId());
      Float pesoTot = 0f;
      
      for(MerceSpedizione m: reloaded.getMerceSpedizioneCollection())
      {
        pesoTot += m.getQuantità() * m.getIdMerce().getPeso();
      };
      
      return pesoTot;
    }
    
    finally
    {
      db.close();
    }
  }
  
  public static CostoMezzoTrasporto mezzoEconomico(Spedizione s)
  {
    float pesoSped = DAOSpedizioni.pesoTotale(s);
    
    EntityManager db = PM.db();
    
    try
    {
      TypedQuery<CostoMezzoTrasporto> allCMT = db.createNamedQuery("CostoMezzoTrasporto.findAll", CostoMezzoTrasporto.class);

      List<CostoMezzoTrasporto> results = allCMT.getResultList();

      CostoMezzoTrasporto min = null;

      for(CostoMezzoTrasporto cmt: results)
      {
        if(cmt.getPesoMassimo() >= pesoSped)
        {
          if(min == null)
          {
            min = cmt;
          }
          else
          {
            if(cmt.getCosto() < min.getCosto())
              min = cmt;
          }
        }
      }
      return min;
    }
    
    finally
    {
      db.close();
    }
  }
}
