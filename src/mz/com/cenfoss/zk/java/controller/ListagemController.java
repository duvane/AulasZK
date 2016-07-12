package mz.com.cenfoss.zk.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import mz.com.cenfoss.zk.java.modelo.Celular;
import mz.com.cenfoss.zk.java.modelo.CelularDAO;

public class ListagemController extends GenericForwardComposer {
	Window WinListagem;

//	Método ao ser executado ao criar a janela WinListagem
	public void onCreate$WinListagem() {
		
//		Limpeza dos elementos da janela
		WinListagem.getChildren().clear();

//		Criacao da minha tabela
		Listbox lista = new Listbox();
		
//		Criacao dos cabecalhos da tabela
		Listhead cabecalho = new Listhead();
		
//		Array de labels para os cabecalhos
		String[] textoCabecalhos = { "Marca", "Modelo", "Fabricante", "Serial", "Cor" };
		for (int i = 0; i < textoCabecalhos.length; i++) {
			
//			Preenchimento das colunas do cabecalho
			Listheader cadaCabecalho = new Listheader(textoCabecalhos[i]);
			cadaCabecalho.setSort("auto");
			cabecalho.appendChild(cadaCabecalho);
		}

//		Adicao do cabecalho a lista
		lista.appendChild(cabecalho);
		
//		Captura da lista de celulares que é guardada na sessão
		List<Celular> listaDeCelulares = CelularDAO.getAll();
//				(ArrayList<Celular>) session.getAttribute("listaDeCelulares");

		try {
			
//			Percorrer a lista de celulares
			for (Celular celular : listaDeCelulares) {
				
//				Criacao da linha da tabela
				Listitem linhaCelular = new Listitem();
				
//				Preenchimento de cada coluna da linha
				Listcell marca = new Listcell(celular.getMarca());
				Listcell modelo = new Listcell(celular.getModelo());
				Listcell fabricante = new Listcell(celular.getFabricante());
				Listcell serial = new Listcell("" + celular.getSerial());
				Listcell cor = new Listcell(celular.getCor());

				linhaCelular.appendChild(marca);
				linhaCelular.appendChild(modelo);
				linhaCelular.appendChild(fabricante);
				linhaCelular.appendChild(serial);
				linhaCelular.appendChild(cor);
				
//				Adicao da linha à tabela
				lista.appendChild(linhaCelular);
			}
		} catch (NullPointerException e) {
			Messagebox.show("Lista está vazia", "Erro", Messagebox.OK, Messagebox.EXCLAMATION);
		}

//		Adicao da tabela à Janela
		WinListagem.appendChild(lista);
	}
}
