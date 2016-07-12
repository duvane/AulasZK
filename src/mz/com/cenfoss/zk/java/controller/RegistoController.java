package mz.com.cenfoss.zk.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Include;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Textbox;

import mz.com.cenfoss.zk.java.modelo.Celular;
import mz.com.cenfoss.zk.java.modelo.CelularDAO;

public class RegistoController extends GenericForwardComposer{
	Textbox marcaTxtBox,modeloTxtBox,fabricanteTxtBox;
	Longbox serialLongBox;
	Listbox corComboBox;
	
	Menuitem registar,listar;
	Include main;
	
	List<Celular> listaCelulares = new ArrayList<Celular>();
	
	public void onClick$gravarCelular() {
		Celular novoCelular = new Celular();
		novoCelular.setMarca(marcaTxtBox.getValue());
		novoCelular.setModelo(modeloTxtBox.getValue());
		novoCelular.setFabricante(fabricanteTxtBox.getValue());
		novoCelular.setSerial(serialLongBox.getValue());
		novoCelular.setCor(corComboBox.getSelectedItem().getValue());
		
		CelularDAO.inserir(novoCelular);
		
		listaCelulares.add(novoCelular);

		marcaTxtBox.setValue(null);
		modeloTxtBox.setValue(null);
		fabricanteTxtBox.setValue(null);
		serialLongBox.setValue(null);
		corComboBox.setSelectedItem(null);

		marcaTxtBox.setFocus(true);
		
		session.setAttribute("listaDeCelulares", listaCelulares);
	}
}
