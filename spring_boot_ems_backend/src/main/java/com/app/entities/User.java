package com.app.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_info")
@Value
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userId;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String about;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String phone;

    @Column(name = "CreateAt",nullable = false)
    private Date date;

    private boolean active;

    @OneToOne(mappedBy = "user")
    private Cart cart;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    // Constructors

    public User() {
        // Default constructor
    }

    public User(String name, String email, String password, String address, String about, String gender,
                String phone, Date date, boolean active) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.about = about;
        this.gender = gender;
        this.phone = phone;
        this.date = date;
        this.active = active;
    }

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

    
    // Getters and setters for other properties...

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<SimpleGrantedAuthority> collect = this.roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toList());
//
//        return collect;
//    }

    
}
