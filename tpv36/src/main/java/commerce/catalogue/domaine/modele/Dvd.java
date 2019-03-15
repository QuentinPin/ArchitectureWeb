package commerce.catalogue.domaine.modele;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity (name="commerce.catalogue.domaine.modele.Dvd")
@DiscriminatorValue("dvd")
public class Dvd extends Article {

	private String ean;
	
	@Basic
	public String getEAN() {
		return ean;
	}
	public void setEAN(String eAN) {
		ean = eAN;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dvd other = (Dvd) obj;
		if (ean == null) {
			if (other.ean != null)
				return false;
		} else if (!ean.equals(other.ean))
			return false;
		return true;
	}
	
}
