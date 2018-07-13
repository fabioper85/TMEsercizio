package org.engim.tss2018;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.validation.validator.RangeValidator;
import org.engim.tss2018.dao.DAOGenerico;
import org.engim.tss2018.db.Merce;

public class FormEditMerce extends Form<Merce>
{
  private Merce m;
  
  public FormEditMerce(String id)
  {
    super(id);
    
    add(new FeedbackPanel("feedback"));
    m = new Merce();
    
    setDefaultModel(new CompoundPropertyModel<Merce>(m));
    
    // add(new TextField("id"));
    
    TextField codice = new TextField("codice");
    codice.setRequired(true);
    add(codice);
    
    TextField desc = new TextField("descrizione");
    desc.setRequired(true);
    add(desc);
    
    NumberTextField peso = new NumberTextField("peso");
    peso.setRequired(true);
    peso.setStep(0.01);
    peso.add(new RangeValidator<Float>(Float.valueOf(0.01f), Float.valueOf(100000)));
    //peso.add(RangeValidator.minimum(0));
    add(peso);
  }

  @Override
  protected void onBeforeRender()
  {
    m = new Merce();
    setDefaultModel(new CompoundPropertyModel<Merce>(m));
    super.onBeforeRender();
  }
  
  

  @Override
  protected void onSubmit()
  {
    DAOGenerico.inserisci_o_aggiorna(m);
  }
}
