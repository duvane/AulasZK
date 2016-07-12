package mz.com.cenfoss.zk.java.controller;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

public class LoginController extends GenericForwardComposer{
	Button login;
	Textbox password_textbox,username_textbox;
	
	public void onClick$login(Event event){
		String username,password;
		username = username_textbox.getValue();
		password = password_textbox.getValue();
		
		if ((username.equals("admin") && (password.equals("root")))) {
			execution.sendRedirect("/secure/index.zul");
		}
		else{
			username_textbox.setValue(null);
			password_textbox.setValue(null);
			Messagebox.show("Erro de login", "Erro", Messagebox.OK, Messagebox.ERROR);
		}
	}
}
