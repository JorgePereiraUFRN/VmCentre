package br.ufrn.vmcentre.Controller;

import java.util.List;

import br.ufrn.consiste.exceptions.ControllerException;
import br.ufrn.vmcentre.DAO.DAOFactory;
import br.ufrn.vmcentre.DAO.HibernateDAOFactory;

abstract class Controller <T, ID>{
	
	protected static final DAOFactory factory = new HibernateDAOFactory();

	public Controller() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract T save(T entity) throws ControllerException;
	
	public abstract T upadate(T entity) throws ControllerException;
	
	public abstract void delete(T entity) throws ControllerException;
	
	public abstract T findById(ID id) throws ControllerException;
	
	public abstract List<T> findAll() throws ControllerException;

}
