package org.engim.tss2018;

import java.util.LinkedList;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.engim.tss2018.db.Merce;
import org.engim.tss2018.FormEditMerce;

public class PaginaMerce extends PaginaBase
{
  public PaginaMerce()
  {
    List<IColumn<Merce, String>> colonne = new LinkedList<>();
    
    PropertyColumn<Merce, String> id = new PropertyColumn<>(Model.of("Id"), "id");
    PropertyColumn<Merce, String> codice = new PropertyColumn<>(Model.of("Codice"), "codice");
    PropertyColumn<Merce, String> desc = new PropertyColumn<>(Model.of("Descrizione"), "descrizione");
    PropertyColumn<Merce, String> peso = new PropertyColumn<>(Model.of("Peso"), "peso");
    
    colonne.add(id);
    colonne.add(codice);
    colonne.add(desc);
    colonne.add(peso);
    
    SPDataProvider<Merce> dataprov = new SPDataProvider<>(Merce.class);
    
    DefaultDataTable table = new DefaultDataTable("elenco_merci", colonne, dataprov, 10);
    
    add(table);
    
    add(new FormEditMerce("editMerce"));
  }
}
