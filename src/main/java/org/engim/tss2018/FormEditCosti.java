/*
 * Copyright 2018 svilupposw.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.engim.tss2018;

import org.apache.wicket.markup.html.form.Form;
import org.engim.tss2018.db.CostoMezzoTrasporto;
import org.engim.tss2018.db.Merce;

/**
 *
 * @author svilupposw
 */
public class FormEditCosti extends Form<CostoMezzoTrasporto>
{
  private CostoMezzoTrasporto CMT;
  
  public FormEditCosti(String id)
  {
    super(id);
    
    CMT = new CostoMezzoTrasporto();
  }
}
