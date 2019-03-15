/**
 * Title:        commerce
 * Description:  Class for e-commerce
 * Company:      IUT Laval - Université du Maine
 * @author  A. Corbière
 */

package commerce.catalogue.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Query;

import commerce.catalogue.domaine.modele.Article;
import commerce.catalogue.domaine.modele.Piste;
import commerce.catalogue.domaine.utilitaire.HibernateUtil;
import commerce.catalogue.domaine.utilitaire.UniqueKeyGenerator;

public class CatalogueManager {

	private List articles;

	public Article chercherArticleParRef(String inRefArticle) throws Exception {
		Article article;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			article = (Article) session.get(Article.class, inRefArticle);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			throw e;
		}
		return (article);
	}

	public void supprimerArticleParRef(String inRefArticle) throws Exception {
		Article article;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			article = (Article) session.get(Article.class, inRefArticle);
			session.delete(article);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			throw e;
		}
	}

	public void soumettreArticle(Article inArticle) throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			if (inArticle.getRefArticle() == null) {
				inArticle.setRefArticle(new UniqueKeyGenerator().getUniqueId());
				session.save(inArticle);
			} else {
				session.saveOrUpdate(inArticle);
			}
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			throw e;
		}
	}

	public void soumettrePiste(Piste inPiste) throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			if (inPiste.getRefPiste() == null) {
				inPiste.setRefPiste(new UniqueKeyGenerator().getUniqueId());
				session.save(inPiste);
			} else {
				session.saveOrUpdate(inPiste);
			}
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			throw e;
		}
	}

	public void setArticles(List inArticles) throws Exception {
		articles = inArticles;
	}

	public List getArticles() throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from commerce.catalogue.domaine.modele.Article") ;
			// Query query = session.createQuery("from
			// commerce.catalogue.domaine.modele.Livre");
			// articles = query.list();
			//Query query = session.createQuery("from commerce.catalogue.domaine.modele.Article as m where "
			//		+ " m.prix>10 and m.prix<15 ");
			articles = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			throw e;
		}
		return articles;
	}
	
	public List getArticles(String type) throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			String selectFromBdd = "from commerce.catalogue.domaine.modele."+type;
			Query query = session.createQuery(selectFromBdd) ;
			articles = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
			throw e;
		}
		return articles;
	}
}