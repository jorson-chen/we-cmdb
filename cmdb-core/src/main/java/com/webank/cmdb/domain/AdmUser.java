package com.webank.cmdb.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the adm_user database table.
 * 
 */
@Entity
@Table(name = "adm_user")
@NamedQuery(name = "AdmUser.findAll", query = "SELECT a FROM AdmUser a")
@GenericGenerator(name = "userid", strategy = "uuid")
public class AdmUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idAdmUser;
	private Byte actionFlag;
	private String code;
	private String description;
	private String name;
	private String encryptedPassword;
	private List<AdmRoleUser> admRoleUsers;
	private AdmTenement admTenement;
	private Integer isSystem;

	public AdmUser() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_adm_user")
	public Integer getIdAdmUser() {
		return this.idAdmUser;
	}

	public void setIdAdmUser(Integer idAdmUser) {
		this.idAdmUser = idAdmUser;
	}

	@Column(name = "action_flag")
	public Byte getActionFlag() {
		return this.actionFlag;
	}

	public void setActionFlag(Byte actionFlag) {
		this.actionFlag = actionFlag;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// bi-directional many-to-one association to AdmRoleUser
	@OneToMany(mappedBy = "admUser")
	public List<AdmRoleUser> getAdmRoleUsers() {
		return this.admRoleUsers;
	}

	public void setAdmRoleUsers(List<AdmRoleUser> admRoleUsers) {
		this.admRoleUsers = admRoleUsers;
	}

	public AdmRoleUser addAdmRoleUser(AdmRoleUser admRoleUser) {
		getAdmRoleUsers().add(admRoleUser);
		admRoleUser.setAdmUser(this);

		return admRoleUser;
	}

	public AdmRoleUser removeAdmRoleUser(AdmRoleUser admRoleUser) {
		getAdmRoleUsers().remove(admRoleUser);
		admRoleUser.setAdmUser(null);

		return admRoleUser;
	}

	// bi-directional many-to-one association to AdmTenement
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_adm_tenement")
	public AdmTenement getAdmTenement() {
		return this.admTenement;
	}

	public void setAdmTenement(AdmTenement admTenement) {
		this.admTenement = admTenement;
	}

	@Column(name = "is_system")
	public Integer getIsSystem() {
		return this.isSystem;
	}

	public void setIsSystem(Integer isSystem) {
		this.isSystem = isSystem;
	}

	// bi-directional many-to-one association to AdmUserPartner


	@Column(name = "encrypted_password")
	public String getEncryptedPassword() {
		return this.encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

}