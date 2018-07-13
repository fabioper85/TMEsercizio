package org.engim.tss2018;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.engim.tss2018.dao.DAOGenerico;
import org.engim.tss2018.db.Merce;

public class FormEditMerce extends Form<Merce>
{
  private Merce p;
  
  public FormEditMerce(String id)
  {
    super(id);
    
    add(new FeedbackPanel("feedback"));
    p = new Merce();
    
    setDefaultModel(new CompoundPropertyModel<Merce>(p));
    
    // add(new TextField("id"));
    
    TextField codice = new TextField("codice");
//    nometxt.add(EmailAddressValidator.getInstance());
    add(codice);
    
    add(new TextField("descrizione"));
    
  }

  @Override
  protected void onSubmit()
  {
    DAOGenerico.inserisci_o_aggiorna(p);
  }
   
}
