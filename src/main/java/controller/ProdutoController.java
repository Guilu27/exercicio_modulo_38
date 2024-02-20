package controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import domain.Produto;
import service.IProdutoService;

@Named
@ViewScoped
public class ProdutoController implements Serializable {

  private static final long serialVersionUID = -8557080475031433290L;

  private Produto produto;

  private Collection < Produto > produtos;

  @Inject
  private IProdutoService iProdutoService;

  private Boolean isUpdate;

  @PostConstruct
  public void init() {
    try {
      this.isUpdate = false;
      this.produto = new Produto();
      this.produtos = iProdutoService.buscarTodos();
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar os produtos"));
    }
  }

  public void cancel() {
    try {
      this.isUpdate = false;
      this.produto = new Produto();
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
    }

  }

  public void edit(Produto produto) {
    try {
      this.isUpdate = true;
      this.produto = produto;
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o produto"));
    }

  }

  public void delete(Produto produto) {
    try {
      iProdutoService.excluir(produto);
      produtos.remove(produto);
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o produto"));
    }

  }

  public void add() {
    try {
      iProdutoService.cadastrar(produto);
      this.produtos = iProdutoService.buscarTodos();
      this.produto = new Produto();
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar o produto"));
    }

  }

  public void update() {
    try {
      iProdutoService.alterar(this.produto);
      cancel();
      FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Produto Atualiado com sucesso"));
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar o produto"));
    }

  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public Collection < Produto > getProdutos() {
    return produtos;
  }

  public void setProdutos(Collection < Produto > produtos) {
    this.produtos = produtos;
  }

  public Boolean getIsUpdate() {
    return isUpdate;
  }

  public void setIsUpdate(Boolean isUpdate) {
    this.isUpdate = isUpdate;
  }

}