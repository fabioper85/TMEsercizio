package org.engim.tss2018;




import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

public class NavMenu extends Panel
{

  public NavMenu(String id)
  {
    super(id);
    
    BookmarkablePageLink home = new BookmarkablePageLink("home", HomePage.class);
    add(home);
    
    BookmarkablePageLink merci = new BookmarkablePageLink("merci", PaginaMerce.class);
    add(merci);
    
    BookmarkablePageLink costi_spedizione = new BookmarkablePageLink("costi_spedizione", PaginaCosti.class);
    add(costi_spedizione);
    
    BookmarkablePageLink lista_spedizioni = new BookmarkablePageLink("lista_spedizioni", PaginaSpedizione.class);
    add(lista_spedizioni);
    
    home.add(new AttributeModifier("class", "nav-link"));
    merci.add(new AttributeModifier("class", "nav-link"));
    costi_spedizione.add(new AttributeModifier("class", "nav-link"));
    lista_spedizioni.add(new AttributeModifier("class", "nav-link"));
  } 
}
