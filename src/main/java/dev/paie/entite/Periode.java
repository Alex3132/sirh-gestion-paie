package dev.paie.entite;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Periode {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="date_debut")
	private LocalDate dateDebut;
	@Column(name="date_fin")
	private LocalDate dateFin;
	@OneToMany(mappedBy = "periode")
	private List<BulletinSalaire> bulletinSalaires;
	
	public String getDateAffichee() {	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
		return formatter.format(dateDebut) + " - " + formatter.format(dateFin);
		
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
