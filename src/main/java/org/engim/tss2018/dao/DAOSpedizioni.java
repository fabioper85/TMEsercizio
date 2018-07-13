package org.engim.tss2018.dao;

import javax.persistence.EntityManager;
import org.engim.tss2018.PM;
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
}
