package com.br.tads.storm.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="registros")
public class ObjectJson implements Serializable{
		
	@Column(name="id")	
private Integer id;
	@Column(name="age")
private Integer age;
	@Column(name="sex")
private Integer sex; // 0 para homem e 1 para mulher
	@Column(name="test_time")
private float test_time;
	@Column(name="motor_updrs")
private float motor_UPDRS;
	@Column(name="total_updrs")
private float total_UPDRS;
	@Column(name="md1")
private float md1;
	@Column(name="md2")
private float md2;
	@Column(name="md3")
private float md3;
	@Column(name="md4")
private float md4;
	@Column(name="md5")
private float md5;
	@Column(name="md6")
private float md6;
	@Column(name="md7")
private float md7;
	@Column(name="md8")
private float md8;
	@Column(name="md9")
private float md9;
	@Column(name="md10")
private float md10;
	@Column(name="md11")
private float md11;
	@Column(name="md12")
private float md12;
	@Column(name="md13")
private float md13;
	@Column(name="md14")
private float md14;
	@Column(name="md15")
private float md15;
	@Column(name="md16")
private float md16;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uuid;

public ObjectJson() {
	super();
}

public ObjectJson(Integer id, Integer age, Integer sex, float test_time, float motor_UPDRS, float total_UPDRS, float md1,
		float md2, float md3, float md4, float md5, float md6, float md7, float md8, float md9, float md10, float md11,
		float md12, float md13, float md14, float md15, float md16,Integer uuid) {
	super();
	this.id = id;
	this.age = age;
	this.sex = sex;
	this.test_time = test_time;
	this.motor_UPDRS = motor_UPDRS;
	this.total_UPDRS = total_UPDRS;
	this.md1 = md1;
	this.md2 = md2;
	this.md3 = md3;
	this.md4 = md4;
	this.md5 = md5;
	this.md6 = md6;
	this.md7 = md7;
	this.md8 = md8;
	this.md9 = md9;
	this.md10 = md10;
	this.md11 = md11;
	this.md12 = md12;
	this.md13 = md13;
	this.md14 = md14;
	this.md15 = md15;
	this.md16 = md16;
	this.uuid = uuid;
}

public Integer getUuid() {
	return uuid;
}

public void setUuid(Integer uuid) {
	this.uuid = uuid;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Integer getAge() {
	return age;
}

public void setAge(Integer age) {
	this.age = age;
}

public Integer getSex() {
	return sex;
}

public void setSex(Integer sex) {
	this.sex = sex;
}

public float getTest_time() {
	return test_time;
}

public void setTest_time(float test_time) {
	this.test_time = test_time;
}

public float getMotor_UPDRS() {
	return motor_UPDRS;
}

public void setMotor_UPDRS(float motor_UPDRS) {
	this.motor_UPDRS = motor_UPDRS;
}

public float getTotal_UPDRS() {
	return total_UPDRS;
}

public void setTotal_UPDRS(float total_UPDRS) {
	this.total_UPDRS = total_UPDRS;
}

public float getMd1() {
	return md1;
}

public void setMd1(float md1) {
	this.md1 = md1;
}

public float getMd2() {
	return md2;
}

public void setMd2(float md2) {
	this.md2 = md2;
}

public float getMd3() {
	return md3;
}

public void setMd3(float md3) {
	this.md3 = md3;
}

public float getMd4() {
	return md4;
}

public void setMd4(float md4) {
	this.md4 = md4;
}

public float getMd5() {
	return md5;
}

public void setMd5(float md5) {
	this.md5 = md5;
}

public float getMd6() {
	return md6;
}

public void setMd6(float md6) {
	this.md6 = md6;
}

public float getMd7() {
	return md7;
}

public void setMd7(float md7) {
	this.md7 = md7;
}

public float getMd8() {
	return md8;
}

public void setMd8(float md8) {
	this.md8 = md8;
}

public float getMd9() {
	return md9;
}

public void setMd9(float md9) {
	this.md9 = md9;
}

public float getMd10() {
	return md10;
}

public void setMd10(float md10) {
	this.md10 = md10;
}

public float getMd11() {
	return md11;
}

public void setMd11(float md11) {
	this.md11 = md11;
}

public float getMd12() {
	return md12;
}

public void setMd12(float md12) {
	this.md12 = md12;
}

public float getMd13() {
	return md13;
}

public void setMd13(float md13) {
	this.md13 = md13;
}

public float getMd14() {
	return md14;
}

public void setMd14(float md14) {
	this.md14 = md14;
}

public float getMd15() {
	return md15;
}

public void setMd15(float md15) {
	this.md15 = md15;
}

public float getMd16() {
	return md16;
}

public void setMd16(float md16) {
	this.md16 = md16;
}

}
