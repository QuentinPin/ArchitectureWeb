package commerce.catalogue.domaine.modele;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Title: commerce Description: Class for e-commerce Company: IUT Laval -
 * Université du Mans Author A. Corbière
 */

@Entity(name = "commerce.catalogue.domaine.modele.Piste")
public class Piste {
	private String refPiste;
	private String titre;
	private String url;

	@Id
	public String getRefPiste() {
		return refPiste;
	}

	public void setRefPiste(String inRefPiste) {
		refPiste = inRefPiste;
	}

	@Basic
	public String getTitre() {
		return titre;
	}

	public void setTitre(String inTitre) {
		titre = inTitre;
	}

	@Basic
	public String getUrl() {
		return url;
	}

	public void setUrl(String inUrl) {
		url = inUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((refPiste == null) ? 0 : refPiste.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piste other = (Piste) obj;
		if (refPiste == null) {
			if (other.refPiste != null)
				return false;
		} else if (!refPiste.equals(other.refPiste))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

}
