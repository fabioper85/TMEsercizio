package org.engim.tss2018;

import java.util.LinkedList;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.Model;
import org.engim.tss2018.db.CostoMezzoTrasporto;

public class PaginaCosti extends PaginaBase
{
  public PaginaCosti()
  {
    List<IColumn<CostoMezzoTrasporto, String>> colonne = new LinkedList<>();
    
    PropertyColumn<CostoMezzoTrasporto, String> id = new PropertyColumn<>(Model.of("Id"), "id");
    PropertyColumn<CostoMezzoTrasporto, String> nome = new PropertyColumn<>(Model.of("Nome mezzo"), "nomeMezzo");
    PropertyColumn<CostoMezzoTrasporto, String> peso = new PropertyColumn<>(Model.of("Peso Massimo consentito"), "pesoMassimo");
    PropertyColumn<CostoMezzoTrasporto, String> costo = new PropertyColumn<>(Model.of("Costo"), "costo");
    
    colonne.add(id);
    colonne.add(nome);
    colonne.add(peso);
    colonne.add(costo);
    
    SPDataProvider<CostoMezzoTrasporto> dataprov = new SPDataProvider<>(CostoMezzoTrasporto.class);
    
    DefaultDataTable table = new DefaultDataTable("costi_trasporto", colonne, dataprov, 10);
    
    add(table);
    
    add(new FormEditMerce("editCosti"));
  }
}
