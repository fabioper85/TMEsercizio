package org.engim.tss2018;

import java.util.LinkedList;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.engim.tss2018.db.Merce;
import org.engim.tss2018.FormEditMerce;
import org.engim.tss2018.db.Spedizione;

public class PaginaMerce extends PaginaBase
{
  public PaginaMerce()
  {
    List<IColumn<Merce, String>> colonne = new LinkedList<>();
    
    PropertyColumn<Merce, String> id = new PropertyColumn<>(Model.of("Id"), "id");
    PropertyColumn<Merce, String> codice = new PropertyColumn<>(Model.of("Codice"), "codice");
    PropertyColumn<Merce, String> desc = new PropertyColumn<>(Model.of("Descrizione"), "descrizione");
    PropertyColumn<Merce, String> peso = new PropertyColumn<>(Model.of("Peso"), "peso");
    AbstractColumn<Merce, String> azioni = new AbstractColumn<Merce, String>(Model.of("Azioni"))
    {
      @Override
      public void populateItem(Item<ICellPopulator<Merce>> item, String wicketId, IModel<Merce> imodel)
      {
        item.add(new AzioniPanel(wicketId, imodel.getObject()));    
      }
    };
    
    colonne.add(id);
    colonne.add(codice);
    colonne.add(desc);
    colonne.add(peso);
    colonne.add(azioni);
    
    SPDataProvider<Merce> dataprov = new SPDataProvider<>(Merce.class);
    
    DefaultDataTable table = new DefaultDataTable("elenco_merci", colonne, dataprov, 10);
    
    add(table);
    
    add(new FormEditMerce("editMerce"));
  }
}
