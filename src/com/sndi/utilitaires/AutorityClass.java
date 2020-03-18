package com.sndi.utilitaires;

public class AutorityClass {
private AutorityModule modules =new AutorityModule();
private AutorityTraitement traitements =new AutorityTraitement();
private AutorityAction actions =new AutorityAction();


public AutorityModule getModules() {
	return modules;
}
public void setModules(AutorityModule modules) {
	this.modules = modules;
}
public AutorityTraitement getTraitements() {
	return traitements;
}
public void setTraitements(AutorityTraitement traitements) {
	this.traitements = traitements;
}
public AutorityAction getActions() {
	return actions;
}
public void setActions(AutorityAction actions) {
	this.actions = actions;
}

}
