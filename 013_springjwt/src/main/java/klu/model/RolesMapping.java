package klu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rolesmapping")
public class RolesMapping {
	
	@Id
	@Column(name = "role")
	private Long role;
	 
	@Id
	@ManyToOne
    @JoinColumn(name = "menuid")
    private Menus menu;

	public Menus getMenu() {
		return menu;
	}

	public void setMenu(Menus menu) {
		this.menu = menu;
	}

}
