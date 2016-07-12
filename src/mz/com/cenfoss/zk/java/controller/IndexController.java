package mz.com.cenfoss.zk.java.controller;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Include;
import org.zkoss.zul.Menuitem;

public class IndexController extends GenericForwardComposer{
	Menuitem registar,listar;
	Include principal;
	
	public void onClick$registar(){
		principal.setSrc("/secure/main.zul");
	}
	
	public void onClick$listar(){
		principal.setSrc("/secure/listar.zul");
	}
}
