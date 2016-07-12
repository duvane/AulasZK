package mz.com.cenfoss.zk.java.modelo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class CelularDAO {
	private static Configuration configuration;
	private static SessionFactory factory;
	private static Session session;
	private static Transaction transaction;
	
	public static void abrirConexao(){
		configuration = new Configuration();
		configuration.configure("hibernate.config.xml");
		
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
	}
	
	public static void fecharConexao() {
		session.close();
		factory.close();
	}

	public static void inserir(Celular celular){
		abrirConexao();
		session.save(celular);
		transaction.commit();
		fecharConexao();
	}
	
	public static List<Celular> getAll(){
		abrirConexao();
		Criteria criteria = session.createCriteria(Celular.class);
		List<Celular> retorno = criteria.list();
		fecharConexao();
		return retorno;
	}
}
