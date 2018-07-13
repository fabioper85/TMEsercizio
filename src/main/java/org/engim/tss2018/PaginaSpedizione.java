package org.engim.tss2018;

import java.util.LinkedList;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.engim.tss2018.dao.DAOSpedizioni;
import org.engim.tss2018.db.Spedizione;

public class PaginaSpedizione extends PaginaBase
{
  public PaginaSpedizione()
  {
    List<IColumn<Spedizione, String>> colonne = new LinkedList<>();
    
    PropertyColumn<Spedizione, String> id = new PropertyColumn<>(Model.of("Id"), "id");
    PropertyColumn<Spedizione, String> nome = new PropertyColumn<>(Model.of("N. spedizione"), "numero");
    PropertyColumn<Spedizione, String> peso = new PropertyColumn<>(Model.of("Data"), "data");
    AbstractColumn<Spedizione, String> pesoTot = new AbstractColumn<Spedizione, String>(Model.of("Peso tot."))
    {
      @Override
      public void populateItem(Item<ICellPopulator<Spedizione>> item, String wicketId, IModel<Spedizione> rowModel)
      {
        String s_pesotot = DAOSpedizioni.pesoTotale(rowModel.getObject()).toString();        
        Label l_pesoTot = new Label(wicketId, s_pesotot);
        item.add(l_pesoTot);
      }
    };
    
    AbstractColumn<Spedizione, String> azioni = new AbstractColumn<Spedizione, String>(Model.of("Azioni"))
    {
      @Override
      public void populateItem(Item<ICellPopulator<Spedizione>> item, String wicketId, IModel<Spedizione> imodel)
      {
        item.add(new AzioniPanel(wicketId, imodel.getObject()));    
      }
    };
    
    colonne.add(id);
    colonne.add(nome);
    colonne.add(peso);
    colonne.add(pesoTot);
    colonne.add(azioni);
    
    SPDataProvider<Spedizione> dataprov = new SPDataProvider<>(Spedizione.class);
    
    DefaultDataTable table = new DefaultDataTable("storico_spedizioni", colonne, dataprov, 10);
    
    add(table);
  }
  
}
